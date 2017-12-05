package net.avicus.minecraft.api.command;

import net.avicus.minecraft.api.permissions.Permissible;
import net.md_5.bungee.api.chat.BaseComponent;

public interface CommandSender extends Permissible {

    /**
     * Get the unique name of this command sender.
     *
     * @return the senders username
     */
    String getName();

    default String getName(CommandSender viewer) {
        return getName();
    }

    /**
     * Send a message to this sender.
     *
     * @param message the message to send
     * @deprecated use components
     */
    @Deprecated
    void sendMessage(String message);

    default void sendMessage(String[] message) {
        for(String line : message) sendMessage(line);
    }

    /**
     * Send a message to this sender.
     *
     * @param message the message to send
     */
    void sendMessage(BaseComponent... message);

    /**
     * Gets the locale this command source is currently using.
     *
     * <p>This is {@link java.util.Locale#US} by default.</p>
     *
     * @return the locale
     */
    default java.util.Locale getLocale() {
        return java.util.Locale.US;
    }

    /**
     * Send a message to this sender.
     *
     * @param message the message to send
     */
    void sendMessage(BaseComponent message);
}
