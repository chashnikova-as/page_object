package page_object.Transfer;

import org.junit.jupiter.api.Test;
import page_object.Card;
import page_object.Client;
import page_object.DataHelper;
import page_object.Login.ConfirmPage;
import page_object.Login.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Тесты на переводы между картами одного клиента
 */
public class InternalPaymentTests {
    private static LoginPage loginPage = new LoginPage();
    private static ConfirmPage confirmPage = new ConfirmPage();
    private static DataHelper dataHelper = new DataHelper();
    private static CardsPage cardsPage = new CardsPage();
    private static AddMoneyPage addMoneyPage = new AddMoneyPage();

    @Test
    void transferFromAllCards() {
        String cardTo = "5559000000000001";
        int sum = 100;
        transferSuccess(cardTo, sum);

        cardTo = "5559000000000002";
        sum = 75;
        transferSuccess(cardTo, sum);
    }


    private void transferSuccess(String fullCardNumberTo, int sum) {
        //тестовые данные
        Client client = dataHelper.getClient();
//        int lastDigit = dataHelper.rnd(1, 2);
        Card cardTo = client.getCards().get(fullCardNumberTo);
        Card cardFrom = client.returnAnotherCard(fullCardNumberTo);

        loginPage.loginSuccess(client);

        confirmPage.inputCodeSuccess();

        int CardFromAmountBefore = cardsPage.getActualCardBalance(cardFrom);
        int CardToAmountBefore = cardsPage.getActualCardBalance(cardTo);
        cardsPage.initTransferSuccess(cardTo, sum);
        addMoneyPage.transferSuccess(cardFrom, cardTo, sum);

        assertEquals(CardFromAmountBefore - sum, (cardsPage.getActualCardBalance(cardFrom)), "Баланс карты списания изменился неправильно");
        assertEquals(CardToAmountBefore + sum, (cardsPage.getActualCardBalance(cardTo)), "Баланс карты зачисления изменился неправильно");
    }
}
