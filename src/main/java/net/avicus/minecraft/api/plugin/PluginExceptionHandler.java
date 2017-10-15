package net.avicus.minecraft.api.plugin;

import javax.inject.Inject;
import net.avicus.exception.LoggingExceptionHandler;

public class PluginExceptionHandler extends LoggingExceptionHandler {
    @Inject public PluginExceptionHandler(Plugin plugin) {
        super(plugin.getLogger());
    }
}
