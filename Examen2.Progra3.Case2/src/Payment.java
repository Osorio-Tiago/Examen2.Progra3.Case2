
public class Payment implements IPay{

	@Override
	public double payment(int devices, double amount) {
		return devices * amount;
	}	
}