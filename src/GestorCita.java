import javax.swing.JOptionPane;
import java.util.ArrayList;
public class GestorCita {

    private ArrayList<Cita> citas;

    //Referencias a las instancias de los gestores de doctores y pacientes
    private GestorDoctor doctores;
    private GestorPacientes pacientes;

    public GestorCita(GestorDoctor gestDoc, GestorPacientes gestPaci) {
        citas = new ArrayList<Cita>();
        doctores = gestDoc;
        pacientes = gestPaci;
    }

    public void nuevoCita() {
        String doctorName = JOptionPane.showInputDialog("Enter Doctor's Name:");
        String patientName = JOptionPane.showInputDialog("Enter Patient's Name:");
        String date = JOptionPane.showInputDialog("Enter Date for the Appointment (dd/mm/yyyy):");

        Doctor doctor = (Doctor) doctores.getDoctor(doctorName);
        Paciente paciente = pacientes.getPaciente(patientName);

        if(doctor != null && paciente != null) {
            Cita cita = new Cita(doctor, paciente, date);
            citas.add(cita);
            JOptionPane.showMessageDialog(null, "Appointment added successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Doctor or Patient not found!");
        }
    }

    public void mostrarCitas() {
        StringBuilder sb = new StringBuilder();
        for(Cita cita : citas) {
            sb.append(cita.toString());
            sb.append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }
}

