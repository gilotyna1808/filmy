package pl.polsl.filmy.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.polsl.filmy.dao.entity.VHS;
import pl.polsl.filmy.menager.VHS_Menager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/vhs")
public class VHS_Api {
    private VHS_Menager vhsMenager;

    @Autowired
    public VHS_Api(VHS_Menager vhsMenager) {
        this.vhsMenager = vhsMenager;
    }



    @GetMapping("/all")
    public Iterable<VHS>gettALL(){
        return this.vhsMenager.findAll();
    }

    @GetMapping()
    public Optional<VHS> getById(@RequestParam long index){
        return vhsMenager.findAllById(index);
    }

    @PostMapping
    public VHS addVideo(@RequestBody VHS vhs){
        return this.vhsMenager.save(vhs);
    }

    @PutMapping
    public VHS updateVideo(@RequestBody VHS vhs){
        return vhsMenager.save(vhs);
    }

    @DeleteMapping
    public void deleteVideo(@RequestParam Long index){
        vhsMenager.delete(index);
    }
}
