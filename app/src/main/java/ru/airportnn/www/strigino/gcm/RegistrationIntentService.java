package ru.airportnn.www.strigino.gcm;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.google.android.gms.gcm.GcmPubSub;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;

import java.io.IOException;

import ru.airportnn.www.strigino.Constants;
import ru.airportnn.www.strigino.R;

public class RegistrationIntentService extends IntentService {

    private static final String TAG = "RegIntentService";
    private static final String[] TOPICS = {"global"};
    private SharedPreferences settings;

    public RegistrationIntentService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        settings = getSharedPreferences(Constants.APP_PREFERENCES, Context.MODE_PRIVATE);

        try {
            InstanceID instanceID = InstanceID.getInstance(this);
            String token = instanceID.getToken(getString(R.string.gcm_defaultSenderId), GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);

            if (Constants.LOG_ON) {
                Log.i(TAG, "GCM Registration Token: " + token);
            }

            sendRegistrationToSettings(token);
            subscribeTopics(token);

            settings.edit().putBoolean(Constants.SENT_TOKEN_TO_SERVER, true).apply();
        } catch (Exception e) {
            if (Constants.LOG_ON) {
                Log.d(TAG, "Failed to complete token refresh", e);
                settings.edit().putBoolean(Constants.SENT_TOKEN_TO_SERVER, false).apply();
            }
        }
        Intent registrationComplete = new Intent(Constants.REGISTRATION_COMPLETE);
        LocalBroadcastManager.getInstance(this).sendBroadcast(registrationComplete);
    }

    private void sendRegistrationToSettings(String token) {
        settings.edit().putString(Constants.APP_TOKEN, token).apply();
    }

    private void subscribeTopics(String token) throws IOException {
        GcmPubSub pubSub = GcmPubSub.getInstance(this);
        for (String topic : TOPICS) {
            pubSub.subscribe(token, "/topics/" + topic, null);
        }
    }
}
