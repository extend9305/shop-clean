package com.example.shopclean.member.adapter.out.persistence;

import com.example.shopclean.member.domain.Member;
import com.example.shopclean.member.domain.MemberId;
import com.example.shopclean.member.domain.Password;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

    Member mapToDomainEntity (MemberJpaEntity member){
        return Member.withId(
                new MemberId(member.getId()),member.getName(),member.getEmails(),new Password(member.getPassword())
        );
    }
}
