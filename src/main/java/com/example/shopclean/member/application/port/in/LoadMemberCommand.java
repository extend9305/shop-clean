package com.example.shopclean.member.application.port.in;

import com.example.shopclean.member.domain.MemberId;
import lombok.Value;

@Value
public class LoadMemberCommand {
    private MemberId memberId;
}
