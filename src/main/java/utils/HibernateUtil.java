package utils;
import entity.CTSanPham;
import entity.ChucVu;
import entity.CuaHang;
import entity.DongSP;
import entity.GioHang;
import entity.GioHangChiTiet;
import entity.HoaDon;
import entity.HoaDonChiTiet;
import entity.KhachHang;
import entity.MauSac;
import entity.NSX;
import entity.NhanVien;
import entity.SanPham;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import java.util.Properties;

public class HibernateUtil {
    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=java4");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "123456");
        properties.put(Environment.SHOW_SQL, "true");

        conf.setProperties(properties);
        conf.addAnnotatedClass(KhachHang.class);
        conf.addAnnotatedClass(MauSac.class);
        conf.addAnnotatedClass(ChucVu.class);
        conf.addAnnotatedClass(CuaHang.class);
        conf.addAnnotatedClass(DongSP.class);
        conf.addAnnotatedClass(NSX.class);
        conf.addAnnotatedClass(HoaDon.class);
        conf.addAnnotatedClass(CTSanPham.class);
        conf.addAnnotatedClass(HoaDonChiTiet.class);
        conf.addAnnotatedClass(NhanVien.class);
        conf.addAnnotatedClass(SanPham.class);
        conf.addAnnotatedClass(GioHang.class);
        conf.addAnnotatedClass(GioHangChiTiet.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {
//        DateConverter dateConverter = new DateConverter();
//        System.out.println( dateConverter.getTimeZone());

        System.out.println(getFACTORY());
    }
}
