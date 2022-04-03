
/**
 * Assignment 6 -- Prisoner's Dilemma -- 2ip90
 * main class
 * 
 * @author Toma Andrei Sacuiu
 * @id     1681591
 * @author Bianca Neagoe
 * @id     1708287
 * @date   22.10.2021
 * @group  71
 * assignment
 * 
 * assignment copyright Kees Huizing
 */

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Hashtable;

class PrisonersDilemma {
    // Initialize the objects.
    private JFrame mainFrame;
    private PlayingField pField;
    private JButton goButton;
    private JButton pauseButton;
    private JButton resetButton;
    private JSlider alphaSlider;
    private JSlider frequencySlider;
    private JPanel interactionPanel;
    private JPanel interactionPanel2;

    final int ALPHA_MIN = 0;
    final int ALPHA_MAX = 30;
    final int ALPHA_INIT = 10;
    private boolean pressed = true;

    void buildGUI() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Color blk = new Color(0, 0, 0);
                Color grey = new Color(75, 75, 75);
                pField = new PlayingField();
                pField.setBackground(blk);
                mainFrame = new JFrame("Prisoner's Dilemma");
                mainFrame.setSize(1000, 1000);
                mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mainFrame.setVisible(true);
                mainFrame.add(pField, BorderLayout.CENTER);
                interactionPanel = new JPanel();
                interactionPanel.setLayout(new FlowLayout());
                interactionPanel.setBackground(grey);
                interactionPanel2 = new JPanel();
                interactionPanel2.setLayout(new FlowLayout());
                interactionPanel2.setBackground(grey);


                // Create the "go" button.
                goButton = new JButton("Go");

                goButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvednt) {
                        if (pressed) {
                            pressed = false;
                            pField.start();
                        }
                    }
                });


                // Create the pause button.
                pauseButton = new JButton("Pause");

                pauseButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvednt) {
                        if (!pressed) {
                            pressed = true;
                            pField.stop();
                        }
                    }
                });

                // Create the reset button.
                resetButton = new JButton("Reset");
                resetButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        pField.stop();
                        pField.reset();
                        pField.repaint();
                        pressed = true;
                    }
                });


                // Create the first slider (for alpha) with the necessary labels.
                JLabel alphaLabel;
                alphaLabel = new JLabel("defection ⍺ = ");
                alphaSlider = new JSlider(JSlider.HORIZONTAL, ALPHA_MIN, ALPHA_MAX, ALPHA_INIT);
                alphaSlider.setMajorTickSpacing(5);
                alphaSlider.setMinorTickSpacing(1);
                alphaSlider.setPaintLabels(true);
                alphaSlider.setPaintTicks(true);
                alphaSlider.setSnapToTicks(true);

                Hashtable pos1 = new Hashtable();
                pos1.put( 0, new JLabel("0.0"));
                pos1.put( 10, new JLabel("1.0"));
                pos1.put( 20, new JLabel("2.0"));
                pos1.put( 30, new JLabel("3.0"));
                alphaSlider.setLabelTable(pos1);
                alphaSlider.setBackground(grey);

                // Assign a value for the slider choice.
                alphaSlider.addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent changeEvent) {
                        JSlider source = (JSlider) changeEvent.getSource();

                        if (!source.getValueIsAdjusting()) {
                            int value = source.getValue();
                            double alpha = value / 10.0;
                            pField.setAlpha(alpha);
                        }
                    }
                });


                // Create the second slider (for frequency) and the needed labels.
                JLabel frequencyLabel;
                frequencyLabel = new JLabel("Frequency");
                frequencySlider = new JSlider(JSlider.HORIZONTAL, 0, 60, 0); 
            
                Hashtable pos2 = new Hashtable();
                pos2.put(0, new JLabel("0"));
                pos2.put(10, new JLabel("10"));
                pos2.put(20, new JLabel("20"));
                pos2.put(30, new JLabel("30"));
                pos2.put(40, new JLabel("40"));
                pos2.put(50, new JLabel("50"));
                pos2.put(60, new JLabel("60"));
                frequencySlider.setLabelTable(pos2);
                frequencySlider.setBackground(grey);

                frequencySlider.setMinorTickSpacing(10);
                frequencySlider.setPaintLabels(true);
                frequencySlider.setPaintTicks(true);
            
                // Assign a value for the chosen option on slider.
                frequencySlider.addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent changeEvent) {
                        JSlider source = (JSlider) changeEvent.getSource();

                        if (!source.getValueIsAdjusting()) {
                            int value = source.getValue();
                            pField.changeFrequency(value);
                        }
                    }
                });

                // The box for extra strategy which can be ticked
                JCheckBox extraStrategy = new JCheckBox("Extra Strategy");

                extraStrategy.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent itemEvent) {
                        Object source = itemEvent.getItemSelectable();
                        if (source == extraStrategy) {
                            pField.setExtra(true);
                        }
                        if (itemEvent.getStateChange() == ItemEvent.DESELECTED) {
                            pField.setExtra(false);
                        }
                    }
                });
                extraStrategy.setBackground(grey);

                // Add buttons, sliders, labels to their panels.
                interactionPanel.add(goButton);
                interactionPanel.add(pauseButton);
                interactionPanel.add(resetButton);
                interactionPanel.add(extraStrategy);
                interactionPanel2.add(alphaLabel);
                interactionPanel2.add(alphaSlider);
                interactionPanel2.add(frequencyLabel);
                interactionPanel2.add(frequencySlider);

                // Add the panels to the main frame.
                mainFrame.add(interactionPanel, BorderLayout.NORTH);
                mainFrame.add(interactionPanel2, BorderLayout.SOUTH);

            }
        });
    }

    public static void main(String[] a) {
        (new PrisonersDilemma()).buildGUI();
    }
}
