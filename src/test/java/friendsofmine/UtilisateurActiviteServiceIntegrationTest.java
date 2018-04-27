package friendsofmine;

import friendsofmine.domain.Activite;
import friendsofmine.domain.Utilisateur;
import friendsofmine.services.UtilisateurActiviteService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;


import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UtilisateurActiviteServiceIntegrationTest {

    @Autowired
    private UtilisateurActiviteService utilisateurActiviteService;

    private Activite activite;
    private Utilisateur utilisateur;

    @Before
    public void setUp() {

        // given a a valid Utilisateur
        utilisateur = new Utilisateur("Yorke", "Thom", "thom@yorke.com", "M");
        // given a a valid activite
        activite = new Activite("Une activité", "Description de l'activité");

    }

    @Test
    public void testSaveValidActivite() {

        // given a a valid activite

        // when saving the activite
        utilisateurActiviteService.save(activite);

        // expect the activite is saved with a generated id
        assertThat(activite.getId(), is(notNullValue()));
    }

    @Test
    public void testSaveValidUtilisateur() {

        // given a valid Utilisateur

        // when saving the utilisateur
        utilisateurActiviteService.save(utilisateur);

        // expect the utilisateur is saved with a generated id
        assertThat(utilisateur.getId(), is(notNullValue()));
    }

    @Test
    public void testFindExistingActiviteById() {

        // given a saved activite
        utilisateurActiviteService.save(activite);


        // when an existing  activite is searched by id
        Activite fetchedActivite = utilisateurActiviteService.findActiviteById(activite.getId());

        // then the fetched activite is correctly instanced
        assertThat(fetchedActivite.getTitre(), is(activite.getTitre()));
        assertThat(fetchedActivite.getDescriptif(), is(activite.getDescriptif()));

    }

    @Test
    public void testFindNonExistingActiviteById() {

        // when a non existing  activite is searched by id
        Activite fetchedActivite = utilisateurActiviteService.findActiviteById(10L);

        // then the fetched activite is null
        assertThat(fetchedActivite, is(nullValue()));

    }

    @Test
    public void testFindExistingUtilisateur() {
        // given a saved Utilisateur
        utilisateurActiviteService.save(utilisateur);

        // when an existing  utilisateur is searched by id
        Utilisateur fetchedUtilisateur = utilisateurActiviteService.findUtilisateurById(utilisateur.getId());

        // the fetched utilisateur is correctly instanced
        assertThat(fetchedUtilisateur.getNom(), is(utilisateur.getNom()));
        assertThat(fetchedUtilisateur.getPrenom(), is(utilisateur.getPrenom()));
        assertThat(fetchedUtilisateur.getEmail(), is(utilisateur.getEmail()));
        assertThat(fetchedUtilisateur.getSexe(), is(utilisateur.getSexe()));

    }

    @Test
    public void testFindNonExistingUtilisateurById() {

        // when a non existing  activite is searched by id
        Utilisateur fetchedUtilisateur = utilisateurActiviteService.findUtilisateurById(10L);

        // then the fetched activite is null
        assertThat(fetchedUtilisateur, is(nullValue()));

    }

}