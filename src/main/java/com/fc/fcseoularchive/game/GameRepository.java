package com.fc.fcseoularchive.game;

import com.fc.fcseoularchive.domain.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    // 오름차순 날짜로 모든 경기 조회
    List<Game> findAllByOrderByDateAsc();
}
