
public class Payment implements IPay{


	/*
	 * La clase Payment implementa la interface IPay con el fin de aplicar un solo metodo en el cual 
	 * podamos hacer los futuros cálculos de costo facturar segun los dispositivos asignados al cliente.
	 * 
	 * */
	
	@Override
	public double payment(int devices, double amount) {
		return devices * amount;
	}	
}