package com.example.shopclean.member.domain;

import jakarta.persistence.Convert;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Member {
    @Getter
    private final MemberId memberId;

    @Getter
    private final Password password;

    @Getter
    private final String name;

    @Getter
    @Convert(converter = EmailSetConverter.class)
    private final EmailSet emails;

    public static Member withId(MemberId memberId, String name, EmailSet emails, Password password) {
        return new Member(memberId,password,name,emails);
    }
}
