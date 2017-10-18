package com.crazyvaperV2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "eliquids")
public class ELiquid extends Product {

    @Column(name = "nicotine_strength")
    private String nicotineStrength;

    public String getNicotineStrength() {
        return nicotineStrength;
    }

    public void setNicotineStrength(String nicotineStrength) {
        this.nicotineStrength = nicotineStrength;
    }
}
