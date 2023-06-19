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

        btn_add[0] = findViewById(R.id.btn_add1);
        btn_add[1] = findViewById(R.id.btn_add2);
        btn_add[2] = findViewById(R.id.btn_add3);
        btn_add[3] = findViewById(R.id.btn_add4);
        btn_add[4] = findViewById(R.id.btn_add5);
        btn_add[5] = findViewById(R.id.btn_add6);
        btn_add[6] = findViewById(R.id.btn_add7);
        btn_add[7] = findViewById(R.id.btn_add8);

        drink_count[0] = findViewById(R.id.drink1_count);
        drink_count[1] = findViewById(R.id.drink2_count);
        drink_count[2] = findViewById(R.id.drink3_count);
        drink_count[3] = findViewById(R.id.drink4_count);
        drink_count[4] = findViewById(R.id.drink5_count);
        drink_count[5] = findViewById(R.id.drink6_count);
        drink_count[6] = findViewById(R.id.drink7_count);
        drink_count[7] = findViewById(R.id.drink8_count);

        drink_price[0] = findViewById(R.id.drink1_price);
        drink_price[1] = findViewById(R.id.drink2_price);
        drink_price[2] = findViewById(R.id.drink3_price);
        drink_price[3] = findViewById(R.id.drink4_price);
        drink_price[4] = findViewById(R.id.drink5_price);
        drink_price[5] = findViewById(R.id.drink6_price);
        drink_price[6] = findViewById(R.id.drink7_price);
        drink_price[7] = findViewById(R.id.drink8_price);




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