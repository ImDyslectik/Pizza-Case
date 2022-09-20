public class InputValidationPattern {
    public boolean Validator(String Name, String StreetName, String PostalAdress) {
        if (Name.isEmpty() || StreetName.isEmpty() || PostalAdress.isEmpty()) {
            System.out.println("het lijkt erop dat u iets leeg gelaten heeft");
            return false;
        } else {
            return true;
        }
    }
}
