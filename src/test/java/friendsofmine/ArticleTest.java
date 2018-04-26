package friendsofmine;

import friendsofmine.domain.Article;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import static org.junit.Assert.assertTrue;

public class ArticleTest {

    private static Validator validator;

    @BeforeClass
    public static void setupContext() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testIdTitreCategorieOK() {
        Article a = new Article(1, "Titre de l'article", "Categorie de l'article");
        assertTrue(validator.validate(a).size() == 0);
    }

    @Test
    public void testIdNegatif() {
        Article a = new Article(-1, "Attention, risque d'orage", "meteo");
        assertTrue(validator.validate(a).size() != 0);
    }

    @Test
    public void testIdZero() {
        Article a = new Article(0, "Attention, risque d'orage", "meteo");
        assertTrue(validator.validate(a).size() == 0);
    }

    @Test
    public void testTitreVide() {
        Article a = new Article(1, "", "categorie");
        assertTrue(validator.validate(a).size() != 0);
    }

    @Test
    public void testTitreNull() {
        Article a = new Article(1, null, "categorie");
        assertTrue(validator.validate(a).size() != 0);
    }

    @Test
    public void testCategorieNull() {
        Article a = new Article(1, "Attantion, rsique d'orage", null);
        assertTrue(validator.validate(a).size() == 0);
    }

}