package com.example.shopclean.member.adapter.out.persistence;

import com.example.shopclean.member.domain.EmailSet;
import com.example.shopclean.member.domain.EmailSetConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "member")
@AllArgsConstructor
@NoArgsConstructor
public class MemberJpaEntity {
    @Id
    @Column(name = "member_id")
    private String id;

    private String name;

    private String password;

    @Column(name = "emails")
    @Convert(converter = EmailSetConverter.class)
    private EmailSet emails;

}
