package com.fc.fcseoularchive.admin;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/test")
public class TestController {

    /**
     * 권한이나 이름 잘꺼내지는지 테스트
     */
    @GetMapping
    public ResponseEntity<TestDto> test(Authentication authentication) {
        Jwt jwt = (Jwt) authentication.getPrincipal();

        String username = jwt.getClaimAsString("preferred_username"); // 유저 네임 꺼내는 방법

        Map<String, Object> realmAccess = jwt.getClaimAsMap("realm_access");

        List<String> roles = List.of();
        if (realmAccess != null && realmAccess.get("roles") instanceof List<?> roleList) {
            roles = roleList.stream()
                    .filter(obj -> String.class.isInstance(obj))
                    .map(obj1 -> String.class.cast(obj1))
                    .toList();
        }

        return ResponseEntity.ok(new TestDto(username, roles));
    }

    // 테스트용 DTO
    public record TestDto(
            String username,
            List<String> roles
    ) {
    }


}
