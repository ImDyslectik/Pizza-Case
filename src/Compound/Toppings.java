package Compound;

import java.util.LinkedList;
import java.util.Scanner;

public class Toppings extends PizzaSet {
    String[] types = { "Kaas", "Mozzerela", "Pepperoni", "Tonijn", "Ui", "Tomaten saus", "Pepers", "Ham", "Kip" };
    LinkedList<String> MyToppings = new LinkedList<>();

    public Toppings() {

    }

    public String[] getAlltypes() {
        return types;
    }

    public void setChoice(String Order) {
        MyToppings.add(Order);
    }

    public LinkedList getChoice() {

        return MyToppings;
    }

    public void accept(Visitor visitor) {
        visitor.visitTopping(this);
    }

}
