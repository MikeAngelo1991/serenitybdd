package starter.tasks.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import starter.ui.login.UiLoginPage;

public class LoginTask implements Task {

    private final String username;
    private final String password;

    public LoginTask(String username, String password){

        this.username = username;
        this.password = password;

    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Enter.theValue(username).into(UiLoginPage.INPUT_USERNAME),
                Enter.theValue(password).into(UiLoginPage.INPUT_PASSWORD),
                Click.on(UiLoginPage.BUTTON_LOGIN)
        );

    }
}
