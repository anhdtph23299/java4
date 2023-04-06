package repositories;

import entity.ChucVu;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.util.List;

public class ChucVuRepository {
    Session hSession = HibernateUtil.getFACTORY().openSession();


    public ChucVu findMa(String ma) {
        Query query = hSession.createQuery("select k from ChucVu k where k.ma =:ma");
        query.setParameter("ma", ma);
        try {
            ChucVu ms = (ChucVu) query.getSingleResult();
            return ms;
        } catch (NoResultException e) {
            return null;
        }
    }

    public void insert(ChucVu kh) {
        try {
            hSession.beginTransaction();
            hSession.persist(kh);
            hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            hSession.getTransaction().rollback();
        }
    }

    public void update(ChucVu kh) {
        try {
            hSession.beginTransaction();
            hSession.merge(kh);
            hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            hSession.getTransaction().rollback();
        }
    }

    public void delete(ChucVu kh) {
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

    public List<ChucVu> getAll() {
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("select ms From ChucVu ms where ms.trangThai=0", ChucVu.class);
        return query.getResultList();
    }
}
