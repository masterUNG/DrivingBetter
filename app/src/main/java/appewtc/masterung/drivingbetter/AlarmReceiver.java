package appewtc.masterung.drivingbetter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

/**
 * Created by masterUNG on 2/11/16 AD.
 */
public class AlarmReceiver extends BroadcastReceiver{


    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "ถึงเวลาแว้ววว", Toast.LENGTH_SHORT).show();
        MediaPlayer effectMediaPlayer = MediaPlayer.create(context, R.raw.horse);
        effectMediaPlayer.start();

    }   // onReceive
}   // Main Class
