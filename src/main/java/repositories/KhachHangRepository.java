package repositories;


import entity.KhachHang;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.util.List;

public class KhachHangRepository {
    private Session hSession = HibernateUtil.getFACTORY().openSession();


    public KhachHang findMa(String ma) {
        Query query = hSession.createQuery("select k from KhachHang k where k.ma =:ma");
        query.setParameter("ma", ma);
        try {
            KhachHang kh = (KhachHang) query.getSingleResult();
            return kh;
        } catch (NoResultException e) {
            return null;
        }
    }

    public void insert(KhachHang kh) {
        try {
            hSession.beginTransaction();
            hSession.persist(kh);
            hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            hSession.getTransaction().rollback();
        }
    }

    public void update(KhachHang kh) {
        try {
            hSession.beginTransaction();
            hSession.merge(kh);
            hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            hSession.getTransaction().rollback();
        }
    }

    public void delete(KhachHang kh) {
        try {
            hSession.beginTransaction();
            hSession.delete(kh);
            hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            hSession.getTransaction().rollback();
        }
    }

    public List<KhachHang> getAll() {
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("select kh From KhachHang kh", KhachHang.class);
        return query.getResultList();
    }



}
