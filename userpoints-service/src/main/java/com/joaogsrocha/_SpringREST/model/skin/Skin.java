package com.joaogsrocha._SpringREST.model.skin;

import com.joaogsrocha._SpringREST.model.expansion.Expansion;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/*@Builder*/
@Entity
@Table(name ="skin", schema = "avarum_shop")
@Data
public class Skin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Long id;
    @ManyToOne
    @JoinColumn(name = "expansion_id", nullable = false)
    private Expansion expansion;
    @Column(name = "sku")
    private String sku;
/*    @Column(name= "text")
    @Type(type = "list-array")
    private List<String> text = new ArrayList<>();*/
    @Column(name = "stripeprice")
    private String stripePrice;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "rarity")
    private String rarity;
    @Column(name = "condition")
    private String condition;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "releasedate")
    private Date releaseDate;
    @Column(name = "image_url")
    private String imgUrl;
    @Column(name = "units_in_stock")
    private int unitsInStock;
    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;
    @Column(name = "last_updated")
    @UpdateTimestamp
    private Date lastUpdated;
}
