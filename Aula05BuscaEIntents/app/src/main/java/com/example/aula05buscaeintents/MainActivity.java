package com.example.aula05buscaeintents;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText busca;
    ListView lista;
    EditText ed01;
    Button btn;
    Button btn_delete;

    ArrayAdapter adapter;
    ArrayList<String> nomes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        busca = findViewById(R.id.busca);
        lista = findViewById(R.id.lista);
        ed01 = findViewById(R.id.ed01);
        btn = findViewById(R.id.btn01);
        btn_delete = findViewById(R.id.btn_delete);

        MainActivity.this.nomes.add("Humberto Gessinger - 62");
        MainActivity.this.nomes.add("Billie Eilish - 61");
        MainActivity.this.nomes.add("Cristiano Ronaldo - 99");
        MainActivity.this.nomes.add("Mateus França - 26564");
        MainActivity.this.nomes.add("Sadio Mané - 5485451");

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, MainActivity.this.nomes);

        lista.setAdapter(MainActivity.this.adapter);

        busca.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                MainActivity.this.adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = ed01.getText().toString();

                if (!text.isEmpty() && !MainActivity.this.nomes.contains(text)) {
                    MainActivity.this.nomes.add(text);

                    lista.setAdapter(MainActivity.this.adapter);

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
                String contato = MainActivity.this.nomes.get(i);
                String nome = contato.split("-")[0];
                String telefone = contato.split("-")[1];
                Intent j = new Intent(MainActivity.this, SegundaTela.class);
                j.putExtra("nome", nome);
                j.putExtra("telefone", telefone);
                startActivity(j);
                finish();
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lista.getCount() > 0) {
                    MainActivity.this.adapter.clear();
                }
            }
        });
    }
}