package com.example.guia.examen2;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Lista extends AppCompatActivity implements AdapterView.OnItemClickListener  {

    private ArrayAdapter adapter;
    Boolean Listado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        adapter = new AdaptadorJugador(Lista.this,MainActivity.listaJugadores);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Listado=getIntent().getBooleanExtra("Listado", false);
        //String nick = getIntent().getStringExtra("NICK");

    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        if(!Listado){
            Intent lista = new Intent(getApplicationContext(),Juego.class);
            lista.putExtra("Posicion", position);
            startActivity(lista);
            finish();
        }else{
            Toast.makeText(this, "hola", Toast.LENGTH_SHORT).show();
        }
    }
}
