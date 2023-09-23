/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered.dao.custom.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pos.layered.dao.CrudUtil;
import pos.layered.dao.custom.ItemDao;
import pos.layered.entity.ItemEntity;

/**
 *
 * @author kavindu
 */
public class ItemDaoImpl implements ItemDao {

    @Override
    public boolean add(ItemEntity t) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("INSERT INTO Item VALUES(?,?,?,?) ", t.getId(), t.getName(),t.getQuantityOnHand(),t.getUnitPrice());
    }

    @Override
    public boolean update(ItemEntity t) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("UPDATE Item SET id=?, name=?,quantityOnHand=?,unitPrice=? WHERE id=? ",t.getId(),t.getName(),t.getQuantityOnHand(),t.getUnitPrice(), t.getId());  
    }

    @Override
    public boolean delete(Integer id) throws SQLException, ClassNotFoundException {
         return CrudUtil.executeUpdate("DELETE FROM Item WHERE id = ? ", id);    }

    @Override
    public ItemEntity get(Integer id) throws SQLException, ClassNotFoundException {
         ResultSet resultSet = CrudUtil.executeQuery("SELECT *FROM Item WHERE id =?", id);   
         
         while(resultSet.next()){
            return new ItemEntity(
                 resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("quantityOnHand"),
                    resultSet.getDouble("unitPrice") 
            );
        }
        return null;
    
    }

    @Override
    public List<ItemEntity> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT *FROM Item"); 
        List<ItemEntity> itemEntitys = new ArrayList<>();
        
        while(resultSet.next()){
            ItemEntity itemEntity = new ItemEntity(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("quantityOnHand"),
                    resultSet.getDouble("unitPrice"));
            itemEntitys.add(itemEntity);
        }
        return itemEntitys;
    }
    
}
