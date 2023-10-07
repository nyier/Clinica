import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public final class GestorDoctor {

    private ArrayList<Doctor> doctores = new ArrayList<>();

    public GestorDoctor() {
        this.doctores = doctores;
    }


    public void crearCSV() {

        try {
            FileWriter writer = new FileWriter("Doctores.txt");
            for (Doctor doctor: doctores) {
                writer.write(doctor.getId() + "," + doctor.getNombre() + "," + doctor.getApellidos() + "," + doctor.getEspecialidad() +"\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while trying to write to the file.");
            e.printStackTrace();
        }
    }
    public void nuevoDoctor() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("\nALTA NUEVO DOCTOR");
        System.out.println("---- ----- ------\n");
        System.out.print("ID: ");
        String id = teclado.nextLine();
        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();
        System.out.print("Apellidos: ");
        String apell = teclado.nextLine();
        System.out.print("Especialidad: ");
        String espe = teclado.nextLine();

        doctores.add(new Doctor(id, nombre, apell, espe));
        crearCSV(); //Añadimos nueva línea CSV al archivo en disco
        System.out.println("Creado");
    }
    public Object getDoctor(String id) {
        for (Doctor doc: doctores)
            if (doc.getId().equals(id))
                return doc; //Doctor encontrado
        //Si el bucle no ha retornado ningún Doctor, es que no existe ese ID
        return doctores;
    }
    public void modificarDoctor() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("\nMODIFICAR DOCTOR");
        System.out.println("---- ----- ------\n");
        System.out.print("ID: ");
        String id = teclado.nextLine();

        Doctor doctor = (Doctor) getDoctor(id);


            System.out.print("New Name: ");
            String nombre = teclado.nextLine();
            System.out.print("New Last Name: ");
            String apell = teclado.nextLine();
            System.out.print("New Specialty: ");
            String espe = teclado.nextLine();
            doctor.setNombre(nombre);
            doctor.setApellidos(apell);
            doctor.setEspecialidad(espe);
            System.out.println("Doctor modified successfully!");

    }

    public void mostrarDoctores() {
        System.out.println("\nLISTA DE DOCTORES");
        System.out.println("----- -- --------\n");

        for(Doctor doctor : doctores) {
            System.out.println(doctor.toString());
        }
    }
}