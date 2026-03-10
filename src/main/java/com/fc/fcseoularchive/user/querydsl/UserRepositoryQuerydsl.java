package com.fc.fcseoularchive.user.querydsl;

import com.fc.fcseoularchive.domain.entity.Seasonauth;
import com.fc.fcseoularchive.domain.entity.User;
import com.fc.fcseoularchive.user.dto.UserResponse;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryQuerydsl {

    List<User> getUserAll();

    Optional<User> selectById(Long id);

    Optional<User> getUser(String userId);


}
