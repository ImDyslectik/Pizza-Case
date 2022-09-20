public class InputValidationPattern {
    public boolean Validator(String Name, String StreetName, String PostalAdress) {
        if (Name.isEmpty() || StreetName.isEmpty()) {
            System.out.println("het lijkt erop dat u iets leeg gelaten heeft");
            return false;

        } else {
            if (PostalAdress.matches("[1-9]{1}[0-9]{3}[a-zA-Z]{2}")) {
                return true;
            }
            System.out.println("het lijkt dat uw postcode niet bestaat ???");
            return false;
        }
    }

}
