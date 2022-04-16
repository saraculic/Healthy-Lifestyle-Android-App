package com.example.projekat;

import android.app.IntentService;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class MessageService extends IntentService {

    public static final String EXTRA_MESSAGE = "message";
    public static final int NOTIFICATION_ID = 1; //ovo se koristi za identifikovanje obavestenja. Moze da bude bilo koji broj

    public MessageService() {
        super("MessageService");
    }

    //Ovaj metod se izvrsava u zasebnoj niti, ako mu se prosledi vise namera, on ih obradjuje jednu po jednu
    @Override
    protected void onHandleIntent(Intent intent) {
        synchronized (this) {
            try {
                wait(10000); //30min = 30*60*1000 = 1800 * 1000 = 1 800 000
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        String text = intent.getStringExtra(EXTRA_MESSAGE);
        showText(text);
    }

    private void showText(final String text){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("My Notification", "My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        //Pravljenje graditelja obavestenja
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this, "My Notification")
                        .setSmallIcon(R.drawable.icon)
                        .setContentTitle(getString(R.string.obavestenje))
                        .setContentText(text)
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setVibrate(new long[] {0, 1000})
                        .setAutoCancel(true);

        //Pravljenje akcije
        Intent actionIntent = new Intent(this, ObavestenjeActivity.class);
        PendingIntent actionPendingIntent = PendingIntent.getActivity(this, 0, actionIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(actionPendingIntent); //dodajemo obavestenju nameru na cekanju

        //Izdavanje obavestenja
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, builder.build()); //prikazivanje obavestenja pomocu menadzera obavestenja
    }


}