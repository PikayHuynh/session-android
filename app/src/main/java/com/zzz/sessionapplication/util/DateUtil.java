package com.zzz.sessionapplication.util;

import android.widget.CalendarView;
import java.util.Calendar;

public class DateUtil {
  public static String getDate(CalendarView calendarView) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(calendarView.getDate());
    return String.format(
        "%s/%s/%s",
        calendar.get(Calendar.DAY_OF_MONTH),
        calendar.get(Calendar.MONTH) + 1,
        calendar.get(Calendar.YEAR));
  }

  public static String getDate(int day, int month, int year) {
    return day + "/" + (month + 1) + "/" + year;
  }

  public static String getHours(int hour, int minute) {
    return String.format("%02d:%02d", hour, minute);
  }
}
