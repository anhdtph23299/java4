package repositories;

import entity.ChucVu;
import entity.CuaHang;
import entity.NhanVien;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.util.List;

public class NhanVienRepository {
    Session hSession = HibernateUtil.getFACTORY().openSession();


    public NhanVien findMa(String ma) {
        Query query = hSession.createQuery("select k from NhanVien k where k.ma =:ma");
        query.setParameter("ma", ma);
        try {
            NhanVien ms = (NhanVien) query.getSingleResult();
            return ms;
        } catch (NoResultException e) {
            return null;
        }
    }

    public void insert(NhanVien kh) {
        try {
            hSession.beginTransaction();
            hSession.persist(kh);
            hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            hSession.getTransaction().rollback();
        }
    }

    public void update(NhanVien kh) {
        try {
            hSession.beginTransaction();
            hSession.merge(kh);
            hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            hSession.getTransaction().rollback();
        }
    }

    public void delete(NhanVien kh) {
        try {
            hSession.beginTransaction();
            hSession.delete(kh);
            hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            hSession.getTransaction().rollback();
        }
    }

    public List<NhanVien> getAll() {
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("select ms From NhanVien ms where ms.trangThai=0", NhanVien.class);
        return query.getResultList();
    }
    public List<ChucVu> getAllChucVu() {
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("select ms From ChucVu ms where ms.trangThai=0", ChucVu.class);
        return query.getResultList();
    }
    public List<CuaHang> getAllCuaHang() {
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("select ms From CuaHang ms where ms.trangThai=0", CuaHang.class);
        return query.getResultList();
    }
    public CuaHang findCuaHangByMa(String ma) {
        Query query = hSession.createQuery("select k from CuaHang k where k.ma =:ma and k.trangThai=0");
        query.setParameter("ma", ma);
        try {
            CuaHang ms = (CuaHang) query.getSingleResult();
            return ms;
        } catch (NoResultException e) {
            return null;
        }
    }
    public ChucVu findChucVuByMa(String ma) {
        Query query = hSession.createQuery("select k from ChucVu k where k.ma =:ma and k.trangThai=0");
        query.setParameter("ma", ma);
        try {
            ChucVu ms = (ChucVu) query.getSingleResult();
            return ms;
        } catch (NoResultException e) {
            return null;
        }
    }
}
