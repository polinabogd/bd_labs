package bgd.model.dao.implementation;

import bgd.HibernateUtil;
import bgd.model.dao.AbstractDAO;
import bgd.model.entity.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDAO implements AbstractDAO<Address> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Address> findAll() throws SQLException {
        List addresses = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            addresses = session.createQuery("from Address ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return addresses;
    }

    @Override
    public Address findById(Integer id) throws SQLException {
        Address address = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            address = session.get(Address.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return address;
    }

    @Override
    public void create(Address address) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(address);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Address address) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(address);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Address address = session.get(Address.class, id);
            if (address != null) {
                session.delete(address);
                session.getTransaction().commit();
                System.out.println("Address with id: " + id + " was deleted\n");
            }
            else  {
                System.out.println("Nothing to delete");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

