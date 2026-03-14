package com.fc.fcseoularchive.player;

import com.fc.fcseoularchive.domain.entity.Player;
import com.fc.fcseoularchive.player.dto.CreatePlayerRequest;
import com.fc.fcseoularchive.player.dto.PlayerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;

    private final String uploadDir = System.getProperty("user.dir") + "/upload/player";

    @Transactional
    public void createPlayer(CreatePlayerRequest req) throws IOException {

        // 업로드 폴더 없으면 폴더 생성
        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // 이미지가 null이 아니고, 비어있지 않다면
        String imagePath = null;
        if (req.getImage() != null && !req.getImage().isEmpty()) {
            String fileName = UUID.randomUUID() + "_" + req.getImage().getOriginalFilename(); // UUID_파일 이름으로 파일 이름 지정해주기
            File dest = new File(uploadDir, fileName); // 경로/fileName 으로 파일 만듦
            req.getImage().transferTo(dest); // 실제 파일 저장해두기
            imagePath = "/upload/player/" + fileName; // 이렇게 해야 db에 저장을 상대경로로 저장해서 프론트에서 바로 사용 가능함 !
        }

        // 객체 생성
        Player player = new Player(req, imagePath);
        playerRepository.save(player);
    }

    public List<PlayerResponse> getAllPlayers() {
        return playerRepository.findAll()
                .stream()
                .map( p -> new PlayerResponse(p) )
                .toList();
    }


}
