package com.fc.fcseoularchive.player.dto;

import com.fc.fcseoularchive.domain.entity.Player;
import lombok.Getter;

@Getter
public class PlayerResponse {

    private final Integer id;

    private final String name;

    private final Integer backNumber;

    private final String image;

    private final String status;


    public PlayerResponse(Player player) {
        this.id = player.getId();
        this.name = player.getName();
        this.backNumber = player.getBackNumber();
        this.image = player.getImage(); // 상대 경로 그대로 줌 (프론트에서 앞에 서버 주소 붙여줘야해!)
        this.status = player.getStatus().toString();
    }
}
