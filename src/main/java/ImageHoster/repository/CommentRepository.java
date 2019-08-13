package ImageHoster.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ImageHoster.model.Comments;
import ImageHoster.model.Image;

@Repository
public class CommentRepository {
	@PersistenceUnit(unitName = "imageHoster")
	private EntityManagerFactory emf;

	public List<Comments> getAllComments(Image image) {
		EntityManager em = emf.createEntityManager();
		// String selectAllCommentsForImageID = "SELECT c from Comment c where
		// c.image_id =:imageId";
		TypedQuery<Comments> typedQuery = em
				.createQuery("SELECT c from Comments c where c.image =:image", Comments.class)
				.setParameter("image", image);
		List<Comments> comments = typedQuery.getResultList();
		return comments;
	}

	public void uploadComment(Comments newComment) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		try {
			et.begin();
			em.persist(newComment);
			et.commit();
		}catch (Exception e) {
			et.rollback();
		}
	}
}
