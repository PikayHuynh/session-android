package com.zzz.sessionapplication.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.zzz.sessionapplication.R;

public class ActivityBT16 extends AppCompatActivity {
  private TextView tvAlert;
  private ImageView imgExit;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.activity_bt16);
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
    tvAlert = findViewById(R.id.tv_alert_bt16);
    tvAlert.setText("Thông báo");
    imgExit = findViewById(R.id.img_logo_alert_bt16);
  }

  private void act() {
    imgExit.setOnClickListener(
        v -> {
          var alert = getBuilder();
          alert.create().show();
        });
  }

  /**
   * popup dialog 1. set icon 2. set title 3. set message 4. set cancelable 5. set positive button
   * "YES" 6. set negative button "NO" 7. set neutral button "CANCEL"
   *
   * @return AlertDialog.Builder
   */
  @NonNull
  private AlertDialog.Builder getBuilder() {
    return new AlertDialog.Builder(this)
        .setIcon(R.drawable.gai_gian)
        .setTitle("Vợ anh đến rồi, anh định bỏ EM mà chạy hả? ?")
        .setMessage("Anh có dám thừa nhận với cô ta là... EM MỚI LÀ CHÂN ÁI KHÔNG?")
        .setCancelable(true)
        .setPositiveButton(
            "Có",
            (dialog, which) ->
                Toast.makeText(
                        this,
                        "Quá bản lĩnh! Vào đây em 'thưởng nóng' rồi ra tính sau!",
                        Toast.LENGTH_LONG)
                    .show())
        .setNegativeButton(
            "Không",
            (dialog, which) -> {
              Toast.makeText(
                      this, "Hèn thế à? Thế thì CÚT luôn khỏi cuộc đời tôi!", Toast.LENGTH_SHORT)
                  .show();
              finish();
            })
        .setNeutralButton(
            "Im lặng",
            (dialog, which) -> {
              Toast.makeText(
                      this,
                      "Im lặng là có đúng không? Đêm nay anh biết tay tôi! Không có thoát đâu!",
                      Toast.LENGTH_LONG)
                  .show();
            });
  }
}
