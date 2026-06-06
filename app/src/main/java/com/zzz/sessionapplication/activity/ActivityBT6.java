package com.zzz.sessionapplication.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.bumptech.glide.Glide;
import com.zzz.sessionapplication.R;
import com.zzz.sessionapplication.constant.Constant;
import java.util.function.BiFunction;

public class ActivityBT6 extends AppCompatActivity {
  private static final String SPELL = "Đánh vần";
  private static final String PUZZLE = "Xếp hình";
  private Button btnExit;
  private Button btnSubmit;
  private CheckBox checkBoxPuzzle;
  private CheckBox checkBoxSpell;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.activity_bt6);
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
    ImageView imgLogo = findViewById(R.id.img_logo_bt6);
    Glide.with(this).load(R.drawable.kim).circleCrop().into(imgLogo);
    checkBoxPuzzle = findViewById(R.id.checkbox_1_bt6);
    checkBoxPuzzle.setText("Xếp hình");
    checkBoxPuzzle.setChecked(false);
    checkBoxSpell = findViewById(R.id.checkbox_2_bt6);
    checkBoxSpell.setText("Đánh vần");
    checkBoxSpell.setChecked(false);
    btnExit = findViewById(R.id.btn_exit_bt6);
    btnExit.setText(Constant.EXIT);
    btnSubmit = findViewById(R.id.btn_submit_bt6);
    btnSubmit.setText("Submit");
  }

  private void act() {
    btnExit.setOnClickListener(v -> finish());
    BiFunction<String, Boolean, String> message =
        (value, isChecked) ->
            isChecked
                ? String.format("Bạn chọn '%s'.", value)
                : String.format("Bạn không chọn '%s'.", value);

    checkBoxPuzzle.setOnCheckedChangeListener(
        (v, isChecked) ->
            Toast.makeText(this, message.apply(PUZZLE, isChecked), Toast.LENGTH_SHORT).show());
    checkBoxSpell.setOnCheckedChangeListener(
        (v, isChecked) ->
            Toast.makeText(this, message.apply(SPELL, isChecked), Toast.LENGTH_SHORT).show());

    btnSubmit.setOnClickListener(
        v -> {
          if (!checkBoxPuzzle.isChecked() && !checkBoxSpell.isChecked()) {
            Toast.makeText(this, "Bạn không chọn gì hết.", Toast.LENGTH_SHORT).show();
          }
          String result =
              message.apply(PUZZLE, checkBoxPuzzle.isChecked())
                  + ", "
                  + message.apply(SPELL, checkBoxSpell.isChecked());
          Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        });
  }
}
