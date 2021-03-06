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

package openconsensus.opencensusshim.trace.samplers;

import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import openconsensus.opencensusshim.trace.Sampler;
import openconsensus.opencensusshim.trace.Span;
import openconsensus.opencensusshim.trace.SpanContext;
import openconsensus.opencensusshim.trace.SpanId;
import openconsensus.opencensusshim.trace.TraceId;

/** Sampler that always makes a "yes" decision on {@link Span} sampling. */
@Immutable
final class AlwaysSampleSampler extends Sampler {

  AlwaysSampleSampler() {}

  // Returns always makes a "yes" decision on {@link Span} sampling.
  @Override
  public boolean shouldSample(
      @Nullable SpanContext parentContext,
      @Nullable Boolean hasRemoteParent,
      TraceId traceId,
      SpanId spanId,
      String name,
      List<Span> parentLinks) {
    return true;
  }

  @Override
  public String getDescription() {
    return toString();
  }

  @Override
  public String toString() {
    return "AlwaysSampleSampler";
  }
}
