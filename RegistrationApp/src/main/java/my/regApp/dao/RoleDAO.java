package my.regApp.dao;

import my.regApp.model.Roles;

import java.util.List;

public interface RoleDAO {
    public void save(Roles role);
    public List<Roles> list();
    public Roles findRole(Roles role);
}