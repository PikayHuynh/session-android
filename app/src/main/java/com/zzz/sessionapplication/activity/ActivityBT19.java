package com.zzz.sessionapplication.activity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.zzz.sessionapplication.R;
import com.zzz.sessionapplication.constant.Constant;
import com.zzz.sessionapplication.util.DateUtil;
import java.util.Calendar;

public class ActivityBT19 extends AppCompatActivity {
  private Button btnExit;
  private Button btnChooseDate;
  private CalendarView calendarView;
  private TextView tvResult;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.activity_bt19);
    init();
    act();
    ViewCompat.setOnApplyWindowInsetsListener(
        findViewById(R.id.main),
        (v, insets) -> {
          Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
          v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
          return insets;
        });
  }

  private void init() {
    ImageView imgLogo = findViewById(R.id.img_logo_bt19);
    btnExit = findViewById(R.id.btn_exit_bt19);
    btnExit.setText(Constant.EXIT);
    btnChooseDate = findViewById(R.id.btn_choose_date_bt19);
    btnChooseDate.setText("Chọn ngày");
    calendarView = findViewById(R.id.cv_bt19);
    tvResult = findViewById(R.id.tv_result_bt19);
    tvResult.setText(DateUtil.getDate(calendarView));
  }

  private void act() {
    btnExit.setOnClickListener(v -> finish());
    btnChooseDate.setOnClickListener(v -> changeDatePicker());
  }

  private void changeDatePicker() {
    final Calendar calendar = Calendar.getInstance();
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH);
    int day = calendar.get(Calendar.DAY_OF_MONTH);

    DatePickerDialog datePickerDialog =
        new DatePickerDialog(
            this,
            (view, selectedYear, selectedMonth, selectedDay) -> {
              // Note: selectedMonth is 0-indexed (January is 0)
              String date = DateUtil.getDate(selectedYear, selectedMonth, selectedDay);
              Toast.makeText(ActivityBT19.this, "Selected Date: " + date, Toast.LENGTH_SHORT)
                  .show();
            },
            year,
            month,
            day);

    DatePicker datePicker = datePickerDialog.getDatePicker();

    datePicker.init(
        year,
        month,
        day,
        (view, years, monthOfYear, dayOfMonth) -> {
          tvResult.setText(DateUtil.getDate(dayOfMonth, monthOfYear, years));
          var date = Calendar.getInstance();
          date.set(years, monthOfYear, dayOfMonth);
          calendarView.setDate(date.getTimeInMillis());
        });

    datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
    datePickerDialog.show();
  }
}
