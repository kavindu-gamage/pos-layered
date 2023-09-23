/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered.service;

import pos.layered.service.custom.impl.CustomerServiceImpl;
import pos.layered.service.custom.impl.ItemServiceImpl;

/**
 *
 * @author kavindu
 */
//Make this class as singleton class-to make sure Only one object runs 
public class ServiceFactory {
    //first step private static instance
    private static ServiceFactory serviceFactory;

    //second step private constructor
    private ServiceFactory() {
    }
    
    //third step- static method for access
    public static ServiceFactory getServiceFactory(){
        if(serviceFactory==null){
            serviceFactory = new ServiceFactory();
        }
        return serviceFactory;
    }
    ///End of sigleton class////
    
    //factory design pattern
    //return similar type objects
    //this use to keep multiple subclasses of superclass
    public SuperService getService(ServiceType type){
        switch (type) {
            case CUSTOMER:
                return new CustomerServiceImpl();
            case ITEM:
                return new ItemServiceImpl();
            default:
                return null;
        }
    }
    
    public enum ServiceType{
        CUSTOMER, ITEM
    }
    
}
