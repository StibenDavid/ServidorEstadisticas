/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorEstadisticas;

import java.util.LinkedList;
import servidor.repositorios.OfertasRepositoryInt;
import sop_corba.ObtenerEstadisticasIntPOA;
import sop_corba.ObtenerEstadisticasIntPackage.estadisticasDTO;
import sop_corba.ObtenerEstadisticasIntPackage.estadisticasDTOHolder;
import sop_corba.ObtenerEstadisticasIntPackage.ultimasOfertasDTO;


public class ObtenerEstadisticasImpl extends ObtenerEstadisticasIntPOA{

    private final OfertasRepositoryInt ofertasRepository;
    
    public ObtenerEstadisticasImpl(OfertasRepositoryInt ofertasRepository) {
        this.ofertasRepository = ofertasRepository;
    }
    
    @Override
    public void consultarEstadisticas(estadisticasDTOHolder resultado) {
        System.out.println("Entrando a consultar estaditicas...");
        calcularEstadisticas calcularEstadisticas = new calcularEstadisticas();
        resultado.value=(estadisticasDTO) calcularEstadisticas.realizarCalculos(this.ofertasRepository.obtenerOfertas());
    }

    @Override
    public ultimasOfertasDTO obtenerUltimasOfertas() {
        LinkedList<Float> ofertas = this.ofertasRepository.obtenerOfertas();
        System.out.println("Entrando a obtener últimas ofertas...");
        ultimasOfertasDTO ultimasOfertas = new ultimasOfertasDTO();

        // Obtener las últimas 5 ofertas
        int totalOfertas = ofertas.size();
        int startIndex = Math.max(totalOfertas - 5, 0);
        int endIndex = totalOfertas;
        float[] ultimasOfertasArray = new float[endIndex - startIndex];

        int index = 0;
        for (int i = startIndex; i < endIndex; i++) {
            ultimasOfertasArray[index++] = ofertas.get(i);
        }

        ultimasOfertas.ultimasOfertas = ultimasOfertasArray;
        return ultimasOfertas;
    }

    
}
