
public class Main {

	/*Examen II - Justificación de los patrones seleccionados - Caso II:
	/*
	 * 
	 * Para el caso 2 se nos solicitó un sistema de cobro con el cual tendremos 2 varibles importantes de 
	 * modelo de negocio, por una lado los descuentos o recargos segun la varible de cantidad dispositivos 
	 * entre meses y la segunta el monto a facturar segun la cantidad de dipositivos asignados a cada cliente.
	 * Al observar que mediante varios metodos había que hacer calculos similares decidimos implementar 
	 * el patron Strategy que no solo nos da facilidad de manipulación para este proceso sino tambien para los 
	 * futuros cambios en el modelo de negocio de la empresa, además de esto para hacerlo de una manera más 
	 * apegado a la realidad implementamos el patron Observer con el cual generaremos notificaciónes a los clientes
	 * sobre el estados de cobro segun los dipositivos agregados. 
	 * 
	 * 
	 */
	
	
	public static void main(String[] args) {
        Manager manager = new Manager();
        

        Client client1 = new Client("Ariadna Chavarría");
        Client client2 = new Client("Santiago Osorio  ");
        Client client3 = new Client("Moisés Bolaños   ");
        Client client4 = new Client("Daniel López     ");
        
        client1.addDevices(15);
        client2.addDevices(33);
        client3.addDevices(74);
        client4.addDevices(24);
       
        manager.attach(client1);
        manager.attach(client2);
        manager.attach(client3);
        manager.attach(client4);
        
        System.out.println("         ******************************************");
        System.out.println("         //               Primer mes             //");
        System.out.println("         ****************************************** \n\n");
     
        
        manager.notifyUpdate();
        
        client2.subDevices(2);
        client3.addDevices(40);
        client4.subDevices(20);
        System.out.println("Fin del primer mes.");  
        System.out.println("____________________________________________________\n\n");
   
        System.out.println("         ******************************************");
        System.out.println("         //              Segundo mes             //");
        System.out.println("         ****************************************** \n\n");
        
        manager.notifyUpdate();
        
        client1.addDevices(200);
        client3.addDevices(15);
        System.out.println("Fin del segundo mes.");  
        System.out.println("____________________________________________________\n\n");
        
        System.out.println("         ******************************************");
        System.out.println("         //               Tercer mes             //");
        System.out.println("         ****************************************** \n\n");
        
        manager.notifyUpdate();
        System.out.println("Fin del tercer mes.");  
        System.out.println("____________________________________________________\n\n");

	}
}
