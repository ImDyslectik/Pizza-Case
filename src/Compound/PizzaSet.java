package Compound;

import java.util.LinkedList;

public class PizzaSet {
    String[] error = { "wrong class" };
    LinkedList<String> error2 = new LinkedList<>();

    public String[] getAlltypes() {
        return error;
    }

    public void setChoice(String Order) {

    }

    public LinkedList getChoice() {
        return error2;
    }

    public void accept(Visitor visitor) {

    }
}
