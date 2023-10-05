import java.io.Serializable;

public class Personas implements Serializable {

    @java.io.Serial
    private static final long serialVersionUID = 1;
    private String name;
    private String dni;
    private int edad;
    private double salario;

    public Personas() {

    }

    public Personas(String name, String dni, int edad, double salario) {
        this.name = name;
        this.dni = dni;
        this.edad = edad;
        this.salario = salario;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Personas{" +
                "name='" + name + '\'' +
                ", dni='" + dni + '\'' +
                ", edad=" + edad +
                ", salario=" + salario +
                '}';
    }
}
