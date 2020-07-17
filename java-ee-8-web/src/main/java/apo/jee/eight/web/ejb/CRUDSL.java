package apo.jee.eight.web.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CRUDSL<T> {

    @PersistenceContext(unitName = "apo_lotteries")
    private EntityManager entityManager;

    public T save(T t) {
	entityManager.persist(t);
	return t;
    }
}
