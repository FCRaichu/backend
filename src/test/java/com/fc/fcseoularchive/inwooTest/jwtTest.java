package com.fc.fcseoularchive.inwooTest;

import com.fc.fcseoularchive.config.jwt.JwtToken;
import com.fc.fcseoularchive.config.jwt.JwtTokenProvider;
import com.fc.fcseoularchive.config.redis.RedisDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * SecurityContext
 * └─ Authentication
 * ├─ principal -> UserDetail 이 들어감
 * [Username=inwoo, Password=[PROTECTED],
 * Enabled=true, AccountNonExpired=true,
 * CredentialsNonExpired=true, AccountNonLocked=true, Granted Authorities=[ADMIN]]
 * ├─ credentials
 * └─ authorities
 * 처럼 구조되어있음
 * <p>
 * 시큐리티 컨텍스트는 로컬스레드로 관리되며
 * 하나의 동작이 끝나면 clear 후 스레드 반환하는 방식으로 동작함
 * <p>
 * Authenticatin 을 만들기 위해 생성하랴고 보니
 * principal, credential,  + authorities (이건 추가 넣고싶은거 ex: ROLE_USER, ROLE_ADMIN 등)
 * principal : 누구? (id)
 * credentials : 뭐로 인증? (비밀번호)
 * authorities : 뭐 할수있음? (동작
 */

@SpringBootTest
public class jwtTest {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    // 가짜 레디스
    @MockBean
    private RedisDao redisDao;

    @Test
    @DisplayName("uuid 하나 아무꺼나 쓰기 jwt secret에 넣을 것")
    public void test1() {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString());
    }

    @Test
    @DisplayName("토큰 생성 테스트")
    public void test2() {

        // 토큰 생성
        Date date = new Date(System.currentTimeMillis() + 36000);
        String accessToken = jwtTokenProvider.generateAccessToken("inwoo", "ADMIN", date);
        System.out.println(accessToken);
    }


    @Test
    @DisplayName("토큰 Access, Refresh 생성 테스트")
    void test3() {
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                "inwoo",
                null,
                List.of(new SimpleGrantedAuthority("ADMIN"))
        );

        JwtToken jwtToken = jwtTokenProvider.generateToken(authentication);

        System.out.println(jwtToken.getAccessToken());
        System.out.println(jwtToken.getRefreshToken());

        String userNameFromToken = jwtTokenProvider.getUserNameFromToken(jwtToken.getAccessToken());
        System.out.println(userNameFromToken);

    }

    @Test
    @DisplayName("토큰 복호화")
    public void test4() {
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                "inwoo",
                null,
                List.of(new SimpleGrantedAuthority("ADMIN"), new SimpleGrantedAuthority("메롱!"))
        );

        JwtToken jwtToken = jwtTokenProvider.generateToken(authentication);

        String accessToken = jwtToken.getAccessToken();

        Authentication authentication1 = jwtTokenProvider.getAuthentication(accessToken); // 복호화

        Assertions.assertEquals(
                "inwoo",
                ((UserDetails) authentication1.getPrincipal()).getUsername()
        );

        Collection<? extends GrantedAuthority> authorities = ((UserDetails) authentication1.getPrincipal()).getAuthorities();
        for (GrantedAuthority authority : authorities) {
            System.out.println("authority = " + authority);
        }


    }

    @Test
    @DisplayName("리프레시 토큰 삭제")
    public void test5() {
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                "inwoo",
                null,
                List.of(new SimpleGrantedAuthority("ADMIN"))
        );
        JwtToken jwtToken = jwtTokenProvider.generateToken(authentication);

        jwtTokenProvider.deleteRefreshToken(jwtTokenProvider.getUserNameFromToken(jwtToken.getRefreshToken())); // 토큰 삭제

        jwtTokenProvider.validateRefreshToken(jwtTokenProvider.getUserNameFromToken(jwtToken.getRefreshToken())); // 오류 예상?

    }


    @Test
    @DisplayName("메롱 토큰 확인")
    public void test6() throws Exception {
        Date date = new Date(System.currentTimeMillis() + 36000);

//        String s = jwtTokenProvider.generateAccessTokenTest("inwoo", "메롱", "ADMIN", date);

//        System.out.println("s = " + s);

        // 토큰 복호화
//        Authentication authentication = jwtTokenProvider.getAuthenticationTest(s);
//        System.out.println(authentication.getPrincipal());

    }


}
