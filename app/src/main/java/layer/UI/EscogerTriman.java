package layer.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import layer.BAL.LogicaJuego;
import layer.Entities.ListaJugadores;

public class EscogerTriman extends AppCompatActivity {

    ListaJugadores lista;
    LogicaJuego logica;
    String nombreTriman = "";
    TextView tvTriman;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escoger_triman);
        InstanciaObjetos();


    }
    private void InstanciaObjetos(){

        lista = ListaJugadores.getInstancia();
        logica=LogicaJuego.getInstancia();
        tvTriman=findViewById(R.id.tvTriman);
    }

    public void MostrarTriman(){
        logica.AsignarTriman(lista);
        nombreTriman=lista.ObtenerTriman().getNombre();
        tvTriman.setText(nombreTriman);
    }

    public void OnClick2(View view){

        MostrarTriman();
    }

    public void OnClick3 (View view){
        startActivity(new Intent(EscogerTriman.this,Jugando.class));

    }
}
