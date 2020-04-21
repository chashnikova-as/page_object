package page_object.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import page_object.models.User;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private static ConfirmPage confirmPage = new ConfirmPage();

    private SelenideElement form = $("#root");
    private SelenideElement loginInput = form.$("[data-test-id = 'login'] input");
    private SelenideElement passwordInput = form.$("[data-test-id = 'password'] input");
    private SelenideElement actionLogin = form.$("[data-test-id = 'action-login']");

    public void login(User user) {
        open("http://localhost:9999");
        loginInput.setValue(user.getLogin());
        passwordInput.setValue(user.getPassword());
        actionLogin.click();
    }

    public void loginSuccess(User user){
        open("http://localhost:9999");
        login(user);
        confirmPage.code.shouldBe(Condition.visible);
    }
}
