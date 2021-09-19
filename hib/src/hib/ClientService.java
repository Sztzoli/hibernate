package hib;


public class ClientService<T extends Client> {
    
    private final DAO dao;

    public ClientService(DAO dao) {
        this.dao = dao;
    }
    
    public void save(T client) {
        dao.save(client);
    }
    
}
