import java.util.LinkedList;

public class Pizza extends PizzaSet {
    String[] types = {"Margherita", "Pepperoni","Hawaii","Tonno"};
    LinkedList<String> Mypizza = new LinkedList<>();
    public Pizza(){
    
    }
    public String[] getAlltypes(){
        return types;
    }
    public void setChoice(String Order){
        Mypizza.add(Order) ;
    }
    public LinkedList getChoice(){

        return Mypizza;
    } 
}
