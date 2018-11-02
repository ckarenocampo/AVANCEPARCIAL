package com.example.guia.examen2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Juego extends AppCompatActivity {

    Button btnAdivinar;
    String nick;
    int numAleatorio=0;
    int intentos= 0;
    int numeroIngresado,nivelGenerar=50;
    TextView txtNivel, txtIntentos, txtNick,lblNumero;
    EditText txtNumIngre;
    public static Jugador j;

    public static int posicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        txtNick = findViewById(R.id.txtNickJug);
        txtIntentos = findViewById(R.id.txtIntentos);
        txtNivel = findViewById(R.id.txtNivel);
        lblNumero = findViewById(R.id.txtNumero);
        txtNumIngre = findViewById(R.id.txtNumeroIngresado);
        posicion=getIntent().getIntExtra("Posicion", 0);
        j=MainActivity.listaJugadores.get(posicion);


        nivelGenerar = MainActivity.nivel;
        nick = getIntent().getStringExtra("NICK");
        txtNick.setText(nick);
        txtIntentos.setText(""+ intentos);

        if(intentos==6){
            txtNivel.setText(1+"");
        }else{
            if(intentos==4){
                txtNivel.setText(2+"");
            }else {
                if(intentos==3) {
                    txtNivel.setText(3 + "");
                }
            }
        }

        numAleatorio = (int) (Math.random() * nivelGenerar) + 1;

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        MainActivity.listaJugadores.set(posicion, j);
    }
    public void OnClickJuego(View v){
        numeroIngresado = Integer.parseInt( txtNumIngre.getText().toString());
        if(numeroIngresado == numAleatorio){
            Toast.makeText(this, "Felicidades adivinaste el numero!", Toast.LENGTH_SHORT).show();
            lblNumero.setText(numAleatorio+"");
            finish();
        }else

            intentos++;
            txtIntentos.setText(intentos+"");
            Toast.makeText(this, "Intenta de nuevo", Toast.LENGTH_SHORT).show();

        }

    }

