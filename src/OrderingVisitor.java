import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class OrderingVisitor implements Visitor {

    public void getOrder(PizzaCompound compound){
        List<PizzaSet> children = compound.getchildren();
        for (PizzaSet child : children) {
            child.accept(this);
        }
    }

    public void visitPizza(Pizza pizza){
       String[] Pizzalist = pizza.getAlltypes();
        int i = 0;
        for (String pizzas : Pizzalist) {
            System.out.println(i + "=" +pizzas);
            i++;
        }
        System.out.println("voer het nummer in van de pizza die u wilt:");
        Scanner myInput = new Scanner( System.in );
        int input = myInput.nextInt();
        pizza.setChoice(Pizzalist[input]);
    }

    public void visitTopping(Toppings topping){
        String[] Toppinglist = topping.getAlltypes();
        int count = 0;
        Boolean WantTopping = true;
        Scanner myInput = new Scanner(System.in);
        do {
            System.out.println("voer het nummer in van de topping die u wilt(MAX 10):");
            System.out.println("u heeft nu " + count + " toppings gekozen");
            int y = 0;
            if (count == 9) {
                WantTopping = false;
            }
            for (String toppings : Toppinglist) {
                System.out.println(y + "=" + toppings);
                y++;
            }
            System.out.println("9 = geen toppings meer");
            int input = myInput.nextInt();
            if (input == 9) {
                WantTopping = false;
            } else {
                topping.setChoice(Toppinglist[input]);
            }
            count++;

        } while (WantTopping);
    }
}
