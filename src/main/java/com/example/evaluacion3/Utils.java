package com.example.evaluacion3;
import com.example.evaluacion3.model.Orden;

import java.time.LocalDate;
import java.util.List;

public class Utils {

    public static int countOrdersLastMonth(List<Orden> ordenList) {

        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaMesAnterior = LocalDate.of(fechaActual.getYear(), fechaActual.getMonthValue() - 1,
                fechaActual.getDayOfMonth());

        int count = 0;

        for (Orden orden : ordenList) {

            LocalDate fechaOrden = orden.getOrder_at();

            if (fechaActual.isEqual(fechaOrden) || fechaMesAnterior.isEqual(fechaOrden)){
                count++;
            }else if (fechaOrden.isAfter(fechaMesAnterior) && fechaOrden.isBefore(fechaActual)) {
                count++;
            }
        }
        return count;
    }

}
