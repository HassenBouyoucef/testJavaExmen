package friendsofmine;

import friendsofmine.domain.Utilisateur;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class UtilisateurTest {

    private static Validator validator;

    @BeforeClass
    public static void setupContext() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testUtilisateurFemme() {
        Utilisateur util = new Utilisateur("Dupont", "Jeanne", "jd@jd.com", "F");
        assertTrue(validator.validate(util).size() == 0);
    }

    @Test
    public void testUtilisateurHomme() {
        Utilisateur util = new Utilisateur("Durand", "Jacques", "jd@jd.com", "M");
        assertTrue(validator.validate(util).size() == 0);
    }

    @Test
    public void testUtilisateurNomNull() {
        Utilisateur util = new Utilisateur(null, "Jacques", "jd@jd.com", "M");
        assertTrue(validator.validate(util).size() > 0);
    }

    @Test
    public void testUtilisateurNomVide() {
        Utilisateur util = new Utilisateur("", "Jacques", "jd@jd.com", "M");
        assertTrue(validator.validate(util).size() > 0);
    }

    @Test
    public void testUtilisateurPrenomNull() {
        Utilisateur util = new Utilisateur("Durand", null, "jd@jd.com", "M");
        assertTrue(validator.validate(util).size() > 0);
    }

    @Test
    public void testUtilisateurPrenomVide() {
        Utilisateur util = new Utilisateur("Durand", "", "jd@jd.com", "M");
        assertTrue(validator.validate(util).size() > 0);
    }

    @Test
    public void testUtilisateurEmailSansArobase() {
        Utilisateur util = new Utilisateur("Durand", "Eric", "jd.jd.com", "M");
        assertTrue(validator.validate(util).size() > 0);
    }

    @Test
    public void testUtilisateurEmailNull() {
        Utilisateur util = new Utilisateur("Durand", "Eric", null, "M");
        assertTrue(validator.validate(util).size() > 0);
    }

    @Test
    public void testUtilisateurSexeInvalide() {
        Utilisateur util = new Utilisateur("Durand", "Eric", "jd@jd.com", "V");
        assertTrue(validator.validate(util).size() > 0);
    }

    @Test
    public void testUtilisateurSexeNull() {
        Utilisateur util = new Utilisateur("Durand", "Eric", "jd@jd.com", null);
        assertTrue(validator.validate(util).size() > 0);
    }

    @Test
    public void testUnNouvelUtilisateurEstSansActivite() {
        Utilisateur util = new Utilisateur("Durand", "Eric", "jd@jd.com", "M");
        assertNull("Un nouvel Utilisateur n'a pas d'activité" , util.getActivites());
    }

}