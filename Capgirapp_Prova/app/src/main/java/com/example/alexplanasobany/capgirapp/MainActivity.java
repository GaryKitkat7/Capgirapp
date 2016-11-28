package com.example.alexplanasobany.capgirapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private CalendarView calendarView;
    private MyTimePickerView timePickerView;
    private TextView yearMonthTextView;
    private Button prevButton;
    private Button nextButton;

    private static String[] MONTH_NAME = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarView = (CalendarView) findViewById(R.id.calendarView);
        yearMonthTextView = (TextView) findViewById(R.id.year_month_textview);
        prevButton = (Button) findViewById(R.id.prev);
        nextButton = (Button) findViewById(R.id.next);
        timePickerView = new MyTimePickerView(MainActivity.this);
        timePickerView.setTitle("Select Year/Month");
        timePickerView.setCyclic(false);
        timePickerView.setCancelable(false);
        timePickerView.setOnTimeSelectListener(new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date) {
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH) + 1;
                calendarView.refresh0(year, month);
            }
        });

        yearMonthTextView.setText(getYearMonthText(calendarView.getYear(), calendarView.getMonth()));
        yearMonthTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerView.setTime(calendarView.getCalendar().getTime());
                timePickerView.show();
            }
        });

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = calendarView.getCalendar();
                c.set(Calendar.MONTH, c.get(Calendar.MONTH) - 1);
                calendarView.refresh0(c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = calendarView.getCalendar();
                c.set(Calendar.MONTH, c.get(Calendar.MONTH) + 1);
                calendarView.refresh0(c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1);
            }
        });


        calendarView.setWeekTextStyle(3);

        calendarView.setOnRefreshListener(new ICalendarView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                yearMonthTextView.setText(getYearMonthText(calendarView.getYear(), calendarView.getMonth()));
            }
        });

        calendarView.setOnItemClickListener(new ICalendarView.OnItemClickListener() {
            @Override
            public void onItemClick(int day) {
                int year = calendarView.getYear();
                int month = calendarView.getMonth();
                Toast.makeText(MainActivity.this, year + "-" + month + "-" + day, Toast.LENGTH_SHORT).show();
            }
        });

    }


    private String getYearMonthText(int year, int month) {
        return new StringBuilder().append(MONTH_NAME[month - 1]).append(", ").append(year).toString();
    }
}
