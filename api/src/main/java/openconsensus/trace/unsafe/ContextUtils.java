/*
 * Copyright 2019, OpenConsensus Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package openconsensus.trace.unsafe;

import io.grpc.Context;
import openconsensus.internal.Utils;
import openconsensus.trace.BlankSpan;
import openconsensus.trace.Span;
import openconsensus.trace.Tracer;

/**
 * Util methods/functionality to interact with the {@link io.grpc.Context}.
 *
 * <p>Users must interact with the current Context via the public APIs in {@link Tracer} and avoid
 * usages of the {@link #CONTEXT_SPAN_KEY} directly.
 *
 * @since 0.1.0
 */
public final class ContextUtils {
  private static final Context.Key<Span> CONTEXT_SPAN_KEY =
      Context.keyWithDefault("openconsensus-trace-span-key", BlankSpan.INSTANCE);

  /**
   * Creates a new {@code Context} with the given value set.
   *
   * @param context the parent {@code Context}.
   * @param span the value to be set.
   * @return a new context with the given value set.
   * @since 0.1.0
   */
  public static Context withValue(Context context, Span span) {
    return Utils.checkNotNull(context, "context").withValue(CONTEXT_SPAN_KEY, span);
  }

  /**
   * Returns the value from the specified {@code Context}.
   *
   * @param context the specified {@code Context}.
   * @return the value from the specified {@code Context}.
   * @since 0.1.0
   */
  public static Span getValue(Context context) {
    return CONTEXT_SPAN_KEY.get(Utils.checkNotNull(context, "context"));
  }

  private ContextUtils() {}
}
