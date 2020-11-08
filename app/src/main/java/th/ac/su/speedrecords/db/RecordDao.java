package th.ac.su.speedrecords.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {

    @Query("SELECT * FROM records")
    Record[] getAllUsers();

    @Query("SELECT * FROM record WHERE id = :id")
    Record getRecordById(int id);

    @Insert
    void addRecord(Record... records);


}
