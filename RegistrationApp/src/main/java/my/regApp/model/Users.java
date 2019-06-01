package my.regApp.model;


import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name="Users")
public class Users {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    @Column(name = "login")
    protected String login;
    @Column(name = "password")
    protected String password;
    @Column(name = "name")
    protected String name;
    @ManyToOne
    @JoinColumn (name="role_id",referencedColumnName="role_id")
    private Roles roles;

    public Users(){
    }


    public Integer getID() {
        return id;
    }

    public void setID(Integer ID) {
        this.id = ID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id.equals(users.id) &&
                login.equals(users.login) &&
                password.equals(users.password) &&
                name.equals(users.name) &&
                roles.equals(users.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, name, roles);
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ",\n login='" + login + '\'' +
                ",\n password='" + password + '\'' +
                ",\n name='" + name + '\'' +
                '}';
    }
}
