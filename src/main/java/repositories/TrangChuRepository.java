package repositories;

import entity.CTSanPham;
import entity.GioHang;
import entity.GioHangChiTiet;
import entity.KhachHang;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.util.List;
import java.util.UUID;

public class TrangChuRepository {
    Session hSession = HibernateUtil.getFACTORY().openSession();

    public List<CTSanPham> getAllSanPham() {
        Query query = hSession.createQuery("select ms From CTSanPham ms", CTSanPham.class);
        return query.getResultList();
    }
    public CTSanPham findCTSanPhamById(UUID id) {
        Query query = hSession.createQuery("select k from CTSanPham k where k.id =:id");
        query.setParameter("id", id);
        try {
            CTSanPham ms = (CTSanPham) query.getSingleResult();
            return ms;
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<CTSanPham> findSearchProduct(String search){
        Query query = hSession.createQuery("select k from CTSanPham k where k.sanPham.ten like :ten");
        query.setParameter("ten", "%" + search + "%");

        try {
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public GioHang findGioHangByKhachHang(UUID idKhachHang){
        Query query = hSession.createQuery("select gh from GioHang gh " +
                "where gh.khachHang.id =:id and gh.tinhTrang=1",GioHang.class);
        query.setParameter("id", idKhachHang);
        try {
            GioHang gh = (GioHang) query.getSingleResult();
            return gh;
        } catch (NoResultException e) {
            return null;
        }
    }
    public void insertGioHang(GioHang gioHang){
        try {
            hSession.beginTransaction();
            hSession.persist(gioHang);
            hSession.getTransaction().commit();
        }catch (Exception e){
            hSession.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void updateMatKhauKH(KhachHang khachHang){
        try {
            hSession.beginTransaction();
            hSession.merge(khachHang);
            hSession.getTransaction().commit();
        }catch (Exception e){
            hSession.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    public void insertGioHangChiTiet(GioHangChiTiet gioHangChiTiet){
        try {
            hSession.beginTransaction();
            hSession.persist(gioHangChiTiet);
            hSession.getTransaction().commit();
        }catch (Exception e){
            hSession.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void updateGioHangChiTiet(GioHangChiTiet gioHangChiTiet){
        try {
            hSession.beginTransaction();
            hSession.merge(gioHangChiTiet);
            hSession.getTransaction().commit();
        }catch (Exception e){
            hSession.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public GioHangChiTiet findGioHangByGioHangCT(UUID idGioHang,UUID idCTSP){
        Query query = hSession.createQuery("select ghct from GioHangChiTiet ghct " +
                        "where ghct.gioHang.id =:idGH and ghct.CTSanPham.id=:idCTSP"
                ,GioHangChiTiet.class);
        query.setParameter("idGH", idGioHang);
        query.setParameter("idCTSP", idCTSP);
        try {
            GioHangChiTiet ghct = (GioHangChiTiet) query.getSingleResult();
            return ghct;
        } catch (NoResultException e) {
            return null;
        }
    }
    public Integer findGioHangByKhachHang(KhachHang kh){
        Query query = hSession.createQuery("select ghct from GioHangChiTiet ghct " +
                        "inner join GioHang gh " +
                        "on ghct.gioHang.id =" +
                        "gh.id where gh.khachHang.id =:idKH and gh.tinhTrang=1"
                ,GioHangChiTiet.class);
        query.setParameter("idKH", kh.getId());
        try {
           return query.getResultList().size();
        } catch (NoResultException e) {
            return 0;
        }
    }


}
