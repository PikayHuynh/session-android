package com.zzz.sessionapplication.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ScrollView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.zzz.sessionapplication.R;
import com.zzz.sessionapplication.constant.Constant;

public class ActivityBT15 extends AppCompatActivity {
  private Button btnExit;
  private ScrollView scrollView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.activity_bt15);
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
    scrollView = findViewById(R.id.sv_bt15);
    btnExit = scrollView.findViewById(R.id.btn_exit_bt15);
    btnExit.setText(Constant.EXIT);
  }

  private void act() {
    btnExit.setOnClickListener(v -> finish());
  }
}
