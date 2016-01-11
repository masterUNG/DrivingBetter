package appewtc.masterung.drivingbetter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class InformationActivity extends AppCompatActivity {

    //Explicit
    private TextView idCarTextView, currentMileTextView,
            ACTextView, ACTnextTextView,
            taxTextView, taxnextTextView,
            insureTextView, insureNextTextView,
            battTextView, battNextTextView,
            tireTextView, tireNextTextView,
            engineOidTextView, engineOidNextTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
    }    // Main Method
}   // Main Class
