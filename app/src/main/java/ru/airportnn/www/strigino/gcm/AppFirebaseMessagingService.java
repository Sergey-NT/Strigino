package ru.airportnn.www.strigino.gcm;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import ru.airportnn.www.strigino.Constants;
import ru.airportnn.www.strigino.MainActivity;
import ru.airportnn.www.strigino.R;

public class AppFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "FirebaseMessaging";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        int icon;

        String message = remoteMessage.getData().get("message");
        String planeNumber = remoteMessage.getData().get("title");
        String direction = remoteMessage.getData().get("direction");
        String title = getString(R.string.plane_desc_flight) + " " + planeNumber + " " + remoteMessage.getData().get("plane_direction");

        if (Constants.LOG_ON) {
            Log.d(TAG, "Message: " + message);
            Log.d(TAG, "Title: " + title);
            Log.d(TAG, "Plane number: " + planeNumber);
            Log.d(TAG, "Direction: " + direction);
        }

        if (direction != null) {
            if (direction.equals("arrival")) {
                icon = R.mipmap.ic_flight_land_white_24dp;
            } else {
                icon = R.mipmap.ic_flight_takeoff_white_24dp;
            }
            sendNotification(title, message, icon, planeNumber, direction);
        }
    }

    private void sendNotification(String title, String message, int icon, String planeNumber, String direction) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("direction", direction);
        intent.putExtra("planeNumber", planeNumber);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(icon)
                .setContentTitle(title)
                .setContentText(message)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setLights(Color.GREEN, 2000, 2000)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
    }
}
