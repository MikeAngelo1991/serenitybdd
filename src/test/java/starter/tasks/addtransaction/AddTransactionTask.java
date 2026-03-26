package starter.tasks.addtransaction;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import starter.ui.addtransaction.UiAddTransactionPage;

public class AddTransactionTask {

    public static Performable withInfo(String transactionDate, String transactionAmount, String transactionDescription) {
        return Task.where("{0} adds a new transaction",
                Click.on(UiAddTransactionPage.BUTTON_ADD_TRANSACTION),
                // Aquí se agregarían las acciones para llenar el formulario de la nueva transacción
                Enter.theValue(transactionDate).into(UiAddTransactionPage.INPUT_DATE),
                Enter.theValue(transactionAmount).into(UiAddTransactionPage.INPUT_AMOUNT),
                Enter.theValue(transactionDescription
                ).into(UiAddTransactionPage.INPUT_DESCRIPTION),
                Click.on(UiAddTransactionPage.BUTTON_SAVE)
        );
    }


// Es un manera de ejecutar multiples métodos para diferentes steps
  /*  public static Performable withRequiredInfo() {
        return Task.where("{0} adds a new transaction",
                Click.on(By.xpath("//button[contains(text(),'Añadir transacción')]")),
                // Aquí se agregarían las acciones para llenar el formulario de la nueva transacción
                Enter.theValue("12-12-2023").into(By.xpath("//input[@type='date']")),
                Enter.theValue("500").into(By.xpath("//input[@id='amount']")),
                Enter.theValue("testing description").into(By.xpath("//input[@id='description']")),
                Click.on(By.xpath("//button[contains(text(),'Guardar')]"))
        );
    }*/

}
