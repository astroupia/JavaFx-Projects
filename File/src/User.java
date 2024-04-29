import java.io.Serializable;

public class User implements Serializable {
    String name, address, id;

    User (String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
