package pl.polsl.filmy.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.filmy.dao.entity.VHS;

@Repository
public interface VHS_Repo extends CrudRepository<VHS,Long> {

}
