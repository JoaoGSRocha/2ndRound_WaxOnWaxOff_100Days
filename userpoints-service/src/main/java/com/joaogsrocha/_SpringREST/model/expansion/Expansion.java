package com.joaogsrocha._SpringREST.model.expansion;

import com.joaogsrocha._SpringREST.model.skin.Skin;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="expansion", schema = "avarum_shop")
@Getter
@Setter
public class Expansion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "expansioncode")
    private String expansionCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "expansion")
    private Set<Skin> skins;
}
