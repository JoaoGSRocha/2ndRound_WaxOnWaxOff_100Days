package com.joaogsrocha._SpringREST.model.voucher;

import com.joaogsrocha._SpringREST.model.vouchermotive.VoucherMotive;
import com.joaogsrocha._SpringREST.model.voucheruser.VoucherUser;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="voucher", schema = "avarum_core")
@Getter
@Setter
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "voucher")
    private VoucherUser voucherUser;
    @OneToOne
    @JoinColumn(name = "vouchermotiveid", nullable = false)
    private VoucherMotive voucherMotive;
}
