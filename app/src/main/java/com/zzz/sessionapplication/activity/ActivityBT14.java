package com.zzz.sessionapplication.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;
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

public class ActivityBT14 extends AppCompatActivity {
  private Button btnExit;
  private MultiAutoCompleteTextView autoCompleteSearch;
  private TextView tvResult;
  private TextView tvTitle;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.activity_bt14);
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
    tvTitle = findViewById(R.id.tv_title_bt14);
    tvTitle.setText("Tìm kiếm nhiều những diễn viên hay nhất mọi thời đại");
    btnExit = findViewById(R.id.btn_exit_bt14);
    btnExit.setText(Constant.EXIT);
    tvResult = findViewById(R.id.tv_result_bt14);

    List<String> actresses =
        List.of(
            "Yui Hatano",
            "Aki Sasaki",
            "Yuu Shinoda",
            "Maki Hojo",
            "Julia Kyoka",
            "Remu Suzumori",
            "Nao Jinguji",
            "Hibiki Otsuki",
            "Shion Utsunomiya",
            "Asahi Mizuno",
            "Mio Kimijima",
            "Meguri Fujiura",
            "Ai Uehara",
            "Saika Kawakita",
            "Arina Hashimoto",
            "Kana Momonogi",
            "Minami Aizawa",
            "Akari Mitani",
            "Mana Sakura",
            "Kaho Shibuya");
    ArrayAdapter<String> adapter =
        new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, actresses);
    autoCompleteSearch = findViewById(R.id.multi_auto_tv_bt14);
    autoCompleteSearch.setAdapter(adapter);
    autoCompleteSearch.setThreshold(1);
    autoCompleteSearch.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
  }

  private void act() {
    btnExit.setOnClickListener(v -> finish());
    StringBuilder sb = new StringBuilder();
    autoCompleteSearch.setOnItemClickListener(
        (parent, view, position, id) -> {
          String actress = StringUtil.cast(autoCompleteSearch.getText());
          processResult(actress, sb);
        });

    autoCompleteSearch.addTextChangedListener(
        new TextWatcher() {
          @Override
          public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

          @Override
          public void onTextChanged(CharSequence s, int start, int before, int count) {
            tvResult.setText(String.format("Kết quả tìm kiếm: %s", StringUtil.cast(s)));
          }

          @Override
          public void afterTextChanged(Editable s) {}
        });
  }

  private void processResult(String actress, StringBuilder sb) {
    tvResult.setText(
        String.format("Kết quả tìm kiếm: %s", actress.substring(0, actress.length() - 2)));
    sb.setLength(0);
    sb.append(actress);
    autoCompleteSearch.setSelection(actress.length());
  }
}
