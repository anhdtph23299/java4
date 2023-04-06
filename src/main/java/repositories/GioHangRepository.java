package repositories;

import entity.CTSanPham;
import entity.GioHang;
import entity.GioHangChiTiet;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class GioHangRepository {

    Session hSession = HibernateUtil.getFACTORY().openSession();
    public List<GioHangChiTiet> getAllSanPham(UUID idKh) {
        Query query = hSession.createQuery("select ghct from GioHangChiTiet ghct " +
                "where ghct.gioHang.khachHang.id=:idkh and ghct.gioHang.tinhTrang=1", GioHangChiTiet.class);
        query.setParameter("idkh",idKh);
        return query.getResultList();
    }
    public GioHang getGioHangByKhachHang(UUID idKH){
        Query query = hSession.createQuery("select gh from GioHang gh where gh.khachHang.id=:idkh" +
                " and gh.tinhTrang=1", GioHang.class);
        query.setParameter("idkh",idKH);
        return (GioHang) query.getSingleResult();
    }

    public GioHangChiTiet getGioHangByIdSpAndIdGh(UUID idSp,UUID idGh){
        Query query = hSession.createQuery("select ghct from GioHangChiTiet ghct " +
                "where ghct.gioHang.id=:idgh and ghct.CTSanPham.id=:idsp and ghct.gioHang.tinhTrang = 1", GioHangChiTiet.class);
        query.setParameter("idsp",idSp);
        query.setParameter("idgh",idGh);
        return (GioHangChiTiet) query.getSingleResult();
    }
    public void updateGioHangChiTiet(GioHangChiTiet gioHangChiTiet){
        try {
            hSession.beginTransaction();
            hSession.merge(gioHangChiTiet);
            hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            hSession.getTransaction().rollback();
        }
    }
    public void deleteGioHang(GioHangChiTiet gioHangChiTiet){
        try {
            hSession.beginTransaction();
            hSession.delete(gioHangChiTiet);
            hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            hSession.getTransaction().rollback();
        }
    }

    public BigDecimal getTongTienList(UUID idKH)
    {
        Query query = hSession.createQuery("select sum(ghct.SoLuong * ghct.CTSanPham.giaBan) from GioHangChiTiet ghct" +
                " where ghct.gioHang.khachHang.id=:idkh and ghct.gioHang.tinhTrang=1", BigDecimal.class);
        query.setParameter("idkh",idKH);
        try{
            return (BigDecimal) query.getSingleResult();
        }catch (NoResultException e){
            return BigDecimal.valueOf(0);
        }
    }

    public void updateGioHang(GioHang gh) {
        try {
            hSession.beginTransaction();
            hSession.merge(gh);
            hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            hSession.getTransaction().rollback();
        }
    }
}
