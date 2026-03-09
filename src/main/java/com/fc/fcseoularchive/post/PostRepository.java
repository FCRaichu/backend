package com.fc.fcseoularchive.post;

import com.fc.fcseoularchive.domain.entity.Post;
import com.fc.fcseoularchive.domain.enums.PostStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findAllByStatus(PostStatus status);
}
