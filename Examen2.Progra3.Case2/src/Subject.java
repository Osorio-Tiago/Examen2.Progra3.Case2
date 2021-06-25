
public interface Subject {
	
	/*
	 * La interface Subject la utilizaremos para implementar el patron observador con el cual los clientes
	 * ser�n observadores de la clase Manager en la cual se implmentar� la interfaz
	 * 
	 * */

    public void attach(Client client);
    public void detach(Client client);
    public void notifyUpdate();
}