package repositories;

import entity.DongSP;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.util.List;

public class DongSPRepository {
    Session hSession = HibernateUtil.getFACTORY().openSession();


    public DongSP findMa(String ma) {
        Query query = hSession.createQuery("select k from DongSP k where k.ma =:ma");
        query.setParameter("ma", ma);
        try {
            DongSP ms = (DongSP) query.getSingleResult();
            return ms;
        } catch (NoResultException e) {
            return null;
        }
    }

    public void insert(DongSP kh) {
        try {
            hSession.beginTransaction();
            hSession.persist(kh);
            hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            hSession.getTransaction().rollback();
        }
    }

    public void update(DongSP kh) {
        try {
            hSession.beginTransaction();
            hSession.merge(kh);
            hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            hSession.getTransaction().rollback();
        }
    }

    public void delete(DongSP kh) {
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

    public List<DongSP> getAll() {
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("select ms From DongSP ms where ms.trangThai=0", DongSP.class);
        return query.getResultList();
    }
}
