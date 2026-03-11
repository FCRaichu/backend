package com.fc.fcseoularchive.post;

import com.fc.fcseoularchive.domain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
    // status 관련 조회는 PostAuthRepository에서 처리
}
