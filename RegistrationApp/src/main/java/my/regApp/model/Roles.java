package my.regApp.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "roles")
public class Roles {
    @Id
    @Column(name = "role_id")
    private Integer roleID;
    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "roles", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Users> users = new ArrayList();

    public Roles(){}

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roles roles = (Roles) o;
        return roleID.equals(roles.roleID) &&
                role.equals(roles.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleID, role, users);
    }

    @Override
    public String toString() {
        return "Roles{" +
                "roleID=" + roleID +
                ",\n role='" + role + '\'' +
                '}';
    }
}

