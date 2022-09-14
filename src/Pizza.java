import java.util.LinkedList;
import java.util.Scanner;
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

    public void ordering(){
        String[] Pizzalist = this.getAlltypes();
        int i = 0;
        for (String pizza : Pizzalist) {
            System.out.println(i + "=" +pizza);
            i++;
        }
        System.out.println("voer het nummer in van de pizza die u wilt:");
        Scanner myInput = new Scanner( System.in );
        int input = myInput.nextInt();
        this.setChoice(Pizzalist[input]);
    }
}
