package controller;

import model.Medicamentos;

import java.util.ArrayList;
import java.util.Iterator;

public class MedicamentosControlador {

    public static Medicamentos agregarMedicamentos(ArrayList<Medicamentos> medicamentos, int idMed) {

        Medicamentos medicamento = null;

        Iterator<Medicamentos> hosp = medicamentos.iterator();
        while (hosp.hasNext()) {
            medicamento = hosp.next();

            if (medicamento.getIdMed() == idMed) {
                break;
            }
        }
        return medicamento;
    }
}
