package hib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class ClientDtoJDBC implements DAO<Client> {

    private final DataSource datasource;

    public ClientDtoJDBC(DataSource datasource) {
        this.datasource = datasource;
    }

   
    @Override
    public void save(Client client) {
        try (Connection conn = datasource.getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into Clients(Id,Name,Age) values (?,?,?)")) {
            ps.setString(1, client.getId());
            ps.setString(2, client.getName());
            ps.setInt(3, client.getAge());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert");
        }
    }

  
    @Override
    public ClientH findById(String id) {
           return null;
    }


    @Override
    public List<Client> getAll() {
        try (
                Connection conn = datasource.getConnection();
                Statement stmt = conn.createStatement();               
                ResultSet rs = stmt.executeQuery("select Id,Name,Age from employees");) {
            List<Client> clients = new ArrayList<>();
            while (rs.next()) {
                Client client = new Client();
                client.setId(rs.getNString("Id"));
                client.setName(rs.getString("Name"));
                client.setAge(rs.getInt("Age"));
                clients.add(client);
            }
            return clients;
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot select employees", se);
        }
    }

 
    @Override
    public void update(Client client) {

    }


    @Override
    public List<Client> getClientAfterAge(int age) {
          return null;
    }
}
