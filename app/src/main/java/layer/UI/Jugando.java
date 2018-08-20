package layer.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import layer.BAL.LogicaJuego;
import layer.Entities.ListaJugadores;

public class Jugando extends AppCompatActivity {

    ListaJugadores lista;
    LogicaJuego logica;
    TextView tvTurno;
    TextView tvDado;
    String JugadorTurno;
    int dado=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugando);
        InstanciaObjetos();
        MostrarJugadorTurno();
    }

    private void InstanciaObjetos(){

        lista = ListaJugadores.getInstancia();
        logica= LogicaJuego.getInstancia();
        tvTurno=findViewById(R.id.tvJugadorQueLanza);
        tvDado=findViewById(R.id.tvDado);
        dado=logica.LanzarDado();
    }

    public void MostrarJugadorTurno(){
        JugadorTurno=lista.ObtenerJugador(logica.getTurnoJugador()).getNombre();
        tvTurno.setText(JugadorTurno);
    }

    public void mostrarNumeroDado(int numero){

        switch(numero){
                case 1:
                    tvDado.setText("1");
                    break;
                case 2:
                    tvDado.setText("2");
                    break;
                case 3:
                    tvDado.setText("3");
                    break;
                case 4:
                    tvDado.setText("4");
                    break;
                case 5:
                    tvDado.setText("5");
                    break;
                case 6:
                    tvDado.setText("6");
                    break;
            }

    }
    public void botonDado(View view){
        mostrarNumeroDado(dado);
    }

    public void OnClick4 (View view){
        //startActivity(new Intent(Jugando.this,Tomando.class));
        Intent in = new Intent(Jugando.this,Tomando.class);
        in.putExtra("numerodado",dado);
        startActivity(in);

    }
}
