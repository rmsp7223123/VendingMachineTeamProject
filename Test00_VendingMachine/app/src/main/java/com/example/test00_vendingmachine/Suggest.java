package com.example.test00_vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Suggest extends AppCompatActivity {

    Button btn_sug_commit;
    EditText suggest;





    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggest);


        btn_sug_commit =findViewById(R.id.btn_sug_commit);
        suggest = findViewById(R.id.suggest);



        btn_sug_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Suggest.this, MainActivity.class);

                intent.putExtra("suu", suggest.getText().toString());
                CommonVal.sug_list.add(suggest.getText().toString());



                Log.d("호호", "onClick: "+suggest.getText().toString());
                startActivity(intent);
            }
        });
    }
}