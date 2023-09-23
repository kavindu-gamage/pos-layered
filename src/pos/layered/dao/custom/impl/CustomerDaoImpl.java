/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered.dao.custom.impl;

import java.sql.SQLException;
import java.util.List;
import pos.layered.dao.CrudUtil;
import pos.layered.dao.custom.CustomerDao;
import pos.layered.entity.CustomerEntity;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author kavindu
 */
public class CustomerDaoImpl implements CustomerDao {

    @Override
    public boolean add(CustomerEntity t) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("INSERT INTO Customer VALUES(?,?,?,?,?) ", t.getId(), t.getName(), t.getAddress(),t.getEmail(),t.getPostalCode());
    }

    @Override
    public boolean update(CustomerEntity t) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("UPDATE Customer SET id=?, name=?, address=?, email=?, postalCode=? WHERE id=?", t.getId(), t.getName(), t.getAddress(),t.getEmail(),t.getPostalCode(),t.getId());
    }

    @Override
    public boolean delete(Integer id) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("DELETE FROM Customer WHERE id = ? ", id);
    }

    @Override
    public CustomerEntity get(Integer id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT *FROM Customer WHERE id =?", id);
        while (resultSet.next()) {
            return new CustomerEntity(
                    resultSet.getInt("id"), 
                    resultSet.getString("name"), 
                    resultSet.getString("email"), 
                    resultSet.getString("address"), 
                    resultSet.getString("postalCode"));
         }
         return null;
    }

    @Override
    public List<CustomerEntity> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT *FROM Customer");
        
         List<CustomerEntity> customerEntitys = new ArrayList<>();
        while (resultSet.next()) {
            CustomerEntity customerEntity = new CustomerEntity(
                    resultSet.getInt("id"), 
                    resultSet.getString("name"), 
                    resultSet.getString("email"), 
                    resultSet.getString("address"), 
                    resultSet.getString("postalCode"));
            customerEntitys.add(customerEntity );
        }
        
        return customerEntitys; 
    }
    
}
