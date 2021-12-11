package com.joaogsrocha._SpringREST.model.vouchermotive;

import com.joaogsrocha._SpringREST.model.voucher.Voucher;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Table(name="vouchermotive", schema = "avarum_core")
@Getter
@Setter
public class VoucherMotive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "motive")
    private String motive;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "voucherMotive")
    private Voucher voucher;
}
