package friendsofmine.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Utilisateur {

    @NotNull
    @Size(min = 1,max = 255)
    private String nom;
    @NotNull
    @Size(min = 1,max = 255)
    private String prenom;

    @NotNull
    @Email
    private String email;
    @NotNull @Pattern(regexp = "^[MF]{1}$")
    private String sexe ;
    public Utilisateur(String n, String p, String s, String f) {
        this.nom = n;
        prenom = p;
        email = s;
        sexe = f;
    }
}
