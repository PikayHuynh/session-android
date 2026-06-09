package com.zzz.sessionapplication.activity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.zzz.sessionapplication.R;
import com.zzz.sessionapplication.constant.Constant;
import com.zzz.sessionapplication.util.StringUtil;
import java.util.List;
import java.util.Objects;

public class ActivityBT18 extends AppCompatActivity {
  private Spinner spinner;
  private ImageView imgPopup;
  private Button btnExit;
  private static final String CODE = "Code";
  private static final String EDIT = "Edit";
  private static final String ADD = "Add";
  private static final String DELETE = "Delete";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.activity_bt18);
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

  @Override
  public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
    super.onCreateContextMenu(menu, v, menuInfo);
    menu.setHeaderTitle("Choose");
    menu.add(0, v.getId(), 0, CODE);
    menu.add(0, v.getId(), 0, EDIT);
    menu.add(0, v.getId(), 0, ADD);
    menu.add(0, v.getId(), 0, DELETE);
  }

  @Override
  public boolean onContextItemSelected(@NonNull MenuItem item) {
    return isChooseToast(item);
  }

  private void init() {
    Toolbar toolbar = findViewById(R.id.toolbar_bt18);
    if (Objects.nonNull(toolbar)) {
      setSupportActionBar(toolbar);
      Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
      spinner = findViewById(R.id.toolbar_spinner_bt18);
      List<String> itemToolbar = List.of("Home", "Search", "Profile");
      ArrayAdapter<String> adapter =
          new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, itemToolbar);
      spinner.setAdapter(adapter);
    }

    List<String> languages =
        List.of(
            "C++", "Java", "Go", "Python", "JavaScript", "Ruby", "Swift", "Kotlin", "TypeScript");
    ArrayAdapter<String> adapterLanguages =
        new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, languages);
    ListView listView = findViewById(R.id.lv_language);
    listView.setAdapter(adapterLanguages);
    registerForContextMenu(listView);
    btnExit = findViewById(R.id.btn_exit_bt18);
    btnExit.setText(Constant.EXIT);
    imgPopup = findViewById(R.id.img_logo_popup_bt18);
  }

  private void act() {
    btnExit.setOnClickListener(v -> finish());
    spinner.setOnItemSelectedListener(
        new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String selectedItem = StringUtil.cast(parent.getItemAtPosition(position));
            Toast.makeText(ActivityBT18.this, "Bạn chọn: " + selectedItem, Toast.LENGTH_SHORT)
                .show();
          }

          @Override
          public void onNothingSelected(AdapterView<?> parent) {}
        });

    imgPopup.setOnClickListener(
        v -> {
          PopupMenu popup = new PopupMenu(ActivityBT18.this, imgPopup);
          popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
          popup.setOnMenuItemClickListener(
              item -> {
                Toast.makeText(ActivityBT18.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
              });
          popup.show();
        });
  }

  private boolean isChooseToast(MenuItem item) {
    if (Objects.equals(item.getTitle(), EDIT)) {
      Toast.makeText(this, "Chọn " + EDIT, Toast.LENGTH_SHORT).show();
    } else if (Objects.equals(item.getTitle(), ADD)) {
      Toast.makeText(this, "Chọn " + ADD, Toast.LENGTH_SHORT).show();
    } else if (Objects.equals(item.getTitle(), DELETE)) {
      Toast.makeText(this, "Chọn " + DELETE, Toast.LENGTH_SHORT).show();
    } else if (Objects.equals(item.getTitle(), CODE)) {
      Toast.makeText(this, "Chọn " + CODE, Toast.LENGTH_SHORT).show();
    } else {
      return false;
    }
    return true;
  }
}
