
# CompoundLiftCalculator

A Java program with a graphical user interface (GUI) designed to calculate strength for various compound lifts based on the amount of weight lifted and the number of repetitions performed. The program estimates the one-repetition maximum (1RM) using the Epley formula. The user can input their lift details, select the type of lift (e.g., Squat, Deadlift, Bench Press), and get an estimate of their maximum strength.

## Features

- Select from various compound lifts: Squat, Deadlift, Bench Press.
- Input the amount of weight lifted and the number of repetitions performed.
- Calculate the estimated 1RM based on the Epley formula.
- Simple and intuitive GUI for easy interaction.

## Formula Used

The program uses the Epley formula for estimating the one-repetition maximum (1RM):

\[
\text{Estimated 1RM} = W \times (1 + 0.0333 \times R)
\]

Where:
- \( W \) is the weight lifted.
- \( R \) is the number of reps performed.

## Getting Started

### Prerequisites

Make sure you have the following installed:
- Java Development Kit (JDK) 8 or higher.
- An IDE or text editor (e.g., IntelliJ IDEA, Eclipse, or VS Code).

### Installation

1. Clone or download this repository.
2. Open the project folder in your preferred IDE.
3. Compile and run the program.

### Running the Program

1. Open the program.
2. Select the type of lift (e.g., Squat, Deadlift, Bench Press) from the dropdown menu.
3. Enter the weight lifted in the "Weight Lifted" field.
4. Enter the number of reps performed in the "Reps" field.
5. Press the "Calculate" button to view your estimated 1RM.

## Example Usage

- **Lift Type**: Squat
- **Weight Lifted**: 150 kg
- **Reps**: 5

Output:  
Estimated 1RM: 180.00 kg

## Contributing

If you'd like to contribute to the development of this program, feel free to fork the repository, make your changes, and submit a pull request. Please ensure that your code adheres to the project's style guidelines.

## License

This project is open-source and available under the MIT License.

## Acknowledgments

- Epley formula for estimating 1RM.
- Java Swing for GUI development.
