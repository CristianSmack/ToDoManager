package com.cristiandevs.todomanager.Model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.cristiandevs.todomanager.Database.DateConverter;

import java.util.Date;

/**
 * Created by Cristian on 15/12/2017.
 */

@Entity(tableName = "ToDoItem")

public class ToDoItem {

    @PrimaryKey(autoGenerate = true)
    private Long id;
    private String name;
    private String description;
    @TypeConverters(DateConverter.class)
    private Date date;
    private boolean done;

    public ToDoItem(Long id, String name, String description, Date date,boolean done) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
        this.done = done;
    }

    @Ignore
    public ToDoItem(String name, String description, Date date,boolean done) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.done = done;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
