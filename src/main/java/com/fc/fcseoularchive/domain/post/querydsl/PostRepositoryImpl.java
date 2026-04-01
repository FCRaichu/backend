package com.fc.fcseoularchive.post.querydsl;

import com.fc.fcseoularchive.domain.entity.Post;
import com.fc.fcseoularchive.domain.entity.QGame;
import com.fc.fcseoularchive.domain.entity.QPost;
import com.fc.fcseoularchive.domain.entity.QUser;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.fc.fcseoularchive.domain.entity.QGame.*;
import static com.fc.fcseoularchive.domain.entity.QPost.*;
import static com.fc.fcseoularchive.domain.entity.QUser.*;

@RequiredArgsConstructor
@Repository
public class PostRepositoryImpl implements PostRepositoryQueryDsl {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public boolean existsByUserIdAndGameId(String userId, Long gameId) {
        QPost post = QPost.post;
        QUser user = QUser.user;
        QGame game = QGame.game;

        return jpaQueryFactory
                .selectOne()
                .from(post)
                .join(post.user, user) // exist 는 fetch join 이 필요없다
                .join(post.game, game)
                .where(
                        post.user.id.eq(userId),
                        post.game.id.eq(gameId)
                )
                .fetchFirst() != null;
    }

    @Override
    public List<Post> findByUser_Id(String userId) {
        QPost post = QPost.post;
        QUser user = QUser.user;
        QGame game = QGame.game;

        return jpaQueryFactory
                .selectFrom(post)
                .distinct()
                .join(post.user, user).fetchJoin()
                .join(post.game, game).fetchJoin()
                .where(post.user.id.eq(userId))
                .fetch();
    }

    @Override
    public List<Post> getPostAll(String loginId) {
        return jpaQueryFactory
                .select(post)
                .from(post)
                .leftJoin(post.user, user).fetchJoin()
                .leftJoin(post.game, game).fetchJoin()
                .where(post.user.id.eq(loginId))
                .fetch();
    }
}
