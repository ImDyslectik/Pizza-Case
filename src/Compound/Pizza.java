package Compound;

import java.util.LinkedList;
import java.util.Scanner;

public class Pizza extends PizzaSet {
    String[] types = { "Margherita", "Pepperoni", "Hawaii", "Tonno", "Hot and spicy", "Ham", "Cappres", "BBQ chicken",
            "Veggie", "Deeg" };
    LinkedList<String> Mypizza = new LinkedList<>();

    public Pizza() {
    }

    public String[] getAlltypes() {
        return types;
    }

    public void setChoice(String Order) {
        Mypizza.add(Order);
    }

    public LinkedList getChoice() {
        return Mypizza;
    }

    public void accept(Visitor visitor) {
        visitor.visitPizza(this);
    }
}
