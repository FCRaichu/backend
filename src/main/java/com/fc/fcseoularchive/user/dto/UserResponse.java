package com.fc.fcseoularchive.user.dto;

import com.fc.fcseoularchive.domain.entity.User;
import com.fc.fcseoularchive.domain.enums.Role;
import lombok.Getter;

@Getter
public class UserResponse {

    private final Long id;

    private final String userId;

    private final String nickname;

    private final Role role;

    private final Integer points;

    private final Integer seasonAuth;


    public UserResponse(User user, Integer seasonAuth) {
        this.id = user.getId();
        this.userId = user.getUserId();
        this.nickname = user.getNickname();
        this.role = user.getRole();
        this.points = user.getPoints();
        this.seasonAuth = seasonAuth;
    }



}
