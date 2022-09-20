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

    public void ordering() {
        String[] Toppinglist = this.getAlltypes();
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
                this.setChoice(Toppinglist[input]);
            }
            count++;

        } while (WantTopping);
    }
}
