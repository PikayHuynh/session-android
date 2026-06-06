package com.zzz.sessionapplication.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.bumptech.glide.Glide;
import com.zzz.sessionapplication.R;
import com.zzz.sessionapplication.constant.Constant;

public class ActivityBT5 extends AppCompatActivity {
  private ImageView imgLogo;
  private Button btnExit;
  private Switch swToggle;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.activity_bt5);
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
    imgLogo = findViewById(R.id.img_logo_bt5);
    Glide.with(this).load(R.drawable.girl_asian_1).circleCrop().into(imgLogo);
    btnExit = findViewById(R.id.btn_exit_bt5);
    swToggle = findViewById(R.id.sw_toggle_bt5);
    btnExit.setText(Constant.EXIT);
    swToggle.setText("Show");
    swToggle.setChecked(true);
  }

  private void act() {
    btnExit.setOnClickListener(v -> finish());
    swToggle.setOnCheckedChangeListener(
        (v, isChecked) -> {
          if (isChecked) {
            Toast.makeText(this, "Show", Toast.LENGTH_SHORT).show();
            imgLogo.setVisibility(View.VISIBLE);
          } else {
            Toast.makeText(this, "Hide", Toast.LENGTH_SHORT).show();
            imgLogo.setVisibility(View.INVISIBLE);
          }
        });
  }
}
