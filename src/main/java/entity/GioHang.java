package entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "GioHang")
public class GioHang implements Serializable {
    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    @Column(name = "Id")
    private UUID id;

    @ManyToOne()
    @JoinColumn(name = "IdKH")
    private KhachHang khachHang;

    @ManyToOne()
    @JoinColumn(name = "IdNV")
    private NhanVien nhanVien;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "NgayTao")
    private Date ngayTao;

    @Column(name = "NgayThanhToan")
    private Date ngayThanhToan;

    @Column(name = "TenNguoiNhan")
    private String tenNguoiNhan;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "Sdt")
    private String sdt;

    @Column(name = "TinhTrang")
    private Integer tinhTrang;

    @Column(name = "MaTuTang",updatable = false,insertable = false)
    private Integer maTuTang;

    @OneToMany(mappedBy = "gioHang")
    private List<GioHangChiTiet> listGioHangChiTiet;
}
