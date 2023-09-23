/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered.entity;

import java.util.Date;

/**
 *
 * @author kavindu
 */
//Entity is exactly table representation
public class OrderEntity {
    private int id;
    private int custId;
    private Date orderDate;
    private double total;

    public OrderEntity() {
    }

    public OrderEntity(int id, int custId, Date orderDate, double total) {
        this.id = id;
        this.custId = custId;
        this.orderDate = orderDate;
        this.total = total;
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
     * @return the custId
     */
    public int getCustId() {
        return custId;
    }

    /**
     * @param custId the custId to set
     */
    public void setCustId(int custId) {
        this.custId = custId;
    }

    /**
     * @return the orderDate
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * @param orderDate the orderDate to set
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "OrderEntity{" + "id=" + id + ", custId=" + custId + ", orderDate=" + orderDate + ", total=" + total + '}';
    }
    
    
}
