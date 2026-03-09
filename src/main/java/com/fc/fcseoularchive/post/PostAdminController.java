package com.fc.fcseoularchive.post;

import com.fc.fcseoularchive.entity.PostStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* todo status, ticket_image 테이블 분리했으니 admin의 기능도 수정 필요 */


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


    // 직관 인증 수락 - 200 ok
    @PostMapping("/posts/{postAuthId}/approve")
    public ResponseEntity<Void> approvePost(
            @PathVariable Long postAuthId
    ) {
        postService.ApprovePost(postAuthId);
        return ResponseEntity.ok().build();
    }

    // 직관 인증 거절 - 204 No Content
    @PostMapping("/posts/{postAuthId}/reject")
    public ResponseEntity<Void> rejectPost(
            @PathVariable Long postAuthId
    ) {
        postService.RejectPost(postAuthId);
        return ResponseEntity.noContent().build();
    }

    // 직관 인증 게시물 pending 으로 되돌리기 - 개발자용
    @PostMapping("/posts/{postAuthId}/pending")
    public ResponseEntity<Void> resetPostToPending(
            @PathVariable Long postAuthId
    ) {
        postService.resetPostToPending(postAuthId);
        return ResponseEntity.ok().build();
    }

    // 직관 인증 게시물 draft 로 되돌리기 - 개발자용
    @PostMapping("/posts/{postAuthId}/draft")
    public ResponseEntity<Void> resetPostToDraft(
            @PathVariable Long postAuthId
    ) {
        postService.resetPostToDraft(postAuthId);
        return ResponseEntity.ok().build();
    }




}
