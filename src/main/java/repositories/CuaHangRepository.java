package repositories;

import entity.CuaHang;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import org.hibernate.Session;
import utils.HibernateUtil;
import java.util.List;

public class CuaHangRepository {
    Session hSession = HibernateUtil.getFACTORY().openSession();

    public CuaHang findMa(String ma) {
        Query query = hSession.createQuery("select k from CuaHang k where k.ma =:ma");
        query.setParameter("ma", ma);
        try {
            CuaHang ms = (CuaHang) query.getSingleResult();
            return ms;
        } catch (NoResultException e) {
            return null;
        }
    }

    public void insert(CuaHang kh) {
        try {
            hSession.beginTransaction();
            hSession.persist(kh);
            hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            hSession.getTransaction().rollback();
        }
    }

    public void update(CuaHang kh) {
        try {
            hSession.beginTransaction();
            hSession.merge(kh);
            hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            hSession.getTransaction().rollback();
        }
    }

    public void delete(CuaHang kh) {
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

    public List<CuaHang> getAll() {
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("select ms From CuaHang ms where ms.trangThai=0", CuaHang.class);
        return query.getResultList();
    }
}
