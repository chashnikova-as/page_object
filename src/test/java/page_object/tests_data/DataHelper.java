package page_object.tests_data;

import page_object.models.Card;
import page_object.models.User;

/**
 * Получение тестовых данных
 */
public class DataHelper {
    public String getVerificationCode() {
        return "12345";
    }

    public User getUser() {
        return new User("vasya", "qwerty123");
    }

    public Card getFirstCard() {
        return new Card("5559000000000001");
    }

    public Card getSecondCard() {
        return new Card("5559000000000002");
    }

    /**
     * Метод получения псевдослучайного целого числа от min до max (включая max);
     */
    public int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
