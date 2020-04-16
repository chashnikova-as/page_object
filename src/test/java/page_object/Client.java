package page_object;

import java.util.HashMap;
import java.util.Map;

public class Client {
    private String login;
    private String password;
    private HashMap<String, Card> cards;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public HashMap<String, Card> getCards() {
        return cards;
    }

    public Client(String login, String password, HashMap<String, Card> cards) {
        this.login = login;
        this.password = password;
        this.cards = cards;
    }

    public Card returnAnotherCard (String cardNumber) {
        for (Map.Entry<String, Card> entry : getCards().entrySet()) {
            if (!(entry.getValue().getNumber()).equals(cardNumber)) {
                return  getCards().get(entry.getKey());
            }
        }
        throw new NumberFormatException("Другой карты нет!");
    }
}
