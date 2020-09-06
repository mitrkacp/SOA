package pl.edu.agh.soa;

import pl.edu.agh.soa.model.Deposit;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DepositDao {
    @PersistenceContext(unitName = "vnd")
    EntityManager entityManager;

    public static DepositEntity depositToEntity(Deposit deposit){
        DepositEntity depositEntity = new DepositEntity();
        depositEntity.setNumber(deposit.getNumber());
        depositEntity.setBalance(deposit.getBalance());
        return depositEntity;
    }

    public static Deposit entityToDeposit(DepositEntity depositEntity){
        Deposit deposit =new Deposit();
        deposit.setNumber(depositEntity.getNumber());
        deposit.setBalance(depositEntity.getBalance());
        return deposit;
    }
    public void save(Deposit deposit) {
        entityManager.persist(DepositDao.depositToEntity(deposit));
    }
    public void add(DepositEntity depositEntity) {
        entityManager.persist(depositEntity);
    }
}
