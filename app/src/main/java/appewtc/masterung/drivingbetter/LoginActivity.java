package appewtc.masterung.drivingbetter;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
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
        //testAddValue();

        //Delete Value in SQLite
        deleteAllValue();

        //Synchronize mySQL to SQLite
        synchronizeMySQLtoSQLite();


    }   // onCreate

    private void synchronizeMySQLtoSQLite() {

        //Setup New Polici


    }   // synchronizeMySQLtoSQLite

    private void deleteAllValue() {

        SQLiteDatabase objSqLiteDatabase = openOrCreateDatabase("car.db", MODE_PRIVATE, null);
        objSqLiteDatabase.delete("carTABLE", null, null);
        objSqLiteDatabase.delete("emerTABLE", null, null);
        objSqLiteDatabase.delete("fixTABLE", null, null);
        objSqLiteDatabase.delete("loginTABLE", null, null);


    }

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
