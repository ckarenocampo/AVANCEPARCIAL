package com.example.guia.examen2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NuevoJugador extends AppCompatActivity {
    Button btnJugar;
    EditText txtNick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_jugador);
        btnJugar = findViewById(R.id.btnJugar);
        txtNick = findViewById(R.id.txtNick);
    }
    public void OnClickJuego(View v){
        String jugador = txtNick.getText().toString();
        Intent act = new Intent(NuevoJugador.this,MainActivity.class);
        act.putExtra("NICK",jugador);
        setResult(MainActivity.JUGADORNUEVO, act);

        Jugador jug = new Jugador(jugador, 0);
        MainActivity.listaJugadores.add(jug);
        finish();

        Intent inten = new Intent(NuevoJugador.this,Juego.class);
        inten.putExtra("NICK",jugador);
        startActivity(inten);
       }
}
