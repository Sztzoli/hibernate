package hib;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class ClientDaoIT {
    
    
    static EntityManagerFactory factory;
    ClientDto clientDto;
    
    @BeforeClass
    public static void initFactory() {
        factory = Persistence.createEntityManagerFactory("hibPU");
    }
    
    @AfterClass
    public static void destroy() {
        factory.close();
    }
    
    @Before()
    public void init() {
        clientDto = new ClientDto(factory);
    }
    
    @Test
    public void setClient() {
        ClientH client = new ClientH();
        client.setId("1");
        client.setName("zoli");
        client.setAge(10);
        
        ClientH client2 = new ClientH();
        client2.setId("1");
        client2.setName("Dunci");
        client2.setAge(20);
        
        client.setClient(client2);
        
        System.out.println(client);
    }
    
    @Test
    public void getAll() {
        List<ClientH> resultList = clientDto.getAll();
        System.out.println(resultList);        
    }
    
    @Test
    public void saveClient() {
        ClientH client = new ClientH();
        client.setId("10");
        client.setName("Test");
        client.setAge(10);
        System.out.println(client);
        clientDto.save(client) ;
        ClientH clientDB = clientDto.findById(client.getId());
        System.out.println(clientDB);
        
    }
    
    
    
           
}
