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

import java.util.BitSet;

/**
 * Vector of bits that grows as needed. Asynchronous interface.
 *
 * @author Nikita Koksharov
 *
 */
public interface RBitSetAsync extends RExpirableAsync {

    RFuture<byte[]> toByteArrayAsync();

    /**
     * Returns "logical size" = index of highest set bit plus one.
     * Returns zero if there are no any set bit.
     * 
     * @return "logical size" = index of highest set bit plus one
     */
    RFuture<Long> lengthAsync();

    /**
     * Set all bits to <code>value</code> from <code>fromIndex</code> (inclusive) to <code>toIndex</code> (exclusive)
     * 
     * @param fromIndex inclusive
     * @param toIndex exclusive
     * @param value true = 1, false = 0
     * @return void
     * 
     */
    RFuture<Void> setAsync(long fromIndex, long toIndex, boolean value);

    /**
     * Set all bits to zero from <code>fromIndex</code> (inclusive) to <code>toIndex</code> (exclusive)
     * 
     * @param fromIndex inclusive
     * @param toIndex exclusive
     * @return void
     * 
     */
    RFuture<Void> clearAsync(long fromIndex, long toIndex);

    /**
     * Copy bits state of source BitSet object to this object
     * 
     * @param bs - BitSet source
     * @return void
     */
    RFuture<Void> setAsync(BitSet bs);

    /**
     * Executes NOT operation over all bits
     * 
     * @return void
     */
    RFuture<Void> notAsync();

    /**
     * Set all bits to one from <code>fromIndex</code> (inclusive) to <code>toIndex</code> (exclusive)
     * 
     * @param fromIndex inclusive
     * @param toIndex exclusive
     * @return void
     */
    RFuture<Void> setAsync(long fromIndex, long toIndex);

    /**
     * Returns number of set bits.
     * 
     * @return number of set bits.
     */
    RFuture<Long> sizeAsync();

    /**
     * Returns <code>true</code> if bit set to one and <code>false</code> overwise.
     * 
     * @param bitIndex - index of bit
     * @return <code>true</code> if bit set to one and <code>false</code> overwise.
     */
    RFuture<Boolean> getAsync(long bitIndex);

    /**
     * Set bit to one at specified bitIndex
     * 
     * @param bitIndex - index of bit
     * @return <code>true</code> - if previous value was true, 
     * <code>false</code> - if previous value was false
     */
    RFuture<Boolean> setAsync(long bitIndex);

    /**
     * Set bit to <code>value</code> at specified <code>bitIndex</code>
     * 
     * @param bitIndex - index of bit
     * @param value true = 1, false = 0
     * @return <code>true</code> - if previous value was true, 
     * <code>false</code> - if previous value was false
     */
    RFuture<Boolean> setAsync(long bitIndex, boolean value);

    /**
     * Returns the number of bits set to one.
     * 
     * @return number of bits
     */
    RFuture<Long> cardinalityAsync();

    /**
     * Set bit to zero at specified <code>bitIndex</code>
     *
     * @param bitIndex - index of bit
     * @return <code>true</code> - if previous value was true, 
     * <code>false</code> - if previous value was false
     */
    RFuture<Boolean> clearAsync(long bitIndex);

    /**
     * Set all bits to zero
     * 
     * @return void
     */
    RFuture<Void> clearAsync();

    /**
     * Executes OR operation over this object and specified bitsets.
     * Stores result into this object.
     * 
     * @param bitSetNames - name of stored bitsets
     * @return void
     */
    RFuture<Void> orAsync(String... bitSetNames);

    /**
     * Executes AND operation over this object and specified bitsets.
     * Stores result into this object.
     * 
     * @param bitSetNames - name of stored bitsets
     * @return void
     */
    RFuture<Void> andAsync(String... bitSetNames);

    /**
     * Executes XOR operation over this object and specified bitsets.
     * Stores result into this object.
     * 
     * @param bitSetNames - name of stored bitsets
     * @return void
     */
    RFuture<Void> xorAsync(String... bitSetNames);

}
