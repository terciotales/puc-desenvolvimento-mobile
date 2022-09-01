package com.example.aula05buscaeintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SegundaTela extends AppCompatActivity {

    TextView nome, telefone;
    Button voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);
        nome = findViewById(R.id.textView);
        telefone = findViewById(R.id.textView2);
        voltar = findViewById(R.id.button);

        Intent dadosRecebidos = getIntent();

        nome.setText("Nome: " + dadosRecebidos.getStringExtra("nome"));
        telefone.setText("Nome: " + dadosRecebidos.getStringExtra("telefone"));

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SegundaTela.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });


    }
}