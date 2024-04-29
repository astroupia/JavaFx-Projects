import java.io.Serializable;

public class User implements Serializable {
    String name, address, id;

    User () {
        
    }

    User (String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String toString () {
        return "User Class: \n Name: " + this.name + " \n Id: " + this.id + " \n Address: " + this.address;
    }
}
