/*-
 *  * Copyright 2016 Skymind, Inc.
 *  *
 *  *    Licensed under the Apache License, Version 2.0 (the "License");
 *  *    you may not use this file except in compliance with the License.
 *  *    You may obtain a copy of the License at
 *  *
 *  *        http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *    Unless required by applicable law or agreed to in writing, software
 *  *    distributed under the License is distributed on an "AS IS" BASIS,
 *  *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *    See the License for the specific language governing permissions and
 *  *    limitations under the License.
 */

package org.datavec.audio;

import org.datavec.audio.dsp.FastFourierTransform;
import org.junit.Assert;
import org.junit.Test;

public class TestFastFourierTransform {

    @Test
    public void testFastFourierTransformComplex() {
        FastFourierTransform fft = new FastFourierTransform();
        double[] amplitudes = new double[] {3.0, 4.0, 0.5, 7.8, 6.9, -6.5, 8.5, 4.6};
        double[] frequencies = fft.getMagnitudes(amplitudes);

        Assert.assertEquals(2, frequencies.length);
        Assert.assertArrayEquals(new double[] {21.335, 18.513}, frequencies, 0.005);
    }

    @Test
    public void testFastFourierTransformReal() {
        FastFourierTransform fft = new FastFourierTransform();
        double[] amplitudes = new double[] {3.0, 4.0, 0.5, 7.8, 6.9, -6.5, 8.5, 4.6};
        double[] frequencies = fft.getMagnitudes(amplitudes, false);

        Assert.assertEquals(4, frequencies.length);
        Assert.assertArrayEquals(new double[] {28.8, 2.107, 14.927, 19.874}, frequencies, 0.005);
    }
}
