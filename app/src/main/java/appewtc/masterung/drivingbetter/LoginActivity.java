package appewtc.masterung.drivingbetter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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

    public void clickSignUp(View view) {

        Intent objIntent = new Intent(LoginActivity.this, SingUpActivity.class);
        startActivity(objIntent);

    }



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

        //Test Add Value to fixTABLE
        objManageTABLE.addValueFixTABLE("Topic", "ImageFix", "DescripFix");

        //Test Add Value to loginTABLE
        objManageTABLE.addValueLoginTABLE("ID", "TimeDate", "Lat", "Lng");

    }   // testAddValue

}   // Main Class
