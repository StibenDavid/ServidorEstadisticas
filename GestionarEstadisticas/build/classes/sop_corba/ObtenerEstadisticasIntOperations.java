package sop_corba;


/**
* sop_corba/ObtenerEstadisticasIntOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from operaciones.idl
* lunes 3 de julio de 2023 08:15:15 AM COT
*/

public interface ObtenerEstadisticasIntOperations 
{
  boolean registrarValorOferta (float valor);
  float consultarMayorOferta ();
  void consultarEstadisticas (sop_corba.ObtenerEstadisticasIntPackage.estadisticasDTOHolder resultado);
  sop_corba.ObtenerEstadisticasIntPackage.ultimasOfertasDTO obtenerUltimasOfertas ();
} // interface ObtenerEstadisticasIntOperations
