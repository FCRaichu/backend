package com.fc.fcseoularchive.post;

import com.fc.fcseoularchive.domain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {

}
