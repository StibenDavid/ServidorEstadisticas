package servidorEstadisticas;

import java.util.LinkedList;
import sop_corba.ObtenerEstadisticasIntPackage.estadisticasDTO;

public class calcularEstadisticas {
    private estadisticasDTO estadisticas;

    public calcularEstadisticas() {
        this.estadisticas = new estadisticasDTO();
    }

    public estadisticasDTO realizarCalculos(LinkedList<Float> ofertas) {
        estadisticas.cantidadSolicitudes = ofertas.size();
        estadisticas.promedioValorSolicitudes = calcularPromedio(ofertas);
        estadisticas.diferenciaMenorSolicitudMayorSolicitud = calcularDiferencia(ofertas);
        estadisticas.tasaCrecimiento = calcularTasaCrecimiento(ofertas);
        return estadisticas;
    }

    public float calcularPromedio(LinkedList<Float> ofertas) {
        if (ofertas == null || ofertas.isEmpty()) {
            return 0;
        }

        float suma = 0;
        for (float valor : ofertas) {
            suma += valor;
        }
        return suma / ofertas.size();
    }

    public float calcularDiferencia(LinkedList<Float> ofertas) {
        if (ofertas == null || ofertas.isEmpty()) {
            return 0;
        }

        float mayor = Float.MIN_VALUE;
        float menor = Float.MAX_VALUE;

        for (float numero : ofertas) {
            if (numero > mayor) {
                mayor = numero;
            }
            if (numero < menor) {
                menor = numero;
            }
        }
        return mayor - menor;
    }

    public float calcularTasaCrecimiento(LinkedList<Float> ofertas) {
        if (ofertas == null || ofertas.isEmpty()) {
            return 0;
        }

        float ofertaInicial = ofertas.getFirst();
        float ofertaFinal = ofertas.getLast();

        return ((ofertaFinal - ofertaInicial) / ofertaInicial) * 100;
    }
}