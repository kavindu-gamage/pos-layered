/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered.service.custom.impl;

import java.util.ArrayList;
import java.util.List;
import pos.layered.dao.DaoFactory;
import pos.layered.dao.custom.CustomerDao;
import pos.layered.dao.custom.ItemDao;
import pos.layered.dto.CustomerDto;
import pos.layered.dto.ItemDto;
import pos.layered.entity.CustomerEntity;
import pos.layered.entity.ItemEntity;
import pos.layered.service.custom.ItemService;

/**
 *
 * @author kavindu
 */
public class ItemServiceImpl implements ItemService {
    
    ItemDao itemDao = (ItemDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.ITEM);


    
    @Override
    public String addItem(ItemDto itemDto) throws Exception {
        if(itemDao.add(new ItemEntity(itemDto.getId(), itemDto.getName(), itemDto.getQuantityOnHand(), itemDto.getUnitPrice()))) {
            return "Successfully added";
        }
        else{
            return "Fail";
        }
        
    }

    @Override
    public String updateItem(ItemDto itemDto) throws Exception {
        if(itemDao.update(new ItemEntity(itemDto.getId(), itemDto.getName(), itemDto.getQuantityOnHand(), itemDto.getUnitPrice()))) {
            return "Successfully updated";
        }
        else{
            return "Fail";
        }    
    }

    @Override
    public String deleteItem(Integer id) throws Exception {
        if(itemDao.delete(id)){
            return "Successfully deleted";
        }
        else{
            return "Fail";
        }    }

    @Override
    public ItemDto getItem(Integer id) throws Exception {
        ItemEntity itemEntity = itemDao.get(id);    
        return new ItemDto(itemEntity.getId(), itemEntity.getName(), itemEntity.getQuantityOnHand(), itemEntity.getUnitPrice());
    }

    @Override
    public List<ItemDto> getAllItems() throws Exception {
        List<ItemDto> dtos = new ArrayList<>();
        List<ItemEntity> ItemEntitys = itemDao.getAll(); 
        for (ItemEntity itemEntity : ItemEntitys) {
            dtos.add(new ItemDto(itemEntity.getId(), itemEntity.getName(), itemEntity.getQuantityOnHand(), itemEntity.getUnitPrice()));
        }
        
        return dtos;
    
    }
    
}
