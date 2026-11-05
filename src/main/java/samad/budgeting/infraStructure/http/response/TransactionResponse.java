package samad.budgeting.infraStructure.http.response;

import samad.budgeting.application.output.TransactionOutput;

import java.math.BigDecimal;

public record TransactionResponse(String id, String category, String description, double amount) {
    public static TransactionResponse from(TransactionOutput transaction) {
        return new TransactionResponse(transaction.id(), transaction.category(), transaction.description(), transaction.value());
    }
}
