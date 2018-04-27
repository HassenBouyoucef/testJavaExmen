package friendsofmine.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Activite {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(min = 1,max = 255)
    @NotNull
    private String titre;

    private String descriptif;

    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    public String getTitre() {
        return titre;

    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Activite(String unTitre, String unDescriptif) {
        titre = unTitre;
        descriptif = unDescriptif;
    }

    public Activite(){

    }

    public Long getId() {
        return id;
    }
}
