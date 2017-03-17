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
package nu.peg.yahtzee.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import nu.peg.yahtzee.game.rule.YatzeRule;
import nu.peg.yahtzee.game.rule.impl.left.AcesRule;
import nu.peg.yahtzee.game.rule.impl.left.FivesRule;
import nu.peg.yahtzee.game.rule.impl.left.FoursRule;
import nu.peg.yahtzee.game.rule.impl.left.LeftBonusRule;
import nu.peg.yahtzee.game.rule.impl.left.SixesRule;
import nu.peg.yahtzee.game.rule.impl.left.ThreesRule;
import nu.peg.yahtzee.game.rule.impl.left.TwosRule;
import nu.peg.yahtzee.game.rule.impl.right.ChanceRule;
import nu.peg.yahtzee.game.rule.impl.right.FourOfAKindRule;
import nu.peg.yahtzee.game.rule.impl.right.FullHouseRule;
import nu.peg.yahtzee.game.rule.impl.right.LargeStraightRule;
import nu.peg.yahtzee.game.rule.impl.right.SmallStraightRule;
import nu.peg.yahtzee.game.rule.impl.right.ThreeOfAKindRule;
import nu.peg.yahtzee.game.rule.impl.right.YahtzeeRule;

/**
 *
 * @author Joel Messerli <joel@peg.nu>
 */
public class YatzeGame {

    private final List<YatzeRule> leftRules = new ArrayList<>();
    private final int[] leftSubtotal = new int[2];
    private final YatzeRule leftBonusRule = new LeftBonusRule();
    private final List<YatzeRule> rightRules = new ArrayList<>();

    private final int[] playerScores = new int[2];
    private int curPlayerIdx = 0;

    public YatzeGame() {
        Collections.addAll(leftRules, new AcesRule(), new TwosRule(), new ThreesRule(), new FoursRule(), new FivesRule(), new SixesRule());
        Collections.addAll(rightRules, new ThreeOfAKindRule(), new FourOfAKindRule(), new FullHouseRule(), new SmallStraightRule(), new LargeStraightRule(), new YahtzeeRule(), new ChanceRule());
    }

    public List<Dice> roll() {
        List<Dice> dice = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            dice.add(Dice.values()[(int) (Math.random() * 5)]);
        }
        return dice;
    }

    public int[] getLeftSubtotal() {
        return leftSubtotal;
    }

    public int getScoreOfPlayer(int playerIndex) {
        return playerScores[playerIndex];
    }
}
