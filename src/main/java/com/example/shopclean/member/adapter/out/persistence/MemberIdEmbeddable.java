package com.example.shopclean.member.adapter.out.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.Objects;

@Getter
@Embeddable
public class MemberIdEmbeddable {
    @Column(name = "member_id")
    private String id;

    protected MemberIdEmbeddable(){

    }
    public MemberIdEmbeddable(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberIdEmbeddable memberIdEmbeddable = (MemberIdEmbeddable) o;
        return Objects.equals(id, memberIdEmbeddable.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static MemberIdEmbeddable of(String id) {
        return new MemberIdEmbeddable(id);
    }
}
