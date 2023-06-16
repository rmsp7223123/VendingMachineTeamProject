package com.example.test00_vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class ManageDrink extends AppCompatActivity {

    Button btn_count_commit, btn_count_cancel;
    EditText drink1_count, drink2_count, drink3_count, drink4_count, drink1_price, drink2_price, drink3_price, drink4_price;

    Intent intent;

    ArrayList<MainDTO> dto = new ArrayList<>();

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
        drink1_price = findViewById(R.id.drink1_price);
        drink2_price = findViewById(R.id.drink2_price);
        drink3_price = findViewById(R.id.drink3_price);
        drink4_price = findViewById(R.id.drink4_price);

        drink1_count.setText(CommonVal.cnt[0] + "");
        drink2_count.setText(CommonVal.cnt[1] + "");
        drink3_count.setText(CommonVal.cnt[2] + "");
        drink4_count.setText(CommonVal.cnt[3] + "");
        drink1_price.setText(CommonVal.price[0] + "");
        drink2_price.setText(CommonVal.price[1] + "");
        drink3_price.setText(CommonVal.price[2] + "");
        drink4_price.setText(CommonVal.price[3] + "");

        btn_count_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(ManageDrink.this, MainActivity.class);
                CommonVal.cnt[0] = rtnInt(drink1_count.getText().toString());
                CommonVal.cnt[1] = rtnInt(drink2_count.getText().toString());
                CommonVal.cnt[2] = rtnInt(drink3_count.getText().toString());
                CommonVal.cnt[3] = rtnInt(drink4_count.getText().toString());
                CommonVal.price[0] = rtnInt(drink1_price.getText().toString());
                CommonVal.price[1] = rtnInt(drink2_price.getText().toString());
                CommonVal.price[2] = rtnInt(drink3_price.getText().toString());
                CommonVal.price[3] = rtnInt(drink4_price.getText().toString());
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

    public int rtnInt(String strData) {
        try {
            return Integer.parseInt(strData);
        } catch (Exception e) {
            return 0;
        }
    }
}