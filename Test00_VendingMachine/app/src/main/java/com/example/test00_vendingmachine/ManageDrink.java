package com.example.test00_vendingmachine;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ManageDrink extends AppCompatActivity implements View.OnClickListener {

    private Button[] btn_add = new Button[8];
    private EditText[] drink_count = new EditText[8];
    private EditText[] drink_price = new EditText[8];
    private Button btn_count_commit, btn_count_cancel;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_drink);

        btn_count_commit = findViewById(R.id.btn_count_commit);
        btn_count_cancel = findViewById(R.id.btn_count_cancel);

        Button[] btn_arr = {findViewById(R.id.btn_add1), findViewById(R.id.btn_add2), findViewById(R.id.btn_add3), findViewById(R.id.btn_add4),
                findViewById(R.id.btn_add5), findViewById(R.id.btn_add6), findViewById(R.id.btn_add7), findViewById(R.id.btn_add8)};
        EditText[] drink_count_arr = {findViewById(R.id.drink1_count), findViewById(R.id.drink2_count), findViewById(R.id.drink3_count), findViewById(R.id.drink4_count),
                findViewById(R.id.drink5_count), findViewById(R.id.drink6_count), findViewById(R.id.drink7_count), findViewById(R.id.drink8_count)};
        EditText[] drink_price_arr = {findViewById(R.id.drink1_price), findViewById(R.id.drink2_price), findViewById(R.id.drink3_price), findViewById(R.id.drink4_price),
                findViewById(R.id.drink5_price), findViewById(R.id.drink6_price), findViewById(R.id.drink7_price), findViewById(R.id.drink8_price)};


        for (int i = 0; i < btn_add.length; i++) {
            btn_add[i] = btn_arr[i];
        }

        for (int i = 0; i < drink_count.length; i++) {
            drink_count[i] = drink_count_arr[i];
        }

        for (int i = 0; i < drink_price.length; i++) {
            drink_price[i] = drink_price_arr[i];
        }


        for (int i = 0; i < btn_add.length; i++) {
            btn_add[i].setOnClickListener(this);
        }

        btn_count_cancel.setOnClickListener(this);
        btn_count_commit.setOnClickListener(this);

        updateDrinkValues();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btn_count_commit.getId()) {
            updateCommonVal();
            intent = new Intent(ManageDrink.this, MainActivity.class);
            MainActivity.money = 0;
            startActivity(intent);
        } else if (v.getId() == btn_count_cancel.getId()) {
            intent = new Intent(ManageDrink.this, MainActivity.class);
            MainActivity.money = 0;
            startActivity(intent);
        } else {
            for (int i = 0; i < btn_add.length; i++) {
                if (v.getId() == btn_add[i].getId()) {
                    MainActivity.dto.set(i, new MainDTO(MainActivity.dto.get(i).getName(),
                            rtnInt(drink_price[i].getText().toString()),
                            rtnInt(drink_count[i].getText().toString())));
                }
            }
        }
    }

    private void updateDrinkValues() {
        for (int i = 0; i < drink_count.length; i++) {
            drink_count[i].setText(CommonVal.cnt[i] + "");
            drink_price[i].setText(CommonVal.price[i] + "");
        }
    }

    private void updateCommonVal() {
        for (int i = 0; i < drink_count.length; i++) {
            CommonVal.cnt[i] = rtnInt(drink_count[i].getText().toString());
            CommonVal.price[i] = rtnInt(drink_price[i].getText().toString());
        }
    }

    private int rtnInt(String strData) {
        try {
            return Integer.parseInt(strData);
        } catch (Exception e) {
            return 0;
        }
    }
}