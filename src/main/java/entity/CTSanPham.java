package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "ChiTietsp")
public class CTSanPham implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "IdSP")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "IdNSX")
    private NSX nsx;

    @ManyToOne
    @JoinColumn(name = "IdMauSac")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "IdDongSP")
    private DongSP dongSP;

    @Column(name = "NamBH")
    private int namBH;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "SoLuongTon")
    private int soLuongTon;

    @Column(name = "GiaNhap")
    private BigDecimal giaNhap;

    @Column(name = "giaBan")
    private BigDecimal giaBan;

    @Column(name = "images")
    private String images;

    @OneToMany(mappedBy = "CTSanPham")
    private List<GioHangChiTiet> listGioHangChiTiet;

    @OneToMany(mappedBy = "CTSanPham")
    private List<HoaDonChiTiet> listHoaDonChiTiet;
}
