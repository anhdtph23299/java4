package repositories;

import entity.NSX;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.util.List;

public class NSXRepository {
    Session hSession = HibernateUtil.getFACTORY().openSession();


    public NSX findMa(String ma) {
        Query query = hSession.createQuery("select k from NSX k where k.ma =:ma");
        query.setParameter("ma", ma);
        try {
            NSX ms = (NSX) query.getSingleResult();
            return ms;
        } catch (NoResultException e) {
            return null;
        }
    }

    public void insert(NSX kh) {
        try {
            hSession.beginTransaction();
            hSession.persist(kh);
            hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            hSession.getTransaction().rollback();
        }
    }

    public void update(NSX kh) {
        try {
            hSession.beginTransaction();
            hSession.merge(kh);
            hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            hSession.getTransaction().rollback();
        }
    }

    public void delete(NSX kh) {
        kh.setTrangThai(1);
        try {
            hSession.beginTransaction();
            hSession.merge(kh);
            hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            hSession.getTransaction().rollback();
        }
    }

    public List<NSX> getAll() {
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("select ms From NSX ms where ms.trangThai=0", NSX.class);
        return query.getResultList();
    }
}
