package sop_corba.ObtenerEstadisticasIntPackage;


/**
* sop_corba/ObtenerEstadisticasIntPackage/estadisticasDTO.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from operaciones.idl
* lunes 3 de julio de 2023 08:15:15 AM COT
*/

public final class estadisticasDTO implements org.omg.CORBA.portable.IDLEntity
{
  public int cantidadSolicitudes = (int)0;
  public float promedioValorSolicitudes = (float)0;
  public float diferenciaMenorSolicitudMayorSolicitud = (float)0;
  public float tasaCrecimiento = (float)0;

  public estadisticasDTO ()
  {
  } // ctor

  public estadisticasDTO (int _cantidadSolicitudes, float _promedioValorSolicitudes, float _diferenciaMenorSolicitudMayorSolicitud, float _tasaCrecimiento)
  {
    cantidadSolicitudes = _cantidadSolicitudes;
    promedioValorSolicitudes = _promedioValorSolicitudes;
    diferenciaMenorSolicitudMayorSolicitud = _diferenciaMenorSolicitudMayorSolicitud;
    tasaCrecimiento = _tasaCrecimiento;
  } // ctor

} // class estadisticasDTO
