package sop_corba.ObtenerEstadisticasIntPackage;


/**
* sop_corba/ObtenerEstadisticasIntPackage/float_seqHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from operaciones.idl
* lunes 3 de julio de 2023 08:15:15 AM COT
*/

public final class float_seqHolder implements org.omg.CORBA.portable.Streamable
{
  public float value[] = null;

  public float_seqHolder ()
  {
  }

  public float_seqHolder (float[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = sop_corba.ObtenerEstadisticasIntPackage.float_seqHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    sop_corba.ObtenerEstadisticasIntPackage.float_seqHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return sop_corba.ObtenerEstadisticasIntPackage.float_seqHelper.type ();
  }

}
