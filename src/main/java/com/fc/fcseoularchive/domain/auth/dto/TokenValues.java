package com.fc.fcseoularchive.domain.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * 캐시 value 에 들어가는 타입
 *
 * 기존 String[] 으로 만들어놨지만 가독성이 너무 떨어져서 만듦
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TokenValues {

    String refreshToken;
    String idToken;

}