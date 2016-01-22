package appewtc.masterung.drivingbetter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailRepairActivity extends AppCompatActivity {

    //Explicit
    private TextView titleTextView, detailTextView;
    private ImageView repairImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_repair);

        //Bind Widget
        bindWidget();

        //Show View
        showView();

    }   // Main Method

    private void showView() {

        //Show Title
        String strTitle = getIntent().getStringExtra("Title");
        titleTextView.setText(strTitle);

        //Show Image
        String strImageSource = getIntent().getStringExtra("Image");
        Picasso.with(DetailRepairActivity.this)
                .load(strImageSource)
                .resize(230,230)
                .into(repairImageView);

        //Show Detail
        String strDetail = getIntent().getStringExtra("Detail");
        detailTextView.setText(strDetail);


    }   // showView

    public void clickBackDetailRepair(View view) {
        finish();
    }

    private void bindWidget() {
        titleTextView = (TextView) findViewById(R.id.textView41);
        detailTextView = (TextView) findViewById(R.id.textView42);
        repairImageView = (ImageView) findViewById(R.id.imageView7);
    }

}   // Main Class
