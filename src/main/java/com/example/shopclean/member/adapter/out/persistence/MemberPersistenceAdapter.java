package com.example.shopclean.member.adapter.out.persistence;

import com.example.shopclean.member.application.port.out.LoadMemberPort;
import com.example.shopclean.member.domain.Member;
import com.example.shopclean.member.domain.MemberId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MemberPersistenceAdapter implements LoadMemberPort {
    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    @Override
    public Member loadMember(MemberId memberId) {
        Optional<MemberJpaEntity> member = memberRepository.findById(memberId.getId());
        return member.map(memberMapper::mapToDomainEntity).orElse(null);
    }
}
