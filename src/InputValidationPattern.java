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
        if (Name.isEmpty() || StreetName.isEmpty()) {
            System.out.println("het lijkt erop dat u iets leeg gelaten heeft");
            return false;

        } else {
            if (PostalAdress.matches("[1-9]{1}[0-9]{3}[a-zA-Z]{2}") && PizzaAmount.matches("[1-99]")) {
                return true;
            }
            System.out.println("Het lijkt erop dat uw gegevens niet geldig zijn, probeer het nogmaals: ");
            return false;
        }
    }

}
