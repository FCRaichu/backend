package com.fc.fcseoularchive.domain.auth;

import com.fc.fcseoularchive.domain.auth.dto.TokenValues;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@CacheConfig(cacheNames = "refreshTokens")
public class TokenCacheService {

    /**
     * TokenValues
     *      .refreshToken
     *      .idToken : 로그인 시 발급되는 id_token -> 로그 아웃 시 필요함
     *
     * Put : 저장
     * able : 가져오기
     * Evict : 삭제
     */
    @CachePut(key = "#userId")
    public TokenValues saveRefreshToken(String userId, TokenValues tokenValues) {

        log.info("캐시 저장 - userId: {}", userId);
        log.info("캐시 저장 - refreshToken: {}", tokenValues.getRefreshToken());
        log.info("캐시 저장 - idToken: {}", tokenValues.getIdToken());

        return tokenValues;
    }

    @Cacheable(key = "#userId")
    public TokenValues getRefreshToken(String userId) {
        return null;  // 캐시 미스 시 null 반환
    }

    @CacheEvict(key = "#userId")
    public TokenValues removeRefreshToken(String userId) {
        return null;
    }



}
