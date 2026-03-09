package com.fc.fcseoularchive.season_auth;

import com.fc.fcseoularchive.domain.entity.Seasonauth;
import com.fc.fcseoularchive.domain.entity.User;
import com.fc.fcseoularchive.error.ApiException;
import com.fc.fcseoularchive.season_auth.dto.createSeanauthRequest;
import com.fc.fcseoularchive.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SeasonauthService {

    private final SeasonauthRepository seasonauthRepository;
    private final UserRepository userRepository;


    @Transactional
    public void create(Long id, MultipartFile image) {

        // 회원이 존재하는 사람인지 확인
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "404", "NOT_FOUND", "존재하지 않은 회원입니다."));

        // 파일 확인
        // 파일 저장하고 경로 받아옴
        String imagePath = "이미지 경로";


//        Long id, User user, String image

        Seasonauth seasonauth = new Seasonauth(user, imagePath);
        seasonauthRepository.save(seasonauth);

    }

}
