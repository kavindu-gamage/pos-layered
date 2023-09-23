/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered.dao;

import pos.layered.dao.custom.impl.CustomerDaoImpl;
import pos.layered.dao.custom.impl.ItemDaoImpl;
import pos.layered.dao.custom.impl.OrderDaoImpl;
import pos.layered.dao.custom.impl.OrderDetailDaoImpl;

/**
 *
 * @author kavindu
 */
//2nd
public class DaoFactory {
    //make this class as Singleton class
    
    private static DaoFactory daoFactory;

    private DaoFactory() {
    }
    
    public static DaoFactory getDaoFactory(){
        if(daoFactory == null){
            daoFactory = new DaoFactory();
        }
        return daoFactory;
    }
    
    public SuperDao getDao(DaoTypes types){
        switch (types) {
            case CUSTOMER:
                return new CustomerDaoImpl();
            case ITEM:
                return new ItemDaoImpl();
            case ORDER:
                return new OrderDaoImpl();
            case ORDER_DETAIL:
                return new OrderDetailDaoImpl();
            default:
                return null;
        }
    }
    
    public enum DaoTypes{
        CUSTOMER, ITEM, ORDER, ORDER_DETAIL
    }
    
}
