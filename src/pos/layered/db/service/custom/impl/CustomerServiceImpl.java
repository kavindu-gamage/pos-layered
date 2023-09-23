/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered.db.service.custom.impl;

import java.util.ArrayList;
import java.util.List;
import pos.layered.dao.DaoFactory;
import pos.layered.dao.custom.CustomerDao;
import pos.layered.db.service.custom.CustomerService;
import pos.layered.dto.CustomerDTO;
import pos.layered.entity.CustomerEntity;

/**
 *
 * @author kavindu
 */
public class CustomerServiceImpl implements CustomerService {
    
    //here use low coupling-modules are independent and changes in one module have little impact on other modules
    //low coupling high cohesion
    //high cohesion-keep related classes in same package or nearly
    CustomerDao customerDao = (CustomerDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.CUSTOMER);

    @Override
    public String addCustomer(CustomerDTO customerDTO) throws Exception {
        if(customerDao.add(new CustomerEntity(customerDTO.getId(), customerDTO.getName(),customerDTO.getEmail(), customerDTO.getAddress(), customerDTO.getPostalCode()))){
            return "Successfully add";
        }
        else{
            return "Fail";
        }
    }

    @Override
    public String updateCustomer(CustomerDTO customerDTO) throws Exception {
        if(customerDao.update(new CustomerEntity(customerDTO.getId(), customerDTO.getName(),customerDTO.getEmail(), customerDTO.getAddress(), customerDTO.getPostalCode()))){
            return "Successfully add";
        }
        else{
            return "Fail";
        }
    }

    @Override
    public String deleteCustomer(Integer id) throws Exception {
        if(customerDao.delete(id)){
            return "Successfully deleted";
        }
        else{
            return "Fail";
        }
    }

    @Override
    public CustomerDTO getCustomer(Integer id) throws Exception {
       CustomerEntity customerEntity = customerDao.get(id);
       return new CustomerDTO(customerEntity.getId(), customerEntity.getName(), customerEntity.getEmail(), customerEntity.getAddress(), customerEntity.getPostalCode());
        
    }

    @Override
    public List<CustomerDTO> getAllCustomers() throws Exception {
        List<CustomerDTO> dtos = new ArrayList<>();
        List<CustomerEntity> customerEntitys = customerDao.getAll();
        for (CustomerEntity customerEntity : customerEntitys) {
            dtos.add(new CustomerDTO(customerEntity.getId(), customerEntity.getName(), customerEntity.getEmail(), customerEntity.getAddress(), customerEntity.getPostalCode()));
        }
        
        return dtos;

    }


}
