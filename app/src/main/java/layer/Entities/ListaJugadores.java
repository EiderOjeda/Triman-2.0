package layer.Entities;

import java.util.ArrayList;

public class ListaJugadores {

    private static ListaJugadores instancia;
    private int Triman;

   // public int GetTriman(){

   // }


    private ArrayList<Jugador> lista;

    public ArrayList<Jugador> getLista() {

        return lista;
    }

    private ListaJugadores() {

        this.lista = new ArrayList<Jugador>();
        Triman = -1;
    }
    public void llenarLista(Jugador j){
        lista.add(j);
    }

    public int ObtenerCantidadJugadores(){
        return lista.size();
    }

    public Jugador ObtenerJugador(int posicion){
        return lista.get(posicion);
    }

    public Jugador ObtenerUltimoJugador() {
        return lista.get(lista.size()-1);
    }

    public static ListaJugadores getInstancia(){
        if(instancia==null){
            instancia=new ListaJugadores();
        }
        return instancia;
    }

    public Jugador ObtenerTriman(){

        for (int i=0;i<ObtenerCantidadJugadores();i++){

            if (lista.get(i).isTriman){
                return lista.get(i);
            }

        }
        return null;
    }
}
