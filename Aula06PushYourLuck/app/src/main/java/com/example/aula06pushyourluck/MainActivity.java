package com.example.aula06pushyourluck;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.rtp.AudioStream;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView txt02;
    ImageView image;
    SoundPool snd;
    MediaPlayer musica;
    boolean isMute = false;
    int click;
    String[] frases = new String[30];
    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        txt02 = findViewById(R.id.tv02);
        image = findViewById(R.id.image);

        snd = new SoundPool(4, AudioManager.STREAM_MUSIC, 8);
        click = snd.load(MainActivity.this, R.raw.laser, 3);
        musica = MediaPlayer.create(MainActivity.this, R.raw.musica);
        musica.start();

        frases = new String[]{"A vida trará coisas boas se tiveres paciência.",
                "Demonstre amor e alegria em todas as oportunidades e verás que a paz nasce dentro de você.",
                "Não compense na ira o que lhe falta na razão.",
                "Defeitos e virtudes são apenas dois lados da mesma moeda.",
                "A maior de todas as torres começa no solo.",
                "Não há que ser forte. Há que ser flexível.",
                "Gente todo dia arruma os cabelos, por que não o coração.",
                "Há três coisas que jamais voltam; a flecha lançada, a palavra dita e a oportunidade perdida.",
                "A juventude não é uma época da vida, é um estado de espírito.",
                "Podemos escolher o que semear, mas somos obrigados a colher o que plantamos.",
                "Dê toda a atenção para a formação dos teus filhos, sobretudo por exemplos de tua própria vida.",
                "Siga os bons e aprenda com eles.",
                "Não importa o tamanho da montanha, ela não pode tapar o sol.",
                "O bom-senso vai mais longe do que muito conhecimento.",
                "Quem quer colher rosas deve suportar os espinhos.",
                "São os nossos amigos que nos ensinam as mais valiosas lições.",
                "Uma iniciativa mal-sucedida não significa o final de tudo. Sempre existe uma nova oportunidade.",
                "Aquele que se importa com o sentimento dos outros, não é um tolo.",
                "A adversidade é um espelho que reflete o verdadeiro eu.",
                "Lamentar aquilo que não temos é desperdiçar aquilo que já possuímos.",
                "Uma bela flor é incompleta sem suas folhas.",
                "Sem o fogo do entusiasmo, não há o calor da vitória.",
                "Não há melhor negócio que a vida. A gente há obtém a troco de nada.",
                "O riso é a menor distância entre duas pessoas.",
                "Você é jovem apenas uma vez. Depois precisa inventar outra desculpa.",
                "É mais fácil conseguir o perdão do que a permissão.",
                "Os defeitos são mais fortes quando o amor é fraco.",
                "Amizade e Amor são coisas que podem virar uma só num piscar de olhos.",
                "Surpreender e ser surpreendido é o segredo do amor.",
                "Faça pequenas coisas agora e maiores coisas lhe serão confiadas cada dia."};

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isMute) {
                    musica.start();
                    image.setImageResource(R.drawable.som);
                } else {
                    musica.pause();
                    image.setImageResource(R.drawable.semsom);
                }

                isMute = !isMute;
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int random = rand.nextInt(29);
                String sorte = frases[random];
                txt02.setText(sorte);
                snd.play(click, 1, 1, 1, 0, 1);
            }
        });
    }
}