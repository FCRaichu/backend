package com.fc.fcseoularchive.user.querydsl;


import com.fc.fcseoularchive.domain.entity.QSeasonauth;
import com.fc.fcseoularchive.domain.entity.QUser;
import com.fc.fcseoularchive.domain.entity.Seasonauth;
import com.fc.fcseoularchive.domain.entity.User;
import com.fc.fcseoularchive.user.dto.UserResponse;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import static com.fc.fcseoularchive.domain.entity.QSeasonauth.seasonauth;
import static com.fc.fcseoularchive.domain.entity.QUser.user;


/**
 * 처음에 그냥 join 을 처음 시도
 * NOT_FOUND 에러 발생 왜?
 * <p>
 * 의도한 동작 : 회원 조회
 * * 시즌권이 없으면 시즌권은 null 로 반환
 * * 시즌권이 있으면 시즌권을 반환
 * <p>
 * 문제점?
 * 시즌권이 없으면 조회 자체가 불가능했음
 * -> join 할 때 시즌권 엔티티에 있는 유저의 id 와 User 의 id 가 같은것을 대상으로 join 을 함
 * join
 * season_auth s1_0
 * on u1_0.id=s1_0.user_id 처럼 쿼리 발생 따라서 시즌권 등록을 하지 않은 유저는 자연스럽게 포함되지 않음
 * <p>
 * 해결 방법?
 * leftJoin 을 하기!
 * 그렇다면 User를 모두 가져온 상황에서 시즌권을 끼워 맞추는 거라서 의도한대로 동작 가능
 * <p>
 * + 시즌권이 없을 수도 있어서 Optional 타입을 쓰기 위해 Optional.ofNullable() 로 타입 변환을 해줘야함.
 */

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryQuerydsl {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<User> getUserAll() {
        return jpaQueryFactory
                .select(user)
                .from(user)
                .leftJoin(user.seasonauth, seasonauth).fetchJoin() // User <-> sseasonauth 패치조인
                .fetch();
    }

    @Override
    public Optional<User> selectById(Long id) {
        return Optional.ofNullable(
                jpaQueryFactory
                        .select(user)
                        .from(user)
                        .leftJoin(user.seasonauth, seasonauth).fetchJoin()
                        .where(user.id.eq(id))
                        .fetchOne()
        );
    }

    @Override
    public Optional<User> getUser(String userId) {
        return Optional.ofNullable(
                jpaQueryFactory
                        .select(user)
                        .from(user)
                        .leftJoin(user.seasonauth, seasonauth).fetchJoin()
                        .where(user.userId.eq(userId))
                        .fetchOne()
        );
    }
}
