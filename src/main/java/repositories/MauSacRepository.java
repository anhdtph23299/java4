package repositories;

import entity.MauSac;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.util.List;

public class MauSacRepository {
    Session hSession = HibernateUtil.getFACTORY().openSession();


    public MauSac findMa(String ma) {
        Query query = hSession.createQuery("select k from MauSac k where k.ma =:ma");
        query.setParameter("ma", ma);
        try {
            MauSac ms = (MauSac) query.getSingleResult();
            return ms;
        } catch (NoResultException e) {
            return null;
        }
    }

    public void insert(MauSac mauSac) {
        try {
            hSession.beginTransaction();
            hSession.persist(mauSac);
            hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            hSession.getTransaction().rollback();
        }
    }

    public void update(MauSac mauSac) {
        try {
            hSession.beginTransaction();
            hSession.merge(mauSac);
            hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            hSession.getTransaction().rollback();
        }
    }

    public void delete(MauSac mauSac) {
        mauSac.setTrangThai(1);
        try {
            hSession.beginTransaction();
            hSession.merge(mauSac);
            hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            hSession.getTransaction().rollback();
        }
    }

    public List<MauSac> getAll() {
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("select ms From MauSac ms where ms.trangThai=0", entity.MauSac.class);
        return query.getResultList();
    }

}
