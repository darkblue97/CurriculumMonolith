package com.darkblue97.curriculummonolith.utils;

import java.util.UUID;
import java.util.regex.Pattern;

public class GenerationUUID {
    private static final String REGEX_UUID = "^[0-9a-fA-F]{8}\b-[0-9a-fA-F]{4}\b-[0-9a-fA-F]{4}\b-[0-9a-fA-F]{4}\b-[0-9a-fA-F]{12}$";
    private static final Pattern UUID_REGEX_PATTERN = Pattern.compile(REGEX_UUID);

    public static UUID generate() {
        return UUID.randomUUID();
    }

    public static boolean isUUIDValid(String uuid) {
        if (uuid == null) {
            return false;
        }
        return UUID_REGEX_PATTERN.matcher(uuid).matches();
    }
}
