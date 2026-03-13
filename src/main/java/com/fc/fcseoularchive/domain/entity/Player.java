package com.fc.fcseoularchive.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Entity
@Table(name = "players")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(nullable = false)
    private String name;

    @JoinColumn(name = "back_number", nullable = false)
    private Integer backNumber;

    @Column(nullable = false, length = 512)
    private String profileImage;

}
