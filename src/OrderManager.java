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

    public static void main(String[] args) {
        // OrderManager bestel = new OrderManager();
        // String[] get = bestel.getOrder();
        // for (String or : get) {
        // System.out.println(or);
        // }
    }

    public String[] getOrder() {
        // String bestelling[] = { naam, pizza };
        InputValidationPattern Input = new InputValidationPattern();
        boolean IsValid = true;
        do {
            Name = cnsl.readLine("Enter Name : ");
            StreetName = cnsl.readLine("Enter Streetname : ");
            PostalAdress = cnsl.readLine("Enter Postal Adress : ");
            PizzaName = cnsl.readLine("Enter Pizza Name : ");
            IsValid = Input.InputValidationPattern(Name, StreetName, PostalAdress, PizzaName);
        } while (IsValid != true);

        System.out.println("pizza time");

        PizzaAmount = 3;
        Toppingamount = 2;
        // Will need to be made into a string array to keep track if people want extra
        // cheese with their mushrooms
        // String[] ToppingName = { "uien", "extra cheeeese" };

        return new String[] { Name, StreetName, PizzaName, PostalAdress, String.valueOf(PizzaAmount),
                String.valueOf(Toppingamount), dtf.format(Date) };
    }
}
