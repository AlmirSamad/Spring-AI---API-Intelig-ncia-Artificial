package samad.budgeting.application.input;

import org.springframework.ai.tool.annotation.ToolParam;
import samad.budgeting.domain.Category;

public record PersistTransactionInput(@ToolParam(description = "Descrição do gasto") String description,
                                      @ToolParam(description = "Valor do gasto em centavos") long amount,
                                      @ToolParam(description = "Categoria do de uma transação") Category category) {
}
