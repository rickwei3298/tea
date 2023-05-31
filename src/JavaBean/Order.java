package JavaBean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Order {
    Integer id;
    Long orderNo;
    Integer userId;
    String name;
    Integer price;
    Integer num;
    Integer points;
    String sweet;
    String temp;
    String size;
    Integer totalPrice;
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    Date created_time;

    public Order() {
    }

    public Order(Integer id, Long orderNo, Integer userId, String name, Integer price, Integer num, Integer points, String sweet, String temp, String size, Integer totalPrice, Date created_time) {
        this.id = id;
        this.orderNo = orderNo;
        this.userId = userId;
        this.name = name;
        this.price = price;
        this.num = num;
        this.points = points;
        this.sweet = sweet;
        this.temp = temp;
        this.size = size;
        this.totalPrice = totalPrice;
        this.created_time = created_time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getSweet() {
        return sweet;
    }

    public void setSweet(String sweet) {
        this.sweet = sweet;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Date created_time) {
        this.created_time = created_time;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNo=" + orderNo +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", points=" + points +
                ", sweet='" + sweet + '\'' +
                ", temp='" + temp + '\'' +
                ", size='" + size + '\'' +
                ", totalPrice=" + totalPrice +
                ", created_time=" + created_time +
                '}';
    }
}
