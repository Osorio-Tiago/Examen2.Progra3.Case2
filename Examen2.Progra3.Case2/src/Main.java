
public class Main {

	public static void main(String[] args) {
        Manager manager = new Manager();
        
        /*
         * QUITAR TODO ESTO Y USAR NOMBRES DISTINTOS PARA LOS CLIENTES
         * QUITAR TODO ESTO Y USAR NOMBRES DISTINTOS PARA LOS CLIENTES
         * QUITAR TODO ESTO Y USAR NOMBRES DISTINTOS PARA LOS CLIENTES
         * QUITAR TODO ESTO Y USAR NOMBRES DISTINTOS PARA LOS CLIENTES
         * QUITAR TODO ESTO Y USAR NOMBRES DISTINTOS PARA LOS CLIENTES
         * QUITAR TODO ESTO Y USAR NOMBRES DISTINTOS PARA LOS CLIENTES
         * QUITAR TODO ESTO Y USAR NOMBRES DISTINTOS PARA LOS CLIENTES
         * QUITAR TODO ESTO Y USAR NOMBRES DISTINTOS PARA LOS CLIENTES
         * QUITAR TODO ESTO Y USAR NOMBRES DISTINTOS PARA LOS CLIENTES
         */
        Client client1 = new Client("Juan");
        Client client2 = new Client("John");
        Client client3 = new Client("Jeremy");
        Client client4 = new Client("Joshua");
        
        client1.addDevices(5);
        client2.addDevices(33);
        client3.addDevices(74);
        client4.addDevices(240);
       
        manager.attach(client1);
        manager.attach(client2);
        manager.attach(client3);
        manager.attach(client4);
        
        System.out.println("----------------------------------------------------");
        System.out.println("Primer mes");
        System.out.println("----------------------------------------------------");
        
        manager.notifyUpdate();
        
        client2.subDevices(2);
        client3.addDevices(40);
        client4.subDevices(20);
        
        System.out.println("----------------------------------------------------");
        System.out.println("Segundo mes");
        System.out.println("----------------------------------------------------");
        
        manager.notifyUpdate();
        
        client1.addDevices(200);
        client3.addDevices(15);
        
        System.out.println("----------------------------------------------------");
        System.out.println("Tercer mes");
        System.out.println("----------------------------------------------------");
        
        manager.notifyUpdate();

	}
}
