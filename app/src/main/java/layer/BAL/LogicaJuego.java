package layer.BAL;
import java.util.Random;

import layer.Entities.*;


public class LogicaJuego {

    private static LogicaJuego instancia;

    public int getTurnoJugador() {
        return turnoJugador;
    }

    private int turnoJugador=0;

    public void AsignarTurno(ListaJugadores lista){

        if (turnoJugador==lista.ObtenerCantidadJugadores()-1){
            turnoJugador=0;
        }else{
            turnoJugador++;
        }

    }


    public void AsignarTriman(ListaJugadores lista){
        for (int i=0;i<lista.ObtenerCantidadJugadores();i++){
            lista.ObtenerJugador(i).setTriman(false);
        }

        Random r = new Random();
        int random=r.nextInt(lista.ObtenerCantidadJugadores());
        lista.ObtenerJugador(random).setTriman(true);
        turnoJugador=random;

        //Lista.ObtenerJugador(random)
    }

    public int LanzarDado(){
        Random r=new Random();
        return r.nextInt(6)+1;

    }

    public String JugadorQueDebeTomar(int resultado, ListaJugadores lista){
        //1=solo, 2=derecha, 3=triman, 4=izquierda, 5=escoger, 6=todos
        Jugador juga;
        switch (resultado){
            case 1:
                juga=lista.ObtenerJugador(turnoJugador);
                return juga.getNombre();
            case 2:
                if (turnoJugador+1<lista.ObtenerCantidadJugadores()){
                    juga=lista.ObtenerJugador(turnoJugador+1);
                    return juga.getNombre();
                }else{
                    juga=lista.ObtenerJugador(0);
                    return juga.getNombre();
                }
            case 3:
                juga=lista.ObtenerTriman();
                return juga.getNombre();

            case 4:
                if (turnoJugador==0){
                juga=lista.ObtenerUltimoJugador();
                return juga.getNombre();
                }else{
                    juga=lista.ObtenerJugador(turnoJugador-1);
                    return juga.getNombre();
                }
                default:
                    return null;
        }

    }

    public String resultadoDado5(){
        return "Se salvan de tomar";
    }

    public String resultadoDado6(){
        return "Todos jartan";
    }



    public static LogicaJuego getInstancia(){
        if(instancia==null){
            instancia=new LogicaJuego();
        }
        return instancia;
    }
}
