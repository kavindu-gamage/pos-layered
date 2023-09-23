/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered.controller;

import java.util.List;
import pos.layered.db.service.ServiceFactory;
import pos.layered.db.service.custom.CustomerService;
import pos.layered.dto.CustomerDTO;

/**
 *
 * @author kavindu
 */
public class CustomerController {
    
    //add subtype object to super type reference- dynamic method dispatch
    //disable dependency between controller layer from other layers
    CustomerService customerService = (CustomerService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceType.CUSTOMER);
    //at here we can directly use customerservice impl class. But here we get it through the customerService interface because
    // if we want change the impl package it can easily change when changing the package name at Service factory
    // this helps to the maintenance part of the code
    
    
    public String addCustomer(CustomerDTO customerDTO) throws Exception{
        
        return customerService.addCustomer(customerDTO);
    }
    public String updateCustomer(CustomerDTO customerDTO) throws Exception{
        return customerService.updateCustomer(customerDTO);
    }
    public String deleteCustomer(Integer id) throws Exception{
        return customerService.deleteCustomer(id);
    }
    
    public CustomerDTO getCustomer(Integer id) throws Exception{
        return customerService.getCustomer(id);
    }
     public List<CustomerDTO> getAllCustomer() throws Exception{
        return customerService.getAllCustomers();
    }
}
