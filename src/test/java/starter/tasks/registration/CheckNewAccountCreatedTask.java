package starter.tasks.registration;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.ensure.Ensure;
import starter.ui.registration.UiSummaryPage;

public class CheckNewAccountCreatedTask implements Task {

    private final String expectedName;
    private final String expectedLastName;

    public CheckNewAccountCreatedTask(String expectedName, String expectedLastName){

        this.expectedName = expectedName;
        this.expectedLastName = expectedLastName;

    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                Switch.toWindowTitled("Summary"),
                //cuestion
                Ensure.that(UiSummaryPage.LABEL_NAME).text().containsIgnoringCase(expectedName),
                Ensure.that(UiSummaryPage.LABEL_LAST_NAME).text().containsIgnoringCase(expectedLastName)


        );

    }
}
