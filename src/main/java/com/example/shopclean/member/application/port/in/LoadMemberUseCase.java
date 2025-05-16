package com.example.shopclean.member.application.port.in;

import com.example.shopclean.member.domain.Member;


public interface LoadMemberUseCase {
    Member loadMember(LoadMemberCommand loadMemberCommand);
}
