package bgd.domain;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "trip_advisor_user")
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
        this(null, surname, name, email, securityLogin);
    }

    public User() {
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "security_login")
    public String getSecurityLogin() {
        return securityLogin;
    }

    public void setSecurityLogin(String securityLogin) {
        this.securityLogin = securityLogin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && surname.equals(user.surname) && name.equals(user.name) && email.equals(user.email) && securityLogin.equals(user.securityLogin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name, email, securityLogin);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", securityLogin='" + securityLogin + '\'' +
                '}';
    }
}
