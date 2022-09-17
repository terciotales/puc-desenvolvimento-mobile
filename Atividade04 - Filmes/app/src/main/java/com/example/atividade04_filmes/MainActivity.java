package com.example.atividade04_filmes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button enviar;
    EditText filme1;
    EditText filme2;
    EditText filme3;
    EditText filme4;
    EditText filme5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enviar = findViewById(R.id.enviar);
        filme1 = findViewById(R.id.filme1);
        filme2 = findViewById(R.id.filme2);
        filme3 = findViewById(R.id.filme3);
        filme4 = findViewById(R.id.filme4);
        filme5 = findViewById(R.id.filme5);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!filme1.getText().toString().isEmpty() && !filme2.getText().toString().isEmpty() && !filme3.getText().toString().isEmpty() && !filme4.getText().toString().isEmpty() && !filme5.getText().toString().isEmpty()) {
                    Intent i = new Intent(MainActivity.this, SegundaTela.class);
                    i.putExtra("filme1", filme1.getText().toString());
                    i.putExtra("filme2", filme2.getText().toString());
                    i.putExtra("filme3", filme3.getText().toString());
                    i.putExtra("filme4", filme4.getText().toString());
                    i.putExtra("filme5", filme5.getText().toString());
                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "É necessário preencher o nome de todos os filmes!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}