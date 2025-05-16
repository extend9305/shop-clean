package com.example.shopclean.member.application.port.out;

import com.example.shopclean.member.domain.Member;
import com.example.shopclean.member.domain.MemberId;

public interface LoadMemberPort {
    Member loadMember(MemberId memberId);
}
