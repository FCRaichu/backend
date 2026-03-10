package com.fc.fcseoularchive.admin;

import com.fc.fcseoularchive.domain.entity.User;
import com.fc.fcseoularchive.season_auth.SeasonauthService;
import com.fc.fcseoularchive.season_auth.dto.SeasonResponse;
import com.fc.fcseoularchive.user.dto.UserResponse;
import com.fc.fcseoularchive.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "0. AdminController")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminController {

    private final UserService userService;
    private final SeasonauthService seasonauthService;

    @Operation(summary = "회원 전체 조회")
    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAll());
    }

    @Operation(summary = "시즌권 전체 수락 (PENDING->APPROVED)")
    @PostMapping("/season-auth/approveAll")
    public ResponseEntity<Void> approveAll(){
        seasonauthService.approveAll();
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }


    @Operation(summary = "시즌권 대기 전체 조회")
    @GetMapping("/season-auth/pending")
    public ResponseEntity<List<SeasonResponse>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(seasonauthService.getAll());
    }


    @Operation(summary = "시즌권 수락 단건")
    @PostMapping("/season-auth/approved/{seasonAuthId}")
    public ResponseEntity<Void> approve(@PathVariable Long seasonAuthId){
        seasonauthService.approve(seasonAuthId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @Operation(summary = "시즌권 거절 단건")
    @PostMapping("/season-auth/rejected/{seasonAuthId}")
    public ResponseEntity<Void> rejected(@PathVariable Long seasonAuthId){
        seasonauthService.rejected(seasonAuthId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
