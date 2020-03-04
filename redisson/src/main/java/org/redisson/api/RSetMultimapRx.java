/**
 * Copyright (c) 2013-2020 Nikita Koksharov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.redisson.api;

import java.util.Set;

import io.reactivex.Single;

/**
 * RxJava2 interface for Set based Multimap
 * 
 * @author Nikita Koksharov
 *
 * @param <K> key type
 * @param <V> value type
 */
public interface RSetMultimapRx<K, V> extends RMultimapRx<K, V> {

    /**
     * Returns a view Set of the values associated with {@code key} in this
     * multimap, if any. Note that when {@code containsKey(key)} is false, this
     * returns an empty collection, not {@code null}.
     *
     * <p>Changes to the returned collection will update the underlying multimap,
     * and vice versa.
     * 
     * @param key - map key
     * @return set of values
     */
    RSetRx<V> get(K key);
 
    /**
     * Returns all elements at once. Result Set is <b>NOT</b> backed by map,
     * so changes are not reflected in map.
     *
     * @param key - map key
     * @return set of values 
     */
    Single<Set<V>> getAll(K key);
    
    /**
     * Removes all values associated with the key {@code key}.
     *
     * <p>Once this method returns, {@code key} will not be mapped to any values
     * <p>Use {@link RMultimapReactive#fastRemove} if values are not needed.</p>
     * 
     * @param key - map key
     * @return the values that were removed (possibly empty). The returned
     *     set <i>may</i> be modifiable, but updating it will have no
     *     effect on the multimap.
     */
    Single<Set<V>> removeAll(Object key);
    
    /**
     * Stores a collection of values with the same key, replacing any existing
     * values for that key.
     *
     * <p>If {@code values} is empty, this is equivalent to
     * {@link #removeAll(Object)}.
     *
     * @param key - map key
     * @param values - map values
     * @return set of replaced values, or an empty collection if no
     *     values were previously associated with the key. Set
     *     <i>may</i> be modifiable, but updating it will have no effect on the
     *     multimap.
     */
    Single<Set<V>> replaceValues(K key, Iterable<? extends V> values);
    
}
