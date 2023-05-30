package com.ywa.thedmslairbackend.Payload.Request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CharacterPostPutRequest {

    private String name;
    private String description;
    private String backstory;
    private String imgURL;
    private int userId;
}
