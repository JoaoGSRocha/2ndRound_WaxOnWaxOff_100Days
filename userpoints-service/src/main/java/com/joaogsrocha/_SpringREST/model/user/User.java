package com.joaogsrocha._SpringREST.model.user;

import com.joaogsrocha._SpringREST.model.voucheruser.VoucherUser;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="user", schema = "avarum_core")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "screenname")
    private String screenName;
    @Column(name = "discordid")
    private String discordID;
    @Column(name = "gender")
    private byte gender;
    @Column(name = "pw")
    private String pw;
    @Column(name = "email")
    private String email;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private VoucherUser voucherUser;
}
