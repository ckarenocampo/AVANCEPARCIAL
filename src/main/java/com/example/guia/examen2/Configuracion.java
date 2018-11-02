package com.example.guia.examen2;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class Configuracion extends AppCompatActivity {

    RadioButton rbt1,rbt2,rbt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        rbt1 = findViewById(R.id.rbtn1);
        rbt2= findViewById(R.id.rbtn2);
        rbt3= findViewById(R.id.rbtn3);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }
    public void OnClickGuardar(View v){
        Intent activity = new Intent(this,MainActivity.class);

        if(rbt1.isChecked()){
            activity.putExtra("NIVEL",50);
            setResult(MainActivity.NIVEL, activity);
        }
        if(rbt2.isChecked()) {
            activity.putExtra("NIVEL", 100);
            setResult(MainActivity.NIVEL, activity);
        }
        if(rbt3.isChecked()) {
            activity.putExtra("NIVEL", 150);
            setResult(MainActivity.NIVEL, activity);
        }

    }
}
