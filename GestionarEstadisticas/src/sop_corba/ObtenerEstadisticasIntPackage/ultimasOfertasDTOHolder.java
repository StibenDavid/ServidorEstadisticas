package sop_corba.ObtenerEstadisticasIntPackage;

/**
* sop_corba/ObtenerEstadisticasIntPackage/ultimasOfertasDTOHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from operaciones.idl
* lunes 3 de julio de 2023 04:15:01 PM COT
*/

public final class ultimasOfertasDTOHolder implements org.omg.CORBA.portable.Streamable
{
  public sop_corba.ObtenerEstadisticasIntPackage.ultimasOfertasDTO value = null;

  public ultimasOfertasDTOHolder ()
  {
  }

  public ultimasOfertasDTOHolder (sop_corba.ObtenerEstadisticasIntPackage.ultimasOfertasDTO initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = sop_corba.ObtenerEstadisticasIntPackage.ultimasOfertasDTOHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    sop_corba.ObtenerEstadisticasIntPackage.ultimasOfertasDTOHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return sop_corba.ObtenerEstadisticasIntPackage.ultimasOfertasDTOHelper.type ();
  }

}
