package com.fc.fcseoularchive.user.dto;

import com.fc.fcseoularchive.domain.entity.Seasonauth;
import com.fc.fcseoularchive.domain.entity.User;
import com.fc.fcseoularchive.domain.enums.Role;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponse {

    private Long id;

    private String userId;

    private String nickname;

    private Role role;

    private Integer points;

    private Integer seasonTicket;


    public UserResponse(Long id, String userId, String nickname, Role role, Integer points, Integer seasonTicket) {
        this.id = id;
        this.userId = userId;
        this.nickname = nickname;
        this.role = role;
        this.points = points;
        this.seasonTicket = seasonTicket;
    }

}
