package com.ywa.thedmslairbackend.Payload.Request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CampaignPostPutRequest {

    private String name;

    private String description;

    private int ownerId;
}
