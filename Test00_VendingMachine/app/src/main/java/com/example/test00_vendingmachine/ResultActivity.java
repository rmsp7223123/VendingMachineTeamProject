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

    TextView total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        drink_list = findViewById(R.id.drink_list);
        drink_list2 = findViewById(R.id.drink_list2);
        drink_list3 = findViewById(R.id.drink_list3);
        total = findViewById(R.id.total);

        for (int i = 0; i < MainActivity.dto.size(); i++) {
            if (CommonVal.drink_cnt_list[i] > 0) {
                drink_list.addView(createTextViewLeft(CommonVal.names[i]));
            }

        }
        for (int i = 0; i < MainActivity.dto.size(); i++) {
            if (CommonVal.drink_cnt_list[i] > 0) {
                drink_list2.addView(createTextViewCenter( CommonVal.drink_cnt_list[i] + "개"));
            }

        }
        for (int i = 0; i < MainActivity.dto.size(); i++) {
            if (CommonVal.drink_cnt_list[i] > 0) {
                drink_list3.addView(createTextViewRight(MainActivity.dto.get(i).getCost() * CommonVal.drink_cnt_list[i] + "원"));
            }

        }

        total.setText("");

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
        drink_list.removeAllViews();
        drink_list2.removeAllViews();
        drink_list3.removeAllViews();
        MainActivity.edt_insert.setText("");
        MainActivity.change.setText("");
    }



    public TextView createTextViewLeft(String text) {
        TextView textView = new TextView(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textView.setText(text);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        textView.setGravity(Gravity.LEFT);
        textView.setLayoutParams(params);
        return textView;
    }

    public TextView createTextViewCenter(String text) {
        TextView textView = new TextView(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textView.setText(text);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        textView.setGravity(Gravity.CENTER);
        textView.setLayoutParams(params);
        return textView;
    }

    public TextView createTextViewRight(String text) {
        TextView textView = new TextView(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textView.setText(text);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        textView.setGravity(Gravity.RIGHT);
        textView.setLayoutParams(params);
        return textView;
    }

    public void totalPrice() {
        for (int i = 0; i < MainActivity.dto.size(); i++) {

        }
    }
}