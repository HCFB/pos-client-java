package ru.homecredit.model.CashOnDelivery;

import lombok.Data;
import ru.homecredit.web.model.CashOnDelivery.enums.CurrencyEnum;
import ru.homecredit.web.model.CashOnDelivery.enums.OfferStatus;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by RRybasov on 17.11.16.
 */
@Data
@Entity
@Table(name = "cod_offers")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cod_offer_id_seq")
    @SequenceGenerator(name = "cod_offer_id_seq", sequenceName = "cod_offer_id_seq", allocationSize = 1)
    private long id;
    @OneToOne(orphanRemoval = true, fetch = FetchType.LAZY ,cascade = {CascadeType.ALL})
    @JoinColumn(referencedColumnName = "id", name = "id")
    private CodDeliveryAddress codDeliveryAddress;
    @OneToMany(orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id", name = "offer_id")
    private List<CartItem> cartItems;
    @OneToOne(orphanRemoval = true, fetch = FetchType.LAZY , cascade = {CascadeType.ALL})
    @JoinColumn(referencedColumnName = "id", name = "id")
    private UserInfo userInfo;
    private Date createDate;
    private String remoteId;
    private Date validTo;
    @Enumerated
    private OfferStatus status;
    private BigDecimal servicePrice;
    private BigDecimal goodsPrice;
    private BigDecimal totalPrice;
    @Enumerated
    private CurrencyEnum currency;
}
