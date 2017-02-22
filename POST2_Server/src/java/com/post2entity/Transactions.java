/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post2entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author katie
 */
@Entity
@Table(name = "TRANSACTIONS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transactions.findAll", query = "SELECT t FROM Transactions t")
    , @NamedQuery(name = "Transactions.findByTransactionId", query = "SELECT t FROM Transactions t WHERE t.transactionId = :transactionId")
    , @NamedQuery(name = "Transactions.findByDatetime", query = "SELECT t FROM Transactions t WHERE t.datetime = :datetime")
    , @NamedQuery(name = "Transactions.findByCustomerName", query = "SELECT t FROM Transactions t WHERE t.customerName = :customerName")
    , @NamedQuery(name = "Transactions.findByPaymentType", query = "SELECT t FROM Transactions t WHERE t.paymentType = :paymentType")
    , @NamedQuery(name = "Transactions.findByTotal", query = "SELECT t FROM Transactions t WHERE t.total = :total")})
public class Transactions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRANSACTION_ID")
    private Integer transactionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DATETIME")
    private String datetime;
    @Size(max = 50)
    @Column(name = "CUSTOMER_NAME")
    private String customerName;
    @Size(max = 5)
    @Column(name = "PAYMENT_TYPE")
    private String paymentType;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TOTAL")
    private BigDecimal total;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transactions")
    private Collection<Transactionitems> transactionitemsCollection;

    public Transactions() {
    }

    public Transactions(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Transactions(Integer transactionId, String datetime) {
        this.transactionId = transactionId;
        this.datetime = datetime;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @XmlTransient
    public Collection<Transactionitems> getTransactionitemsCollection() {
        return transactionitemsCollection;
    }

    public void setTransactionitemsCollection(Collection<Transactionitems> transactionitemsCollection) {
        this.transactionitemsCollection = transactionitemsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionId != null ? transactionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transactions)) {
            return false;
        }
        Transactions other = (Transactions) object;
        if ((this.transactionId == null && other.transactionId != null) || (this.transactionId != null && !this.transactionId.equals(other.transactionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.post2entity.Transactions[ transactionId=" + transactionId + " ]";
    }
    
}
