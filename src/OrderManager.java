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

    Pizza pizzaorder = new Pizza();
    PizzaCompound compound = new PizzaCompound();
    Toppings topping = new Toppings();
    LinkedList<String> compoundresult = new LinkedList<>();

    public static void main(String[] args) {
        OrderManager bestel = new OrderManager();
        LinkedList<String> get = bestel.getOrder();
        for (String or : get) {
            System.out.println(or);
        }
    }

    public void Bestel() {
        try (Scanner myInput = new Scanner(System.in)) {
            InputValidationPattern Input = new InputValidationPattern();
            boolean IsValid = true;
            pizzaorder.ordering();
            topping.ordering();
            compound.add(pizzaorder);
            compound.add(topping);
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
        // String bestelling[] = { naam, pizza };

        LinkedList<String> Gegevens = new LinkedList<String>();
        Gegevens.addLast(Name + "\n" + StreetName + "\n" + PostalAdress + "\n" + compoundresult.get(0) + "\n"
                + PizzaAmount + "\n" + dtf.format(Date) + "\n");
        return Gegevens;
         }
}
