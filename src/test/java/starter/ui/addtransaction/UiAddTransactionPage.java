package starter.ui.addtransaction;

import net.serenitybdd.screenplay.targets.Target;

public class UiAddTransactionPage {

    public static Target BUTTON_ADD_TRANSACTION = Target.the("add transaction button").locatedBy("//button[contains(text(),'Añadir transacción')]");
    public static Target INPUT_DATE = Target.the("input date").locatedBy("//input[@type='date']");
    public static Target INPUT_AMOUNT = Target.the("input amount").locatedBy("//input[@type='number']");
    public static Target INPUT_DESCRIPTION = Target.the("input amount").locatedBy("//input[@id='description']");
    public static Target BUTTON_SAVE = Target.the("save button").locatedBy("//button[contains(text(),'Guardar')]");

// check new transaction was added
    public static Target TRANSACTIONS_TABLE = Target.the("transactions table").locatedBy("//tbody[@id='transactions-list']");

    //question
    public static String TRANSACTIONS_TABLE_XPATH = "//tbody[@id='transactions-list']";

}
