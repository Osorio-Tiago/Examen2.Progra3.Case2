import java.util.ArrayList;
import java.util.List;

public class Manager implements Subject{

/*
 * La clase Manager es nuestra clase principal ya que es por medio de la cual veremos la funcionalidad de los
 * 2 patrones trabajando entre si, por un lado tenemos el patron Strategy que nos permite
 * remplazar las extrategias segun las necesidad de negocio con base a los Extras y Costos que se establezcan
 * en ambos. Si se quiere cambiar el descuento para los dispositivos segun el mes o el recargo este patron 
 * nos da la oportunidad de hacerlo de una manera eficiente y por otro lado se puede observar que 
 * implementa la clase Subject con la cual utilizamos el segundo patron, el Observer este con el fin 
 * de agregar a los futuros clientes como observadores y así notificar el estado de los costos ya aplicando
 * los cálculos definidos
 * 
 */
	
    private List<Client> observers = new ArrayList<Client>();
    
    /*
     *  Constantes que contienen los valores de descuento y recargo lo que lo hace más fácil de cambiar en algún futuro.
     */
    
    static final double SURCHARGE = 0.05;
    static final double DISCOUNT = 0.25;
    
    
    /*
     * Enum que contiene el precio por dispositivo en el intervalo dado (5 o menos, 6 a 49, etc...)
     * De esta manera puedo cambiar el precio de los dispositivos de una manera más sencilla sin tener que 
     * ir a cambiar todo el código que utiliza esos precios.
     */
    enum DevicesPrice{
    	 c5orLess (0),
    	 c6to49 (0.10),
    	 c50to99 (0.07),
    	 c100orMore (0.05); 
    	
    	private final double price;
    	 DevicesPrice(double price){
    		 this.price = price;
    	 }
		public double getPrice() {
			return price;
		}
    }
    
    @Override
    public void attach(Client client) {
        this.observers.add(client);
    }

    @Override
    public void detach(Client client) {
        this.observers.remove(client);
    }

    @Override
    public void notifyUpdate() {
        Client client;
        int actualDevices;
        int previousDevices;
        double monto = 0;
        double extras = 0;
        
        for(int i =0; i < observers.size(); i++){
            client = observers.get(i);
            System.out.println("+=====+==========================================+");
            System.out.println("|Información personal del cliente                |");
            System.out.println("+=====+==========================================+");
            System.out.println("|Nombre: " + client.getName()); 
            actualDevices = client.getActualdevices(); 
            previousDevices = client.getPreviousDevices();         
            System.out.println("|Dispositivos: " + client.getActualdevices());
            System.out.print("|Pago por dispositivo:");
            monto = payForDevices(actualDevices);
            
            if(previousDevices != 0) {
            monto = extraPayment(actualDevices, previousDevices, monto);
            }
            client.updatePayment(monto);
            System.out.println("+=====+==========================================+\n\n");
        }
    }
    
    
    double payForDevices(int actualDevices) {
    	
         double amount = 0.0;
         
         if(actualDevices >= 100){
        	 System.out.println(" $" + DevicesPrice.c100orMore.getPrice());
             IPay pay = new Payment();
             amount = pay.payment(actualDevices, DevicesPrice.c100orMore.getPrice());
         }

         else if(actualDevices>=50 && actualDevices<=90){
        	 System.out.println("$" + DevicesPrice.c50to99.getPrice());
             IPay pay = new Payment();
             amount = pay.payment(actualDevices, DevicesPrice.c50to99.getPrice());
         }
         
         else if(actualDevices>=6 && actualDevices<=49){
        	 System.out.println("$" + DevicesPrice.c6to49.getPrice());
        	 IPay pay = new Payment();
        	 amount = pay.payment(actualDevices, DevicesPrice.c6to49.getPrice());
         }
          else {
        	  System.out.println("$" + DevicesPrice.c5orLess.getPrice());
        	  IPay pay = new Payment();
        	  amount = pay.payment(actualDevices, DevicesPrice.c5orLess.getPrice());
          }   
		return amount;
    }
    
    
    double extraPayment(int actualDevices, int previousDevices,double amount) {
    	double amountTmp = amount;
    	double extraTmp;
    	
    	if(actualDevices < previousDevices){
    		IExtra extra = new Extra();
            extraTmp = extra.extra(amount, SURCHARGE);
            System.out.println("|Recargo de $: " + extraTmp);
            amountTmp = amountTmp + extraTmp;   
    	}
    	else if(actualDevices > previousDevices) {
    		IExtra extra = new Extra();
    		extraTmp = extra.extra(amount,DISCOUNT);
    		System.out.println("|Descuento de $: " + extraTmp);
    		amountTmp = amountTmp - extraTmp; 
    	}
    	return amountTmp;
    }
}
