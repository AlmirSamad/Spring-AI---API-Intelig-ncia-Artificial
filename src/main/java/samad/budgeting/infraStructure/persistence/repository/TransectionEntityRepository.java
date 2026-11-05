package samad.budgeting.infraStructure.persistence.repository;


import org.springframework.data.repository.CrudRepository;
import samad.budgeting.domain.Category;
import samad.budgeting.infraStructure.persistence.entity.TransactionEntity;

import java.util.List;
import java.util.UUID;

public interface TransectionEntityRepository extends CrudRepository<TransactionEntity, UUID> {
    List<TransactionEntity> findAllByCategory(Category category);
}
