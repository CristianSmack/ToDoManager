package com.cristiandevs.todomanager.Database;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by Cristian on 15/12/2017.
 */

public class DateConverter {
    @TypeConverter
    public static Date fromTimeStamp(Long value){return value == null ? null: new Date(value);}

    @TypeConverter
    public static Long dateToTimestamp(Date date) {return date == null ? null : date.getTime();}
}
