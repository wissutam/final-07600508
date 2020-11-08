package th.ac.su.speedrecords;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import th.ac.su.speedrecords.adapter.RecordAdapter;
import th.ac.su.speedrecords.db.AppDatabase;
import th.ac.su.speedrecords.util.AppExecutors;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    @Override
    protected void onResume() {
        super.onResume();

        final AppExecutors executors = new AppExecutors();
        executors.diskIO().execute(new Runnable() {
            @Override
            public void run() {
                AppDatabase db = AppDatabase.getInstance(MainActivity.this);
                final Record[] records = db.userDao().getAllRecords();

                executors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        RecordAdapter adapter = new RecordAdapter(MainActivity.this, records);
                        mRecyclerView.setAdapter(adapter);
                    }
                });

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.speed_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        Button addButton = findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AddRecordActivity.class);
                startActivity(i);
            }
        });
    }
}