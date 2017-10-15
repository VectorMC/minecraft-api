package net.avicus.minecraft.api.scheduler;

import com.google.inject.BindingAnnotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;

/**
 * Binding annotation indicating something that is
 * NOT synchronized with the main server thread.
 */
@Qualifier
@BindingAnnotation
@Retention(RetentionPolicy.RUNTIME)
public @interface Async {}
