package com.products.vendas.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.products.vendas.entities.pk.OrderItemPK;
import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();
    private Integer quantity;
    private Double price;

    public OrderItem(Order order, Product product, Integer quantity, Double price){
        super();
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }
    @JsonIgnore
    public Order getOrder(){

        return id.getOrder();
    }
    public void setOrder(Order order){

        id.setOrder(order);
    }
    public Product getProduct(){

        return id.getProduct();
    }
    public void setProduct(Product product){

        id.setProduct(product);
    }

    public Double getSubTotal(){
        return price * quantity;
    }
}
