package com.zzz.sessionapplication.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.snackbar.Snackbar;
import com.zzz.sessionapplication.R;
import com.zzz.sessionapplication.constant.Constant;

public class ActivityBT17 extends AppCompatActivity {
  private Button btnExit;
  private Button btnToast;
  private Button btnToastCustom;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.activity_bt17);
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
    btnExit = findViewById(R.id.btn_exit_bt17);
    btnExit.setText(Constant.EXIT);
    btnToast = findViewById(R.id.btn_toast_simple_bt17);
    btnToast.setText("Toast");
    btnToastCustom = findViewById(R.id.btn_toast_custom_bt17);
    btnToastCustom.setText("Toast Custom");
  }

  private void act() {
    btnExit.setOnClickListener(v -> finish());
    btnToast.setOnClickListener(
        v -> {
          View root = findViewById(android.R.id.content);
          Snackbar snackbar = Snackbar.make(root, "Sướng quá anh ơi!", Snackbar.LENGTH_SHORT);
          View snackbarView = snackbar.getView();
          FrameLayout.LayoutParams params =
              (FrameLayout.LayoutParams) snackbarView.getLayoutParams();
          params.gravity = Gravity.TOP;
          params.topMargin = 150;
          snackbarView.setLayoutParams(params);
          snackbar.show();
        });

    btnToastCustom.setOnClickListener(
        v -> {
          LayoutInflater inflater = getLayoutInflater();
          /**
           * 1. inflate layout
           *
           * <p>
           *
           * @param layoutResID -> {@link R.layout.custom_toast}
           * @param findViewById -> tree from {@link R.layout.custom_toast} to childrent
           *     {@id/custom_toast_container}
           */
          final View layout =
              inflater.inflate(R.layout.custom_toast, findViewById(R.id.custom_toast_container));

          final PopupWindow toast =
              new PopupWindow(
                  layout,
                  ViewGroup.LayoutParams.WRAP_CONTENT,
                  ViewGroup.LayoutParams.WRAP_CONTENT,
                  false);
          handleShowToast(toast);
        });
  }

  private void handleShowToast(PopupWindow toast) {
    View root = findViewById(android.R.id.content);
    toast.showAtLocation(root, Gravity.TOP, 0, 0);
    // tắt sau 2 giây
    new Handler(Looper.getMainLooper())
        .postDelayed(
            () -> {
              if (toast.isShowing()) {
                toast.dismiss();
              }
            },
            2000);
  }
}
