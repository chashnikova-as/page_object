package page_object.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import page_object.models.Card;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class CardsPage {
    private SelenideElement form = $("#root");
    public SelenideElement refresh = form.$("[data-test-id = 'action-reload']");

    public void refresh() {
        refresh.click();
    }

    public void initTransfer (Card card, int sum) {
        if (getActualCardBalance(card) < sum) {
            throw new ArithmeticException("Баланс карты меньше суммы перевода!");
        }
        SelenideElement cardItem = form.$(withText(card.getMaskedNumber()));
        cardItem.$("button").click();
    }

    public void initTransferSuccess (Card card, int sum) {
        if (getActualCardBalance(card) < sum) {
            throw new ArithmeticException("Баланс карты меньше суммы перевода!");
        }
        SelenideElement cardItem = form.$(withText(card.getMaskedNumber()));
        cardItem.$("button").click();
        new AddMoneyPage().amount.shouldBe(Condition.visible);
    }

    public int getActualCardBalance (Card card) {
        String cardInformation = form.$(withText(card.getMaskedNumber())).getText();
        String balance = cardInformation.substring(cardInformation.indexOf(":") + 1, cardInformation.indexOf("р")).trim();
        if (balance.matches("^-?\\d+$") && !balance.isEmpty()) {
            return Integer.parseInt(balance);
        } else {
            throw new NumberFormatException("Баланс карты некорректен!");
        }
    }
}
