package starter.util;

import io.cucumber.datatable.DataTable;
import starter.models.LoginModel;
import starter.models.TransactionModel;

import java.util.List;

public class GetInfoFromTable {

    public static LoginModel getLoginCredentials(DataTable userLogin) {

        List<List<String>> rows = userLogin.asLists(String.class); // Convertir la tabla de datos en una lista de listas de cadenas

        String username = "";
        String password = "";

        for (List<String> columns : rows){
            username = columns.get(0); // Obtener el nombre de usuario de la primera columna
            password = columns.get(1); // Obtener la contraseña de la segunda columna
        }

        LoginModel loginModel = new LoginModel();
        loginModel.setUsername(username);
        loginModel.setPassword(password);

        return loginModel;

    }

    public static TransactionModel getTransactionData(DataTable transactionInfo) {

        List<List<String>> rows = transactionInfo.asLists(String.class); // Convertir la tabla de datos en una lista de listas de cadenas

        String transactionDate = "";
        String transactionAmount = "";
        String transactionDescription = "";

        for (List<String> columns : rows){
            transactionDate = columns.get(0); // Obtener el nombre de usuario de la primera columna
            transactionAmount = columns.get(1); // Obtener la contraseña de la segunda columna
            transactionDescription = columns.get(2); // Obtener la descripción de la tercera columna
        }


        TransactionModel transactionModel = new TransactionModel();
        transactionModel.setTransactionDate(transactionDate);
        transactionModel.setTransactionAmount(transactionAmount);
        transactionModel.setTransactionDescription(transactionDescription);

        return transactionModel;

    }


}
