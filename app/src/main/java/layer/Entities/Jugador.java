package layer.Entities;

public class Jugador {

    String nombre;
    Boolean isTriman;

    public Boolean getTriman() {
        return isTriman;
    }

    public void setTriman(Boolean triman) {
        isTriman = triman;
    }


    public Jugador(String nombre) {
        this.nombre = nombre;
        this.isTriman=false;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        this.isTriman=false;
    }
}
