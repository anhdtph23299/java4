package repositories;

import entity.SanPham;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.util.List;

public class SanPhamRepository {
    Session hSession = HibernateUtil.getFACTORY().openSession();


    public SanPham findMa(String ma) {
        Query query = hSession.createQuery("select k from SanPham k where k.ma =:ma");
        query.setParameter("ma", ma);
        try {
            SanPham ms = (SanPham) query.getSingleResult();
            return ms;
        } catch (NoResultException e) {
            return null;
        }
    }

    public void insert(SanPham kh) {
        try {
            hSession.beginTransaction();
            hSession.persist(kh);
            hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            hSession.getTransaction().rollback();
        }
    }

    public void update(SanPham kh) {
        try {
            hSession.beginTransaction();
            hSession.merge(kh);
            hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            hSession.getTransaction().rollback();
        }
    }

    public void delete(SanPham kh) {
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

    public List<SanPham> getAll() {
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("select ms From SanPham ms where ms.trangThai=0", SanPham.class);
        return query.getResultList();
    }
}
