package com.example.shopclean.member.domain;

import java.io.Serializable;
import java.util.Objects;

public class MemberId implements Serializable {
    private String id;

    protected MemberId() {
    }

    public MemberId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberId memberId = (MemberId) o;
        return Objects.equals(id, memberId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static MemberId of(String id) {
        return new MemberId(id);
    }
}
