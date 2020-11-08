package th.ac.su.speedrecords;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import th.ac.su.speedrecords.db.AppDatabase;
import th.ac.su.speedrecords.util.AppExecutors;

public class AddRecordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);

        Button saveButton = findViewById(R.id.save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText speed = findViewById(R.id.text_distance);
                String speedString = speed.getText().toString();
                EditText time = findViewById(R.id.text_time);
                String timeString = time.getText().toString();


                double Distance = Double.parseDouble(speedString);
                double Time = Double.parseDouble(timeString);
                double Answer = (Distance/1000)/(Time/3600);
                final Record record = new Record(0, speedString,timeString);


                AppExecutors executors = new AppExecutors();
                executors.diskIO().execute(new Runnable() {
                    @Override
                    public void run() { // worker thread
                        AppDatabase db = AppDatabase.getInstance(AddRecordActivity.this);
                        db.recordDao().addRecord(record);
                        finish();
                    }
                });

        }
        });

    }
}