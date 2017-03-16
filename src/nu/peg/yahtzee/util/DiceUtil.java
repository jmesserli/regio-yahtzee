/*
 * The MIT License
 *
 * Copyright 2017 Joel Messerli <joel@peg.nu>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package nu.peg.yahtzee.util;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import nu.peg.yahtzee.game.Dice;

/**
 *
 * @author Joel Messerli <joel@peg.nu>
 */
public final class DiceUtil {

    private DiceUtil() {
    }

    public static int countDice(Dice diceToCount, List<Dice> dice) {
        return (int) dice.stream()
                .filter(thisDice -> thisDice == diceToCount)
                .count();
    }

    public static int sequentialDiceCount(List<Dice> dice) {
        final List<Dice> sortedDice = dice.stream()
                .sorted(Comparator.comparing(Dice::diceValue))
                .collect(Collectors.toList());

        int[] maxSequential = new int[]{1};
        int[] curSequential = new int[]{0};
        int lastValue = Integer.MIN_VALUE;

        sortedDice.forEach(thisDice -> {
            if (thisDice.diceValue() == lastValue + 1) {
                curSequential[0]++;
                return;
            } else if (curSequential[0] > maxSequential[0]) {
                maxSequential[0] = curSequential[0];
            }

            curSequential[0] = 1;
        });

        return maxSequential[0];
    }
}
