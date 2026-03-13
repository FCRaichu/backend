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

    @Operation(summary = "경기 전체 일정 조회")
    @GetMapping("/all")
    public ResponseEntity<List<GameResponse>> getGames() {
        List<GameResponse> response = gameService.getAllGames(null, null);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "경기 전체 일정 조회 (년, 월 필터링)")
    @GetMapping
    public ResponseEntity<List<GameResponse>> getGames(
            @RequestParam Integer year,
            @RequestParam Integer month
    ) {
        List<GameResponse> response = gameService.getAllGames(year, month);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "경기 전체 일정 조회 - 로그인 전 (년, 월 필터링)")
    @GetMapping("/guest")
    public ResponseEntity<List<GameResponse>> getGamesForGuest(
            @RequestParam Integer year,
            @RequestParam Integer month
    ) {
        List<GameResponse> response;

        response = gameService.getAllGamesForGuestByYear(year, month);

        return ResponseEntity.ok(response);
    }



}
