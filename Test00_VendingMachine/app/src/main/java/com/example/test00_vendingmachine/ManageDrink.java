package com.example.test00_vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ManageDrink extends AppCompatActivity {

    Button btn_count_commit, btn_count_cancel;
    EditText drink1_count, drink2_count, drink3_count, drink4_count;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_drink);
        btn_count_commit = findViewById(R.id.btn_count_commit);
        btn_count_cancel = findViewById(R.id.btn_count_cancel);
        drink1_count = findViewById(R.id.drink1_count);
        drink2_count = findViewById(R.id.drink2_count);
        drink3_count = findViewById(R.id.drink3_count);
        drink4_count = findViewById(R.id.drink4_count);

        btn_count_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(ManageDrink.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn_count_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(ManageDrink.this, MainActivity.class);


                startActivity(intent);
            }
        });
    }
}