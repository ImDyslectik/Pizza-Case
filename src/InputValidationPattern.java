public class InputValidationPattern {
    public boolean InputValidationPattern(String Name, String StreetName, String PostalAdress, String PizzaName) {
        if (Name.isEmpty() || StreetName.isEmpty() || PostalAdress.isEmpty() || PizzaName.isEmpty()) {
            System.out.println("vies vuil tering joch hoe durf je iets leeg te laten");
            return false;
        } else {
            return true;
        }
    }
}
