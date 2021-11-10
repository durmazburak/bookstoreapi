package com.example.bookstoreapi.repository;

import com.example.bookstoreapi.model.entity.Order;
import com.example.bookstoreapi.model.entity.OrderDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@AutoConfigureMockMvc
@AutoConfigureDataMongo
@SpringBootTest
public class OrderRepositoryTest {
    @Autowired
    OrderRepository repository;

    @Test
    public void findAllBy() {
        List<Order> list = repository.findAllBy();
        List<OrderDetail> orderDetails = new ArrayList<>();

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setBookId(1);
        orderDetail.setCount(2);
        orderDetail.setPrice(5.12);

        Order order = new Order();
        order.setId(1);
        order.setCustomerId(1);
        order.setOrderDate(LocalDate.now());
        order.setOrderDetails(orderDetails);
        order.setTotalPrice(10.24);
        list.add(order);
        assertNotNull(repository.findAllBy());
    }

    @Test
    public void givenOrderByCustomerIdReturnValid(){
        List<Order> orderList = repository.findOrderByCustomerId(1);
        assertThat(orderList.get(0).getCustomerId()).isEqualTo(1);
    }
}
