package com.example.atividade01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
;import java.util.Random;

public class SegundaTela extends AppCompatActivity {
    Button button;
    Button button1;
    TextView textView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda_tela);

        button = findViewById(R.id.button);
        button1 = findViewById(R.id.button2);
        textView = findViewById(R.id.rndNum);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rand = new Random();
                int random_number = rand.nextInt(100);
                String random = String.valueOf(random_number);
                textView.setText(random);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SegundaTela.class);
                startActivity(i);
                finish();
            }
        });
    }
}
