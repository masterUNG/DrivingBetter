package appewtc.masterung.drivingbetter;

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

    }   // createListView

}   // Main Class
