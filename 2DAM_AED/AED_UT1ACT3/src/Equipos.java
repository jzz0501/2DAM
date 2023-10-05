import java.io.Serializable;

public class Equipos implements Serializable {

    @java.io.Serial
    private static final long serialVersionUID = 1L;
    private int num_club;
    private String name_club;
    private String presidente;
    private String telefono;
    private String localidad;

    public Equipos(int num_club, String name_club, String presidente, String telefono, String localidad) {
        this.num_club = num_club;
        this.name_club = name_club;
        this.presidente = presidente;
        this.telefono = telefono;
        this.localidad = localidad;
    }

    @Override
    public String toString() {
        return "Equipos{" +
                "num_club=" + num_club +
                ", name_club='" + name_club + '\'' +
                ", presidente='" + presidente + '\'' +
                ", telefono='" + telefono + '\'' +
                ", localidad='" + localidad + '\'' +
                '}';
    }

    public int getNum_club() {
        return num_club;
    }

    public void setNum_club(int num_club) {
        this.num_club = num_club;
    }

    public String getName_club() {
        return name_club;
    }

    public void setName_club(String name_club) {
        this.name_club = name_club;
    }

    public String getPresidente() {
        return presidente;
    }

    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
}
