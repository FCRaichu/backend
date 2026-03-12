package com.fc.fcseoularchive.game;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "2. GameController", description = "경기 관련 API")
@RestController
@RequestMapping("/api/games")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @Operation(summary = "경기 전체 일정 조회 (연도별 필터링 가능)")
    @GetMapping
    public ResponseEntity<List<GameResponse>> getGames(@RequestParam(required = false) Integer year) {
        List<GameResponse> response = gameService.getAllGames(year);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "경기 전체 일정 조회 - 로그인 전 (연도별 필터링 가능)")
    @GetMapping("/guest")
    public ResponseEntity<List<GameResponse>> getGamesForGuest(@RequestParam(required = false) Integer year) {
        List<GameResponse> response;

        if (year != null) {
            response = gameService.getAllGamesForGuestByYear(year);
        } else {
            response = gameService.getAllGamesForGuest();
        }

        return ResponseEntity.ok(response);
    }



}
