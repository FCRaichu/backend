package com.fc.fcseoularchive.donation;


import com.fc.fcseoularchive.domain.entity.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationRepository extends JpaRepository<Donation,Long> {

}
