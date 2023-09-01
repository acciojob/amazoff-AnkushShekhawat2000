package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {


    @Autowired
    OrderRepository orderRepository;

    public void addPartner(String partnerId) {

        orderRepository.addPartner(partnerId);


    }

    public void addOrder(Order order) {
        orderRepository.addOrder(order);
    }

    public void addOrderPartnerPair(String orderId, String partnerId) {
        orderRepository.addOrderPartnerPair(orderId,partnerId);
    }

    public Order getOrderById(String orderId) {


        Order order = orderRepository.getOrderById(orderId);
        return order;
    }

    public DeliveryPartner getPartnerById(String partnerId) {
        DeliveryPartner deliveryPartner = orderRepository.getPartnerById(partnerId);
        return deliveryPartner;
    }

    public List<String> getOrdersByPartnerId(String partnerId) {
        List<String> partner = orderRepository.getOrdersByPartnerId(partnerId);
        return partner;
    }

    public List<String> getAllOrders() {
        List<String> order = orderRepository.getAllOrders();
        return order;
    }

    public Integer getCountOfUnassignedOrders() {
      Integer count = orderRepository.getCountOfUnassignedOrders();
    return count;
    }

    public int getOrdersLeftAfterGivenTimeByPartnerId(String time, String partnerId) {
      String timeInArray[] = time.split(":");

      int newTime = Integer.parseInt(timeInArray[0])*60 + Integer.parseInt(timeInArray[1]);

     return orderRepository.getOrdersLeftAfterGivenTimeByPartnerId(newTime,partnerId);
    }

    public String getLastDeliveryTimePartnerId(String partnerId) {
        int time = orderRepository.getLastDeliveryTimePartnerId(partnerId);
        String HH = String.valueOf(time/60);
        String MM = String.valueOf(time%0);

        if(HH.length() < 2)
        {
            HH = '0' + HH;
        }
        if(MM.length() < 2)
        {
            MM = '0' + MM;
        }

        return HH+":"+MM;

    }

    public Integer getOrderCountByPartnerId(String partnerId) {
        int orderCount = orderRepository.getOrderCountByPartnerId(partnerId);
        return orderCount;
    }

    public void deleteOrderById(String orderId) {
        orderRepository.deleteOrderById(orderId);
    }

    public void deletePartnerById(String partnerId) {
        orderRepository.deletePartnerById(partnerId);
    }
}
