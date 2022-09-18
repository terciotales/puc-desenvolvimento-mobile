package com.example.atividade04_filmes;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SegundaTela extends AppCompatActivity {

    ListView lista;
    EditText busca;

    ArrayAdapter adapter;
    ArrayList<String> filmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda_tela);

        lista = findViewById(R.id.listafilmes);
        busca = findViewById(R.id.busca);

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, filmes);

        Intent dadosRecebidos = getIntent();

        filmes.add("Vingadores Ultimato");
        filmes.add("Top Gun: Maverick");
        filmes.add("Thor: Amor e Trovão");
        filmes.add("Homem Aranha: De volta ao lar");
        filmes.add("Venon: Tempo de carnificina");
        filmes.add(dadosRecebidos.getStringExtra("filme1"));
        filmes.add(dadosRecebidos.getStringExtra("filme2"));
        filmes.add(dadosRecebidos.getStringExtra("filme3"));
        filmes.add(dadosRecebidos.getStringExtra("filme4"));
        filmes.add(dadosRecebidos.getStringExtra("filme5"));

        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(SegundaTela.this, TerceiraTela.class);
                intent.putExtra("nome_filme", filmes.get(i));
                startActivity(intent);
            }
        });

        busca.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                SegundaTela.this.adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}
