
package hib;



import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;



@MappedSuperclass
public class Client implements Serializable {
    
    @Id
    @Column(name = "Id")
    protected String id;
    
    @Column(name = "Name")
    protected String name;
    
    @Column(name = "Age")
    protected int age;

    public Client() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public void setClient(Client other) {
        this.name = other.name;
        this.age = other.age;
    }   

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", name=" + name + ", age=" + age + '}';
    }
    
    
        
}
