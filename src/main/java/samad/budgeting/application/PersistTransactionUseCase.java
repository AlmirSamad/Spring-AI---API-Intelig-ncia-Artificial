package samad.budgeting.application;


import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;
import samad.budgeting.application.input.PersistTransactionInput;
import samad.budgeting.application.output.TransactionOutput;
import samad.budgeting.domain.Transaction;
import samad.budgeting.domain.TransactionRepository;

@Service

public class PersistTransactionUseCase {
    private final TransactionRepository transactionRepository;

    public PersistTransactionUseCase(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Tool(name = "persist-transaction",description = "Persiste uma nova transação financeira")
    public TransactionOutput  execute(PersistTransactionInput input){
        var transaction = transactionRepository.save(new Transaction(input.description(),
                input.amount(), input.category()));

        return TransactionOutput.from(transaction);
    }
}
