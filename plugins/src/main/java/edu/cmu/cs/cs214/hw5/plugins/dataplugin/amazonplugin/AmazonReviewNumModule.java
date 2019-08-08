package edu.cmu.cs.cs214.hw5.plugins.dataplugin.amazonplugin;

import edu.cmu.cs.cs214.hw5.framework.plugin.control.ControlPoint;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * The {@code AmazonReviewNumModule} controls the number of reviews to fetch.
 *
 * @author Team6
 */
public class AmazonReviewNumModule implements ControlPoint<Integer> {
    private int defaultNum;
    private final JTextField inputField = new JTextField(4);
    private static final int MAX_CHAR = 2;

    AmazonReviewNumModule(int defaultNum) {
        this.defaultNum = defaultNum;
        inputField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (inputField.getText().length() >= MAX_CHAR) // limit text field to MAX_CHAR characters
                    e.consume();
            }
        });
    }

    @Override
    public String getControlName() {
        return "ReviewNum";
    }

    @Override
    public Integer getDefaultValue() {
        return defaultNum;
    }

    @Override
    public Integer getCurrentValue() {
        return Integer.valueOf(inputField.getText());
    }

    @Override
    public JPanel onDisplay() {
        JPanel inputModule = new JPanel();
        JLabel label = new JLabel("Number of reviews to fetch: ");
        inputField.setText(getDefaultValue().toString());
        inputModule.setLayout(new BoxLayout(inputModule, BoxLayout.LINE_AXIS));
        inputModule.add(label);
        inputModule.add(inputField);
        return inputModule;
    }
}
