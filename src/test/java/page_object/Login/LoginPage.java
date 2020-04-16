package page_object.Login;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import page_object.Client;
import page_object.DataHelper;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private static ConfirmPage confirmPage = new ConfirmPage();

    private SelenideElement form = $("#root");
    private SelenideElement loginInput = form.$("[data-test-id = 'login'] input");
    private SelenideElement passwordInput = form.$("[data-test-id = 'password'] input");
    private SelenideElement actionLogin = form.$("[data-test-id = 'action-login']");

    public void login(Client client) {
        open("http://localhost:9999");
        loginInput.setValue(client.getLogin());
        passwordInput.setValue(client.getPassword());
        actionLogin.click();
    }

    public void loginSuccess(Client client){
        open("http://localhost:9999");
        login(client);
        confirmPage.code.shouldBe(Condition.visible);
    }
}
