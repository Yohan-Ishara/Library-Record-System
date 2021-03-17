package lk.ijse.dep.web.institute.dao;

import javax.persistence.EntityManager;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-01
 **/
public interface SuperDAO {
  EntityManager getEntityManager();
}
