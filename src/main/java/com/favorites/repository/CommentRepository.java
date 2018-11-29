package com.favorites.repository;

import com.favorites.domain.Comment;
import com.favorites.domain.view.CommentView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public interface CommentRepository extends JpaRepository<Comment, Long> {

    String findReplyUserSql = "select u.id as userId, u.userName as userName,u.profilePicture as profilePicture,c.content as content," +
            " c.createTime as createTime,c.replyUserId as replyUserId "
            + "from Comment c,User u WHERE c.userId=u.id";

    Long countByCollectId(Long collectId);

    List<Comment> findByCollectIdOrderByIdDesc(Long collectId);

    @Transactional
    void deleteById(Long id);


    @Query(findReplyUserSql + " and c.id=?1")
    CommentView findReplyUser(Long id);

}