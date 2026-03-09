package com.fc.fcseoularchive.post;

import com.fc.fcseoularchive.domain.entity.Post;
import com.fc.fcseoularchive.domain.enums.PostStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostAdminResponse {
    private Long verificationId;
    private Long postId;
    private String nickname;
    private Long gameId;
    private String gameTitle;
    private String ticketImage;
    private PostStatus status;
    private LocalDateTime createdAt;

    public static PostAdminResponse from(Post post) {
        PostAdminResponse response = new PostAdminResponse();

        // verificationId 와 postId 가 뭐가 다른거지?
        response.setVerificationId(post.getId());
        response.setPostId(post.getId());
        response.setNickname(post.getUser().getNickname());
        response.setGameId(post.getGame().getId());
        response.setGameTitle(post.getTitle());
        response.setTicketImage(post.getTicketImage());
        response.setStatus(post.getStatus());
        response.setCreatedAt(post.getCreatedAt());
        return response;
    }
}
