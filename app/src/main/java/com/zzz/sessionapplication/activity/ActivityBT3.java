package com.zzz.sessionapplication.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.bumptech.glide.Glide;
import com.zzz.sessionapplication.R;
import com.zzz.sessionapplication.constant.Constant;
import com.zzz.sessionapplication.util.StringUtil;

public class ActivityBT3 extends AppCompatActivity {
  private static final String SUB = "-";
  private static final String ADD = "+";
  private TextView tvCount;
  private Button btnExit;
  private Button btnAdd;
  private Button btnSub;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.activity_bt3);
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
    ImageView imgLogoGif = findViewById(R.id.img_logo_bt3);
    Glide.with(this).asGif().load(R.drawable.giphy).into(imgLogoGif);
    TextView tvTitle = findViewById(R.id.tv_title_bt3);
    tvTitle.setText("Hãy click em đi anh.");
    tvCount = findViewById(R.id.tv_count_bt3);
    btnAdd = findViewById(R.id.btn_add_bt3);
    btnAdd.setText(ADD);
    btnSub = findViewById(R.id.btn_sub_bt3);
    btnSub.setText(SUB);
    btnExit = findViewById(R.id.btn_exit_bt3);
    btnExit.setText(Constant.EXIT);
  }

  private void act() {
    btnExit.setOnClickListener(v -> finish());
    btnAdd.setOnClickListener(v -> handleClick(btnAdd));
    btnSub.setOnClickListener(v -> handleClick(btnSub));
  }

  private void handleClick(Button btn) {
    String value = btn.getText().toString().trim();
    if (StringUtil.isInvalid(tvCount.getText().toString())) {
      tvCount.setText("0");
    }
    if (value.equals(SUB)) {
      if (tvCount.getText().toString().equals("0")) {
        Toast.makeText(
                this, "Không được số âm nhé anh yêu <3 chỉ muốn là số dương.", Toast.LENGTH_SHORT)
            .show();
        return;
      }
      tvCount.setText(StringUtil.cast(Long.parseLong(tvCount.getText().toString()) - 1));
    } else {
      tvCount.setText(StringUtil.cast(Long.parseLong(tvCount.getText().toString()) + 1));
    }
  }
}
