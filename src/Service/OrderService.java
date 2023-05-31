package Service;

import DAO.OrderDAO;
import JavaBean.Order;

import java.util.List;

public class OrderService {
    private OrderDAO orderDAO = new OrderDAO();

    public Boolean add(Order order) {
        int row = orderDAO.update("INSERT INTO `order` (`orderNo`,`userId`,`name`,`price`,`num`,`sweet`,`temp`,`size`,`totalPrice`) VALUES(?,?,?,?,?,?,?,?,?)",order.getOrderNo(), order.getUserId(), order.getName(), order.getPrice(), order.getNum(), order.getSweet(), order.getTemp(), order.getSize(), order.getTotalPrice());

        return row > 0;

    }

    public Order getOrderById(int id) {
        Order order = orderDAO.queryRow("SELECT * FROM `order` WHERE `id`= ?", Order.class, id);

        return order;
    }

    public String getOrderListByUserId(int user_id) {
        List<Order> orders = orderDAO.queryMulti("SELECT * FROM `order` WHERE user_id = ?", Order.class, user_id);
        StringBuilder str = new StringBuilder("飲品名稱\t甜度\t冰量\t尺寸\t杯數\t單價\t總計\n");
        if (orders.size() == 0) {
            return "您還沒有訂購任何飲品";
        }

        for (Order order : orders) {
            str.append(order.getName() + "\t" + order.getSweet() + "\t" + order.getTemp() + "\t" + order.getSize() + "\t" + order.getNum()
                    + "\t" + order.getPrice() + "\t" + order.getTotalPrice() + "\n");
        }
        return str.toString();
    }

    public List<Order> selectAll(){

        List<Order> orders = orderDAO.queryMulti("SELECT * FROM `order`", Order.class);
        return orders;

    }

    public Boolean deleteById(int id){
        int row = orderDAO.update("DELETE FROM `order` WHERE `id` = ?", id);
        return row>0;
    }
}
