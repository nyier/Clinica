import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.ArrayList;


public class Doctor {

    private String id;
    private String nombre;
    private String apellidos;
    private String especialidad;
    private ArrayList<Doctor> doctores = new ArrayList<>();
    public Doctor(String id, String nombre, String apellidos, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.especialidad = especialidad;
    }

    public Object getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Object getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Object getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * Muestra por panel todos los datos del doctor
     */
    public void mostrar() {
        String mensaje = "ID doctor: " + id + "\nNombre: " + nombre
                + "\nApellidos: " + apellidos + "\nEspecialidad: " + especialidad;
    }


}