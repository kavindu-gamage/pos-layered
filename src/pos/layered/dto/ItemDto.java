/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered.dto;

/**
 *
 * @author kavindu
 */
public class ItemDto {
    private int id;
    private String name;
    private int quantityOnHand;
    private double unitPrice;

    public ItemDto() {
    }

    public ItemDto(int id, String name, int quantityOnHand, double unitPrice) {
        this.id = id;
        this.name = name;
        this.quantityOnHand = quantityOnHand;
        this.unitPrice = unitPrice;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the quantityOnHand
     */
    public int getQuantityOnHand() {
        return quantityOnHand;
    }

    /**
     * @param quantityOnHand the quantityOnHand to set
     */
    public void setQuantityOnHand(int quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }

    /**
     * @return the unitPrice
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "ItemDto{" + "id=" + id + ", name=" + name + ", quantityOnHand=" + quantityOnHand + ", unitPrice=" + unitPrice + '}';
    }
    
    
}
