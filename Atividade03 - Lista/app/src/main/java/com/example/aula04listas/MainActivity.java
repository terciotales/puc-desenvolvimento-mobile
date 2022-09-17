package com.example.aula04listas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    EditText ed01;
    Button btn;
    Button btn_delete;
    Button crescente;
    Button decrescente;
    Button aleatorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.lista);
        ed01 = findViewById(R.id.ed01);
        btn = findViewById(R.id.btn01);
        btn_delete = findViewById(R.id.btn_delete);
        crescente = findViewById(R.id.crescente);
        decrescente = findViewById(R.id.decrescente);
        aleatorio = findViewById(R.id.aleatorio);


        ArrayList<String> nomes = new ArrayList<>();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, nomes);

        nomes.add("Thiago");
        nomes.add("Ana");
        nomes.add("Pablo");
        nomes.add("Tales");
        nomes.add("Marcos");
        nomes.add("Paulo");
        nomes.add("Jefferson");
        nomes.add("Fernando");

        lista.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = ed01.getText().toString();

                if (!text.isEmpty() && !nomes.contains(text)) {
                    nomes.add(text);

                    lista.setAdapter(adapter);

                    ed01.setText("");

                    Toast.makeText(MainActivity.this, "Nome " + text + " foi adicionado.", Toast.LENGTH_SHORT).show();
                } else if (text.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Não há texto para adicionar.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "O nome " + text + " já foi adicionado na lista.", Toast.LENGTH_SHORT).show();

                    ed01.setText("");
                }
            }
        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Clicou em " + nomes.get(i), Toast.LENGTH_SHORT).show();
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

        crescente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.sort(nomes);
                lista.setAdapter(adapter);
            }
        });

        decrescente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.sort(nomes);
                Collections.reverse(nomes);
                lista.setAdapter(adapter);
            }
        });

        aleatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.shuffle(nomes);
                lista.setAdapter(adapter);
            }
        });
    }
}