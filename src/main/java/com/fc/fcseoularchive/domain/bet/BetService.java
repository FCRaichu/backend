package com.fc.fcseoularchive.domain.bet;

import com.fc.fcseoularchive.domain.bet.dto.BetCreateRequest;
import com.fc.fcseoularchive.domain.bet.dto.BetResponse;
import com.fc.fcseoularchive.domain.bet.dto.BetSummaryResponse;
import com.fc.fcseoularchive.domain.game.Game;
import com.fc.fcseoularchive.domain.game.GameRepository;
import com.fc.fcseoularchive.global.error.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BetService {

    private final BetRepository betRepository;
    private final BetHistoryRepository betHistoryRepository;
    private final GameRepository gameRepository;

    public BetSummaryResponse getBetSummary(String loginId) {
        // loginId로 bet_history 에서 찾기

        List<BetHistory> betHistoryList = betHistoryRepository.findAllByUser_Id(loginId);

        BetSummaryResponse response = new BetSummaryResponse();

        long totalNumber = 0L; // 본인이 베팅에 참여한 경기 수
        long gain = 0L;
        long loss = 0L;

        for (BetHistory history : betHistoryList) {
            long benefit = history.getPayoutPoint();

            totalNumber++;
            if (benefit > 0) gain += benefit;
            else loss += benefit * -1;
        }

        response.setUserId(loginId);
        response.setTotalNumber(totalNumber);
        response.setGain(gain);
        response.setLoss(loss);

        return response;

    }

    public BetResponse getBet(String loginId) {

        LocalDateTime now = LocalDateTime.now();
        //LocalDateTime now = LocalDateTime.of(2026, 3, 17, 13, 0, 0); // 베팅 gameId=3 테스트용
        //LocalDateTime now = LocalDateTime.of(2028, 3, 17, 13, 0, 0); // 베팅 경기 없는 테스트용

        BetResponse response = new BetResponse();

        response.setUserId(loginId);

        // 현재 시각으로 현재 베팅중인 경기 구하기
        // 현재시각 < 경기 시각 을 만족하는 경기 중 가장 날짜가 작은 경기 구하기
        Game game = gameRepository.findFirstByDateAfterOrderByDateAsc(now) // gameId : 3
                .orElse(null);

        if (game == null) return response; // bet 중인 경기가 없으면 유저 아이디만 반환, 나머지는 null 이나 기본값

        // gameId가 있으니 bet 에서 포인트 정보, games 에서 opponent, date 가져오기

        Bet bet = betRepository.findByGame_Id(game.getId())
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "404", "NOT_FOUND", "경기에 대응하는 베팅 정보가 DB에 존재하지 않습니다."));


        String opponent = game.getHomeTeam().equals("FC서울") ? game.getAwayTeam() : game.getHomeTeam();

        response.setBetId(bet.getId());
        response.setGameId(game.getId());
        response.setGameDate(game.getDate());
        response.setOpponent(opponent);

        response.setTotalBettors(bet.getBettors());
        response.setTotalPoint(bet.getTotalPoint());
        response.setWinPoint(bet.getWinPoint());
        response.setDrawPoint(bet.getDrawPoint());
        response.setLosePoint(bet.getLosePoint());



        return response;
    }

   /* public Void createBet(String loginId, BetCreateRequest request) {
        // todo

    }*/
}
