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

    private String idCarString, currentMileString,
            ACTString, ACTnextString,
            taxString, taxnextString,
            insureString, insureNextString,
            battString, battNextString,
            tireString, tireNextString,
            engineOidString, engineOidNextString;

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
        objCursor.moveToPosition(intID - 1);
        Log.d("car", "idCar = " + objCursor.getString(objCursor.getColumnIndex(ManageTABLE.COLUMN_Id_Car)));

        idCarString = objCursor.getString(objCursor.getColumnIndex(ManageTABLE.COLUMN_Id_Car));
        currentMileString = objCursor.getString(objCursor.getColumnIndex(ManageTABLE.COLUMN_MileCar));
        ACTString = objCursor.getString(objCursor.getColumnIndex(ManageTABLE.COLUMN_ACT));
        taxString = objCursor.getString(objCursor.getColumnIndex(ManageTABLE.COLUMN_TAX));
        insureString = objCursor.getString(objCursor.getColumnIndex(ManageTABLE.COLUMN_Insure));
        battString = objCursor.getString(objCursor.getColumnIndex(ManageTABLE.COLUMN_Batt));
        tireString = objCursor.getString(objCursor.getColumnIndex(ManageTABLE.COLUMN_Tire));
        engineOidString = objCursor.getString(objCursor.getColumnIndex(ManageTABLE.COLUMN_Engine_oil));

        //Show at TextView
        idCarTextView.setText(idCarString);
        currentMileTextView.setText(currentMileString);
        ACTextView.setText(ACTString);
        taxTextView.setText(taxString);
        insureTextView.setText(insureString);
        battTextView.setText(battString);
        tireTextView.setText(tireString);
        engineOidTextView.setText(engineOidString);

        //Split String
        String[] ACTStrings = ACTString.split("/");
        for (int i = 0; i < ACTStrings.length; i++) {
            Log.d("car", "ACTStrings[" + Integer.toString(i) + "] = " + ACTStrings[i]);
        }   //for

        //Increase Year
        int intYear = Integer.parseInt(ACTStrings[2]);
        intYear += 1;

        ACTnextString = ACTStrings[0] + "/" + ACTStrings[1] + "/" + Integer.toString(intYear);

        ACTnextTextView.setText(ACTnextString);

        String[] taxStrings = taxString.split("/");
        int intYearTax = Integer.parseInt(taxStrings[2]) + 1;
        taxnextTextView.setText(taxStrings[0] + "/" + taxStrings[1] + "/" + Integer.toString(intYearTax));

        String[] insureStrings = insureString.split("/");
        int intYearInsure = Integer.parseInt(insureStrings[2]) + 1;
        insureNextTextView.setText(insureStrings[0] + "/" + insureStrings[1] + "/" + Integer.toString(intYearInsure));


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
