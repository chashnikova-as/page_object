package page_object.transfers_tests;

import org.junit.jupiter.api.Test;
import page_object.models.Card;
import page_object.models.User;
import page_object.tests_data.DataHelper;
import page_object.pages.AddMoneyPage;
import page_object.pages.CardsPage;
import page_object.pages.ConfirmPage;
import page_object.pages.LoginPage;

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
    void transferSuccess() {
        User user = dataHelper.getUser();
        Card cardFrom = dataHelper.getFirstCard();
        Card cardTo = dataHelper.getSecondCard();
        int sum = dataHelper.rnd(1,100);

        loginPage.loginSuccess(user);
        confirmPage.inputCodeSuccess();


        int CardFromAmountBefore = cardsPage.getActualCardBalance(cardFrom);
        int CardToAmountBefore = cardsPage.getActualCardBalance(cardTo);

        cardsPage.initTransferSuccess(cardTo, sum);
        addMoneyPage.transferSuccess(cardFrom, sum);

        assertEquals(CardFromAmountBefore - sum, (cardsPage.getActualCardBalance(cardFrom)), "Баланс карты списания изменился неправильно");
        assertEquals(CardToAmountBefore + sum, (cardsPage.getActualCardBalance(cardTo)), "Баланс карты зачисления изменился неправильно");
    }
}
