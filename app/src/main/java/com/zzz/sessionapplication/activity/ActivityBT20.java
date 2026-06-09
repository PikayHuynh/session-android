package com.zzz.sessionapplication.activity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.zzz.sessionapplication.R;
import com.zzz.sessionapplication.constant.Constant;
import com.zzz.sessionapplication.util.DateUtil;
import java.util.Calendar;

public class ActivityBT20 extends AppCompatActivity {
  private Button btnPickTime;
  private Button btnExit;
  private TextView tvResult;
  private TimePicker timePicker;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.activity_bt20);
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
    timePicker = findViewById(R.id.tp_change_hour_bt20);
    tvResult = findViewById(R.id.tv_result_bt20);
    btnPickTime = findViewById(R.id.btn_hour_bt20);
    btnPickTime.setText("Chọn giờ");
    btnExit = findViewById(R.id.btn_exit_bt20);
    btnExit.setText(Constant.EXIT);
  }

  private void act() {
    btnExit.setOnClickListener(v -> finish());
    btnPickTime.setOnClickListener(
        v -> {
          Calendar calendar = Calendar.getInstance();
          int hour = calendar.get(Calendar.HOUR_OF_DAY);
          int minute = calendar.get(Calendar.MINUTE);

          TimePickerDialog dialog =
              new TimePickerDialog(
                  ActivityBT20.this,
                  (view, selectedHour, selectedMinute) -> {
                    String time = DateUtil.getHours(selectedHour, selectedMinute);
                    tvResult.setText(time);
                  },
                  hour,
                  minute,
                  true // true = 24h, false = 12h
                  );
          dialog.show();
        });

    timePicker.setOnTimeChangedListener(
        (view, hourOfDay, minute) -> {
          String time = DateUtil.getHours(hourOfDay, minute);
          tvResult.setText(time);
        });
  }
}
