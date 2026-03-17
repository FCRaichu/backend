package com.fc.fcseoularchive.post.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class PostGetAllResponse {

    private final List<PostResponse> posts;

    private final int win;

    private final int draw;

    private final int lose;

    private final float winRate;

    private final float drawRate;

    private final float loseRate;

    public PostGetAllResponse(List<PostResponse> posts, int win, int draw, int lose, float winRate, float drawRate, float loseRate) {
        this.posts = posts;
        this.win = win;
        this.draw = draw;
        this.lose = lose;
        this.winRate = winRate;
        this.drawRate = drawRate;
        this.loseRate = loseRate;
    }
}
