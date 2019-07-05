package JavaDesignPatterns.Factory;

import java.io.Serializable;

public class Car implements Serializable {

    private String name;
    private int price;

    @Override
    public String toString()
    {
        return "Car [name=" + name + ", price=" + price + "]";
    }

    public Car(String name,int price)
    {
        this.name = name;
        this.price = price;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public int getPrice()
    {
        return price;
    }
    public void setPrice(int price)
    {
        this.price = price;
    }

}
