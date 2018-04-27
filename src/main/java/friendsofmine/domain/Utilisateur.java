package friendsofmine.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Size(min = 1,max = 255)
    private String nom;
    @NotNull
    @Size(min = 1,max = 255)
    private String prenom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public Utilisateur(){

    }

    public Long getId() {
        return id;
    }
}
