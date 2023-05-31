package JavaBean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Product {
    Integer id;
    String name;
    String img;
    String information;
    Integer price;
    Integer point;
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    Date created_time;

    public Product() {
    }

    public Product(Integer id, String name, String img, String information, Integer price, Integer point, Date created_time) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.information = information;
        this.price = price;
        this.point = point;
        this.created_time = created_time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Date getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Date created_time) {
        this.created_time = created_time;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", information='" + information + '\'' +
                ", price=" + price +
                ", point=" + point +
                ", created_time=" + created_time +
                '}';
    }
}
