package com.vaibhav.Agora.Common.Utils;

import com.sun.istack.Nullable;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

public class Utilities {

    public static boolean isNotEmpty(@Nullable Collection<?> collectionObject) {
        return !CollectionUtils.isEmpty(collectionObject);
    }
}
