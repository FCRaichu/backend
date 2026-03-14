package com.fc.fcseoularchive.inwooTest;

import com.fc.fcseoularchive.domain.entity.Donation;
import com.fc.fcseoularchive.donation.DonationRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DonationTest {

    @Autowired
    private DonationRepository donationRepository;

    @Test
    @DisplayName("후원 <-> 유저 fetchJoin 테스트")
    public void test1() throws Exception {

        List<Donation> donationAll = donationRepository.getDonationAll();

        for (Donation donation : donationAll) {
            System.out.println("donation = " + donation.getId());
            System.out.println("donation.getPoint() = " + donation.getPoint());
            System.out.println("donation.getUser().getNickname() = " + donation.getUser().getNickname());
            System.out.println("==============");
        }

    }


}
