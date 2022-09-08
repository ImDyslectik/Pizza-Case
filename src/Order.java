import java.util.ArrayList;

public class Order {
    private String name;
    private int pizzaNum;

    ArrayList<Ingredients> orderlist = new ArrayList<>();

    // makes an order with just name pizza amount and date for debug reasons

    public Order(String name, int pizzaNum) {
        this.name = name;
        this.pizzaNum = pizzaNum;
    }

    // we will need to convert it to a string so we can add it to our arraylist
    // (or whatever kind of list we end up using)
    @Override
    public String toString() {
        return name + pizzaNum;
    }
}
