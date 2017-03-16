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
package nu.peg.yahtzee.game.rule.impl.right;

import java.util.List;
import nu.peg.yahtzee.game.Dice;
import nu.peg.yahtzee.game.YatzeGame;
import nu.peg.yahtzee.game.rule.YatzeRule;
import nu.peg.yahtzee.util.DiceUtil;

/**
 *
 * @author Joel Messerli <joel@peg.nu>
 */
public class LargeStraightRule implements YatzeRule {

    @Override
    public String getName() {
        return "Large Straight";
    }

    @Override
    public int getBonus(YatzeGame game, int playerIndex, List<Dice> dice) {
        return DiceUtil.sequentialDiceCount(dice) == 5 ? 40 : 0;
    }
}
