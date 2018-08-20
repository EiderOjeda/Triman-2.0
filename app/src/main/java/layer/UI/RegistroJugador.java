package layer.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import layer.Entities.Jugador;
import layer.Entities.ListaJugadores;

public class RegistroJugador extends AppCompatActivity {

    ListaJugadores lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_jugador);
        InstanciaObjetos();
    }

    //Metodos privados

    private void InstanciaObjetos(){

        lista = ListaJugadores.getInstancia();
    }

    public void BtnRegistrar (View view){

        EditText etTxt = ((EditText)findViewById(R.id.etNombre));
        String nombre = etTxt.getText().toString();

        if(nombre.isEmpty()){
            Toast.makeText(this,"Campo vacio",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"Funciona el registro", Toast.LENGTH_SHORT).show();
            Jugador j = new Jugador(nombre);
            lista.llenarLista(j);
        }
        etTxt.setText("");
    }

    public void OnClick1 (View view){
        startActivity(new Intent(RegistroJugador.this,EscogerTriman.class));

    }
}
