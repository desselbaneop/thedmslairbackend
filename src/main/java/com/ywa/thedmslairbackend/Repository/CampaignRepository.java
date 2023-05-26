package com.ywa.thedmslairbackend.Repository;

import com.ywa.thedmslairbackend.Domain.Campaign;
import com.ywa.thedmslairbackend.Domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CampaignRepository extends JpaRepository<Campaign, Integer> {

    @Query(
            value = "INSERT INTO campaign_players (player_id) VALUES (?1) WHERE campaign_id = ?2 ",
            nativeQuery = true
    )
    ResponseEntity<List<Player>> addPlayerByPlayerId(int playerId, int campaign_id);

    @Query(
            value = "INSERT INTO campaign_admins (player_id) VALUES (?1) WHERE campaign_id = ?2 ",
            nativeQuery = true
    )
    ResponseEntity<Player> addAdminByPlayerId(int playerId, int campaign_id);


/*    @Query(
            value = "SELECT campaign_id FROM campaign_players WHERE player_id = ?1",
            nativeQuery = true)
    List<Integer> findAllByPlayerId(int playerId);*/
}
