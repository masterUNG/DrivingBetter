package appewtc.masterung.drivingbetter;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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

        //Bind Widget
        bindWidget();

        //Show View
        showView();

    }    // Main Method

    private void showView() {

        //Receive id from Intent
        String strID = getIntent().getStringExtra("id");
        int intID = Integer.parseInt(strID);

        //Get Value from Database
        SQLiteDatabase objSqLiteDatabase = openOrCreateDatabase(MyOpenHelper.DATABASE_NAME,
                MODE_PRIVATE, null);
        Cursor objCursor = objSqLiteDatabase.rawQuery("SELECT * FROM carTABLE", null);
        objCursor.moveToFirst();
        objCursor.moveToPosition(intID-1);
        Log.d("car", "idCar = " + objCursor.getString(objCursor.getColumnIndex(ManageTABLE.COLUMN_Id_Car)));

    }   // showView

    private void bindWidget() {

        idCarTextView = (TextView) findViewById(R.id.textView18);
        currentMileTextView = (TextView) findViewById(R.id.textView20);
        ACTextView = (TextView) findViewById(R.id.textView22);
        ACTnextTextView = (TextView) findViewById(R.id.textView33);
        taxTextView = (TextView) findViewById(R.id.textView24);
        taxnextTextView = (TextView) findViewById(R.id.textView34);
        insureTextView = (TextView) findViewById(R.id.textView26);
        insureNextTextView = (TextView) findViewById(R.id.textView35);
        battTextView = (TextView) findViewById(R.id.textView28);
        battNextTextView = (TextView) findViewById(R.id.textView36);
        tireTextView = (TextView) findViewById(R.id.textView30);
        tireNextTextView = (TextView) findViewById(R.id.textView37);
        engineOidTextView = (TextView) findViewById(R.id.textView32);
        engineOidNextTextView = (TextView) findViewById(R.id.textView38);


    }   // bindWidget

}   // Main Class
