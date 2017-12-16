package com.cristiandevs.todomanager.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.cristiandevs.todomanager.Model.ToDoItem;

import java.util.List;

/**
 * Created by Cristian on 15/12/2017.
 */

@Dao
public interface ToDoItemDAO {
    @Query("SELECT * FROM ToDoItem WHERE done =0")
    List<ToDoItem> getAll();

    @Insert
    Long insertToDo(ToDoItem item);

    @Delete
    void delete(ToDoItem item);
}
