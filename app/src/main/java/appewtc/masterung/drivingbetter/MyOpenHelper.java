package appewtc.masterung.drivingbetter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by masterUNG on 11/24/15 AD.
 */
public class MyOpenHelper extends SQLiteOpenHelper{

    //Explicit
    private static final String DATABASE_NAME = "car.db";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_CAR_TABLE = "create table carTABLE (_id integer primary key, " +
            "Id_Car text, " +
            "Password text, " +
            "MileCar text, " +
            "Date text, " +
            "Mile text, " +
            "ACT text, " +
            "TAX text, " +
            "Insure text, " +
            "Batt text, " +
            "Tire text, " +
            "Engine_oil text, " +
            "Radiator text, " +
            "Fullservice text);";

    public MyOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }   // Constructor

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CAR_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}   // Main Class
