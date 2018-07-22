package Dao;

import Hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Repositorio<T,K extends Integer> implements IRepositorio<T, K>{


    private Class<T> tClass;

    public Repositorio(Class<T> tClass) {

        this.tClass = tClass;
    }

    @Override
    public void add(T t) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.openSession();
            transaction = session.beginTransaction();

            session.save(t);

            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(T t) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.openSession();
            transaction = session.beginTransaction();

            session.update(t);

            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteById(T t) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.openSession();
            transaction = session.beginTransaction();

            session.delete(t);

            transaction.commit();

        } catch (HibernateException e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void merge(T t) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.openSession();
            transaction = session.beginTransaction();

            session.merge(t);

            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public T findOne(K k) {
        Session session = null;
        Transaction transaction = null;
        Query query = null;

        try {
            session = HibernateUtil.openSession();
            transaction = session.beginTransaction();

            query = session.createQuery("from " + tClass.getSimpleName() + " t where t.id = " + k);

            return (T) query.uniqueResult();
        } catch (HibernateException e) {
            transaction.rollback();
            return null;
        } finally {
            session.close();
        }
    }


    @Override
    public List<T> getAll() {
        Session session = null;
        Transaction transaction = null;
        Query query = null;

        try {
            session = HibernateUtil.openSession();
            transaction = session.beginTransaction();

            query = session.createQuery("from " + tClass.getSimpleName());

            return query.list();
        } catch (HibernateException e) {
            transaction.rollback();
            return null;
        } finally {
            session.close();
        }
    }
}
