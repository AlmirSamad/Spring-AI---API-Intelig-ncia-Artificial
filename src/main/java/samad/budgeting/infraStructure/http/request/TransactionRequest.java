package samad.budgeting.infraStructure.http.request;

import samad.budgeting.application.input.PersistTransactionInput;
import samad.budgeting.domain.Category;

public record TransactionRequest(String description, Category category, long amount) {
    public PersistTransactionInput toInput() {
        return new PersistTransactionInput(description, amount, category);
    }
}
