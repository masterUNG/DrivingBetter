package appewtc.masterung.drivingbetter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class InformationActivity extends AppCompatActivity {

    //Explicit
    private TextView Id_CarTextView, MileCarTextView, DateTextView, MileTextView,
            ACTextView, TAXTextView, BattTextView, TireTextView, Engine_oilTextView,
            RadiatorTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
    }    // Main Method
}   // Main Class
