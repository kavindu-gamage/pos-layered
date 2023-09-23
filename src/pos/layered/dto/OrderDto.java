/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered.dto;

import java.util.Date;
import java.util.List;

/**
 *
 * @author kavindu
 */
public class OrderDto {
    private int id;
    private int custId;
    private Date orderDate;
    private double total;
    
    private List<OrderDetailDto> detailDtos;

    public OrderDto() {
    }

    public OrderDto(int id, int custId, Date orderDate, double total, List<OrderDetailDto> detailDtos) {
        this.id = id;
        this.custId = custId;
        this.orderDate = orderDate;
        this.total = total;
        this.detailDtos = detailDtos;
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

    /**
     * @return the detailDtos
     */
    public List<OrderDetailDto> getDetailDtos() {
        return detailDtos;
    }

    /**
     * @param detailDtos the detailDtos to set
     */
    public void setDetailDtos(List<OrderDetailDto> detailDtos) {
        this.detailDtos = detailDtos;
    }

    @Override
    public String toString() {
        return "orderDto{" + "id=" + id + ", custId=" + custId + ", orderDate=" + orderDate + ", total=" + total + ", detailDtos=" + detailDtos + '}';
    }
    
    
}
