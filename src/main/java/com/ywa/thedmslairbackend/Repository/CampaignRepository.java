package com.ywa.thedmslairbackend.Repository;

import com.ywa.thedmslairbackend.Domain.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<Campaign, Integer> {
}
