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

    String nome;
    Button btn01;
    EditText num1;
    EditText num2;
    TextView sumtext;

    String soma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.novo_layout);

        btn01 = findViewById(R.id.btn1);

        btn01.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SegundaAtividade.class);
                startActivity(i);
            }
        });
    }
}