package page_object.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import page_object.models.Card;

import static com.codeborne.selenide.Selenide.$;

public class AddMoneyPage {
    private SelenideElement form = $("#root");
    public SelenideElement amount = form.$("[data-test-id = 'amount'] input");
    private SelenideElement from = form.$("[data-test-id = 'from'] input");
    private SelenideElement action = form.$("[data-test-id = 'action-transfer']");

    public void transferSuccess (Card fromCard, int sum) {
        amount.setValue(String.valueOf(sum));
        from.setValue(fromCard.getNumber());
        action.click();
        new CardsPage().refresh.shouldBe(Condition.visible);
    }
}