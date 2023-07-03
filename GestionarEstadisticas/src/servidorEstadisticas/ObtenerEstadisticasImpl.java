/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorEstadisticas;

import java.util.HashMap;
import java.util.LinkedList;
import servidorEstadisticas.calcularEstadisticas;
import sop_corba.ObtenerEstadisticasIntPOA;
import sop_corba.ObtenerEstadisticasIntPackage.estadisticasDTO;
import sop_corba.ObtenerEstadisticasIntPackage.estadisticasDTOHolder;
import sop_corba.ObtenerEstadisticasIntPackage.ultimasOfertasDTO;

/**
 *
 * @author LENOVO
 */
public class ObtenerEstadisticasImpl extends ObtenerEstadisticasIntPOA{

    
    private LinkedList <Float> ofertas;
    public ObtenerEstadisticasImpl()
    {
        this.ofertas = new LinkedList<>();
    }

    @Override
    public boolean registrarValorOferta(float valor) {
        System.out.println("Entrando a registrar oferta...");
        if(consultarMayorOferta() < valor){
            this.ofertas.add(valor);
            return true;
        }
        return false;
    }

    @Override
    public float consultarMayorOferta() {
        float mayor = 0;
        System.out.println("Entrando a consultar mayor oferta...");
        if (this.ofertas == null || this.ofertas.isEmpty()) {
            return mayor;
        }
        else{
            mayor = this.ofertas.getFirst();
            for (float numero : this.ofertas) {
                if (numero > mayor) {
                    mayor = numero;
                }
            }
        }
        return mayor;
    }

    @Override
    public void consultarEstadisticas(estadisticasDTOHolder resultado) {
        System.out.println("Entrando a consultar estaditicas...");
        calcularEstadisticas calcularEstadisticas = new calcularEstadisticas();
        resultado.value=(estadisticasDTO) calcularEstadisticas.realizarCalculos(this.ofertas);
    }

    @Override
    public ultimasOfertasDTO obtenerUltimasOfertas() {
        System.out.println("Entrando a obtener últimas ofertas...");
        ultimasOfertasDTO ultimasOfertas = new ultimasOfertasDTO();

        // Obtener las últimas 5 ofertas
        int totalOfertas = this.ofertas.size();
        int startIndex = Math.max(totalOfertas - 5, 0);
        int endIndex = totalOfertas;
        float[] ultimasOfertasArray = new float[endIndex - startIndex];

        int index = 0;
        for (int i = startIndex; i < endIndex; i++) {
            ultimasOfertasArray[index++] = this.ofertas.get(i);
        }

        ultimasOfertas.ultimasOfertas = ultimasOfertasArray;
        return ultimasOfertas;
    }

    
}
