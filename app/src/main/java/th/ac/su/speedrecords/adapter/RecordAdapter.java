package th.ac.su.speedrecords.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import th.ac.su.speedrecords.model.Record;
import th.ac.su.speedrecords.R;

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.MyViewHolder> {

    private Context mContext;
    private Record[] mRecords;

    public RecordAdapter(Context context, Record[] records) {
        this.mContext = context;
        this.mRecords = records;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_speed, parent, false);
        return new MyViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Record record = mRecords[position];

        holder.distanceTextView.setText(record.distance);
        holder.durationTextView.setText(record.duration);

    }

    @Override
    public int getItemCount() {
        return mRecords.length;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView distanceTextView;
        TextView durationTextView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.distanceTextView = itemView.findViewById(R.id.speed_text_view);
            this.durationTextView= itemView.findViewById(R.id.time_text_view);

        }
    }


}

