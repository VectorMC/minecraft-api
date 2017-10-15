package net.avicus.minecraft.api.scheduler;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.google.inject.AbstractModule;
import com.google.inject.Key;
import com.google.inject.multibindings.OptionalBinder;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.inject.Singleton;

public class MinecraftSchedulerModule extends AbstractModule {

    @Override
    protected void configure() {
        final Key<Executor> executor = Key.get(Executor.class, Async.class);
        final Key<ExecutorService> executorService = Key.get(ExecutorService.class, Async.class);
        final Key<ListeningExecutorService> listeningExecutorService = Key.get(ListeningExecutorService.class, Async.class);

        bind(executor).to(executorService);
        bind(executorService).to(listeningExecutorService);

        OptionalBinder.newOptionalBinder(binder(), listeningExecutorService)
                      .setDefault()
                      .toProvider(() -> MoreExecutors.listeningDecorator(Executors.newCachedThreadPool(
                          new ThreadFactoryBuilder().setNameFormat("Minecraft Scheduler Thread - %1$d")
                                                    .build()
                      )))
                      .in(Singleton.class);
    }
}
