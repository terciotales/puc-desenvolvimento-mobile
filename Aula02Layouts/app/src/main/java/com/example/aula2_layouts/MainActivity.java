package com.example.aula2_layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn01;
    Button btn02;
    EditText txt01;
    EditText txt02;
    TextView sumtext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.novo_layout);

        txt01 = findViewById(R.id.txt01);
        txt02 = findViewById(R.id.txt02);
        btn01 = findViewById(R.id.btn1);
        btn02 = findViewById(R.id.btn2);
        sumtext = findViewById(R.id.sumtext);

        btn01.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                String text = txt01.getText().toString() + txt02.getText().toString();
                sumtext.setText(text);
            }
        });

        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SegundaAtividade.class);
                startActivity(i);
                finish();
            }
        });
    }
}