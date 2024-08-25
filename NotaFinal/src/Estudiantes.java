

public class Estudiantes {
    private int Ci;
    private String Nombre;
    private String Apellido;
    private int edad;
    private static int nota;

    public int getNota() {
        return nota;
    }
    public void setNota() {
        nota = nota;
    }
    public int getCi() {
        return Ci;
    }

    public void setCi(int ci) {
        Ci = ci;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Estudiantes(int ci, String nombre, String apellido, int edad, int nota) {
        this.Ci = ci;
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.edad = edad;
        this.nota = nota;
    }
    public static boolean verificarNota(){
        return nota >= 8;
    }
    public Boolean esMayorEdad(){
        return this.edad >= 18;
    }
    public String mostrar(){
        return this.Ci + "-"+ this.Apellido+"-"+this.Nombre + "-"+this.edad;
    }
}
