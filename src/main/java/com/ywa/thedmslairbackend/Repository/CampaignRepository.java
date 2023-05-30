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
            value = "INSERT INTO campaign_users (user_id, campaign_id) VALUES (?1, ?2) RETURNING user_id;",
            nativeQuery = true
    )
    void addPlayerByPlayerId(int playerId, int campaign_id);

    @Transactional
    @Modifying
    @Query(
            value = "INSERT INTO campaign_admins (user_id, campaign_id) VALUES (?1, ?2) RETURNING user_id;",
            nativeQuery = true
    )
    void addAdminByPlayerId(int userId, int campaign_id);

    @Transactional
    @Modifying
    @Query(
            value = "DELETE FROM campaign_users WHERE campaign_id = ?1 AND user_id = ?2 RETURNING user;",
            nativeQuery = true
    )
    void removePlayerFromCampaignByIds(int campaignId, int userId);

    @Transactional
    @Modifying
    @Query(
            value = "DELETE FROM campaign_admins WHERE campaign_id = ?1 AND user_id = ?2 RETURNING user_id;",
            nativeQuery = true
    )
    void removeAdminFromCampaignByIds(int campaignId, int userId);

}
