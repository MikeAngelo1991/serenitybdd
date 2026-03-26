package starter.tasks.registration;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actions.Upload;
import starter.ui.registration.UiRegisterUserForm;

import java.net.URISyntaxException;

public class RegisterUserTask implements Task {

    private final String expectedName;
    private final String expectedLastName;
    private final String expectedAge;
    private final String expectedEmail;
    private final String expectedCountry;

    public RegisterUserTask(String expectedName, String expectedLastName, String expectedAge, String expectedEmail, String expectedCountry){

        this.expectedName = expectedName;
        this.expectedLastName = expectedLastName;
        this.expectedAge = expectedAge;
        this.expectedEmail = expectedEmail;
        this.expectedCountry = expectedCountry;

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    Enter.theValue(expectedName).into(UiRegisterUserForm.INPUT_NAME),
                    Enter.theValue(expectedLastName).into(UiRegisterUserForm.INPUT_LAST_NAME),
                    Enter.theValue(expectedAge).into(UiRegisterUserForm.INPUT_AGE),
                    SelectFromOptions.byVisibleText(expectedCountry).from(UiRegisterUserForm.SELECT_COUNTRY),
                    Click.on(UiRegisterUserForm.SELECT_SEX),
                    Enter.theValue(expectedEmail).into(UiRegisterUserForm.INPUT_EMAIL),
                    Click.on(UiRegisterUserForm.SELECT_DAY),
                    Upload.theClasspathResource("pictures/rock.jpg").to(UiRegisterUserForm.UPLOAD_FILE),
                    Click.on(UiRegisterUserForm.BUTTON_SAVE)
            );
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
