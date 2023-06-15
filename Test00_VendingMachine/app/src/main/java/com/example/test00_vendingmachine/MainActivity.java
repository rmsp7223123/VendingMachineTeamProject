package com.example.test00_vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn_insert, btn_change, btn_add;
    EditText edt_insert;
    int money;
    TextView change;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_insert = findViewById(R.id.btn_insert);
        edt_insert = findViewById(R.id.edt_insert);
        btn_change = findViewById(R.id.btn_change);
        btn_add = findViewById(R.id.btn_add);
        change = findViewById(R.id.change);
        btn_insert.setOnClickListener(this);
        btn_change.setOnClickListener(this);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this , CheckPassword.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_insert) {
            int[] arr = {100, 500, 1000, 5000, 10000};
            try {
                int addMoney = Integer.parseInt(edt_insert.getText().toString());
                int tempMoney = addMoney;
                int charge = addMoney;
                for (int i = 0; i < arr.length; i++) {
                    tempMoney = charge / arr[i];
                    charge = charge % arr[i];
                    if (charge == 0) {
                        break;
                    }
                }
                if (charge != 0) {
                    Toast.makeText(MainActivity.this, "반환됨. 금액을 다시 입력해주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    money += addMoney;
                    Toast.makeText(MainActivity.this, "금액 입력이 완료되었습니다." + money, Toast.LENGTH_SHORT).show();
                    change.setText("잔액 : "+money+"원");
                }
            }catch (Exception e) {
                Toast.makeText(MainActivity.this, "입력 오류. 숫자 값만 입력해주세요.", Toast.LENGTH_SHORT).show();
            }

        }else if(v.getId()==R.id.btn_change) {
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("money", money);
            startActivity(intent);
        }

        }

}