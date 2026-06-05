package com.zzz.sessionapplication.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.zzz.sessionapplication.R;
import com.zzz.sessionapplication.constant.Constant;

public class ActivityBT2 extends AppCompatActivity {
    private Button btnExit;
    private EditText edtName;
    private TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bt2);
        init();
        act();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void init() {
        ImageView imgLogo = findViewById(R.id.img_logo_bt2);
        Glide.with(this)
                .load(R.drawable.java)
                .circleCrop()
                .into(imgLogo);
        btnExit = findViewById(R.id.btn_exit_bt2);
        btnExit.setText(Constant.EXIT);
        TextView tvNameTitle = findViewById(R.id.tv_name_title);
        tvNameTitle.setText("Tên vừa nhập vào");
        edtName = findViewById(R.id.edt_name);
        tvName = findViewById(R.id.tv_name);

    }

    private void act() {
        btnExit.setOnClickListener(v -> finish());
        edtName.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tvName.setText(s);
            }
        });
    }
}