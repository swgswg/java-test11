package Goods;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定义一个商品类（id, 名称，分类，售价，创建时间），重写toString，可以输出json形式的商品信息，同时实现
 *  Comparable接口，能在TreeSet中按创建时间倒序排列。
 */
public class Goods implements Comparable<Goods>{
    private int id;
    private String name;
    private int category;
    private int price;
    private String createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String  getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", price=" + price +
                ", createTime=" + createTime +
                '}';
    }

    /**
     * 时间倒序排列
     * @param goods
     * @return
     */
    @Override
    public int compareTo(Goods goods) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date start = format.parse(this.createTime);
            Date end = format.parse(goods.createTime);
            return end.compareTo(start);
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
