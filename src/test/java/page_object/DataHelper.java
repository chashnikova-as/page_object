package page_object;//todo переписать методы при изменении логики получения тестовых данных.
// Сейчас захаркожены данные

import java.util.HashMap;

/**
 * Получение тестовых данных
 */
public class DataHelper {
    public String getVerificationCode() {
        return "12345";
    }

    public Client getClient() {
        HashMap<String, Card> cardList = new HashMap<>();
        cardList.put("5559000000000001", new Card("5559000000000001", 10000, "RUB"));
        cardList.put("5559000000000002", new Card("5559000000000002", 10000, "RUB"));
        return new Client("vasya", "qwerty123", cardList);
    }

    /**
     * Метод получения псевдослучайного целого числа от min до max (включая max);
     */
    public static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
