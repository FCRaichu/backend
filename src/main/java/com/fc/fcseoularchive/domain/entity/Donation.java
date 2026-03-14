package com.fc.fcseoularchive.domain.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/** User <-> Player 후원 N:M 중간 다리 테이블 */
@Entity
@Table(name = "donation")
@NoArgsConstructor
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer point;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    private Player player;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist(){
        createdAt = LocalDateTime.now();
    }

    public Donation(Integer point, User user, Player player) {
        this.point = point;
        this.user = user;
        this.player = player;
    }

    public void addPoint(Integer point) {
        this.point += point;
    }

}
