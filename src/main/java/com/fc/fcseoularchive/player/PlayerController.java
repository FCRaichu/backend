package com.fc.fcseoularchive.player;

import com.fc.fcseoularchive.domain.entity.Player;
import com.fc.fcseoularchive.player.dto.CreatePlayerRequest;
import com.fc.fcseoularchive.player.dto.PlayerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@Tag(name = "4. PlayerController")
@RequestMapping("/api/players")
@RestController
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;


    // todo 나중에 admin 으로 옮겨야함
    @Operation(summary = "선수 생성 API")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> createPlayer(@Valid @ModelAttribute CreatePlayerRequest req) throws IOException {
        playerService.createPlayer(req);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "선수 전체 조회 (현역/임대/은퇴 모두)")
    @GetMapping
    public ResponseEntity<List<PlayerResponse>> getAllPlayers() {
        return ResponseEntity.status(HttpStatus.OK).body(playerService.getAllPlayers());
    }

    @Operation(summary = "선수 단건 조회")
    @GetMapping("/{id}")
    public ResponseEntity<PlayerResponse> getPlayer(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(playerService.getPlayer(id));
    }





}
