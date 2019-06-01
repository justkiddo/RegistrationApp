package my.regApp.dao;

import my.regApp.model.Roles;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class RoleDAOImpl implements RoleDAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Roles role) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(role);
        tx.commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    public List<Roles> list() {
        Session session = this.sessionFactory.openSession();
        List<Roles> usersList = session.createQuery("from Roles").list();
        session.close();
        return usersList;
    }
    public Roles findRole(Roles role) {
        Session session = this.sessionFactory.openSession();
        List<Roles> roles = session.createQuery("from Roles where role = :role")
                .setParameter("role",role.getRole())
                .list();
        if(roles!=null&&roles.size()>0) {
            return roles.get(0);
        }
        return null;
    }
}
