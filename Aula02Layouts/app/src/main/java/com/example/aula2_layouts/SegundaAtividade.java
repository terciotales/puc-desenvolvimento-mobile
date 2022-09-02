package com.example.aula2_layouts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;


public class SegundaAtividade extends AppCompatActivity {

    Button button;
    Button button1;
    TextView textView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                Intent i = new Intent(SegundaAtividade.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
