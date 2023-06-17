package com.example.test00_vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView change, drink1,drink2, drink3, drink4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        change = findViewById(R.id.change);
        drink1 = findViewById(R.id.drink1);
        drink2 = findViewById(R.id.drink2);
        drink3 = findViewById(R.id.drink3);
        drink4 = findViewById(R.id.drink4);

        Intent intent = getIntent();
        int money = intent.getIntExtra("money", 0);
        change.setText("잔액 : "+money+"원");
        String name1 = intent.getStringExtra("name1");
        int drink_cnt1 = intent.getIntExtra("drink_cnt1", 0);
        String name2 = intent.getStringExtra("name2");
        int drink_cnt2 = intent.getIntExtra("drink_cnt2", 0);
        String name3 = intent.getStringExtra("name3");
        int drink_cnt3 = intent.getIntExtra("drink_cnt3", 0);
        String name4 = intent.getStringExtra("name4");
        int drink_cnt4 = intent.getIntExtra("drink_cnt4", 0);
        if(drink_cnt1!=0) {
            drink1.setText(name1+drink_cnt1+"개");
        }
        if(drink_cnt2!=0) {
            drink2.setText(name2+CommonVal.drink_cnt2+"개");
        }
        if(drink_cnt3!=0) {
            drink3.setText(name3+CommonVal.drink_cnt3+"개");
        }
        if(drink_cnt4!=0) {
            drink4.setText(name4+CommonVal.drink_cnt4+"개");
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        } , 1000 * 3);
    }
}