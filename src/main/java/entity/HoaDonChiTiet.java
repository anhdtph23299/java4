package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "HoaDonChiTiet")
public class HoaDonChiTiet implements Serializable {
    @EmbeddedId
    private HoaDonChiTietId hoaDonChiTietId;

    @ManyToOne
    @JoinColumn(name = "IdHoaDon", insertable = false, updatable = false)
    private HoaDon hoaDon;

    @ManyToOne
    @JoinColumn(name = "IdChiTietSP", insertable = false, updatable = false)
    private CTSanPham CTSanPham;

    @Column(name = "SoLuong")
    private int soLuong;

    @Column(name = "DonGia")
    private BigDecimal donGia;

    @Column(name = "DonGiaKhiGiam")
    private BigDecimal donGiaKhiGiam;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HoaDonChiTiet that = (HoaDonChiTiet) o;
        return hoaDonChiTietId.equals(that.hoaDonChiTietId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hoaDonChiTietId);
    }
}
