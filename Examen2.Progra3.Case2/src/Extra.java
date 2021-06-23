
public class Extra implements IExtra {

	@Override
	public double extra(double amount, double sur_dis) {  //Sur = surcharge / dis = discount
		return amount * sur_dis;
	}
}
