package my.regApp.dao;

import my.regApp.model.Users;

import java.util.List;

public interface UsersDAO {
    public void save(Users user);
    public List<Users> list();
    public Users findUser(Users user);
}
