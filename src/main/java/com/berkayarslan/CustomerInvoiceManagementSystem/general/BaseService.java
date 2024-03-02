package com.berkayarslan.CustomerInvoiceManagementSystem.general;

import lombok.Getter;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;


@Getter
public abstract class BaseService<E extends BaseEntity, R extends JpaRepository<E,Long>> {

    private final R repository;

    protected BaseService(R repository) {
        this.repository = repository;
    }

    public E save(E entity){
        BaseAdditionalFields baseAdditionalFields = entity.getBaseAdditinalFields();
        if(baseAdditionalFields == null){
            baseAdditionalFields = new BaseAdditionalFields();
        }

        LocalDateTime now = LocalDateTime.now();
        if(entity.getId() == null){
            baseAdditionalFields.setCreateDate(now);
        }
        baseAdditionalFields.setUpdateDate(now);

        entity.setBaseAdditinalFields(baseAdditionalFields);

        entity = repository.save(entity);

        return entity;
    }
    public List<E> findAll(){
        return repository.findAll();
    }

    public E findByIdWithControl(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Entity with ID " + id + " not found"));
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
