import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import javax.swing.JOptionPane;

final class GestorPacientes {

    private ArrayList<Paciente> pacientes = new ArrayList<>();

    public void crearCSV() {
        try {
            FileWriter writer = new FileWriter("Paciente.txt");
            for (Paciente paciente : pacientes) {
                writer.write(paciente.getID() + "," + paciente.getNombre() + "," + paciente.getApellidos() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while trying to write to the file.");
            e.printStackTrace();
        }
    }

    public void nuevoPaciente() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("\nALTA NUEVO PACIENTE");
        System.out.println("---- ----- ------\n");
        System.out.print("ID: ");
        String id = teclado.nextLine();
        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();
        System.out.print("Apellidos: ");
        String apell = teclado.nextLine();
        Paciente paciente = new Paciente(nombre, apell);
        pacientes.add(new Paciente(id, nombre, apell));
        crearCSV();
        System.out.println("Creado");

    }

    public void mostrarPacientes() {
        StringBuilder sb = new StringBuilder();
        for(Paciente paciente : pacientes) {
            sb.append(paciente.toString());
            sb.append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public void modificarPaciente() {
        String nombre = JOptionPane.showInputDialog("Enter Patient's Name to Modify:");

        for(Paciente paciente : pacientes) {
            if(paciente.getNombre().equals(nombre)) {
                String nuevoNombre = JOptionPane.showInputDialog("Enter New Name:");
                String nuevosApellidos = JOptionPane.showInputDialog("Enter New Last Name:");
                String nuevaEspecialidad = JOptionPane.showInputDialog("Enter New Specialty:");

                paciente.setNombre(nuevoNombre);
                paciente.setApellidos(nuevosApellidos);

                JOptionPane.showMessageDialog(null, "Patient modified successfully!");
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Patient not found!");
    }

    public void borrarPaciente() {
        String nombre = JOptionPane.showInputDialog("Enter Patient's Name to Delete:");

        for(int i = 0; i < pacientes.size(); i++) {
            if(pacientes.get(i).getNombre().equals(nombre)) {
                pacientes.remove(i);
                JOptionPane.showMessageDialog(null, "Patient deleted successfully!");
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Patient not found!");
    }

    public Paciente getPaciente(String patientName) {
        for(Paciente paciente : pacientes) {
            if(paciente.getNombre().equals(patientName)) {
                return paciente;
            }
        }

        return null;
    }
}