package com.fc.fcseoularchive.domain.bet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BetHistoryRepository extends JpaRepository<BetHistory, Long> {
}
