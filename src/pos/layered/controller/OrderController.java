/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered.controller;

import pos.layered.dto.OrderDto;
import pos.layered.service.custom.OrderService;
import pos.layered.service.ServiceFactory;

/**
 *
 * @author kavindu
 */
public class OrderController {
    
    OrderService orderService = (OrderService)ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceType.ORDER);

    public String placeOrder(OrderDto orderDto) throws Exception {
        return orderService.placeOrder(orderDto);    
    }
    
}
