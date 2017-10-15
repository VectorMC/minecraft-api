package net.avicus.minecraft.api.user;

import com.google.common.base.Charsets;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;
import net.avicus.text.StringUtils;

public interface UserUtils {

    Pattern USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9_]{2,16}$");

    static boolean isValidUsername(String username) {
        return USERNAME_PATTERN.matcher(username).matches();
    }

    static boolean isValidId(UUID id) {
        return id.version() != 3;
    }

    static String sanitizeUsername(String username) {
        return StringUtils.truncate(username.replaceAll("[^A-Za-z0-9_]", ""), 16);
    }

    static UUID offlinePlayerId(String username) {
        return UUID.nameUUIDFromBytes(("OfflinePlayer:" + username.toLowerCase(Locale.ROOT)).getBytes(Charsets.UTF_8));
    }
}
