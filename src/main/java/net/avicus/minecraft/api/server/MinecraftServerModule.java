package net.avicus.minecraft.api.server;

import com.google.inject.AbstractModule;
import net.avicus.minecraft.api.scheduler.MinecraftSchedulerModule;
import net.avicus.minecraft.api.user.MinecraftUserModule;

public class MinecraftServerModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new MinecraftSchedulerModule());
        install(new MinecraftUserModule());

        bind(ServerExceptionHandler.class);
    }
}
