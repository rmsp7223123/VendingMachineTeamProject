package com.example.test00_vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CheckPassword extends AppCompatActivity {

    Button btn_password, btn_password_cancel;
    EditText edt_password;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_password);
        btn_password = findViewById(R.id.btn_password);
        edt_password = findViewById(R.id.edt_password);

        btn_password_cancel = findViewById(R.id.btn_password_cancel);
        btn_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt_password.getText().toString().equals("0000")) {
                    intent = new Intent(CheckPassword.this, ManageDrink.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(CheckPassword.this, "비밀번호가 틀렸습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_password_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(CheckPassword.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}