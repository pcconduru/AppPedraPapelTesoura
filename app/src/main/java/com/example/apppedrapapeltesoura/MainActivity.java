package com.example.apppedrapapeltesoura;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void pedra(View view){
        verificarGanhador("Pedra");
    }
    public void papel(View view){
        verificarGanhador("Papel");
    }
    public void tesoura(View view){
        verificarGanhador("Tesoura");
    }
    //Escolha do BOT - Aleatória
    public String bot(){
        String[] opcoes = {
                "Pedra","Papel","Tesoura"
        };
        int numeroAleatorio = new Random().nextInt(3);

        ImageView botImage = findViewById(R.id.bot_image);
        String escolhaBot = opcoes[numeroAleatorio];

        switch (escolhaBot){
            case "Pedra":
                botImage.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                botImage.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                botImage.setImageResource(R.drawable.tesoura);
                break;
        }
        return escolhaBot;
    }
    //Escolha do Usuario como parametro para os metedos de cima
    public void verificarGanhador(String usuario){
        String escolhaBot = bot();
        TextView textResultado = findViewById(R.id.text_resultado);
        if(
                (escolhaBot == "Pedra" && usuario == "Tesoura") ||
                (escolhaBot == "Papel" && usuario == "Pedra") ||
                (escolhaBot == "Tesoura" && usuario == "Papel")
        ){
            textResultado.setText("Você Perdeu! :(");
        }
        else if(
                (usuario == "Pedra" && escolhaBot == "Tesoura") ||
                (usuario == "Papel" && escolhaBot == "Pedra") ||
                (usuario == "Tesoura" && escolhaBot == "Papel")
        ){
            textResultado.setText("Você Ganhou! :)");
        }
        else{
            textResultado.setText("Empatou! :/");
        }
    }
}