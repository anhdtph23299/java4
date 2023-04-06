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

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "NhanVien")
public class NhanVien implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private UUID id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "TenDem")
    private String tenDem;

    @Column(name = "Ho")
    private String ho;

    @Column(name = "GioiTinh")
    private String gioiTinh;

    @Column(name = "NgaySinh")
    private Date ngaySinh;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "Sdt")
    private String sdt;

    @Column(name = "MatKhau")
    private String matKhau;

    @ManyToOne()
    @JoinColumn(name = "IdCH")
    private CuaHang cuaHang;

    @ManyToOne()
    @JoinColumn(name = "IdCV")
    private ChucVu chucVu;

    @Column(name = "TrangThai")
    private Integer trangThai;

    @OneToMany(mappedBy = "nhanVien")
    private List<HoaDon> listHoaDon;

    @OneToMany(mappedBy = "nhanVien")
    private List<GioHang> listGioHang;
}
