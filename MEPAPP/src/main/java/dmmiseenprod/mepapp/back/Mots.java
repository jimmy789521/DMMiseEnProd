package dmmiseenprod.mepapp.back;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Mots")

public class Mots{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable=false)
    private Long mots_id;
    private String mot;

    public Mots(){
    }

    public void setMot (String mot){
        this.mot = mot;
    }

    public String getMot (){
        return this.mot;
    }
}

