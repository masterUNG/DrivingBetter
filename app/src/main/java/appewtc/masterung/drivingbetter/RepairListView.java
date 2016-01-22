package appewtc.masterung.drivingbetter;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class RepairListView extends AppCompatActivity {

    //Explicit
    private ListView repairListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repair_list_view);

        //Bind Widget
        repairListView = (ListView) findViewById(R.id.listView);

        //Create ListView
        createListView();

    }   // Main Method

    private void createListView() {

        //Get Value From SQLite
        SQLiteDatabase objSqLiteDatabase = openOrCreateDatabase(MyOpenHelper.DATABASE_NAME,
                MODE_PRIVATE, null);
        Cursor objCursor = objSqLiteDatabase.rawQuery("SELECT * FROM fixTABLE", null);
        objCursor.moveToFirst();
        int intLoop = objCursor.getCount();
        String[] topicStrings = new String[intLoop];
        String[] imageFixStrings = new String[intLoop];
        String[] descripFixStrings = new String[intLoop];

        for (int i=0;i<intLoop;i++) {

            topicStrings[i] = objCursor.getString(objCursor.getColumnIndex(ManageTABLE.COLUMN_Topig));
            imageFixStrings[i] = objCursor.getString(objCursor.getColumnIndex(ManageTABLE.COLUMN_ImageFix));
            descripFixStrings[i] = objCursor.getString(objCursor.getColumnIndex(ManageTABLE.COLUMN_DescripFix));

            objCursor.moveToNext();
        }   // for
        objCursor.close();

        //Create ListView
        RepairAdapter objRepairAdapter = new RepairAdapter(RepairListView.this, topicStrings, imageFixStrings);
        repairListView.setAdapter(objRepairAdapter);

    }   // createListView

}   // Main Class
