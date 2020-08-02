package apo.jee.eight.web.ejb;

import apo.jee.eight.web.entity.Lottery;
import apo.jee.eight.web.entity.Result;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@Stateless
public class ResultSL {

    @PersistenceContext(unitName = "apo_lottery")
    private EntityManager entityManager;

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void loadPickFourResults(Path path) {
	try (Scanner scanner = new Scanner(path)) {
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
	    while (scanner.hasNext()) {
		Date date = simpleDateFormat.parse(scanner.next());
		String part = scanner.next();
		Lottery lottery = findLottery("PickFour".concat(part));
		if (existResult(date, lottery)) {
		    continue;
		}
		String firstDigit = scanner.next();
		//calling scanner.next() to skip the dash
		scanner.next();
		String secondDigit = scanner.next();
		//calling scanner.next() to skip the dash
		scanner.next();
		String thirdDigit = scanner.next();
		//calling scanner.next() to skip the dash
		scanner.next();
		String fourthDigit = scanner.next();
		Result result = new Result(firstDigit.concat(secondDigit).concat(thirdDigit).concat(fourthDigit), date,
				lottery);
		entityManager.persist(result);
	    }
	} catch (IOException | ParseException e) {
	    e.printStackTrace();
	}
    }

    private Lottery findLottery(String lotteryName) {
	return (Lottery) entityManager.createQuery("select l from Lottery l where l.name like '%" + lotteryName + "%'")
			.getSingleResult();
    }

    private boolean existResult(Date date, Lottery lottery) {
	List<Result> results = entityManager
			.createQuery("select r from Result r where r.date=:date and r.lottery=:lottery")
			.setParameter("date", date).setParameter("lottery", lottery).getResultList();
	return !results.isEmpty();
    }

    public List<Lottery> getLotteries() {
	return entityManager.createQuery("select l from Lottery  l order by l.name asc").getResultList();
    }
}
