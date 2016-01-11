package appewtc.masterung.drivingbetter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainHoldActivity extends AppCompatActivity {

    //Explicit
    private String idString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_hold);

        //Receive from Login
        idString = getIntent().getStringExtra("id");
        Log.d("car", "idString = " + idString);


    }   // Main Method

    public void clickInformation(View view) {
        Intent objIntent = new Intent(MainHoldActivity.this, InformationActivity.class);
        objIntent.putExtra("id", idString);
        startActivity(objIntent);

    }

    public void clickRepair(View view) {

    }

    public void clickGPS(View view) {

    }

    public void clickCenterService(View view) {

    }

}   // Main Class
