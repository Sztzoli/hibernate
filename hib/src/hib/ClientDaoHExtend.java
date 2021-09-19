package hib;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

public class ClientDaoHExtend implements DAO<ClientH>{

    private final EntityManagerFactory entityManagerFactory;

    public ClientDaoHExtend(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public ClientH findById(String id) {
       EntityManager em = entityManagerFactory.createEntityManager();
        ClientH client = em.find(ClientH.class, id);
        em.close();
        return client;
    }

    @Override
    public List<ClientH> getAll() {
            String sql = "select c from ClientH c";
        EntityManager em = entityManagerFactory.createEntityManager();
        List<ClientH> clients
                = em.createQuery(sql, ClientH.class)
                        .getResultList();
        em.close();
        return clients;
    }

    @Override
    public List<ClientH> getClientAfterAge(int age) {
        String sql = "select c from ClientH c where c.age > :age";
        EntityManager em = entityManagerFactory.createEntityManager();
        List<ClientH> clients
                = em.createQuery(sql, ClientH.class)
                        .setParameter("age", age)
                        .getResultList();
        em.close();
        return clients;
    }

    @Override
    public void save(ClientH client) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(client);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(ClientH client) {
              EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        ClientH clientDB = em.find(ClientH.class, client.getId());
        clientDB.setClient(client);
        em.getTransaction().commit();
        em.close();
    }

   
    
    

    
     
     
    
    
   

       
    
}
