/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor.repositorios;

import java.util.LinkedList;
import sop_corba.OfertasInt;

/**
 *
 * @author ASUS
 */
public class OfertasRepositoryImpl implements OfertasRepositoryInt{
    private final  OfertasInt objOfertas;
    
    public OfertasRepositoryImpl(OfertasInt objOfertas) {
        this.objOfertas=objOfertas;
    }

    @Override
    public LinkedList<Float> obtenerOfertas() {
        
        float[] ofertas = objOfertas.obtenerOfertas();
        LinkedList<Float> listaOfertas = new LinkedList<>();
        for (float oferta : ofertas) {
            listaOfertas.add(oferta);
        }
        
        return listaOfertas;
    }   
}