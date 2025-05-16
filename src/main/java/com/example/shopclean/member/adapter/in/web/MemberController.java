package com.example.shopclean.member.adapter.in.web;

import com.example.shopclean.member.application.port.in.LoadMemberCommand;
import com.example.shopclean.member.application.port.in.LoadMemberUseCase;
import com.example.shopclean.member.domain.Member;
import com.example.shopclean.member.domain.MemberId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final LoadMemberUseCase loadMemberUseCase;

    @GetMapping("/members/{memberId}")
    LoadMemberResponse loadMember(@PathVariable String memberId) {
        Member member = loadMemberUseCase.loadMember(new LoadMemberCommand(new MemberId(memberId)));
        return new LoadMemberResponse(member.getMemberId().getId(),member.getName());
    }
}
