package appewtc.masterung.drivingbetter;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

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

    public void clickLogin(View view) {

    }

    public void clickClear(View view) {

    }


    private void synchronizeMySQLtoSQLite() {

        //Setup New Policy
        StrictMode.ThreadPolicy myPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(myPolicy);

        //Synchronize
        int intTable = 1;
        while (intTable <= 4) {

            InputStream objInputStream = null;
            String strJSON = null;
            String strURLcarTABLE = "http://swiftcodingthai.com/car/php_get_data_car.php";
            String strURLemerTABLE = "http://swiftcodingthai.com/car/php_get_data_Emer.php";
            String strURLfixTABLE = "http://swiftcodingthai.com/car/php_get_data_fix.php";
            String strURLloginTABLE = "http://swiftcodingthai.com/car/php_get_data_login.php";
            String TAG = "car";
            HttpPost objHttpPost = null;

            //1. Create InputStream
            try {

                HttpClient objHttpClient = new DefaultHttpClient();

                switch (intTable) {
                    case 1:
                        objHttpPost = new HttpPost(strURLcarTABLE);
                        break;
                    case 2:
                        objHttpPost = new HttpPost(strURLemerTABLE);
                        break;
                    case 3:
                        objHttpPost = new HttpPost(strURLfixTABLE);
                        break;
                    case 4:
                        objHttpPost = new HttpPost(strURLloginTABLE);
                        break;
                }   // switch

                HttpResponse objHttpResponse = objHttpClient.execute(objHttpPost);
                HttpEntity objHttpEntity = objHttpResponse.getEntity();
                objInputStream = objHttpEntity.getContent();

            } catch (Exception e) {
                Log.d(TAG, "InputStream ==> " + e.toString());
            }

            //2. Create strJSON
            try {

                BufferedReader objBufferedReader = new BufferedReader(new InputStreamReader(objInputStream, "UTF-8"));
                StringBuilder objStringBuilder = new StringBuilder();
                String strLine = null;

                while ((strLine = objBufferedReader.readLine()) != null) {
                    objStringBuilder.append(strLine);
                }   // while
                objInputStream.close();
                strJSON = objStringBuilder.toString();

            } catch (Exception e) {
                Log.d(TAG, "strJSON ==> " + e.toString());
            }

            //3. Update to SQLite
            try {

                JSONArray objJsonArray = new JSONArray(strJSON);
                for (int i = 0; i < objJsonArray.length(); i++) {

                    JSONObject object = objJsonArray.getJSONObject(i);

                    switch (intTable) {
                        case 1: //  carTABLE

                            String strId_Car = object.getString("Id_Car");
                            String strPassword = object.getString("Password");
                            String strMileCar = object.getString("MileCar");
                            String strDate = object.getString("Date");
                            String strMile = object.getString("Mile");
                            String strACT = object.getString("ACT");
                            String strTAX = object.getString("TAX");
                            String strInsure = object.getString("Insure");
                            String strBatt = object.getString("Batt");
                            String strTire = object.getString("Tire");
                            String strEngine_oil = object.getString("Engine_oil");
                            String strRadiator = object.getString("Radiator");
                            String strFullservice = object.getString("Fullservice");
                            objManageTABLE.addValueCarTABLE(strId_Car,
                                    strPassword,
                                    strMileCar,
                                    strDate,
                                    strMile,
                                    strACT,
                                    strTAX,
                                    strInsure,
                                    strBatt,
                                    strTire,
                                    strEngine_oil,
                                    strRadiator,
                                    strFullservice);

                            break;
                        case 2: // emerTABLE

                            String strImgService = object.getString("Img_ser");
                            String strTelService = object.getString("Tel_ser");
                            String strImgInsure = object.getString("Img_insur");
                            String strTelInsure = object.getString("Tel_insur");
                            objManageTABLE.addValueEmerTABLE(strImgService,
                                    strTelService,
                                    strImgInsure,
                                    strTelInsure);

                            break;
                        case 3: // fixTABLE

                            String strTopig = object.getString("Topic");
                            String strImageFix = object.getString("IMG");
                            String strDescripFix = object.getString("Description");
                            objManageTABLE.addValueFixTABLE(strTopig,
                                    strImageFix,
                                    strDescripFix);

                            break;
                        case 4: // loginTABLE

                            String strID_car_login = object.getString("ID_Carlogin");
                            String strTimeDate = object.getString("TimeDate");
                            String strLat = object.getString("Lat");
                            String strLng = object.getString("Lng");
                            objManageTABLE.addValueLoginTABLE(strID_car_login,
                                    strTimeDate,
                                    strLat,
                                    strLng);

                            break;
                    }   // switch

                }   // for

            } catch (Exception e) {
                Log.d(TAG, "Update ==> " + e.toString());
            }


            intTable += 1;
        }   // while


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
