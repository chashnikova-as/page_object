package page_object.Login;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import page_object.DataHelper;
import page_object.Transfer.CardsPage;

import static com.codeborne.selenide.Selenide.$;

public class ConfirmPage {
    private SelenideElement form = $("#root");
    public final SelenideElement code = form.$("[data-test-id = 'code'] input");
    public final SelenideElement actionVerify = form.$("[data-test-id = 'action-verify']");

    public void inputCodeSuccess() {
        code.setValue(new DataHelper().getVerificationCode());
        actionVerify.click();
        new CardsPage().refresh.shouldBe(Condition.visible);
    }

    public void inputCode() {
        code.setValue(new DataHelper().getVerificationCode());
        actionVerify.click();
    }
}
