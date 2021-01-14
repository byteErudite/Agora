package com.vaibhav.Agora.Common.Utils;

import java.util.Objects;

public class StringUtilities {

    public static boolean isNotEmpty(String string) {
        return Objects.nonNull(string) && !string.isEmpty();
    }
}
