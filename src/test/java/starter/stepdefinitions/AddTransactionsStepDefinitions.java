package starter.stepdefinitions;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import starter.models.LoginModel;
import starter.models.TransactionModel;
import starter.tasks.addtransaction.AddTransactionTask;
import starter.tasks.addtransaction.CheckNewTransactionWasAddedTask;
import starter.tasks.login.LoginTask;
import starter.tasks.navigation.NavigateToTask;
import starter.util.GetInfoFromTable;

import java.util.List;

public class AddTransactionsStepDefinitions {

    @Given("{actor} is logged into the application")
    public void pepitoIsLoggedIntoTheApplication(Actor actor, DataTable userLogin) {

        LoginModel loginModel = GetInfoFromTable.getLoginCredentials(userLogin); // Aquí puedes implementar la lógica para extraer el nombre de usuario y la contraseña de la tabla de datos y crear un modelo de login

        actor.attemptsTo(
                NavigateToTask.loginPage(),
                new LoginTask(loginModel.getUsername(), loginModel.getPassword()) // Aquí puedes pasar el nombre de usuario y la contraseña extraídos de la tabla de datos para realizar el inicio de sesión
        );

    }

    @When("{actor} enters the required information to add a new transaction")
    public void pepitoEntersTheRequiredInformationToAddANewTransaction(Actor actor, DataTable transactionInfo) {


        TransactionModel transactionModel = GetInfoFromTable.getTransactionData(transactionInfo); // Aquí puedes implementar la lógica para extraer la información de la transacción de la tabla de datos y crear un modelo de transacción


        actor.attemptsTo(
                AddTransactionTask.withInfo(
                        transactionModel.getTransactionDate(),
                        transactionModel.getTransactionAmount(),
                        transactionModel.getTransactionDescription()) // Aquí puedes pasar la información necesaria para agregar la transacción, como descripción, monto, fecha, etc.
        );

    }

    @Then("{actor} should see a new transaction in the transaction list with correct details")
    public void pepitoShouldSeeANewTransactionInTheTransactionListWithCorrectDetails(Actor actor, DataTable transactionAssertion) {

        /*List<List<String>> rows = transactionAssertion.asLists(String.class); // Convertir la tabla de datos en una lista de listas de cadenas

        String transactionDateAssertion = "";
        String transactionAmountAssertion = "";
        String transactionDescriptionAssertion = "";

        for (List<String> columns : rows){
            transactionDateAssertion = columns.get(0); // Obtener el nombre de usuario de la primera columna
            transactionAmountAssertion = columns.get(1); // Obtener la contraseña de la segunda columna
            transactionDescriptionAssertion = columns.get(2); // Obtener la descripción de la tercera columna
        }*/

        actor.attemptsTo(
                new CheckNewTransactionWasAddedTask() /*( transactionDateAssertion, transactionAmountAssertion, transactionDescriptionAssertion) */// Aquí puedes pasar la información necesaria para verificar que la transacción se agregó correctamente, como descripción, monto, fecha, etc.
        );

    }
}
