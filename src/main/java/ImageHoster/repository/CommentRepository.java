package ImageHoster.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ImageHoster.model.Comment;

@Repository
public class CommentRepository {
	@PersistenceUnit(unitName="imageHoster")
	private EntityManagerFactory emf;
	
	public Comment getCommentsById(Integer imageId) {
		EntityManager em = emf.createEntityManager();
		String selectAllCommentsForImageID = "SELECT c from Comment c where c.image_id =:imageId";
		
		try {
			TypedQuery<Comment> typedQuery = em.createQuery(selectAllCommentsForImageID, Comment.class).setParameter("imageId", imageId);
			return typedQuery.getSingleResult();
		}
		catch (NoResultException nre) {
			return null;
		}
	}
	
	public void uploadComment(Comment newComment) {
		
	}
}
