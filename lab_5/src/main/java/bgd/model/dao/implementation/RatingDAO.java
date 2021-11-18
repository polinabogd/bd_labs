package bgd.model.dao.implementation;

import bgd.HibernateUtil;
import bgd.model.dao.AbstractDAO;

import bgd.model.entity.Rating;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RatingDAO implements AbstractDAO<Rating> {
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Rating> findAll() throws SQLException {
        List ratings = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            ratings = session.createQuery("from Rating ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ratings;
    }

    @Override
    public Rating findById(Integer id) throws SQLException {
        Rating rating = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            rating = session.get(Rating.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rating;
    }

    @Override
    public void create(Rating rating) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(rating);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(Integer id, Rating rating) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(rating);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Rating rating = session.get(Rating.class, id);
            if (rating != null) {
                session.delete(rating);
                session.getTransaction().commit();
                System.out.println("Rating with id: " + id + " was deleted\n");
            }
            else  {
                System.out.println("Nothing to delete");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
