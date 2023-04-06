package repositories;

import entity.CTSanPham;
import entity.DongSP;
import entity.MauSac;
import entity.NSX;
import entity.SanPham;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.util.List;
import java.util.UUID;

public class CTSanPhamRepository {
    Session hSession = HibernateUtil.getFACTORY().openSession();


    public CTSanPham findID(UUID id) {
        Query query = hSession.createQuery("select k from CTSanPham k where k.id =:id");
        query.setParameter("id", id);
        try {
            CTSanPham ms = (CTSanPham) query.getSingleResult();
            return ms;
        } catch (NoResultException e) {
            return null;
        }
    }

    public void insert(CTSanPham kh) {
        try {
            hSession.beginTransaction();
            hSession.persist(kh);
            hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            hSession.getTransaction().rollback();
        }
    }

    public void update(CTSanPham kh) {
        try {
            hSession.beginTransaction();
            hSession.merge(kh);
            hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            hSession.getTransaction().rollback();
        }
    }

    public void delete(CTSanPham kh) {
        try {
            hSession.beginTransaction();
            hSession.delete(kh);
            hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            hSession.getTransaction().rollback();
        }
    }

    public List<CTSanPham> getAll() {
        Query query = hSession.createQuery("select ms From CTSanPham ms", CTSanPham.class);
        return query.getResultList();
    }
    public List<SanPham> getAllSanPham() {
        Query query = hSession.createQuery("select ms From SanPham ms where ms.trangThai=0", SanPham.class);
        return query.getResultList();
    }
    public List<DongSP> getAllDongSP() {
        Query query = hSession.createQuery("select ms From DongSP ms where ms.trangThai=0", DongSP.class);
        return query.getResultList();
    }
    public List<MauSac> getAllMauSac() {
        Query query = hSession.createQuery("select ms From MauSac ms where ms.trangThai=0", MauSac.class);
        return query.getResultList();
    }
    public List<NSX> getAllNSX() {
        Query query = hSession.createQuery("select ms From NSX ms where ms.trangThai=0", NSX.class);
        return query.getResultList();
    }
    public DongSP findMaDongSP(String ma) {
        Query query = hSession.createQuery("select k from DongSP k where k.ma =:ma");
        query.setParameter("ma", ma);
        try {
            DongSP ms = (DongSP) query.getSingleResult();
            return ms;
        } catch (NoResultException e) {
            return null;
        }
    }
    public MauSac findMaMauSac(String ma) {
        Query query = hSession.createQuery("select k from MauSac k where k.ma =:ma");
        query.setParameter("ma", ma);
        try {
            MauSac ms = (MauSac) query.getSingleResult();
            return ms;
        } catch (NoResultException e) {
            return null;
        }
    }
    public NSX findMaNSX(String ma) {
        Query query = hSession.createQuery("select k from NSX k where k.ma =:ma");
        query.setParameter("ma", ma);
        try {
            NSX ms = (NSX) query.getSingleResult();
            return ms;
        } catch (NoResultException e) {
            return null;
        }
    }
    public SanPham findMaSanPham(String ma) {
        Query query = hSession.createQuery("select k from SanPham k where k.ma =:ma");
        query.setParameter("ma", ma);
        try {
            SanPham ms = (SanPham) query.getSingleResult();
            return ms;
        } catch (NoResultException e) {
            return null;
        }
    }
}
