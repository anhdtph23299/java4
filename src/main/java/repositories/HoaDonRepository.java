package repositories;

import entity.GioHang;
import entity.GioHangChiTiet;
import entity.HoaDon;
import jakarta.persistence.Query;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.util.List;
import java.util.UUID;

public class HoaDonRepository {

    Session hSession  = HibernateUtil.getFACTORY().openSession();

    public List<GioHang> getHoaDon(){
        Query query = hSession.createQuery("select gh from GioHang gh where" +
                " gh.tinhTrang not in (1)", GioHang.class);
        return query.getResultList();
    }
    public List<GioHangChiTiet> getGioHangChiTietByID(UUID id){
        Query query = hSession.createQuery("select ghct from GioHangChiTiet ghct " +
                "where ghct.gioHang.id=:idgh", GioHangChiTiet.class);
        query.setParameter("idgh",id);
        return query.getResultList();
    }
    public GioHang getGioHangById(UUID idGH){
        Query query = hSession.createQuery("select gh from GioHang gh where gh.id =:idgh", GioHang.class);
        query.setParameter("idgh",idGH);
        return (GioHang) query.getSingleResult();
    }
    public void chuyenTrangThaiGioHang(GioHang gioHang,Integer trangThai){
        //2 chờ xác nhận
        //3 đang giao
        //4 hoàn thành
        //5 huỷ
        //1 ở giỏ hàng
    gioHang.setTinhTrang(trangThai);
        try {
            hSession.beginTransaction();
            hSession.merge(gioHang);
            hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            hSession.getTransaction().rollback();
        }
    }
}
