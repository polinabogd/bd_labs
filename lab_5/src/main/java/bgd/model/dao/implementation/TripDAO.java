package bgd.model.dao.implementation;

import bgd.HibernateUtil;
import bgd.model.dao.AbstractDAO;
import bgd.model.entity.Trip;;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TripDAO implements AbstractDAO<Trip> {
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Trip> findAll() throws SQLException {
        List trips = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            trips = session.createQuery("from Trip ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trips;
    }

    @Override
    public Trip findById(Integer id) throws SQLException {
        Trip trip = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            trip = session.get(Trip.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trip;
    }

    @Override
    public void create(Trip trip) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(trip);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(Integer id, Trip trip) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(trip);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Trip trip = session.get(Trip.class, id);
            if (trip != null) {
                session.delete(trip);
                session.getTransaction().commit();
                System.out.println("Trip with id: " + id + " was deleted\n");
            }
            else  {
                System.out.println("Nothing to delete");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
