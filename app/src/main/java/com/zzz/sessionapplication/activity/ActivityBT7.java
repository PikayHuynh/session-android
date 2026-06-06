package com.zzz.sessionapplication.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.bumptech.glide.Glide;
import com.zzz.sessionapplication.R;
import com.zzz.sessionapplication.constant.Constant;

public class ActivityBT7 extends AppCompatActivity {
  private Button btnExit;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.activity_bt7);
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

  public void init() {
    ImageView imgLogo = findViewById(R.id.img_logo_bt7);
    Glide.with(this).load(R.drawable.java).circleCrop().into(imgLogo);
    CheckBox checkBoxOld = findViewById(R.id.checkbox_old_bt7);
    checkBoxOld.setText("Old");
    CheckBox checkBoxNew = findViewById(R.id.checkbox_new_bt7);
    checkBoxNew.setText("New");
    btnExit = findViewById(R.id.btn_exit_bt7);
    btnExit.setText(Constant.EXIT);
  }

  public void act() {
    btnExit.setOnClickListener(v -> finish());
  }
}
