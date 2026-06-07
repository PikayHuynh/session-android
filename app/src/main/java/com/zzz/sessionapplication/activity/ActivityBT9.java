package com.zzz.sessionapplication.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.zzz.sessionapplication.R;
import com.zzz.sessionapplication.constant.Constant;
import java.util.List;
import java.util.function.Predicate;

public class ActivityBT9 extends AppCompatActivity {
  private TextView tvSpinner;
  private Spinner spinner;
  private Button btnExit;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.activity_bt9);
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
    tvSpinner = findViewById(R.id.tv_spinner_bt9);
    tvSpinner.setText("Spinner");

    List<String> movies =
        List.of(
            "Vui lòng chọn phim",
            "Cô giáo thảo",
            "Anh và cô ấy",
            "50 sắc thái",
            "365 Dni",
            "Chị chị em em",
            "Friends With Benefits",
            "Sex Education",
            "Bồng Bột Tuổi Dậy Thì",
            "Yêu Lầm Bạn Thân",
            "Juno",
            "Dính bầu");
    ArrayAdapter<String> adapters =
        new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, movies);
    adapters.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinner = findViewById(R.id.spinner_bt9);
    spinner.setAdapter(adapters);
    btnExit = findViewById(R.id.btn_exit_bt9);
    btnExit.setText(Constant.EXIT);
  }

  private void act() {
    btnExit.setOnClickListener(v -> finish());

    Predicate<Integer> isNotZero = num -> num != 0;
    spinner.setOnItemSelectedListener(
        new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (isNotZero.test(position)) {
              String value = parent.getItemAtPosition(position).toString();
              Toast.makeText(ActivityBT9.this, value, Toast.LENGTH_SHORT).show();
            }
          }

          @Override
          public void onNothingSelected(AdapterView<?> parent) {}
        });
  }
}
