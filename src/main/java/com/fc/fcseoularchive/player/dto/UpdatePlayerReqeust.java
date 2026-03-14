package com.fc.fcseoularchive.player.dto;

import com.fc.fcseoularchive.domain.enums.PlayerStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
public class UpdatePlayerReqeust {

    private Integer backNumber;

    private MultipartFile image;

    private PlayerStatus status;

}


