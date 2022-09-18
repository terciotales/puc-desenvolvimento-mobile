package com.example.atividade04_filmes;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class TerceiraTela extends AppCompatActivity {

    TextView titulo;
    TextView descricao;
    ImageView image;
    Button voltar;
    TextView nota;

    Random rand = new Random();
    String[] descricoes = {
            "Anthony Edward \"Tony\" Stark foi um industrialista," +
                    " membro fundador dos Vingadores e antigo CEO das" +
                    " Indústrias Stark.",
            "O adolescente Peter Parker vive com seus tios May e Ben " +
                    "Parker. Picado por uma aranha radiativa, o rapaz desenvolve " +
                    "atributos do inseto.",
            "Thor era um deus da mitologia nórdica e o mais popular entre os" +
                    " nórdicos na Era Viking. Era conhecido como o deus do trovão," +
                    " das tempestades e da agricultura.",
            "Considerado um dos maiores lutadores de artes marciais da Terra," +
                    " ele é familiarizado com muitos estilos de luta, especialmente " +
                    "os chineses, como Kung Fu.",
            "Após Thanos eliminar metade das criaturas vivas, os Vingadores têm" +
                    " de lidar com a perda de amigos e entes queridos. Com Tony Stark" +
                    " vagando perdido no espaço sem água e comida.."
    };

    int[] imagens = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.terceira_tela);

        titulo = findViewById(R.id.titulo);
        descricao = findViewById(R.id.descricao);
        image = findViewById(R.id.imageView);
        voltar = findViewById(R.id.voltar);
        nota = findViewById(R.id.nota);

        Intent dadosRecebidos = getIntent();
        titulo.setText(dadosRecebidos.getStringExtra("nome_filme"));

        int random = rand.nextInt(4);
        String sorte = descricoes[random];
        descricao.setText(sorte);
        random = rand.nextInt(4);
        image.setImageResource(imagens[random]);
        String nota_value = "Nota: " + rand.nextInt(10);
        nota.setText(nota_value);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TerceiraTela.this, SegundaTela.class);
                startActivity(i);
                finish();
            }
        });

    }
}
