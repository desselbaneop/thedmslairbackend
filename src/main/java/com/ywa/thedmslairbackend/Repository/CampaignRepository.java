package com.ywa.thedmslairbackend.Repository;

import com.ywa.thedmslairbackend.Domain.Campaign;
import jakarta.transaction.Transactional;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CampaignRepository extends JpaRepository<Campaign, Integer> {

    @Transactional
    @Modifying
    @Query(
            value = "INSERT INTO campaign_players (player_id, campaign_id) VALUES (?1, ?2) RETURNING player_id;",
            nativeQuery = true
    )
    void addPlayerByPlayerId(int playerId, int campaign_id);

    @Transactional
    @Modifying
    @Query(
            value = "INSERT INTO campaign_admins (player_id, campaign_id) VALUES (?1, ?2) RETURNING player_id;",
            nativeQuery = true
    )
    void addAdminByPlayerId(int playerId, int campaign_id);

    @Transactional
    @Modifying
    @Query(
            value = "DELETE FROM campaign_players WHERE campaign_id = ?1 AND player_id = ?2 RETURNING player_id;",
            nativeQuery = true
    )
    void removePlayerFromCampaignByIds(int campaignId, int playerId);

    @Transactional
    @Modifying
    @Query(
            value = "DELETE FROM campaign_admins WHERE campaign_id = ?1 AND player_id = ?2 RETURNING player_id;",
            nativeQuery = true
    )
    void removeAdminFromCampaignByIds(int campaignId, int playerId);

}
