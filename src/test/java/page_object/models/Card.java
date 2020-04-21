package page_object.models;

public class Card {
    private String number;

    public String getNumber() {
        return number;
    }

    public Card(String number) {
        this.number = number;
    }

    public String getMaskedNumber() {
        String lastDigits = number.substring(number.length() - 4);
        return "**** **** **** " + lastDigits;
    }
}
