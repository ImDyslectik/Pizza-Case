import java.io.*;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import Compound.OrderingVisitor;
import Compound.Pizza;
import Compound.PizzaCompound;
import Compound.Toppings;

class OrderManager {
    private String Name;
    private String StreetName;
    private String PostalAdress;
    private String PizzaAmount;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    LocalDateTime Date = LocalDateTime.now();
    Console cnsl = System.console();
    OrderingVisitor visitor = new OrderingVisitor();
    Pizza pizzaorder = new Pizza();
    PizzaCompound compound = new PizzaCompound();
    Toppings topping = new Toppings();
    LinkedList<String> compoundresult = new LinkedList<>();

    /**
     * Creates the inputvalidator that gives back either true or false depending on
     * the input provided
     * 
     * IsValid set to true on starting, once false stop the loop and finish ordering
     * kevin spul
     */

    public void Bestel() {
        InputValidationPattern Input = new InputValidationPattern();
        boolean IsValid = true;
        compound.add(pizzaorder);
        compound.add(topping);
        visitor.getOrder(compound);
        compoundresult = compound.getContent();
        do {
            System.out.println("Enter Name : ");
            Name = cnsl.readLine();
            System.out.println("Enter Streetname : ");
            StreetName = cnsl.readLine();
            System.out.println("Enter Postal Adress : ");
            PostalAdress = cnsl.readLine();
            System.out.println("Enter Pizza Amount : ");
            PizzaAmount = cnsl.readLine();
            IsValid = Input.Validator(Name, StreetName, PostalAdress, PizzaAmount);
        } while (IsValid != true);
    }

    /**
     * Combines the input of the console readlines into an order
     * Parameters are pretty self explanitory
     * 
     * @param Name
     * @param StreetName
     * @param PostalAdress
     * @param PizzaAmount
     * @param order          ( de topping fix effe betere naam kevin)
     * @param ToppingCounter
     * @param Date
     * @return Receipt ( the linkedlist with the entire order)
     */

    public LinkedList<String> getOrder() {
        LinkedList<String> Receipt = new LinkedList<String>();
        Receipt.addLast(Name);
        Receipt.addLast(StreetName);
        Receipt.addLast(PostalAdress);
        Receipt.addLast(compoundresult.get(0));
        Receipt.addLast(PizzaAmount);
        boolean first = true;
        int toppingcounter = 0;
        for (String order : compoundresult) {
            if (first == true) {
                first = false;
            } else {
                Receipt.addLast(order);
                toppingcounter++;
            }
        }
        Receipt.addLast("" + toppingcounter);
        Receipt.addLast(dtf.format(Date));
        return Receipt;
    }
}