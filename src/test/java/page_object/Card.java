package page_object;

public class Card {
    private String number;
    private int balance;
    private String currency;

    public String getNumber() {
        return number;
    }

    public int getBalance() {
        return balance;
    }

    public String getCurrency() {
        return currency;
    }

    public Card (String number, int balance, String currency) {
        this.number = number;
        this.balance = balance;
        this.currency = currency;
    }

    public String getMaskedNumber () {
        String lastDigits = number.substring(number.length()-4);
        return "**** **** **** " + lastDigits;
    }
}
