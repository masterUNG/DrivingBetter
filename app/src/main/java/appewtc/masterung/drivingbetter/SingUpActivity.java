package appewtc.masterung.drivingbetter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SingUpActivity extends AppCompatActivity {

    //Explicit
    private EditText idCarEditText, passwordEditText, MileCarEditText,
             actEditText, taxEditText, insureEditText, battEditText,
            tireEditText, engineOilEditText;

    private String idCarString, passwordString, MileCarString, MileString,
             actString, taxString, insureString, battString,
            tireString, engineOilString, radiatorString, fullserviceString,
            dateString, provinceString;

    private TextView dateTextView;
    private Spinner provinceSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        //Bind Widget
        bindWidget();

        //Get & Show Time
        getAndShowTime();

        //Create Spinner
        createSpinner();

    }   // Main Method

    private void createSpinner() {

        String[] strProvinceArray = getResources().getStringArray(R.array.province);
        ArrayAdapter<String> objAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strProvinceArray);
        provinceSpinner.setAdapter(objAdapter);

    }   // createSpinner

    private void getAndShowTime() {

        DateFormat myDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date currentDate = new Date();
        dateString = myDateFormat.format(currentDate);
        dateTextView.setText(dateString);

    }   // getAndShowTime

    public void clickSaveData(View view) {

    }   // clickSaveData


    private void bindWidget() {

        idCarEditText = (EditText) findViewById(R.id.editText3);
        passwordEditText = (EditText) findViewById(R.id.editText4);
        MileCarEditText = (EditText) findViewById(R.id.editText5);
        actEditText = (EditText) findViewById(R.id.editText6);
        taxEditText = (EditText) findViewById(R.id.editText7);
        insureEditText = (EditText) findViewById(R.id.editText8);
        battEditText = (EditText) findViewById(R.id.editText9);
        tireEditText = (EditText) findViewById(R.id.editText10);
        engineOilEditText = (EditText) findViewById(R.id.editText11);
        dateTextView = (TextView) findViewById(R.id.textView16);
        provinceSpinner = (Spinner) findViewById(R.id.spinner);


    }   // bindWidget


}   // Main Class
