package com.fc.fcseoularchive.game.querydsl;

import com.fc.fcseoularchive.domain.entity.Game;

import java.util.List;

public interface GameRepositoryQueryDsl {

    List<Game> getAll(Integer year, Integer month);

}
