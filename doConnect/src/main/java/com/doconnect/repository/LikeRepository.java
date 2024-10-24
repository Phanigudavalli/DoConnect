package com.doconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.doconnect.model.Like;
import com.doconnect.model.User;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {

    
    @Query("SELECT COUNT(l) FROM Like l WHERE l.answer.id = :answerId")
    Long countLikesForAnswer(@Param("answerId") Long answerId);

    
    @Query("SELECT COUNT(l) FROM Like l WHERE l.question.id = :questionId")
    Long countLikesForQuestion(@Param("questionId") Long questionId);

    
    @Query("SELECT COUNT(l) FROM Like l WHERE l.comment.id = :commentId")
    Long countLikesForComment(@Param("commentId") Long commentId);

    
    @Query("SELECT l.user FROM Like l WHERE l.answer.id = :answerId")
    List<User> findUsersWhoLikedAnswer(@Param("answerId") Long answerId);

    
    @Query("SELECT l.user FROM Like l WHERE l.question.id = :questionId")
    List<User> findUsersWhoLikedQuestion(@Param("questionId") Long questionId);

    
    @Query("SELECT l.user FROM Like l WHERE l.comment.id = :commentId")
    List<User> findUsersWhoLikedComment(@Param("commentId") Long commentId);
}

