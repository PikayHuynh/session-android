package com.zzz.sessionapplication.activity;

import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
import java.util.List;
import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class ActivityBT8 extends AppCompatActivity {
  private static final Pair<Integer, String> MALE = Pair.create(1, "Male");
  private static final Pair<Integer, String> FEMALE = Pair.create(2, "Female");
  private static final Pair<Integer, String> OTHER = Pair.create(2, "Other");
  private Button btnExit;
  private RadioGroup sexGroup;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.activity_bt8);
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
    ImageView imgLogo = findViewById(R.id.img_logo_bt8);
    Glide.with(this).load(R.drawable.gender).circleCrop().into(imgLogo);
    TextView tvGender = findViewById(R.id.tv_gender_bt8);
    tvGender.setText("Your sex:");
    btnExit = findViewById(R.id.btn_exit_bt8);
    btnExit.setText(Constant.EXIT);
    sexGroup = findViewById(R.id.radio_group_sex_bt8);
    List<String> sexOptions = List.of(MALE.second, FEMALE.second, OTHER.second);

    Function<String, RadioButton> buildRadioButton =
        option -> {
          RadioButton radioButton = new RadioButton(this);
          radioButton.setId(View.generateViewId());
          radioButton.setText(option);
          return radioButton;
        };

    for (var option : sexOptions) {
      sexGroup.addView(buildRadioButton.apply(option));
    }
  }

  private void act() {
    btnExit.setOnClickListener(v -> finish());
    sexGroup.setOnCheckedChangeListener(
        (group, checkedId) -> {
          var id = findViewById(checkedId).getId();

          BiPredicate<Integer, Integer> mathId = Objects::equals;
          if (mathId.test(id, MALE.first)) {
            Toast.makeText(this, "You are Male", Toast.LENGTH_SHORT).show();
          } else if (mathId.test(id, FEMALE.first)) {
            Toast.makeText(this, "You are Female", Toast.LENGTH_SHORT).show();
          } else {
            Toast.makeText(this, "Are you Other ?", Toast.LENGTH_SHORT).show();
          }
        });
  }
}
