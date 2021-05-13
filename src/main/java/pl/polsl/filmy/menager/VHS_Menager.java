package pl.polsl.filmy.menager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.polsl.filmy.dao.VHS_Repo;
import pl.polsl.filmy.dao.entity.VHS;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class VHS_Menager {
    private VHS_Repo vhsRepo;

    @Autowired
    public VHS_Menager(VHS_Repo vhsRepo) {
        this.vhsRepo = vhsRepo;
    }

    public Optional<VHS> findAllById(Long id){
        return vhsRepo.findById(id);
    }

    public Iterable<VHS> findAll(){
        return vhsRepo.findAll();
    }

    public VHS save(VHS vhs){
        return vhsRepo.save(vhs);
    }

    public void delete(Long id){
        vhsRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        save((new VHS(1L,"Tytul 1", LocalDate.of(1998,8,18))));
        save((new VHS(2L,"Tytul 2", LocalDate.of(2001,1,1))));
        save((new VHS(3L,"Tytul 3", LocalDate.of(2018,5,15))));
    }
}
