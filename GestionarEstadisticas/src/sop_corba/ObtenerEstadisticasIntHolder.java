package sop_corba;

/**
* sop_corba/ObtenerEstadisticasIntHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from operaciones.idl
* lunes 3 de julio de 2023 04:21:07 PM COT
*/

public final class ObtenerEstadisticasIntHolder implements org.omg.CORBA.portable.Streamable
{
  public sop_corba.ObtenerEstadisticasInt value = null;

  public ObtenerEstadisticasIntHolder ()
  {
  }

  public ObtenerEstadisticasIntHolder (sop_corba.ObtenerEstadisticasInt initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = sop_corba.ObtenerEstadisticasIntHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    sop_corba.ObtenerEstadisticasIntHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return sop_corba.ObtenerEstadisticasIntHelper.type ();
  }

}
