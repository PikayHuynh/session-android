package com.zzz.sessionapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.bumptech.glide.Glide;
import com.zzz.sessionapplication.activity.ActivityBT1;
import com.zzz.sessionapplication.activity.ActivityBT2;
import com.zzz.sessionapplication.activity.ActivityBT3;
import com.zzz.sessionapplication.activity.ActivityBT4;
import com.zzz.sessionapplication.activity.ActivityBT5;
import com.zzz.sessionapplication.activity.ActivityBT6;
import com.zzz.sessionapplication.activity.ActivityBT7;
import com.zzz.sessionapplication.activity.ActivityBT8;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
  private static final Map<Integer, Class<? extends AppCompatActivity>> ACTIVITY_PAGE =
      Map.of(
          1,
          ActivityBT1.class,
          2,
          ActivityBT2.class,
          3,
          ActivityBT3.class,
          4,
          ActivityBT4.class,
          5,
          ActivityBT5.class,
          6,
          ActivityBT6.class,
          7,
          ActivityBT7.class,
          8,
          ActivityBT8.class);
  private Spinner spinnerSelectExercise;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.activity_main);
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
    ImageView imgLogo = findViewById(R.id.img_home);
    Glide.with(this).load(R.drawable._8e31c2119edb0829c6e18d9b07eab49).circleCrop().into(imgLogo);
    spinnerSelectExercise = findViewById(R.id.spinner_home);
    List<String> exercises =
        List.of(
            "Vui lòng chọn bài tập",
            "Bài 1",
            "Bài 2",
            "Bài 3",
            "Bài 4",
            "Bài 5",
            "Bài 6",
            "Bài 7",
            "Bài 8",
            "Bài 9",
            "Bài 10",
            "Bài 11",
            "Bài 12",
            "Bài 13",
            "Bài 14",
            "Bài 15",
            "Bài 16",
            "Bài 17",
            "Bài 18",
            "Bài 19");

    ArrayAdapter<String> adapter =
        new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, exercises);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinnerSelectExercise.setAdapter(adapter);
  }

  private void act() {
    spinnerSelectExercise.setOnItemSelectedListener(
        new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String value = parent.getItemAtPosition(position).toString();
            int page = value.startsWith("Bài ") ? Integer.parseInt(value.split(" ")[1].trim()) : 0;
            switchPage(page);
            parent.setSelection(0);
          }

          @Override
          public void onNothingSelected(AdapterView<?> parent) {}
        });
  }

  private void switchPage(int page) {
    if (page <= 0 || page > 19) return;
    Intent intent = new Intent(this, ACTIVITY_PAGE.get(page));
    startActivity(intent);
  }
}
