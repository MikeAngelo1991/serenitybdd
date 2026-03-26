package starter.tasks.addtransaction;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import starter.questions.GetTransactionInfoQuestion;
import starter.ui.addtransaction.UiAddTransactionPage;

public class CheckNewTransactionWasAddedTask implements Task {

    /*private final String transactionDateAssertion;
    private final String transactionAmountAssertion;
    private final String transactionDescriptionAssertion;

    public CheckNewTransactionWasAddedTask(String transactionDateAssertion, String transactionAmountAssertion, String transactionDescriptionAssertion){
        this.transactionDateAssertion = transactionDateAssertion;
        this.transactionAmountAssertion = transactionAmountAssertion;
        this.transactionDescriptionAssertion = transactionDescriptionAssertion;
    }*/


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Ensure.that(GetTransactionInfoQuestion.getDate()).contains("2023-12-12"),                //(transactionDateAssertion), // Dependiendo de cómo se muestre la fecha, es posible que necesites ajustar este valor
                Ensure.that(UiAddTransactionPage.TRANSACTIONS_TABLE).text().contains("500"),                       //(transactionAmountAssertion),
                Ensure.that(GetTransactionInfoQuestion.getDescription()).contains("testing description")        //(transactionDescriptionAssertion)
        );

    }
}
