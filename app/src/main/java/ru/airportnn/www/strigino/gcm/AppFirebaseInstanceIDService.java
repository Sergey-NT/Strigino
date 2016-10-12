package ru.airportnn.www.strigino.gcm;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import ru.airportnn.www.strigino.Constants;

public class AppFirebaseInstanceIDService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        sendRegistrationToSettings(refreshedToken);
    }

    private void sendRegistrationToSettings(String token) {
        SharedPreferences settings;
        settings = getSharedPreferences(Constants.APP_PREFERENCES, Context.MODE_PRIVATE);
        settings.edit().putString(Constants.APP_TOKEN, token).apply();
    }
}
