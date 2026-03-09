package com.fc.fcseoularchive.game;

import com.fc.fcseoularchive.domain.entity.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GameService {

    private final GameRepository gameRepository;

    // 최신 경기 순으로 모든 경기 일정 정보 반환
    public List<GameResponse> getAllGames() {
        List<Game> games = gameRepository.findAllByOrderByDateAsc();

        return games.stream().map(game -> {
            GameResponse response = new GameResponse();

            response.setId(game.getId());
            response.setDate(game.getDate());
            response.setRound(game.getRound());
            response.setHomeTeam(game.getHomeTeam());
            response.setAwayTeam(game.getAwayTeam());
            response.setStadium(game.getStadium());
            response.setHomeScore(game.getHomeScore());
            response.setAwayScore(game.getAwayScore());

            // 상대팀 찾기 : 홈팀이 "FC Seoul" 이 아니면 awayTeam 이 opponent
            String opponent = game.getHomeTeam().equals("FC Seoul") ? game.getAwayTeam() : game.getHomeTeam();
            response.setOpponent(opponent);

            // 경기 결과 (W, D, L) 가 null 이면 "경기 전"
            response.setStatus(game.getResult() == null ? "SCHEDULED" : "FINISHED");

            // 경기 결과가 null 이 아니면 String 으로 변환 해서 반환
            response.setResult(game.getResult() != null ? game.getResult().toString() : null);

            /* todo db(image db? 아니면 로고 db 새로 생성?) 에서 FC Seoul 과 opponent 등 필요한 이미지 불러 오는 작업 필요
            */
            response.setImages(new ArrayList<>()); // 일단 빈 리스트 처리

            return response;
        }).collect(Collectors.toList());
    }
}
