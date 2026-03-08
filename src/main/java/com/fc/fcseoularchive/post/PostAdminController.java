package com.fc.fcseoularchive.post;

import com.fc.fcseoularchive.entity.Post;
import com.fc.fcseoularchive.entity.PostStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// todo admin 관련은 admin 패키지에 작성 : merge 할 때 분리
// Auth 관련 parameter 는 제외하고 작성

@RestController
@RequestMapping("/api/admin/verifications")
@RequiredArgsConstructor
public class PostAdminController {

    private final PostService postService;

    // 모든 status 에 대해 param 으로 조회
    @GetMapping("/posts")
    public ResponseEntity<List<PostAdminResponse>> getPostsByStatus(
            @RequestParam(name = "status")PostStatus status
    ) {
        List<PostAdminResponse> response = postService.getPostsByStatus(status);
        return ResponseEntity.ok(response);
    }
}
