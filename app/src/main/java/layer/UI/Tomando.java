package layer.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import layer.BAL.LogicaJuego;
import layer.Entities.ListaJugadores;

public class Tomando extends AppCompatActivity {

    LogicaJuego logica;
    ListaJugadores lista;
    String JugadorTomar;
    TextView tvJugadorQueToma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tomando);
        InstanciaObjetos();
        MostrarJugadorTomar();
    }

    public void OnClick5 (View view){
        logica.AsignarTurno(lista);
        startActivity(new Intent(Tomando.this,Jugando.class));
    }


    private void InstanciaObjetos(){

        lista = ListaJugadores.getInstancia();
        logica= LogicaJuego.getInstancia();
        tvJugadorQueToma=findViewById(R.id.tvJugadorQueToma);
    }

    public void MostrarJugadorTomar(){
        Intent in=getIntent();
        int numdado= in.getIntExtra("numerodado",0);

        if (numdado<5){
            JugadorTomar=logica.JugadorQueDebeTomar(numdado,lista);
        }
        else if (numdado==5){
            JugadorTomar=logica.resultadoDado5();
        }else {
            JugadorTomar=logica.resultadoDado6();
        }
        tvJugadorQueToma.setText(JugadorTomar);
    }





}
