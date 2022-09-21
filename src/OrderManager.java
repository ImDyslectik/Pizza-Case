import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

class OrderManager {
    private String Name;
    private String StreetName;
    private String PostalAdress;
    private String PizzaName;
    private int PizzaAmount;
    private int Toppingamount;
    private String ToppingName;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    LocalDateTime Date = LocalDateTime.now();
    Console cnsl = System.console();
    OrderingVisitor visitor = new OrderingVisitor();
    Pizza pizzaorder = new Pizza();
    PizzaCompound compound = new PizzaCompound();
    Toppings topping = new Toppings();
    LinkedList<String> compoundresult = new LinkedList<>();

    public void Bestel() {
        try (Scanner myInput = new Scanner(System.in)) {
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
                PizzaAmount = myInput.nextInt();
                IsValid = Input.Validator(Name, StreetName, PostalAdress);
            } while (IsValid != true);
        }

    }

    public LinkedList<String> getOrder() {
        LinkedList<String> Gegevens = new LinkedList<String>();
        Gegevens.addLast(
                Name + "\n" + StreetName + "\n" + PostalAdress + "\n" + compoundresult.get(0) + "\n" + PizzaAmount);
        boolean first = true;
        int toppingcounter = 0;
        for (String order : compoundresult) {
            if (first == true) {
                first = false;
            } else {
                Gegevens.addLast(order);
                toppingcounter++;
            }
        }
        Gegevens.addLast(toppingcounter + "\n" + dtf.format(Date) + "\n");
        return Gegevens;
    }
}