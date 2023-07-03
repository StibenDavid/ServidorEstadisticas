
package cliente;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import sop_corba.*;
import sop_corba.ObtenerEstadisticasIntPackage.estadisticasDTO;
import sop_corba.ObtenerEstadisticasIntPackage.estadisticasDTOHolder;

public class ClienteDeObjetos {

    static ObtenerEstadisticasInt ref;
   
    public static void main(String[] args) {
        try {
            String[] vec = new String[4];
            vec[0] = "-ORBInitialPort";
            System.out.println("Ingrese la dirección IP donde escucha el n_s");
            vec[1] = UtilidadesConsola.leerCadena();
            vec[2] = "-ORBInitialPort";
            System.out.println("Ingrese el puerto donde escucha el n_s");
            vec[3] = UtilidadesConsola.leerCadena();

            // se crea e inicia el ORB
            ORB orb = ORB.init(vec, null);

            // se obtiene un link al name service
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // *** Resuelve la referencia del objeto en el N_S ***
            String name = "objUsuarios";
            ref = ObtenerEstadisticasIntHelper.narrow(ncRef.resolve_str(name));

            System.out.println("Obtenido el manejador sobre el servidor de objetos: " + ref);
                        
            int rta = 0;
            do {
                rta = menu();
                
                switch(rta){
                    case 1:
                        opcion1();
                    break;                        
                    case 2:
                        opcion2();
                    break;
                }
                
            }while(rta != 3);
            

        } catch (Exception e) {
            System.out.println("ERROR : " + e);
            e.printStackTrace(System.out);
        }
    }
    
    private static int menu() {
        
        System.out.println(" :: MENU ::");
        System.out.println(" :1: Registrar oferta");
        System.out.println(" :2: Consulta estadisticas");
        System.out.println(" :3: Salir");
        int rta = UtilidadesConsola.leerEntero();
        
        return rta;
        
    }
    
    private static void mostrarEstadisticas(estadisticasDTO objEstadisticas){
        System.out.println("mostrando estadisticas:");
        System.out.println("solicitudes: " + objEstadisticas.cantidadSolicitudes);
        System.out.println("diferencia entre mayor y menor solicitud: " + objEstadisticas.diferenciaMenorSolicitudMayorSolicitud);
        System.out.println("promedio de solicitudes: " + objEstadisticas.promedioValorSolicitudes);
        System.out.println("tasa de crecimiento: " + objEstadisticas.tasaCrecimiento);
    }
    private static void opcion1()
    {
        float valor;
        boolean bandera;
        System.out.println("Digite el valor de su puja:");
        valor = UtilidadesConsola.leerReal();
        bandera = ref.registrarValorOferta(valor);
        if(bandera == true){
            System.out.println("oferta realizada");
        }
        else{
            System.out.println("oferta rechazada...");
        }
    }
    
    private static void opcion2()
    {
        estadisticasDTOHolder objestadisticas = new estadisticasDTOHolder();
        ref.consultarEstadisticas(objestadisticas);
        if(objestadisticas.value.cantidadSolicitudes != 0 ){
            mostrarEstadisticas(objestadisticas.value);
        }
        else{
            System.out.println("no existe estadisticas...");
        }
    }
    
}
