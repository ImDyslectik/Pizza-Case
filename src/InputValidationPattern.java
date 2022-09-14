public class InputValidationPattern {
    public boolean Validator(String Name, String StreetName, String PostalAdress) {
        if (Name.isEmpty() || StreetName.isEmpty() || PostalAdress.isEmpty()) {
            System.out.println("vies vuil tering joch hoe durf je iets leeg te laten");
            return false;
        } else {
            return true;
        }
    }
}
