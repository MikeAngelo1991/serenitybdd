package starter.tasks.registration;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import starter.ui.registration.UiRegisterUserForm;

public class DoNotSendAllRequiredInformationTask implements Task {


    private final String expectedName;
    private final String expectedLastName;

    public DoNotSendAllRequiredInformationTask(String expectedName, String expectedLastName){

        this.expectedName = expectedName;
        this.expectedLastName = expectedLastName;

    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Enter.theValue(expectedName).into(UiRegisterUserForm.INPUT_NAME),
                Enter.theValue(expectedLastName).into(UiRegisterUserForm.INPUT_LAST_NAME),
                Click.on(UiRegisterUserForm.BUTTON_SAVE)
        );

    }
}
