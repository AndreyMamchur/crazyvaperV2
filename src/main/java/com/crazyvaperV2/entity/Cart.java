package com.crazyvaperV2.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id", nullable = false)
    private long id;

    @OneToOne(cascade=CascadeType.ALL, mappedBy="cart", targetEntity = Payment.class)
    private Payment payment;

    @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER, targetEntity = Product.class)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private List<Product> productsList = new ArrayList<>();

    private double total;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Cart() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public List<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Product> productsList) {
        this.productsList = productsList;
    }
}
