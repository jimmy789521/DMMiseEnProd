package dmmiseenprod.mepapp.back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/mots")
public class MotsController {
    @Autowired
    private MotsRepository motRep;

    @GetMapping("")
    public List<Mots> list(){
        List<Mots> listemots = motRep.findAll();
        Collections.sort(listemots, new Comparator<Mots>(){
            public int compare(Mots m1, Mots m2) {
                return m1.getMot().compareTo(m2.getMot());
            }
        });
        return listemots;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mots> getByid(@PathVariable long id){
        try{
            Mots mot = motRep.findById(id).orElseThrow();
            return new ResponseEntity<Mots>(mot, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Mots>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Mots> newAdmin (@RequestParam String mot){
        Mots newMot = new Mots();
        newMot.setMot(mot);
        motRep.save(newMot);
        return new ResponseEntity<Mots>(newMot, HttpStatus.OK);
    }
}
