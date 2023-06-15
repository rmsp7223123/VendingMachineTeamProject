package com.example.test00_vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        change = findViewById(R.id.change);

        Intent intent = getIntent();
        int money = intent.getIntExtra("money", 0);
        change.setText("잔액 : "+money+"원");
        String name1 = intent.getStringExtra("name1");
        int drink_cnt1 = intent.getIntExtra("drink_cnt1", 0);
        String name2 = intent.getStringExtra("name1");
        int drink_cnt2 = intent.getIntExtra("drink_cnt2", 0);
        String name3 = intent.getStringExtra("name1");
        int drink_cnt3 = intent.getIntExtra("drink_cnt3", 0);
        String name4 = intent.getStringExtra("name1");
        int drink_cnt4 = intent.getIntExtra("drink_cnt4", 0);

        if()

    }
}