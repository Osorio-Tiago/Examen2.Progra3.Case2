




public class Client {
    
    String name;
    int actualDevices = 0;
    int previousDevices = 0;

    public Client(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void addDevices(int devices){
    	this.previousDevices = actualDevices;
    	this.actualDevices +=devices;
    }
    
    public void subDevices(int devices){
        this.previousDevices = actualDevices;
        this.actualDevices -=devices;
        if(this.actualDevices<0)
            this.actualDevices = 0;
    }

    public int getActualdevices() {
        return actualDevices;
    }

    public void setActualdevices(int actualdevices) {
        this.actualDevices = actualdevices;
    }

    public int getPreviousDevices() {
        return previousDevices;
    }

    public void setPreviousDevices(int previousDevices) {
        this.previousDevices = previousDevices;
    }
    
    public void updatePayment(double amount){
        System.out.println("Monto a pagar este mes: $" + amount);
    }
}  
