package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;
@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HoaDonChiTietId implements Serializable {

    @Column(name = "IdHoaDon")
    private UUID idHoaDon;

    @Column(name = "IdChiTietSP")
    private UUID IdChiTietSP;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HoaDonChiTietId that = (HoaDonChiTietId) o;
        return idHoaDon.equals(that.idHoaDon) && IdChiTietSP.equals(that.IdChiTietSP);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHoaDon, IdChiTietSP);
    }
}
