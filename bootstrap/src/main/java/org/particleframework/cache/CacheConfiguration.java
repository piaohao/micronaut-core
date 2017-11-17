/*
 * Copyright 2017 original authors
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
package org.particleframework.cache;

import org.particleframework.context.annotation.Argument;
import org.particleframework.context.annotation.ForEach;

import java.time.Duration;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.OptionalLong;

/**
 * <p>A base configuration class for configuring caches</p>
 *
 * @author Graeme Rocher
 * @since 1.0
 */
@ForEach(property = "particle.caches")
public class CacheConfiguration {

    protected Integer initialCapacity;
    protected Long maximumSize;
    protected Long maximumWeight;
    protected Duration expireAfterWrite;
    protected Duration expireAfterAccess;

    private final String cacheName;

    public CacheConfiguration(@Argument String cacheName) {
        this.cacheName = cacheName;
    }

    /**
     * @return The name of the cache
     */
    public String getCacheName() {
        return cacheName;
    }

    /**
     * @return The initial capacity of the cache
     */
    public OptionalInt getInitialCapacity() {
        return initialCapacity == null ? OptionalInt.empty() : OptionalInt.of(initialCapacity);
    }

    /**
     * @return The maximum size of the cache
     */
    public OptionalLong getMaximumSize() {
        return maximumSize == null ? OptionalLong.empty() : OptionalLong.of(maximumSize);
    }

    /**
     * @return The maximum weight of cache entries
     */
    public OptionalLong getMaximumWeight() {
        return maximumWeight == null ? OptionalLong.empty() : OptionalLong.of(maximumWeight);
    }

    /**
     *
     * @return The expiry to use after the value is written
     */
    public Optional<Duration> getExpireAfterWrite() {
        return Optional.ofNullable(expireAfterWrite);
    }

    /**
     * Specifies that each entry should be automatically removed from the cache once a fixed duration
     * has elapsed after the entry's creation, the most recent replacement of its value, or its last
     * read.
     *
     * @return The {@link Duration}
     */
    public Optional<Duration> getExpireAfterAccess() {
        return Optional.ofNullable(expireAfterAccess);
    }
}