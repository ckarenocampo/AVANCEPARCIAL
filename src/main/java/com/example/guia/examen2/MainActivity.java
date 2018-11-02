package com.example.guia.examen2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final int JUGADORNUEVO=1;
    public static final int NIVEL=2;
    public static int nivel=6;
    public static ArrayList<Jugador> listaJugadores;
    Button btnJuego, btnPuntajes, btnConfi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnJuego = findViewById(R.id.btnJuego);
        btnPuntajes = findViewById(R.id.btnPuntajes);
        btnConfi = findViewById(R.id.btnConfi);
        listaJugadores=new ArrayList<>();
        //Jugador jug = new Jugador("karen", 0);
        //listaJugadores.add(jug);

    }
    public void OnClickJuego(View v){
        Intent intent = new Intent(MainActivity.this,NuevoJugador.class);
        startActivityForResult(intent,JUGADORNUEVO);
    }
    public void OnClickPuntajes(View v){
        Intent intent = new Intent(MainActivity.this,Lista.class);
        intent.putExtra("Listado", true);
        startActivity(intent);
    }
    public void OnClickConfi(View v){
        Intent intent = new Intent(MainActivity.this,Configuracion.class);
        startActivityForResult(intent,NIVEL);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case JUGADORNUEVO:
                if (data == null) return;
                String nick = data.getExtras().getString("NICK");
                //Jugador jug = new Jugador(nick, 0);
                //listaJugadores.add(jug);
                break;
            case NIVEL:
                if (data == null) return;
                 nivel = data.getIntExtra("NIVEL",6);
                Toast.makeText(this, ""+nivel, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
