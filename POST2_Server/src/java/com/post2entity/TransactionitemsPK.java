/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post2entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author katie
 */
@Embeddable
public class TransactionitemsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "TRANSACTION_ID")
    private int transactionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UPC")
    private int upc;

    public TransactionitemsPK() {
    }

    public TransactionitemsPK(int transactionId, int upc) {
        this.transactionId = transactionId;
        this.upc = upc;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getUpc() {
        return upc;
    }

    public void setUpc(int upc) {
        this.upc = upc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) transactionId;
        hash += (int) upc;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransactionitemsPK)) {
            return false;
        }
        TransactionitemsPK other = (TransactionitemsPK) object;
        if (this.transactionId != other.transactionId) {
            return false;
        }
        if (this.upc != other.upc) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.post2entity.TransactionitemsPK[ transactionId=" + transactionId + ", upc=" + upc + " ]";
    }
    
}
