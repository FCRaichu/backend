package com.fc.fcseoularchive.game.querydsl;

import com.fc.fcseoularchive.domain.entity.Game;
import com.fc.fcseoularchive.domain.entity.QGame;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.fc.fcseoularchive.domain.entity.QGame.*;

@RequiredArgsConstructor
public class GameRepositoryImpl implements GameRepositoryQueryDsl {

    private final JPAQueryFactory jpaQueryFactory;


    @Override
    public List<Game> getAll(Integer year, Integer month) {
        return jpaQueryFactory
                .select(game)
                .from(game)
                .where(yearEq(year), monthEq(month))
                .fetch();
    }


    private BooleanExpression yearEq(Integer year) {
        return year != null ? game.date.year().eq(year) : null;
    }

    private BooleanExpression monthEq(Integer month) {
        return month != null ? game.date.month().eq(month) : null;
    }

}
