package com.example.test00_vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton btn_insert1, btn_insert2, btn_change, btn_add, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn_user;

    TextView text_cost1, text_cost2, text_cost3, text_cost4;

    public static ArrayList<MainDTO> dto = new ArrayList<>();

    TextView text_cost5, text_cost6, text_cost7, text_cost8;
    static EditText edt_insert;
    static int money;
    static TextView change;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (dto.isEmpty()) {
            for (int i = 0; i < CommonVal.names.length; i++) {
                dto.add(new MainDTO(CommonVal.names[i], CommonVal.price[i], CommonVal.cnt[i]));
            }
        }
        btn_insert1 = findViewById(R.id.btn_insert1);
        btn_insert2 = findViewById(R.id.btn_insert2);
        edt_insert = findViewById(R.id.edt_insert);
        btn_change = findViewById(R.id.btn_change);
        btn_add = findViewById(R.id.btn_add);
        btn_user = findViewById(R.id.btn_user);
        change = findViewById(R.id.change);
        edt_insert = findViewById(R.id.edt_insert);
        btn_insert1.setOnClickListener(this);
        btn_insert2.setOnClickListener(this);
        btn_change.setOnClickListener(this);

        text_cost1 = findViewById(R.id.text_cost1);
        text_cost2 = findViewById(R.id.text_cost2);
        text_cost3 = findViewById(R.id.text_cost3);
        text_cost4 = findViewById(R.id.text_cost4);
        text_cost5 = findViewById(R.id.text_cost5);
        text_cost6 = findViewById(R.id.text_cost6);
        text_cost7 = findViewById(R.id.text_cost7);
        text_cost8 = findViewById(R.id.text_cost8);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);

        ImageButton[] buttons = {btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8};
        TextView[] textViews = {text_cost1, text_cost2, text_cost3, text_cost4, text_cost5, text_cost6, text_cost7, text_cost8};

        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setOnClickListener(this);
            textViews[i].setText(dto.get(i).getCost() + "원");
        }

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, CheckPassword.class);
                startActivity(intent);
            }
        });

        btn_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, Suggest.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_insert1) {
            try {
                int addMoney = Integer.parseInt(edt_insert.getText().toString());
                int charge = addMoney;
                charge = charge % 10;

                if (charge != 0 || addMoney >= 1000) {
                    Toast.makeText(MainActivity.this, "반환됨. 동전만 넣어주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    money += addMoney;
                    Toast.makeText(MainActivity.this, "금액 입력이 완료되었습니다." + money+"원", Toast.LENGTH_SHORT).show();
                    change.setText(money + "원");
                    handle_imageButton();
                }
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "입력 오류. 숫자 값만 입력해주세요.", Toast.LENGTH_SHORT).show();
            }

        } else if (v.getId() == R.id.btn_insert2) {
            try {
                int addMoney = Integer.parseInt(edt_insert.getText().toString());
                int charge = addMoney;
                charge = charge % 1000;

                if (charge != 0) {
                    Toast.makeText(MainActivity.this, "반환됨. 지폐만 넣어주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    money += addMoney;
                    Toast.makeText(MainActivity.this, "금액 입력이 완료되었습니다." + money+"원", Toast.LENGTH_SHORT).show();
                    change.setText(money + "원");
                    handle_imageButton();
                }
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "입력 오류. 숫자 값만 입력해주세요.", Toast.LENGTH_SHORT).show();
            }
        } else if (v.getId() == R.id.btn1) {
            handle_drink_button(0);
        } else if (v.getId() == R.id.btn2) {
            handle_drink_button(1);
        } else if (v.getId() == R.id.btn3) {
            handle_drink_button(2);
        } else if (v.getId() == R.id.btn4) {
            handle_drink_button(3);
        } else if (v.getId() == R.id.btn5) {
            handle_drink_button(4);
        } else if (v.getId() == R.id.btn6) {
            handle_drink_button(5);
        } else if (v.getId() == R.id.btn7) {
            handle_drink_button(6);
        } else if (v.getId() == R.id.btn8) {
            handle_drink_button(7);
        } else if (v.getId() == R.id.btn_change) {
            intent = new Intent(MainActivity.this, ResultActivity.class);
            ImageButton[] buttons = {btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8};
            for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setImageResource(R.drawable.btn2);
            }
            startActivity(intent);
        }
    }

    public void handle_drink_button(int drink_order) {
        if (dto.get(drink_order).getCnt() > 0) {
            if (money >= dto.get(drink_order).getCost()) {
                dto.set(drink_order, new MainDTO(dto.get(drink_order).getName(), dto.get(drink_order).getCost(), dto.get(drink_order).getCnt() - 1));
                money -= dto.get(drink_order).getCost();
                change.setText("잔액 : " + money + "원");
                CommonVal.drink_cnt_list[drink_order]++;
                Toast.makeText(this, dto.get(drink_order).getName() + " 선택이 완료되었습니다..", Toast.LENGTH_SHORT).show();
                ImageButton[] buttons = {btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8};
                for (int i = 0; i < buttons.length; i++) {
                    if (money < CommonVal.price[i] || MainActivity.dto.get(i).getCnt() < 1) {
                        buttons[i].setImageResource(R.drawable.btn2);
                    }
                }
            } else {
                Toast.makeText(this, "잔액이 부족합니다.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "재고가 부족합니다.", Toast.LENGTH_SHORT).show();
        }
    }

    public void handle_imageButton() {
        ImageButton[] buttons = {btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8};
        for (int i = 0; i < buttons.length; i++) {
            if (money >= CommonVal.price[i]) {
                buttons[i].setImageResource(R.drawable.btn);
            }
        }
    }


}