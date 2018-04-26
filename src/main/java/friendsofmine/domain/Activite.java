package friendsofmine.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Activite {
    @Size(min = 1,max = 255)
    @NotNull
    private String titre;

    private String descriptif;

    public Activite(String unTitre, String unDescriptif) {
        titre = unTitre;
        descriptif = unDescriptif;
    }
}
