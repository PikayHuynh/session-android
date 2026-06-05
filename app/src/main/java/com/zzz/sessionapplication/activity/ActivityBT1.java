package com.zzz.sessionapplication.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.zzz.sessionapplication.R;
import com.zzz.sessionapplication.constant.Constant;

public class ActivityBT1 extends AppCompatActivity {
    private Button btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bt1);
        init();
        act();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void init() {
        TextView tvWelcome = findViewById(R.id.tv_welcome);
        tvWelcome.setText("Welcome to Android");

        btnExit = findViewById(R.id.btn_exit_bt1);
        btnExit.setText(Constant.EXIT);

    }

    private void act() {
        btnExit.setOnClickListener(v -> finish());
    }
}