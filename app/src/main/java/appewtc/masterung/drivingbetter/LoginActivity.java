package appewtc.masterung.drivingbetter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {

    //Explicit
    private ManageTABLE objManageTABLE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Create & Connected
        objManageTABLE = new ManageTABLE(this);

        //Test Add Value
        testAddValue();

    }   // onCreate

    private void testAddValue() {

        //Test Add Value to carTABLE
        objManageTABLE.addValueCarTABLE("" +
                        "IDcar",
                "Pass",
                "MileCar",
                "Date",
                "Mile",
                "ACT",
                "TAX",
                "Insure",
                "Batt",
                "Tire",
                "Engin",
                "Radia",
                "FullService");

        //Test Add Value to emerTABLE
        objManageTABLE.addValueEmerTABLE("ImageSer", "TelSer", "ImageInsure", "TelInsure");

    }   // testAddValue

}   // Main Class
