package com.example.test00_vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    LinearLayout drink_list, drink_list2, drink_list3;

    TextView total, change_money;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        drink_list = findViewById(R.id.drink_list);
        drink_list2 = findViewById(R.id.drink_list2);
        drink_list3 = findViewById(R.id.drink_list3);
        total = findViewById(R.id.total);
        change_money = findViewById(R.id.change_money);

        for (int i = 0; i < MainActivity.dto.size(); i++) {
            if (CommonVal.drink_cnt_list[i] > 0) {
                drink_list.addView(createTextView(CommonVal.names[i], Gravity.LEFT));
            }

        }
        for (int i = 0; i < MainActivity.dto.size(); i++) {
            if (CommonVal.drink_cnt_list[i] > 0) {
                drink_list2.addView(createTextView(CommonVal.drink_cnt_list[i] + "개", Gravity.CENTER));
            }

        }
        for (int i = 0; i < MainActivity.dto.size(); i++) {
            if (CommonVal.drink_cnt_list[i] > 0) {
                drink_list3.addView(createTextView(MainActivity.dto.get(i).getCost() * CommonVal.drink_cnt_list[i] + "원", Gravity.RIGHT));
            }

        }

        money();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 1000 * 5);
    }

    @Override
    protected void onPause() {
        super.onPause();
        CommonVal.drink_cnt_list = new int[]{
                0, 0, 0, 0, 0, 0, 0, 0
        };
        MainActivity.edt_insert.setText("");
        MainActivity.change.setText("");
        MainActivity.money = 0;

    }


    public TextView createTextView(String text, int gravity ) {
        TextView textView = new TextView(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textView.setText(text);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        textView.setGravity(gravity);//Gravity.LEFT
        textView.setLayoutParams(params);
        return textView;
    }

    public void money() {
        int totalSum = 0;
        for (int i = 0; i < MainActivity.dto.size(); i++) {
            totalSum += MainActivity.dto.get(i).getCost() * CommonVal.drink_cnt_list[i];
        }
        total.setText(totalSum + "원");
        change_money.setText(MainActivity.money + "원");
    }
}