package page_object.Transfer;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import page_object.Card;

import static com.codeborne.selenide.Selenide.$;
//import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddMoneyPage {
    private SelenideElement form = $("#root");
    public SelenideElement amount = form.$("[data-test-id = 'amount'] input");
    private SelenideElement from = form.$("[data-test-id = 'from'] input");
    private SelenideElement to = form.$("[data-test-id = 'to'] input");
    private SelenideElement action = form.$("[data-test-id = 'action-transfer']");
    private SelenideElement cancel = form.$("[data-test-id = 'action-cancel']");

    public void transferSuccess (Card fromCard, Card toCard, int sum) {
//        todo поискать как взять value из недоступного элемента
//        assertEquals(to.getValue(),toCard.getMaskedNumber(),"Проверьте номер карты зачисления!");
        amount.setValue(String.valueOf(sum));
        from.setValue(fromCard.getNumber());
        action.click();
        new CardsPage().refresh.shouldBe(Condition.visible);
    }
}