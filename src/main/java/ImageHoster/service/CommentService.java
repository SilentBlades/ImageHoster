package ImageHoster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ImageHoster.model.Comments;
import ImageHoster.model.Image;
import ImageHoster.repository.CommentRepository;

@Service
public class CommentService {
	@Autowired
	private CommentRepository commentRepository;
	
	public List<Comments> getAllComments(Image image) {
		return commentRepository.getAllComments(image);
	}
	
	public void uploadComment(Comments newComment) {
		commentRepository.uploadComment(newComment);
	}
}
