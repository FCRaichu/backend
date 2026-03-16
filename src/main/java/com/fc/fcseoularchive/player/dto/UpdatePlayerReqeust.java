package com.fc.fcseoularchive.player.dto;

import com.fc.fcseoularchive.domain.enums.PlayerPosition;
import com.fc.fcseoularchive.domain.enums.PlayerStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
public class UpdatePlayerReqeust {

    private Integer backNumber;

    private PlayerPosition position;
    
    private PlayerStatus status;

    private MultipartFile image;

}


