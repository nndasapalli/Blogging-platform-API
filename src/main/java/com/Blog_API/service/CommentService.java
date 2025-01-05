package com.Blog_API.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Blog_API.entity.Blog;
import com.Blog_API.entity.Comment;
import com.Blog_API.entity.User;
import com.Blog_API.repository.BlogRepository;
import com.Blog_API.repository.CommentRepository;
import com.Blog_API.repository.UserRepository;

@Service
public class CommentService {
	
	@Autowired
	private final CommentRepository commentRepository;
	
	@Autowired
    private final BlogRepository blogRepository;
	
	@Autowired
    private final UserRepository userRepository;

    public CommentService(CommentRepository commentRepository, BlogRepository blogRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.blogRepository = blogRepository;
        this.userRepository = userRepository;
    }

    public Comment addComment(Long blogId, Long userId, Comment comment) {
        Blog blog = blogRepository.findById(blogId)
                .orElseThrow(() -> new RuntimeException("Blog not found"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        comment.setBlog(blog);
        comment.setUser(user);
        comment.setCreatedAt(LocalDateTime.now());
        comment.setUpdatedAt(LocalDateTime.now());
        return commentRepository.save(comment);
    }
    
    public Comment updateComment(Long userId, Long commentId, Comment updatedComment) {
        // Fetch the existing comment
        Comment existingComment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment with ID " + commentId + " not found"));

        // Optional: Check if the comment belongs to the given user
        if (!existingComment.getUser().getId().equals(userId)) {
            throw new RuntimeException("User with ID " + userId + " is not authorized to update this comment");
        }

        // Update the comment details
        existingComment.setContent(updatedComment.getContent());
        existingComment.setUpdatedAt(LocalDateTime.now());

        // Save and return the updated comment
        return commentRepository.save(existingComment);
    }

    public List<Comment> getCommentsByBlogId(Long blogId) {
        return commentRepository.findAllByBlogId(blogId);
    }
    
    public void deleteComment(Long commentId) {
        // Check if the comment exists before attempting to delete
        Comment existingComment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment with ID " + commentId + " not found"));

        // Delete the comment
        commentRepository.delete(existingComment);
    }
}
