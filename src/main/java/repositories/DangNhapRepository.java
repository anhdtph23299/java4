package repositories;

import entity.KhachHang;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import org.hibernate.Session;
import utils.HibernateUtil;
import viewmodel.Login;

public class DangNhapRepository {

    Session hSession = HibernateUtil.getFACTORY().openSession();
    public KhachHang getKhachHang(Login login) {
        Query query = hSession.createQuery("select k from KhachHang k where k.sdt=:tk and k.matKhau=:mk", KhachHang.class);
        query.setParameter("tk",login.getTaiKhoan());
        query.setParameter("mk",login.getMatKhau());
        try {
            KhachHang khachHang = (KhachHang) query.getSingleResult();
            return khachHang;
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }
}
