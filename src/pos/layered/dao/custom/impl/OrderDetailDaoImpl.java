/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered.dao.custom.impl;

import java.sql.SQLException;
import java.util.List;
import pos.layered.dao.CrudUtil;
import pos.layered.dao.crudDao;
import pos.layered.dao.custom.OrderDetailDao;
import pos.layered.entity.OrderDetailEntity;

/**
 *
 * @author kavindu
 */
public class OrderDetailDaoImpl implements OrderDetailDao {

    @Override
    public boolean add(OrderDetailEntity t) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("INSERT INTO orderDetail (order_id, item_id, unitprice, qty, subTotal) VALUES (?,?,?,?,?)", t.getOrderId(),t.getItemId(),t.getUnitPrice(),t.getQty(),t.getQty()*t.getUnitPrice() );
    }

    @Override
    public boolean update(OrderDetailEntity t) throws SQLException, ClassNotFoundException {
        return false;    
    }

    @Override
    public boolean delete(Integer id) throws SQLException, ClassNotFoundException {
        return false;    }

    @Override
    public OrderDetailEntity get(Integer id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<OrderDetailEntity> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
    
}
