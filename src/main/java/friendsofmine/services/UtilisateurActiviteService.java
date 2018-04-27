package friendsofmine.services;

import friendsofmine.domain.Activite;
import friendsofmine.domain.Utilisateur;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class UtilisateurActiviteService {

    @PersistenceContext
    EntityManager entityManager;
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Activite activite) {

        entityManager.persist(activite);
        entityManager.flush();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void save(Utilisateur utilisateur) {
        entityManager.persist(utilisateur);
    }

    public Activite findActiviteById(Long anId) {
        return entityManager.find(Activite.class,anId);
    }

    public Utilisateur findUtilisateurById(Long anId) {
        return entityManager.find(Utilisateur.class,anId);
    }
}
