
public class Extra implements IExtra {

	/*
	 * La clase Extra implementa la interface IExtra con el fin de aplicar un solo metodo con el cual 
	 * podamos hacer el descuento o recargo con base a la interacción que el cliente tenga con los dispositivos
	 * entre periodos mensuales segun lo establece el enunciado.
	 * 
	 * */
	
	
	@Override
	public double extra(double amount, double sur_dis) {  //Sur = surcharge / dis = discount
		return amount * sur_dis;
	}
}
