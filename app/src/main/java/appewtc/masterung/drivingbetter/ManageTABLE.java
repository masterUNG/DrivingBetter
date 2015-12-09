package appewtc.masterung.drivingbetter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by masterUNG on 11/24/15 AD.
 */
public class ManageTABLE {

    //Explicit
    private MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

    public static final String TABLE_CAR = "carTABLE";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_Id_Car = "Id_Car";
    private static final String COLUMN_Password = "Password";
    private static final String COLUMN_MileCar = "MileCar";
    private static final String COLUMN_Date = "Date";
    private static final String COLUMN_Mile = "Mile";
    private static final String COLUMN_ACT = "ACT";
    private static final String COLUMN_TAX = "TAX";
    private static final String COLUMN_Insure = "Insure";
    private static final String COLUMN_Batt = "Batt";
    private static final String COLUMN_Tire = "Tire";
    private static final String COLUMN_Engine_oil = "Engine_oil";
    private static final String COLUMN_Radiator = "Radiator";
    private static final String COLUMN_Fullservice = "Fullservice";

    public static final String TABLE_EMER = "emerTABLE";
    private static final String COLUMN_ImgService = "ImgService";
    private static final String COLUMN_TelService = "TelService";
    private static final String COLUMN_ImgInsure = "ImgInsure";
    private static final String COLUMN_TelInsure = "TelInsure";

    public static final String TABLE_FIX = "fixTABLE";
    private static final String COLUMN_Topig = "Topig";
    private static final String COLUMN_ImageFix = "ImageFix";
    private static final String COLUMN_DescripFix = "DescripFix";

    public static final String TABLE_LOGIN = "loginTABLE";
    private static final String COLUMN_ID_car_login = "ID_car_login";
    private static final String COLUMN_TimeDate = "TimeDate";
    private static final String COLUMN_Lat = "Lat";
    private static final String COLUMN_Lng = "Lng";


    public ManageTABLE(Context context) {

        //Connected Database
        objMyOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = objMyOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMyOpenHelper.getReadableDatabase();

    }   // Constructor

}   // Main Class
