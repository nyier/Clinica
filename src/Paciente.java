public class Paciente {


    private String id;
    private String nombre;
    private String apellidos;

    public Paciente(String nombre, String apell) {
    }

    public String generaLineaCSV() {
        return String.format("%s;%s;%s;%s\n", id, nombre, apellidos);
    }


    public Paciente(String id, String nombre, String apellidos) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;

    }

    public Object getNombre() {
        return nombre;
    }
    public Object getApellidos() {
        return apellidos;
    }
    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    public void setApellidos(String nuevosApellidos) {
        this.apellidos = nuevosApellidos;
    }

    public Object getID() {
        return id;
    }


}

