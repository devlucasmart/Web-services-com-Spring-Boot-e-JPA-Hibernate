package com.products.vendas.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.products.vendas.entities.enums.OrderStatus;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;
    @Autowired
    private Integer orderStatus;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Person client;
    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    public Order(OrderStatus orderStatus) {

        setOrderStatus(orderStatus);
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null) {
            this.orderStatus = orderStatus.getCode();
        }
    }

    public Double getTotal(){
        double sum = 0.0;
        for (OrderItem x: items) {
            sum += x.getSubTotal();
        }
        return sum;
    }
}