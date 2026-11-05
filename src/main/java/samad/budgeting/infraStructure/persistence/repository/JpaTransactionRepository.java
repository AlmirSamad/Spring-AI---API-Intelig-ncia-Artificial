package samad.budgeting.infraStructure.persistence.repository;

import org.springframework.stereotype.Repository;
import samad.budgeting.domain.Category;
import samad.budgeting.domain.Transaction;
import samad.budgeting.domain.TransactionRepository;
import samad.budgeting.infraStructure.persistence.entity.TransactionEntity;

import java.util.List;

@Repository
public class JpaTransactionRepository implements TransactionRepository{
    private final TransectionEntityRepository transectionEntityRepository;

    public JpaTransactionRepository(TransectionEntityRepository transectionEntityRepository) {
        this.transectionEntityRepository = transectionEntityRepository;
    }

    @Override
    public Transaction save(Transaction transaction) {
        var entity = TransactionEntity.from(transaction);
        return transectionEntityRepository.save(entity).toDomain();

    }

    @Override
    public List<Transaction> findAllByCategory(Category category) {
        return transectionEntityRepository.findAllByCategory(category)
                .stream()
                .map(TransactionEntity::toDomain)
                .toList();

    }
}
