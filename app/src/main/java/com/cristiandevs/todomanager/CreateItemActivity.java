package com.cristiandevs.todomanager;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

import com.cristiandevs.todomanager.Model.ToDoItem;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreateItemActivity extends AppCompatActivity {

    private Date date;
    @BindView(R.id.title)
    TextView title;

    //Butterknife doesn't allow static fields
    static TextView textDate;
    static TextView time;

    @BindView(R.id.alarm)
    Switch alarm;
    @BindView(R.id.date_picker_button)
    Button datePicker;
    @BindView(R.id.time_picker_button)
    Button timePicker;
    @BindView(R.id.resetButton)
    Button reset;
    @BindView(R.id.submitButton)
    Button submit;
    @BindView(R.id.cancelButton)
    Button cancel;

    public static String timeString,dateString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_item);
        ButterKnife.bind(this);

        textDate = findViewById(R.id.date);
        time = findViewById(R.id.time);

        defaultDateTime();

        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });

        timePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullDate = dateString + " " + timeString;
                Date dateItem = new Date(fullDate);
                ToDoItem item = new ToDoItem(title.getText().toString(),"Description",date,false);
                Intent i = new Intent();
                i.putExtra("item",item);
                // - return data Intent and finish
                setResult(RESULT_OK, i);
                finish();



            }
        });


    }

    public void defaultDateTime(){
        // Default is current time + 7 days
        date = new Date();
        date = new Date(date.getTime() + (24*7*60*60*1000));

        Calendar c = Calendar.getInstance();
        c.setTime(date);

        setDateString(c.get(Calendar.YEAR), c.get(Calendar.MONTH),
                c.get(Calendar.DAY_OF_MONTH));

        textDate.setText(dateString);

        setTimeString(c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE),
                c.get(Calendar.MILLISECOND));

        time.setText(timeString);
    }

    private static void setDateString(int year, int monthOfYear, int dayOfMonth) {

        // Increment monthOfYear for Calendar/Date -> Time Format setting
        monthOfYear++;
        String mon = "" + monthOfYear;
        String day = "" + dayOfMonth;

        if (monthOfYear < 10)
            mon = "0" + monthOfYear;
        if (dayOfMonth < 10)
            day = "0" + dayOfMonth;

        dateString = year + "-" + mon + "-" + day;
    }

    private static void setTimeString(int hourOfDay, int minute, int mili) {
        String hour = "" + hourOfDay;
        String min = "" + minute;

        if (hourOfDay < 10)
            hour = "0" + hourOfDay;
        if (minute < 10)
            min = "0" + minute;

        timeString = hour + ":" + min + ":00";
    }


    public static class DatePickerFragment extends DialogFragment implements
            DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            // Use the current date as the default date in the picker

            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            setDateString(year, monthOfYear, dayOfMonth);

            textDate.setText(dateString);
        }

    }

    // DialogFragment used to pick a ToDoItem deadline time

    public static class TimePickerFragment extends DialogFragment implements
            TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    true);
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            setTimeString(hourOfDay, minute, 0);

            time.setText(timeString);
        }
    }

    private void showDatePickerDialog() {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(), "datePicker");
    }

    private void showTimePickerDialog() {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getFragmentManager(), "timePicker");
    }

}
