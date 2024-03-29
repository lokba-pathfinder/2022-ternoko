package com.woowacourse.ternoko.core.domain.member;

import java.util.Arrays;
import java.util.Locale;

public enum MemberType {
    COACH,
    CREW;

    public boolean matchType(final String value) {
        return this.name().equals(value.toUpperCase(Locale.ROOT));
    }

    public static boolean existType(final String value) {
        return Arrays.stream(values())
                .anyMatch(type -> type.name().equals(value));
    }

    public boolean isSameType(final MemberType memberType) {
        return this == memberType;
    }
}


