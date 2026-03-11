package com.fc.fcseoularchive.season_auth;


import com.fc.fcseoularchive.domain.entity.Seasonauth;
import com.fc.fcseoularchive.season_auth.dto.SeasonResponse;
import com.fc.fcseoularchive.season_auth.dto.createSeanauthRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Tag(name = "3. SeasonAuthController")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/season-auth")
public class SeasonauthController {

    private final SeasonauthService seasonauthService;

    @Operation(summary = "시즌권 신청")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> createSeasonauth(@RequestParam Long id, @NotNull @RequestPart MultipartFile image) throws IOException {
        seasonauthService.create(id, image);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
