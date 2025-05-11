import java.awt.*;
import javax.swing.*;

public class CompoundLiftCalculator extends JFrame {
    private JTextField weightField, repsField, bodyweightField;
    private JComboBox<String> liftSelector, genderSelector;
    private JButton calculateButton;
    private JLabel resultLabel;

    public CompoundLiftCalculator() {
        setTitle("Compound Lift Strength Calculator");
        setSize(400, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        weightField = new JTextField(10);
        repsField = new JTextField(10);
        bodyweightField = new JTextField(10);
        calculateButton = new JButton("Calculate");
        resultLabel = new JLabel("Estimated 1RM: ");
        liftSelector = new JComboBox<>(new String[]{
            "Squat", "Deadlift", "Bench Press", "Weighted Pull-Up"
        });
        genderSelector = new JComboBox<>(new String[]{"Male", "Female"});

        // Layout
        setLayout(new FlowLayout());
        add(new JLabel("Select Lift:"));
        add(liftSelector);
        add(new JLabel("Gender:"));
        add(genderSelector);
        add(new JLabel("Bodyweight (lbs):")); // Changed label to lbs
        add(bodyweightField);
        add(new JLabel("Weight Lifted (added weight for pull-ups, kg):"));
        add(weightField);
        add(new JLabel("Reps:"));
        add(repsField);
        add(calculateButton);
        add(resultLabel);

        // Button listener
        calculateButton.addActionListener(e -> calculateStrength());
    }

    private void calculateStrength() {
        try {
            double weight = Double.parseDouble(weightField.getText());
            int reps = Integer.parseInt(repsField.getText());
            double bodyweightLbs = Double.parseDouble(bodyweightField.getText());
            String gender = (String) genderSelector.getSelectedItem();

            // Convert bodyweight from pounds to kilograms
            double bodyweightKg = bodyweightLbs * 0.453592;

            double oneRepMax = 0;
            String lift = (String) liftSelector.getSelectedItem();

            if (lift.equals("Weighted Pull-Up")) {
                double totalWeight = bodyweightKg + weight;
                oneRepMax = totalWeight * (1 + (0.0333 * reps));
            } else {
                oneRepMax = weight * (1 + (0.0333 * reps));
            }

            if (gender.equals("Female")) {
                oneRepMax *= 0.9;
            }

            if (!lift.equals("Weighted Pull-Up") && bodyweightKg > 70) {
                oneRepMax *= (1 + (bodyweightKg - 70) / 100);
            }

            resultLabel.setText("Estimated 1RM: " + String.format("%.2f", oneRepMax) + " kg");
        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter valid numbers.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CompoundLiftCalculator().setVisible(true));
    }
}
