package com.cristiandevs.todomanager.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.cristiandevs.todomanager.Dao.ToDoItemDAO;
import com.cristiandevs.todomanager.Model.ToDoItem;

/**
 * Created by Cristian on 15/12/2017.
 */

@Database(entities = {ToDoItem.class}, version = 3, exportSchema = false)
public abstract class ToDoItemDB extends RoomDatabase {
    private static ToDoItemDB database;

    //Singleton Pattern
    public static ToDoItemDB getInstance(Context context){
        if(database==null){
            database = Room.databaseBuilder(context.getApplicationContext(),ToDoItemDB.class,"todoitem_db").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        }

        return database;
    }
    public abstract ToDoItemDAO toDoItemDAO();
}
