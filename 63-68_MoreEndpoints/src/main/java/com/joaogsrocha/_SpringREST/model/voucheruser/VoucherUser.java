package com.joaogsrocha._SpringREST.model.voucheruser;

import com.joaogsrocha._SpringREST.model.user.User;
import com.joaogsrocha._SpringREST.model.voucher.Voucher;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="voucheruser", schema = "avarum_core")
@Getter
@Setter
public class VoucherUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @OneToOne
    @JoinColumn(name = "userid", nullable = false)
    private User user;
    @OneToOne
    @JoinColumn(name = "voucherid", nullable = false)
    private Voucher voucher;

}
