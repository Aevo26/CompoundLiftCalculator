import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class CompoundLiftCalculator extends JFrame {
    private JTextField weightField, repsField;
    private JButton calculateButton;
    private JLabel resultLabel, liftLabel;
    private JComboBox<String> liftSelector;

    public CompoundLiftCalculator() {
        setTitle("Compound Lift Strength Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        weightField = new JTextField(10);
        repsField = new JTextField(10);
        calculateButton = new JButton("Calculate");
        resultLabel = new JLabel("Estimated 1RM: ");
        liftSelector = new JComboBox<>(new String[]{"Squat", "Deadlift", "Bench Press"});
        
        // Set layout and add components
        setLayout(new FlowLayout());
        add(new JLabel("Select Lift:"));
        add(liftSelector);
        add(new JLabel("Weight Lifted:"));
        add(weightField);
        add(new JLabel("Reps:"));
        add(repsField);
        add(calculateButton);
        add(resultLabel);

        // Add button listener
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateStrength();
            }
        });
    }

    private void calculateStrength() {
        try {
            double weight = Double.parseDouble(weightField.getText());
            int reps = Integer.parseInt(repsField.getText());

            // Use Epley formula for estimated 1RM
            double oneRepMax = weight * (1 + (0.0333 * reps));
            resultLabel.setText("Estimated 1RM: " + String.format("%.2f", oneRepMax));
        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter valid numbers.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CompoundLiftCalculator frame = new CompoundLiftCalculator();
            frame.setVisible(true);
        });
    }
}
