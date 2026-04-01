package com.fc.fcseoularchive.user.dto;

import com.fc.fcseoularchive.domain.entity.User;
import com.fc.fcseoularchive.domain.enums.Role;
import lombok.Getter;

@Getter
public class UserResponse {

    private final String id;

    private final String nickname;

    private final Role role;

    private final Integer points;


    public UserResponse(User user) {
        this.id = user.getId();
        this.nickname = user.getNickname();
        this.role = user.getRole();
        this.points = user.getPoints();
    }



}
