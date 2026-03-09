package com.fc.fcseoularchive.season_auth;

import com.fc.fcseoularchive.domain.entity.Seasonauth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SeasonauthRepository extends JpaRepository<Seasonauth,Long> {

}
