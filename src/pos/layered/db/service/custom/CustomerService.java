/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pos.layered.db.service.custom;

import java.util.List;
import pos.layered.db.service.SuperService;
import pos.layered.dto.CustomerDTO;

/**
 *
 * @author kavindu
 */
//blue print of CustomerService
public interface CustomerService extends SuperService {
    String addCustomer(CustomerDTO customerDTO) throws Exception;
    String updateCustomer(CustomerDTO customerDTO) throws Exception;
    String deleteCustomer(Integer id) throws Exception;
    CustomerDTO getCustomer(Integer id) throws Exception;
    List<CustomerDTO> getAllCustomers() throws Exception;
}
