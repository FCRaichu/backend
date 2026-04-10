package com.fc.fcseoularchive.sangminTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.time.LocalDateTime;

public class BetTest {

    @Test
    @DisplayName("현재 베팅 게임 정보 반환")
    public void test1() throws Exception {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
    }
}
