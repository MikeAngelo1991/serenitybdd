package starter.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import starter.ui.addtransaction.UiAddTransactionPage;

public class GetTransactionInfoQuestion {

    public static Question<String> getDescription(){

        return Question.about("transaction description").answeredBy(
                actor -> BrowseTheWeb.as(actor).textOf(UiAddTransactionPage.TRANSACTIONS_TABLE_XPATH)
        );

    }

    public static Question<String> getDate(){

        return Question.about("2023-12-12").answeredBy(
                actor -> BrowseTheWeb.as(actor).textOf(UiAddTransactionPage.TRANSACTIONS_TABLE_XPATH)
        );

    }

}
