package com.fc.fcseoularchive.rank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AttendanceRankResponse {

    private int rank;
    private String nickname;
    private Long count;


}
