package entity;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MauSac")
public class MauSac implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private UUID id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    public MauSac(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    @Column(name = "trangThai")
    private Integer trangThai;

    @OneToMany(mappedBy = "mauSac")
    private List<CTSanPham> listCTSanPham;
}
