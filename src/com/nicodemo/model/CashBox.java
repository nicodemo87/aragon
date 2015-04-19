/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nicodemo.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Nico
 */
@Entity
@Table
public class CashBox {

    @Id
    @GeneratedValue
    @Column
    private int id;
    @Column
    private float startAmount;
    @Column
    private float endAmount;
    @Column
    private Date startTime;
    @Column
    private Date endTime;
    @ManyToOne
    private User user;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Sale> sales;

    public CashBox(){
        startTime = new Date();
        sales = new HashSet<>();
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the startAmount
     */
    public float getStartAmount() {
        return startAmount;
    }

    /**
     * @param startAmount the startAmount to set
     */
    public void setStartAmount(float startAmount) {
        this.startAmount = startAmount;
    }

    /**
     * @return the endAmount
     */
    public float getEndAmount() {
        return endAmount;
    }

    /**
     * @param endAmount the endAmount to set
     */
    public void setEndAmount(float endAmount) {
        this.endAmount = endAmount;
    }

    /**
     * @return the startTime
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the endTime
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * @param endTime the endTime to set
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    public void addSale(Sale sale) {
        this.sales.add(sale);
    }

    /**
     * @return the sales
     */
    public Set<Sale> getSales() {
        return sales;
    }

    /**
     * @param sales the sales to set
     */
    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }

    public double total() {        
        return sales.stream()
                .mapToDouble(s -> s.total())
                .sum();
    }
}
