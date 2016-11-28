package com.example.alexplanasobany.capgirapp;

/**
 * Created by alexplanasobany on 22/11/16.
 */


import java.util.Calendar;

public interface ICalendarView {

    /**
     * only used for MODE_CALENDAR
     */
    void refresh0(int year, int month);

    void setSelectedDayTextColor(int color);

    void setSelectedDayBgColor(int color);

    void setTodayBgColor(int color);

    /**
     * only used for MODE_SHOW_DATA_OF_THIS_MONTH
     */
    void refresh1(boolean data[]);

    int daysCompleteTheTask();

    /**
     * used for both
     */
    void setWeekTextStyle(int style);

    void setWeekTextColor(int color);

    void setCalendarTextColor(int color);

    void setWeekTextSizeScale(float scale);

    void setTextSizeScale(float scale);

    void setMode(int mode);

    int getYear();

    int getMonth();

    int daysOfCurrentMonth();

    Calendar getCalendar();

    void setOnItemClickListener(OnItemClickListener onItemClickListener);

    void setOnRefreshListener(OnRefreshListener onRefreshListener);

    interface OnItemClickListener{
        void onItemClick(int day);
    }

    interface OnRefreshListener{
        void onRefresh();
    }

}
