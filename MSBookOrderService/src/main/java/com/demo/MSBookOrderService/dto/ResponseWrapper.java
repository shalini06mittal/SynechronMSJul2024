package com.demo.MSBookOrderService.dto;

import com.demo.MSBookOrderService.model.BookOrder;

import java.util.List;

public class ResponseWrapper {

    private List<BookOrder> orders;
    String isMember;
    private List<String> titles;

    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    public List<BookOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<BookOrder> orders) {
        this.orders = orders;
    }

    public String getIsMember() {
        return isMember;
    }

    public void setIsMember(String isMember) {
        this.isMember = isMember;
    }
}
