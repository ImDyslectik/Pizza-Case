import java.util.LinkedList;

public class Toppings extends PizzaSet{
    String[] types = {"Kaas", "Mozzerela","Pepperoni","Tonijn","Ui","saus"};
    LinkedList<String> MyToppings = new LinkedList<>();
    public Toppings(){
    
    }
    public String[] getAlltypes(){
        return types;
    }
    public void setChoice(String Order){
        MyToppings.add(Order);
    }
    public LinkedList getChoice(){

        return MyToppings;
    } 
}
