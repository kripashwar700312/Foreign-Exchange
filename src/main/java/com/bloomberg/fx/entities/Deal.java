package com.bloomberg.fx.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "deal")
public class Deal implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "deal_id", nullable = false, unique = true)
    private String dealId;

    @Column(name = "from_currency_iso_code", nullable = false)
    private String fromCurrencyISOCode;

    @Column(name = "to_currency_iso_code", nullable = false)
    private String toCurrencyISOCode;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "order_date", nullable = false)
    private Date orderDate;

    @Column(name = "amount", nullable = false)
    private Double amount;
}
