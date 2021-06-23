
public interface Subject {
    public void attach(Client client);
    public void detach(Client client);
    public void notifyUpdate();
}