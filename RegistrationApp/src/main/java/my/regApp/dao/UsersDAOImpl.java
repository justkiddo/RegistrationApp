package my.regApp.dao;

import my.regApp.model.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class UsersDAOImpl implements UsersDAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Users user) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(user);
        tx.commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    public List<Users> list() {
        Session session = this.sessionFactory.openSession();
        List<Users> usersList = session.createQuery("from Users").list();
        session.close();
        return usersList;
    }

    public Users findUser(Users user) {
        Session session = this.sessionFactory.openSession();
        List<Users> users = session.createQuery("from Users where login = :login")
                .setParameter("login",user.getLogin())
                .list();
        if(users!=null&&users.size()>0) {
            return users.get(0);
        }
        return null;
    }

}
