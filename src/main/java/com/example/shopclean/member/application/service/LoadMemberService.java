package com.example.shopclean.member.application.service;

import com.example.shopclean.member.application.port.in.LoadMemberCommand;
import com.example.shopclean.member.application.port.in.LoadMemberUseCase;
import com.example.shopclean.member.application.port.out.LoadMemberPort;
import com.example.shopclean.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoadMemberService implements LoadMemberUseCase {
    private final LoadMemberPort loadMemberPort;

    @Override
    public Member loadMember(LoadMemberCommand loadMemberCommand) {
        return loadMemberPort.loadMember(loadMemberCommand.getMemberId());
    }
}
