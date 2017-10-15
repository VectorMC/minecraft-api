package net.avicus.minecraft.api.server;

import javax.inject.Inject;
import net.avicus.exception.LoggingExceptionHandler;

public class ServerExceptionHandler extends LoggingExceptionHandler {

    @Inject ServerExceptionHandler(LocalServer localServer) {
        super(localServer.getLogger());
    }
}
