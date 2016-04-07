package appewtc.masterung.drivingbetter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

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

public class MainHoldActivity extends AppCompatActivity {

    //Explicit
    private String idString;
    private int timesAnInt = 0;
    private double distantADouble, mySumADouble = 0;
    private double[] latDoubles, lngDoubles;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_hold);

        //Receive from Login
        idString = getIntent().getStringExtra("id");
        Log.d("car", "idString = " + idString);

        //Setup Start
        latDoubles = new double[2];
        lngDoubles = new double[2];
        latDoubles[0] = 13.6770983;
        lngDoubles[0] = 100.6159983;


        //Calculate Distance
        //calculateDistance();

        calculateDistanceLast();


    }   // Main Method

    public class MyConnected extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {

            try {

                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url("http://swiftcodingthai.com/car/php_get_check.php").build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();

            } catch (Exception e) {
                return null;
            }   // try

        }   // doInBack

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Log.d("7April", "s ==> " + s);

            try {

                JSONArray jsonArray = new JSONArray(s);
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                double douLat = Double.parseDouble(jsonObject.getString("Lat"));
                double douLng = Double.parseDouble(jsonObject.getString("Lng"));

                mySumDistance(distance(latDoubles[0], lngDoubles[0], douLat, douLng));

                latDoubles[0] = douLat;
                lngDoubles[0] = douLng;

            } catch (Exception e) {
                e.printStackTrace();
            }   // try

        }   // onPost
    }   // MyConnected Class

    private void mySumDistance(double distance) {

        mySumADouble = mySumADouble + distance;
        Log.d("8April", "mySum ==> " + mySumADouble);

        if (mySumADouble > 2000) {
            Toast.makeText(this, "เกินแล้วเว้ยเห้ย", Toast.LENGTH_SHORT).show();
        }


    }   // mySum

    private void calculateDistanceLast() {

        MyConnected myConnected = new MyConnected();
        myConnected.execute();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                calculateDistanceLast();
            }
        }, 3000);

    }   // cal


    //นี่คือ เมทอด ที่หาระยะ ระหว่างจุด
    private static double distance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515 * 1.609344;


        return (dist);
    }

    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }


    private void calculateDistance() {

        //Connected Http
        StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy
                .Builder().permitAll().build();
        StrictMode.setThreadPolicy(threadPolicy);

        //1 InputStream
        InputStream inputStream = null;

        try {

            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("http://swiftcodingthai.com/car/php_get_check.php");
            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            inputStream = httpEntity.getContent();

        } catch (Exception e) {
            Log.d("28March", "Input ==> " + e.toString());
        }

        //2 strJSON
        String strJSON = null;

        try {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            StringBuilder stringBuilder = new StringBuilder();
            String strLine = null;
            while ((strLine = bufferedReader.readLine()) != null) {
                stringBuilder.append(strLine);
            }
            inputStream.close();
            strJSON = stringBuilder.toString();

        } catch (Exception e) {
            Log.d("28March", "strJSON ==> " + e.toString());
        }


        //3 Calculate Distance

        try {

            JSONArray jsonArray = new JSONArray(strJSON);
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                latDoubles[1] = Double.parseDouble(jsonObject.getString("Lat"));
                lngDoubles[1] = Double.parseDouble(jsonObject.getString("Lng"));

                //จะได้ Lat, Lng

                distantADouble = distantADouble + distance(latDoubles[0], lngDoubles[0],
                        latDoubles[1], lngDoubles[1]);

                latDoubles[0] = latDoubles[1];
                lngDoubles[0] = lngDoubles[1];

                Log.d("28March", "Dis ==>" + distantADouble);


            }   // for


        } catch (Exception e) {
            Log.d("28March", "Calculate ==> " + e.toString());
        }



        timesAnInt += 1;
        Log.d("28March", "Times = " + timesAnInt);

        myLoop();
    }   // calculate

    private void myLoop() {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                calculateDistance();

            }
        }, 3000);

    } // myLoop

    public void clickInformation(View view) {
        Intent objIntent = new Intent(MainHoldActivity.this, InformationActivity.class);
        objIntent.putExtra("id", idString);
        startActivity(objIntent);

    }

    public void clickRepair(View view) {

        startActivity(new Intent(MainHoldActivity.this, RepairListView.class));

    }



    public void clickGPS(View view) {

        Intent objIntent = new Intent(MainHoldActivity.this, MapsActivity.class);
        startActivity(objIntent);

    }   //

    public void clickCenterService(View view) {

        AlertDialog.Builder objBuilder = new AlertDialog.Builder(this);
        objBuilder.setIcon(R.drawable.icon_question);
        objBuilder.setTitle(getResources().getString(R.string.tel));
        objBuilder.setMessage("คุณต้องการไปที่ไหน ?");
        objBuilder.setCancelable(false);
        objBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        objBuilder.setNeutralButton("ศูนย์บริการ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Intent objIntent = new Intent(MainHoldActivity.this, ServiceCenterActivity.class);
                objIntent.putExtra("Index", 1);
                startActivity(objIntent);
                dialogInterface.dismiss();

            }   // event
        });
        objBuilder.setPositiveButton("ประกันภัย", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Intent obj2Intent = new Intent(MainHoldActivity.this, ServiceCenterActivity.class);
                obj2Intent.putExtra("Index", 2);
                startActivity(obj2Intent);
                dialogInterface.dismiss();

            }   // event
        });

        objBuilder.show();


    }   // clickCenterService

}   // Main Class
