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
package nu.peg.yahtzee.ui;

import java.awt.Image;
import java.net.URL;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import nu.peg.yahtzee.game.Dice;
import nu.peg.yahtzee.game.YatzeGame;

/**
 *
 * @author Joel Messerli <joel@peg.nu>
 */
public class GameWindow extends javax.swing.JFrame {

    private final String player1Name, player2Name;
    private final YatzeGame game;
    private final ImageIcon[] dice = new ImageIcon[6];

    /**
     * Creates new form GameWindow
     */
    public GameWindow(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;

        this.game = new YatzeGame();

        createIcons();
        initComponents();

        player1NameLbl.setText(player1Name);
        player2NameLbl.setText(player2Name);

        updateScores();
    }

    private void createIcons() {
        for (int i = 0; i < dice.length; i++) {
            final URL iconRes = getClass().getResource("/nu/peg/yahtzee/ui/img/dice-" + (i + 1) + "-md.png");
            System.out.println("Loading " + iconRes);
            if (iconRes == null) {
                dice[i] = new ImageIcon();
                continue;
            }
            final ImageIcon icon = new ImageIcon(iconRes);
            Image scaled = icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            dice[i] = new ImageIcon(scaled);
        }
    }

    private void updateScores() {
        this.player1ScoreLbl.setText(game.getScoreOfPlayer(0) + "");
        this.player2ScoreLbl.setText(game.getScoreOfPlayer(1) + "");
    }

    private void updateButtons(List<Dice> dice) {
        JToggleButton[] buttons = new JToggleButton[]{dice1Btn, dice2Btn, dice3Btn, dice4Btn, dice5Btn};
        for (int i = 0; i < buttons.length; i++) {
            JToggleButton button = buttons[i];
            button.setIcon(this.dice[dice.get(i).diceValue() - 1]);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        leftTbl = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        rightTbl = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        dice1Btn = new javax.swing.JToggleButton();
        dice2Btn = new javax.swing.JToggleButton();
        dice3Btn = new javax.swing.JToggleButton();
        dice4Btn = new javax.swing.JToggleButton();
        dice5Btn = new javax.swing.JToggleButton();
        rollBtn = new javax.swing.JButton();
        playBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        totalScoreHeaderLbl = new javax.swing.JLabel();
        player1NameLbl = new javax.swing.JLabel();
        player2NameLbl = new javax.swing.JLabel();
        player1ScoreLbl = new javax.swing.JLabel();
        player2ScoreLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        leftTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Player1Name", "Player2Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(leftTbl);

        rightTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Player1Name", "Player2Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(rightTbl);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        dice1Btn.setIcon(dice[0]);
        dice1Btn.setMaximumSize(new java.awt.Dimension(50, 50));
        dice1Btn.setMinimumSize(new java.awt.Dimension(0, 0));
        dice1Btn.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel3.add(dice1Btn);

        dice2Btn.setIcon(dice[1]);
        dice2Btn.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel3.add(dice2Btn);

        dice3Btn.setIcon(dice[2]);
        dice3Btn.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel3.add(dice3Btn);

        dice4Btn.setIcon(dice[3]);
        dice4Btn.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel3.add(dice4Btn);

        dice5Btn.setIcon(dice[4]);
        dice5Btn.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel3.add(dice5Btn);

        rollBtn.setText("Roll");
        rollBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rollBtnActionPerformed(evt);
            }
        });

        playBtn.setText("Play");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(rollBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(playBtn)
                .addGap(145, 145, 145))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rollBtn)
                    .addComponent(playBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        totalScoreHeaderLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        totalScoreHeaderLbl.setText("Total Score");

        player1NameLbl.setText("player1Name");

        player2NameLbl.setText("player2Name");

        player1ScoreLbl.setText("player1Score");

        player2ScoreLbl.setText("player2Score");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(player1NameLbl)
                    .addComponent(totalScoreHeaderLbl)
                    .addComponent(player2NameLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(player1ScoreLbl)
                    .addComponent(player2ScoreLbl))
                .addGap(95, 95, 95))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(totalScoreHeaderLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(player1NameLbl)
                    .addComponent(player1ScoreLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(player2NameLbl)
                    .addComponent(player2ScoreLbl))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rollBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rollBtnActionPerformed
        updateButtons(game.roll());
    }//GEN-LAST:event_rollBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton dice1Btn;
    private javax.swing.JToggleButton dice2Btn;
    private javax.swing.JToggleButton dice3Btn;
    private javax.swing.JToggleButton dice4Btn;
    private javax.swing.JToggleButton dice5Btn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable leftTbl;
    private javax.swing.JButton playBtn;
    private javax.swing.JLabel player1NameLbl;
    private javax.swing.JLabel player1ScoreLbl;
    private javax.swing.JLabel player2NameLbl;
    private javax.swing.JLabel player2ScoreLbl;
    private javax.swing.JTable rightTbl;
    private javax.swing.JButton rollBtn;
    private javax.swing.JLabel totalScoreHeaderLbl;
    // End of variables declaration//GEN-END:variables
}
