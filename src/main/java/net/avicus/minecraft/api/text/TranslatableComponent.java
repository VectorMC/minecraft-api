package net.avicus.minecraft.api.text;

import net.avicus.minecraft.api.command.CommandSender;
import net.md_5.bungee.api.chat.BaseComponent;

import java.util.Locale;

/**
 * A component which can be translated using a {@link Locale}.
 */
public interface TranslatableComponent {

    /**
     * Translate this component into a {@link BaseComponent} in the specified {@link Locale}.
     *
     * @param locale the locale to translate this component into
     * @return the translated component
     */
    BaseComponent translate(Locale locale);

    /**
     * Translate this component into a {@link BaseComponent} in the specified {@link Locale}.
     *
     * @param viewer the viewer of the component
     * @return the translated component
     */
    default BaseComponent translate(CommandSender viewer) {
        return this.translate(viewer.getLocale());
    }
}
