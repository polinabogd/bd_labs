package bgd.model.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class User {
    private Integer id;
    private String surname;
    private String name;
    private String email;
    private String securityLogin;

    public User(Integer id, String surname, String name,
                String email, String securityLogin){
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.securityLogin = securityLogin;
    }

    public User(String surname, String name, String email, String securityLogin) {
    }

    @Override
    public String toString() {
        return "\nAddress: id: " + id + " surname: " + surname +
                ", name: " + name + ", email: " + email +
                ", security login: " + securityLogin;
    }
}
