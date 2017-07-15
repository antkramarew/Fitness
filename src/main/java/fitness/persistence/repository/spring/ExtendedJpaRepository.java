package fitness.persistence.repository.spring;

import fitness.service.exeption.ResourceNotFoundException;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by toxa on 7/13/2017.
 */
public class ExtendedJpaRepository<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> {

    public ExtendedJpaRepository(Class domainClass, EntityManager em) {
        super(domainClass, em);
    }

    public ExtendedJpaRepository(JpaEntityInformation entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
    }

    @Override
    public void delete(ID id) {
        Assert.notNull(id, "The given id must not be null!");
        T entity = this.findOne(id);
        if(entity == null) {
            throw new ResourceNotFoundException(id);
        } else {
            this.delete(entity);
        }
    }
}
