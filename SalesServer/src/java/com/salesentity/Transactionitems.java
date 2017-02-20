/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salesentity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author katie
 */
@Entity
@Table(name = "TRANSACTIONITEMS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transactionitems.findAll", query = "SELECT t FROM Transactionitems t")
    , @NamedQuery(name = "Transactionitems.findByTransactionId", query = "SELECT t FROM Transactionitems t WHERE t.transactionitemsPK.transactionId = :transactionId")
    , @NamedQuery(name = "Transactionitems.findByUpc", query = "SELECT t FROM Transactionitems t WHERE t.transactionitemsPK.upc = :upc")
    , @NamedQuery(name = "Transactionitems.findByQuantity", query = "SELECT t FROM Transactionitems t WHERE t.quantity = :quantity")})
public class Transactionitems implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TransactionitemsPK transactionitemsPK;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @JoinColumn(name = "UPC", referencedColumnName = "UPC", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Products products;
    @JoinColumn(name = "TRANSACTION_ID", referencedColumnName = "TRANSACTION_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Transactions transactions;

    public Transactionitems() {
    }

    public Transactionitems(TransactionitemsPK transactionitemsPK) {
        this.transactionitemsPK = transactionitemsPK;
    }

    public Transactionitems(int transactionId, int upc) {
        this.transactionitemsPK = new TransactionitemsPK(transactionId, upc);
    }

    public TransactionitemsPK getTransactionitemsPK() {
        return transactionitemsPK;
    }

    public void setTransactionitemsPK(TransactionitemsPK transactionitemsPK) {
        this.transactionitemsPK = transactionitemsPK;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public Transactions getTransactions() {
        return transactions;
    }

    public void setTransactions(Transactions transactions) {
        this.transactions = transactions;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionitemsPK != null ? transactionitemsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transactionitems)) {
            return false;
        }
        Transactionitems other = (Transactionitems) object;
        if ((this.transactionitemsPK == null && other.transactionitemsPK != null) || (this.transactionitemsPK != null && !this.transactionitemsPK.equals(other.transactionitemsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.salesentity.Transactionitems[ transactionitemsPK=" + transactionitemsPK + " ]";
    }
    
}
