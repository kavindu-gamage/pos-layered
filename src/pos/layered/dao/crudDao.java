/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pos.layered.dao;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author kavindu
 */
//3rd
//T-object
//ID-Type of the primary key of that entity
//given as generic type
public interface crudDao<T, ID> extends SuperDao{
    
    boolean add(T t) throws SQLException, ClassNotFoundException;
    boolean update(T t) throws SQLException, ClassNotFoundException;
    boolean delete(ID id) throws SQLException, ClassNotFoundException;
    T get(ID id) throws SQLException, ClassNotFoundException;
    List<T> getAll() throws SQLException, ClassNotFoundException;
}
