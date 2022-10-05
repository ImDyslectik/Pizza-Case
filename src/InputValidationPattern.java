public class InputValidationPattern {
    /**
     * Input Validation Pattern checks for our required specifications
     * https://en.wikipedia.org/wiki/Data_validation#Structured_check
     * 
     * Parameters are self explanatory
     * 
     * @param Name
     * @param StreetName
     * @param PostalAdress
     * @param PizzaAmount
     * @return
     */
    public boolean Validator(String Name, String StreetName, String PostalAdress, String PizzaAmount) {
        if (Name.matches("[a-zA-Z]+") && StreetName.matches("[a-zA-Z]+")
                && PostalAdress.matches("[1-9]{1}[0-9]{3}[a-zA-Z]{2}") && PizzaAmount.matches("[1-99]")) {
            return true;
        } else {
            System.out.println("Het lijkt erop dat uw gegevens niet geldig zijn, probeer het nogmaals: ");
            return false;
        }
    }
}
