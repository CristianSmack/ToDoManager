package com.cristiandevs.todomanager.Model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.cristiandevs.todomanager.DateConverter;

import java.util.Date;

/**
 * Created by Cristian on 15/12/2017.
 */

@Entity(tableName = "ToDoItem")

public class ToDoItem {

    @PrimaryKey(autoGenerate = true)
    public Long id;
    public String name;
    public String description;
    @TypeConverters(DateConverter.class)
    public Date date;

    public ToDoItem(Long id, String name, String description, Date date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
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
