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

    ImageButton btn_insert1, btn_insert2, btn_change, btn_add, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;

    TextView text_cost1, text_cost2, text_cost3, text_cost4;

    ArrayList<MainDTO> dto = new ArrayList<>();

    //   TextView text_cnt1, text_cnt2, text_cnt3, text_cnt4;
    TextView text_cost5, text_cost6, text_cost7, text_cost8;
    EditText edt_insert;
    int money;
    TextView change;
    Intent intent;

    int drink_cnt1, drink_cnt2, drink_cnt3, drink_cnt4;
    int drink_cnt5, drink_cnt6, drink_cnt7, drink_cnt8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < CommonVal.names.length; i++) {
            dto.add(new MainDTO(CommonVal.names[i], CommonVal.price[i], CommonVal.cnt[i]));

        }
        btn_insert1 = findViewById(R.id.btn_insert1);
        btn_insert2 = findViewById(R.id.btn_insert2);
//        dto.add(new MainDTO("콜라", 800, 10));
//        dto.add(new MainDTO("사이다", 900, 15));
//        dto.add(new MainDTO("환타", 700, 8));
//        dto.add(new MainDTO("실론티", 100, 9));
//        dto.add(new MainDTO("음료5", 400, 4));
//        dto.add(new MainDTO("음료6", 300, 3));
//        dto.add(new MainDTO("음료7", 200, 2));
//        dto.add(new MainDTO("음료8", 100, 1));
        edt_insert = findViewById(R.id.edt_insert);
        btn_change = findViewById(R.id.btn_change);
        btn_add = findViewById(R.id.btn_add);
        change = findViewById(R.id.change);
        edt_insert = findViewById(R.id.edt_insert);
        btn_insert1.setOnClickListener(this);
        btn_insert2.setOnClickListener(this);
        btn_change.setOnClickListener(this);

        text_cost1 = findViewById(R.id.text_cost1);
        btn1 = findViewById(R.id.btn1);
        text_cost2 = findViewById(R.id.text_cost2);
        btn2 = findViewById(R.id.btn2);
        text_cost3 = findViewById(R.id.text_cost3);
        btn3 = findViewById(R.id.btn3);
        text_cost4 = findViewById(R.id.text_cost4);
        btn4 = findViewById(R.id.btn4);
        text_cost5 = findViewById(R.id.text_cost5);

        btn5 = findViewById(R.id.btn5);
        text_cost6 = findViewById(R.id.text_cost6);
        btn6 = findViewById(R.id.btn6);
        text_cost7 = findViewById(R.id.text_cost7);

        btn7 = findViewById(R.id.btn7);
        text_cost8 = findViewById(R.id.text_cost8);

        btn8 = findViewById(R.id.btn8);


        btn1.setOnClickListener(this);
        text_cost1.setText(dto.get(0).getCost() + "원");
        btn2.setOnClickListener(this);
        text_cost2.setText(dto.get(1).getCost() + "원");
        btn3.setOnClickListener(this);
        text_cost3.setText(dto.get(2).getCost() + "원");
        btn4.setOnClickListener(this);
        text_cost4.setText(dto.get(3).getCost() + "원");
        text_cost4.setText(dto.get(3).getName() + dto.get(3).getCost() + "원");

        btn5.setOnClickListener(this);
        text_cost5.setText(dto.get(4).getName() + dto.get(4).getCost() + "원");

        btn6.setOnClickListener(this);
        text_cost6.setText(dto.get(5).getName() + dto.get(5).getCost() + "원");

        btn7.setOnClickListener(this);
        text_cost7.setText(dto.get(6).getName() + dto.get(6).getCost() + "원");

        btn8.setOnClickListener(this);
        text_cost8.setText(dto.get(7).getName() + dto.get(7).getCost() + "원");


        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, CheckPassword.class);
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
                    Toast.makeText(MainActivity.this, "금액 입력이 완료되었습니다." + money, Toast.LENGTH_SHORT).show();
                    change.setText(money + "원");
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
                    Toast.makeText(MainActivity.this, "금액 입력이 완료되었습니다." + money, Toast.LENGTH_SHORT).show();
                    change.setText(money + "원");
                }
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "입력 오류. 숫자 값만 입력해주세요.", Toast.LENGTH_SHORT).show();
            }
        } else if (v.getId() == R.id.btn1) {
            if (dto.get(0).getCnt() > 0) {
                if (money >= (dto.get(0).getCost())) {
                    dto.set(0, new MainDTO(dto.get(0).getName(), dto.get(0).getCost(), dto.get(0).getCnt() - 1));
                    money -= dto.get(0).getCost();
                    change.setText("잔액 : " + money + "원");
//                    text_cnt1.setText(dto.get(0).getCnt() + "개 남음");
                    drink_cnt1++;
                    Toast.makeText(this, dto.get(0).getName() + " 선택이 완료되었습니다..", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "잔액이 부족합니다.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "재고가 부족합니다.", Toast.LENGTH_SHORT).show();
            }
        } else if (v.getId() == R.id.btn2) {
            if (dto.get(1).getCnt() > 0) {
                if (money >= (dto.get(1).getCost())) {
                    dto.set(1, new MainDTO(dto.get(1).getName(), dto.get(1).getCost(), dto.get(1).getCnt() - 1));
                    money -= dto.get(1).getCost();
                    change.setText("잔액 : " + money + "원");
//                    text_cnt2.setText(dto.get(1).getCnt() + "개 남음");
                    drink_cnt2++;
                    Toast.makeText(this, dto.get(1).getName() + " 선택이 완료되었습니다..", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "잔액이 부족합니다.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "재고가 부족합니다.", Toast.LENGTH_SHORT).show();
            }
        } else if (v.getId() == R.id.btn3) {
            if (dto.get(2).getCnt() > 0) {
                if (money >= (dto.get(2).getCost())) {
                    dto.set(2, new MainDTO(dto.get(2).getName(), dto.get(2).getCost(), dto.get(2).getCnt() - 1));
                    money -= dto.get(2).getCost();
                    change.setText("잔액 : " + money + "원");
//                    text_cnt3.setText(dto.get(2).getCnt() + "개 남음");
                    drink_cnt3++;
                    Toast.makeText(this, dto.get(2).getName() + " 선택이 완료되었습니다..", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "잔액이 부족합니다.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "재고가 부족합니다.", Toast.LENGTH_SHORT).show();
            }
        } else if (v.getId() == R.id.btn4) {
            if (dto.get(3).getCnt() > 0) {
                if (money >= (dto.get(3).getCost())) {
                    dto.set(3, new MainDTO(dto.get(3).getName(), dto.get(3).getCost(), dto.get(3).getCnt() - 1));
                    money -= dto.get(3).getCost();
                    change.setText("잔액 : " + money + "원");
                    //text_cnt4.setText(dto.get(3).getCnt() + "개 남음");
                    drink_cnt4++;
                    Toast.makeText(this, dto.get(3).getName() + " 선택이 완료되었습니다..", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(this, "잔액이 부족합니다.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "재고가 부족합니다.", Toast.LENGTH_SHORT).show();
            }

        } else if (v.getId() == R.id.btn5) {
            if (dto.get(4).getCnt() > 0) {
                if (money >= (dto.get(4).getCost())) {
                    dto.set(4, new MainDTO(dto.get(4).getName(), dto.get(4).getCost(), dto.get(4).getCnt() - 1));
                    money -= dto.get(4).getCost();
                    change.setText("잔액 : " + money + "원");
                    //text_cnt4.setText(dto.get(3).getCnt() + "개 남음");
                    drink_cnt5++;
                    Toast.makeText(this, dto.get(4).getName() + " 선택이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "잔액이 부족합니다.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "재고가 부족합니다.", Toast.LENGTH_SHORT).show();
            }

        } else if (v.getId() == R.id.btn6) {
            if (dto.get(5).getCnt() > 0) {
                if (money >= (dto.get(5).getCost())) {
                    dto.set(5, new MainDTO(dto.get(5).getName(), dto.get(5).getCost(), dto.get(5).getCnt() - 1));
                    money -= dto.get(5).getCost();
                    change.setText("잔액 : " + money + "원");
                    //text_cnt4.setText(dto.get(3).getCnt() + "개 남음");
                    drink_cnt6++;
                    Toast.makeText(this, dto.get(5).getName() + " 선택이 완료되었습니다..", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "잔액이 부족합니다.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "재고가 부족합니다.", Toast.LENGTH_SHORT).show();
            }

        } else if (v.getId() == R.id.btn7) {
            if (dto.get(6).getCnt() > 0) {
                if (money >= (dto.get(6).getCost())) {
                    dto.set(6, new MainDTO(dto.get(6).getName(), dto.get(6).getCost(), dto.get(6).getCnt() - 1));
                    money -= dto.get(6).getCost();
                    change.setText("잔액 : " + money + "원");
                    //text_cnt4.setText(dto.get(3).getCnt() + "개 남음");
                    drink_cnt7++;
                    Toast.makeText(this, dto.get(6).getName() + " 선택이 완료되었습니다..", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "잔액이 부족합니다.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "재고가 부족합니다.", Toast.LENGTH_SHORT).show();
            }

        } else if (v.getId() == R.id.btn7) {
            if (dto.get(6).getCnt() > 0) {
                if (money >= (dto.get(6).getCost())) {
                    dto.set(6, new MainDTO(dto.get(6).getName(), dto.get(6).getCost(), dto.get(6).getCnt() - 1));
                    money -= dto.get(6).getCost();
                    change.setText("잔액 : " + money + "원");
                    //text_cnt4.setText(dto.get(3).getCnt() + "개 남음");
                    drink_cnt8++;
                    Toast.makeText(this, dto.get(6).getName() + " 선택이 완료되었습니다..", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "잔액이 부족합니다.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "재고가 부족합니다.", Toast.LENGTH_SHORT).show();
            }

        } else if (v.getId() == R.id.btn_change) {
            intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("money", money);
            //  음료 이름, 선택한 음료 개수
            if (drink_cnt1 != 0) {
                intent.putExtra("name1", dto.get(0).getName());
                intent.putExtra("drink_cnt1", drink_cnt1);
            }
            if (drink_cnt2 != 0) {
                intent.putExtra("name2", dto.get(1).getName());
                intent.putExtra("drink_cnt2", drink_cnt2);
            }
            if (drink_cnt3 != 0) {
                intent.putExtra("name3", dto.get(2).getName());
                intent.putExtra("drink_cnt3", drink_cnt3);
            }
            if (drink_cnt4 != 0) {
                intent.putExtra("name4", dto.get(3).getName());
                intent.putExtra("drink_cnt4", drink_cnt4);
            }
            if (drink_cnt5 != 0) {
                intent.putExtra("name5", dto.get(4).getName());
                intent.putExtra("drink_cnt5", drink_cnt5);
            }
            if (drink_cnt6 != 0) {
                intent.putExtra("name6", dto.get(5).getName());
                intent.putExtra("drink_cnt6", drink_cnt6);
            }
            if (drink_cnt7 != 0) {
                intent.putExtra("name7", dto.get(6).getName());
                intent.putExtra("drink_cnt7", drink_cnt7);
            }
            if (drink_cnt8 != 0) {
                intent.putExtra("name8", dto.get(7).getName());
                intent.putExtra("drink_cnt8", drink_cnt8);
            }
            startActivity(intent);
        }
    }
}