package com.Blog_API.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Blog_API.entity.Comment;
import com.Blog_API.service.CommentService;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
	
	@Autowired
	private CommentService commentService;

    @PostMapping("/{blogId}/{userId}")
    public ResponseEntity<Comment> addComment(@PathVariable Long blogId, @PathVariable Long userId, @RequestBody Comment comment) {
        return ResponseEntity.ok(commentService.addComment(blogId, userId, comment));
    }

    @GetMapping("/blog/{blogId}")
    public ResponseEntity<List<Comment>> getCommentsByBlogId(@PathVariable Long blogId) {
        return ResponseEntity.ok(commentService.getCommentsByBlogId(blogId));
    }

    @PutMapping("/{commentId}/{userId}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long userId, @PathVariable Long commentId, @RequestBody Comment comment) {
        return ResponseEntity.ok(commentService.updateComment(userId, commentId, comment));
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.noContent().build();
    }
}
