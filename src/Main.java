import java.util.ArrayList;
import java.util.Scanner;

final class Clinica {

    private static ArrayList<Administrador> administradores = new ArrayList<Administrador>();
    private static Scanner teclado = new Scanner(System.in);
    private static GestorPacientes pacientes;
    private static GestorDoctor doctores;
    private static GestorCita citas;


    public static void main(String[] args) {

        crearAdmins();

        if (validarAcceso()) {
            System.out.println("\nUsuario autorizado\n");
            doctores = new GestorDoctor();
            pacientes = new GestorPacientes();
            citas = new GestorCita(doctores, pacientes);
            while(menu()) {
                // The menu method will handle all operations
            }
            System.out.println("\n\t\tFIN DE PROGRAMA");
        }
    }


    private static boolean menu(){
        System.out.println("\nMENU");
        System.out.println("----\n");
        System.out.println("1. Agregar Doctor");
        System.out.println("2. Modificar Doctor");
        System.out.println("3. Mostrar Doctors");
        System.out.println("4. Agregar Paciente");
        System.out.println("5. Modificar Paciente");
        System.out.println("6. Borrar Paciente");
        System.out.println("7. Mostrar Pacientes");
        System.out.println("8. Agregar Citas");
        System.out.println("9. Mostrar Citas");
        System.out.println("0. Salir");

        String option = teclado.nextLine();

        switch(option) {
            case "1":
                doctores.nuevoDoctor();
                break;
            case "2":
                doctores.modificarDoctor();
                break;
            case "3":
                doctores.mostrarDoctores();
                break;
            case "4":
                pacientes.nuevoPaciente();
                break;
            case "5":
                pacientes.modificarPaciente();
                break;
            case "6":
                pacientes.borrarPaciente();
                break;
            case "7":
                pacientes.mostrarPacientes();
                break;
            case "8":
                citas.nuevoCita();
                break;
            case "9":
                citas.mostrarCitas();
                break;
            case "0":
                return false;
            default:
                System.out.println("Invalid option, please try again.");
        }

        return true;
    }

    private static void crearAdmins() {
        administradores.add(new Administrador("SantiagoR", "1234"));
        administradores.add(new Administrador("PabloA", "5678"));
        administradores.add(new Administrador("AnaT", "0000"));
    }

    private static boolean validarAcceso( ) {

        System.out.println("ACCESO AL SISTEMA");
        System.out.println("------ -- -------\n");
        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();
        System.out.print("Password: ");
        String password = teclado.nextLine();

        Administrador admin = new Administrador(nombre, password);

        return administradores.contains(admin);
    }
}
