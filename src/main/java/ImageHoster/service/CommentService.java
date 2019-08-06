package ImageHoster.service;

import org.springframework.beans.factory.annotation.Autowired;

import ImageHoster.model.Comment;
import ImageHoster.repository.CommentRepository;

public class CommentService {
	@Autowired
	private CommentRepository commentRepository;
	
	public Comment getCommentsById(Integer imageId) {
		return commentRepository.getCommentsById(imageId);
	}
	
	public void uploadComment(Comment newComment) {
		commentRepository.uploadComment(newComment);
	}
}
