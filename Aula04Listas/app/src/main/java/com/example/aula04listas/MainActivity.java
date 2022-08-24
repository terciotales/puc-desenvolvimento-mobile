package com.example.aula04listas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    EditText ed01;
    Button btn;
    Button btn_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.lista);
        ed01 = findViewById(R.id.ed01);
        btn = findViewById(R.id.btn01);
        btn_delete = findViewById(R.id.btn_delete);

        ArrayList<String> nomes = new ArrayList<>();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, nomes);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nomes.add(ed01.getText().toString());

                lista.setAdapter(adapter);
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lista.getCount() > 0) {
                    adapter.clear();
                }
            }
        });
    }
}