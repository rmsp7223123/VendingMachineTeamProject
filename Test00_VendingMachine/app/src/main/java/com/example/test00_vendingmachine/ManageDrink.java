package com.example.test00_vendingmachine;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ManageDrink extends AppCompatActivity {

    Button btn_count_commit, btn_count_cancel,
            btn_add1, btn_add2, btn_add3, btn_add4, btn_add5, btn_add6, btn_add7, btn_add8,
            btn_del1, btn_del2, btn_del3, btn_del4, btn_del5, btn_del6, btn_del7, btn_del8;

    EditText drink1_count, drink2_count, drink3_count, drink4_count, drink1_price, drink2_price, drink3_price, drink4_price,
            drink5_count, drink6_count, drink7_count, drink8_count, drink5_price, drink6_price, drink7_price, drink8_price;

    Intent intent;
    LinearLayout ln_board;

    ArrayList<MainDTO> dto = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_drink);
        btn_count_commit = findViewById(R.id.btn_count_commit);
        btn_count_cancel = findViewById(R.id.btn_count_cancel);
        btn_add1 = findViewById(R.id.btn_add1);
        btn_add2 = findViewById(R.id.btn_add2);
        btn_add3 = findViewById(R.id.btn_add3);
        btn_add4 = findViewById(R.id.btn_add4);
        btn_add5 = findViewById(R.id.btn_add5);
        btn_add6 = findViewById(R.id.btn_add6);
        btn_add7 = findViewById(R.id.btn_add7);
        btn_add8 = findViewById(R.id.btn_add8);
        btn_del1 = findViewById(R.id.btn_del1);
        btn_del2 = findViewById(R.id.btn_del2);
        btn_del3 = findViewById(R.id.btn_del3);
        btn_del4 = findViewById(R.id.btn_del4);
        btn_del5 = findViewById(R.id.btn_del5);
        btn_del6 = findViewById(R.id.btn_del6);
        btn_del7 = findViewById(R.id.btn_del7);
        btn_del8 = findViewById(R.id.btn_del8);

        drink1_count = findViewById(R.id.drink1_count);
        drink2_count = findViewById(R.id.drink2_count);
        drink3_count = findViewById(R.id.drink3_count);
        drink4_count = findViewById(R.id.drink4_count);
        drink1_price = findViewById(R.id.drink1_price);
        drink2_price = findViewById(R.id.drink2_price);
        drink3_price = findViewById(R.id.drink3_price);
        drink4_price = findViewById(R.id.drink4_price);
        drink5_count = findViewById(R.id.drink5_count);
        drink6_count = findViewById(R.id.drink6_count);
        drink7_count = findViewById(R.id.drink7_count);
        drink8_count = findViewById(R.id.drink8_count);
        drink5_price = findViewById(R.id.drink5_price);
        drink6_price = findViewById(R.id.drink6_price);
        drink7_price = findViewById(R.id.drink7_price);
        drink8_price = findViewById(R.id.drink8_price);
        ln_board = findViewById(R.id.ln_board);

        drink1_count.setText(CommonVal.cnt[0] + "");
        drink2_count.setText(CommonVal.cnt[1] + "");
        drink3_count.setText(CommonVal.cnt[2] + "");
        drink4_count.setText(CommonVal.cnt[3] + "");
        drink1_price.setText(CommonVal.price[0] + "");
        drink2_price.setText(CommonVal.price[1] + "");
        drink3_price.setText(CommonVal.price[2] + "");
        drink4_price.setText(CommonVal.price[3] + "");
        drink5_count.setText(CommonVal.cnt[4] + "");
        drink6_count.setText(CommonVal.cnt[5] + "");
        drink7_count.setText(CommonVal.cnt[6] + "");
        drink8_count.setText(CommonVal.cnt[7] + "");
        drink5_price.setText(CommonVal.price[4] + "");
        drink6_price.setText(CommonVal.price[5] + "");
        drink7_price.setText(CommonVal.price[6] + "");
        drink8_price.setText(CommonVal.price[7] + "");



        btn_add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommonVal.cnt[0] = rtnInt(drink1_count.getText().toString());
                CommonVal.price[0] = rtnInt(drink1_price.getText().toString());
            }
        });

        btn_del1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drink1_count.setText(String.valueOf(0));
                drink1_price.setText(String.valueOf(0));
            }
        });
        btn_add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommonVal.cnt[1] = rtnInt(drink2_count.getText().toString());
                CommonVal.price[1] = rtnInt(drink2_price.getText().toString());
            }
        });

        btn_del2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drink2_count.setText(String.valueOf(0));
                drink2_price.setText(String.valueOf(0));
            }
        });
        btn_add3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommonVal.cnt[2] = rtnInt(drink3_count.getText().toString());
                CommonVal.price[2] = rtnInt(drink3_price.getText().toString());
            }
        });

        btn_del3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drink3_count.setText(String.valueOf(0));
                drink3_price.setText(String.valueOf(0));
            }
        });
        btn_add4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommonVal.cnt[3] = rtnInt(drink4_count.getText().toString());
                CommonVal.price[3] = rtnInt(drink4_price.getText().toString());
            }
        });

        btn_del4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drink4_count.setText(String.valueOf(0));
                drink4_price.setText(String.valueOf(0));
            }
        });
        btn_add5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommonVal.cnt[4] = rtnInt(drink5_count.getText().toString());
                CommonVal.price[4] = rtnInt(drink5_price.getText().toString());
            }
        });

        btn_del5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drink5_count.setText(String.valueOf(0));
                drink5_price.setText(String.valueOf(0));
            }
        });
        btn_add6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                CommonVal.cnt[5] = rtnInt(drink6_count.getText().toString());
                CommonVal.price[5] = rtnInt(drink6_price.getText().toString());
            }
        });

        btn_del6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drink6_count.setText(String.valueOf(0));
                drink6_price.setText(String.valueOf(0));
            }
        });
        btn_add7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommonVal.cnt[6] = rtnInt(drink7_count.getText().toString());
                CommonVal.price[6] = rtnInt(drink7_price.getText().toString());
            }
        });

        btn_del7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drink7_count.setText(String.valueOf(0));
                drink7_price.setText(String.valueOf(0));
            }
        });
        btn_add8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommonVal.cnt[7] = rtnInt(drink8_count.getText().toString());
                CommonVal.price[7] = rtnInt(drink8_price.getText().toString());
            }
        });

        btn_del8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drink8_count.setText(String.valueOf(0));
                drink8_price.setText(String.valueOf(0));
            }
        });

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
                CommonVal.cnt[0] = rtnInt(drink1_count.getText().toString());
                CommonVal.cnt[1] = rtnInt(drink2_count.getText().toString());
                CommonVal.cnt[2] = rtnInt(drink3_count.getText().toString());
                CommonVal.cnt[3] = rtnInt(drink4_count.getText().toString());
                CommonVal.price[0] = rtnInt(drink1_price.getText().toString());
                CommonVal.price[1] = rtnInt(drink2_price.getText().toString());
                CommonVal.price[2] = rtnInt(drink3_price.getText().toString());
                CommonVal.price[3] = rtnInt(drink4_price.getText().toString());
                CommonVal.cnt[4] = rtnInt(drink1_count.getText().toString());
                CommonVal.cnt[5] = rtnInt(drink2_count.getText().toString());
                CommonVal.cnt[6] = rtnInt(drink3_count.getText().toString());
                CommonVal.cnt[7] = rtnInt(drink4_count.getText().toString());
                CommonVal.price[4] = rtnInt(drink1_price.getText().toString());
                CommonVal.price[5] = rtnInt(drink2_price.getText().toString());
                CommonVal.price[6] = rtnInt(drink3_price.getText().toString());
                CommonVal.price[7] = rtnInt(drink4_price.getText().toString());

                startActivity(intent);
            }
        });


        ArrayList<String> boardLIst = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            boardLIst.add("글" + i);
        }

        for (int i = 0; i < boardLIst.size(); i++) {
            ln_board.addView(createTextView(boardLIst.get(i)));
        }
    }

    public int rtnInt(String strData) {
        try {
            return Integer.parseInt(strData);
        } catch (Exception e) {
            return 0;
        }
    }

    public TextView createTextView(String text){
        TextView textView = new TextView(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT , ViewGroup.LayoutParams.WRAP_CONTENT);
        textView.setText(text);
        textView.setLayoutParams(params);
        return textView;
    }


}