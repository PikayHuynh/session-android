package com.zzz.sessionapplication.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.zzz.sessionapplication.R;
import com.zzz.sessionapplication.constant.Constant;
import com.zzz.sessionapplication.util.StringUtil;
import java.util.List;

public class ActivityBT13 extends AppCompatActivity {
  private Button btnExit;
  private AutoCompleteTextView autoCompleteSearch;
  private TextView tvResult;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.activity_bt13);
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
    btnExit = findViewById(R.id.btn_exit_bt13);
    btnExit.setText(Constant.EXIT);
    tvResult = findViewById(R.id.tv_result_bt13);
    TextView tvTitle = findViewById(R.id.tv_title_bt13);
    tvTitle.setText("Tìm kiếm top phim hay");

    List<String> movies =
        List.of(
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

    autoCompleteSearch = findViewById(R.id.auto_search_bt13);
    ArrayAdapter<String> adapters =
        new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, movies);
    autoCompleteSearch.setAdapter(adapters);
    autoCompleteSearch.setThreshold(1); // Bắt đầu lọc từ 1 ký tự
  }

  private void act() {
    btnExit.setOnClickListener(v -> finish());
    autoCompleteSearch.setOnItemClickListener(
        (parent, view, position, id) -> {
          String movie = StringUtil.cast(parent.getItemAtPosition(position));
          tvResult.setText(String.format("Kết quả tìm kiếm : %s.", movie));
        });
  }
}
