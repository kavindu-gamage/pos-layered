/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered.service.custom.impl;

import pos.layered.dto.OrderDto;
import pos.layered.service.custom.OrderService;
import java.sql.Connection;
import pos.layered.dao.DaoFactory;
import pos.layered.dao.custom.ItemDao;
import pos.layered.dao.custom.OrderDao;
import pos.layered.dao.custom.OrderDetailDao;
import pos.layered.db.DbConnection;
import pos.layered.dto.OrderDetailDto;
import pos.layered.entity.ItemEntity;
import pos.layered.entity.OrderDetailEntity;
import pos.layered.entity.OrderEntity;

/**
 *
 * @author kavindu
 */
public class OrderServiceImpl implements OrderService {
    
    private OrderDao orderDao = (OrderDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.ORDER );
    private OrderDetailDao orderDetailDao = (OrderDetailDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.ORDER_DETAIL );
    private ItemDao itemDao = (ItemDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.ITEM);
    
    @Override
    public String placeOrder(OrderDto orderDto) throws Exception {
        Connection connection = DbConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        
        try {
            if(orderDao.add(new OrderEntity(orderDto.getId(), orderDto.getCustId(), orderDto.getOrderDate(), orderDto.getTotal()))){
                boolean isOrderDetailsSaved = true;
                for (OrderDetailDto detailDto : orderDto.getDetailDtos()) {
                    if(!(orderDetailDao.add(new OrderDetailEntity(-1, detailDto.getItemId(), orderDto.getId(), detailDto.getQty(), detailDto.getUnitPrice(), detailDto.getName())))){
                       isOrderDetailsSaved = false; 
                    }
                        
                }
                if(isOrderDetailsSaved){
                    boolean isItemUpdated = true;
                    
                    for (OrderDetailDto detailDto : orderDto.getDetailDtos()) {
                        ItemEntity entity = itemDao.get(detailDto.getItemId());
                        entity.setQuantityOnHand(entity.getQuantityOnHand()-detailDto.getQty());
                        if(!(itemDao.update(entity))){
                            isItemUpdated = false;
                        }
                    }
                    
                    if(isItemUpdated){
                        connection.commit();
                        return "Success";
                    }else{
                        connection.rollback();
                        return "Item Update Error";
                    }
                }else{
                    connection.rollback();
                    return "Order Details Save Error";
                }
            }else{
                connection.rollback();
                return "Order save Error";
            }
            
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true );
        }
    }
    //transactions handle at here
    
    
}
