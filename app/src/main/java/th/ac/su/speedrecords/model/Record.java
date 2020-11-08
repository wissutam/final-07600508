package th.ac.su.speedrecords.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "records")
public class Record {

    @ColumnInfo(name = "distance")
    public final String distance;

    @ColumnInfo(name = "last_name")
    public final String duration;

    public Record(String distance, String duration) {
        this.distance = distance;
        this.duration = duration;
    }
}
