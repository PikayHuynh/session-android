package com.zzz.sessionapplication.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.zzz.sessionapplication.R;
import com.zzz.sessionapplication.constant.Constant;

public class ActivityBT4 extends AppCompatActivity {
  private static final String ON = "On";
  private static final String OFF = "Off";
  private ImageView imgLogo;
  private Button btnExit;
  private Button btnToggle;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.activity_bt4);
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
    imgLogo = findViewById(R.id.img_logo_bt4);
    btnExit = findViewById(R.id.btn_exit_bt4);
    btnToggle = findViewById(R.id.btn_toggle_bt4);
    btnExit.setText(Constant.EXIT);
    btnToggle.setText(ON);
  }

  private void act() {
    btnExit.setOnClickListener(v -> finish());
    btnToggle.setOnClickListener(
        v -> {
          // equals so sánh bằng return đúng(true)/sai(false)
          btnToggle.setText(btnToggle.getText().equals(ON) ? OFF : ON);
          imgLogo.setVisibility(btnToggle.getText().equals(ON) ? View.VISIBLE : View.INVISIBLE);
        });
  }
}
