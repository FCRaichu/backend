package com.fc.fcseoularchive.season_auth.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
public class createSeanauthRequest {

    @NotNull
    private Long userId; // 유저 id

}
