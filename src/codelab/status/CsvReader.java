package codelab.status;

import parser.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CsvReader {

    String pattern = "###,##0.00";
    DecimalFormat decimalFormat = new DecimalFormat(pattern);
    String csvFilePath = System.getProperty("user.dir") + "/src/codelab/status/roster.csv";
    String line = "";
    String csvSplitBy = ",";
    BufferedReader br = null;
    List<Trainee> roster = new ArrayList<>();

    public static void main(String[] args) {
        /*
         Comma-Separated Value(CSV) of CodeLab status is downloaded and it parsed.
         Based on number of solution you solved, message is generated for you.
         You need to find the average score of the class.
         */
        CsvReader csv = new CsvReader();

        csv.readAdd();
        csv.printResult();
        csv.avgScore();
    }

    //Reading from CSV file, then add each line to the ArrayList
    public void readAdd() {
        try {
            br = new BufferedReader(new FileReader(csvFilePath));
            int lineNumber = 0;
            while ((line = br.readLine()) != null) {
                if (lineNumber == 0) {
                    lineNumber++;
                    continue;
                }
                String[] name = line.split(csvSplitBy);
                roster.add(new Trainee(name[4].replace("\"", ""), name[5].replace("\"",
                        ""), Integer.parseInt(name[10])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Print each student's record from the CSV file
    public void printResult() {
        Collections.sort(roster);

        for (Trainee student : roster) {
            if (student.getNumberOfExercisesSolved() >= 500) {
                System.out.print("You did pretty good-->                    ");
                System.out.println(student.getFirstName() + " " + student.getLastName() + " " + student.getNumberOfExercisesSolved());
            } else if (student.getNumberOfExercisesSolved() >= 400 && student.getNumberOfExercisesSolved() < 500) {
                System.out.print("You could do better-->                    ");
                System.out.println(student.getFirstName() + " " + student.getLastName() + " " + student.getNumberOfExercisesSolved());
            } else if (student.getNumberOfExercisesSolved() >= 300 && student.getNumberOfExercisesSolved() < 400) {
                System.out.print("You should have done more-->              ");
                System.out.println(student.getFirstName() + " " + student.getLastName() + " " + student.getNumberOfExercisesSolved());
            } else if (student.getNumberOfExercisesSolved() >= 200 && student.getNumberOfExercisesSolved() < 300) {
                System.out.print("You haven't done enough-->                 ");
                System.out.println(student.getFirstName() + " " + student.getLastName() + " " + student.getNumberOfExercisesSolved());
            } else if (student.getNumberOfExercisesSolved() >= 100 && student.getNumberOfExercisesSolved() < 200) {
                System.out.print("You did not take this exercise seriously-->   ");
                System.out.println(student.getFirstName() + " " + student.getLastName() + " " + student.getNumberOfExercisesSolved());
            } else if (student.getNumberOfExercisesSolved() < 100) {
                System.out.print("You are in bad shape !-->                           ");
                System.out.println(student.getFirstName() + " " + student.getLastName() + " " + student.getNumberOfExercisesSolved());
            }
        }
    }

    //Calculate the total & average score
    public void avgScore() {
        CsvReader csv = new CsvReader();
        double totalScore = 0;
        for (Trainee student : roster) {
            totalScore += student.getNumberOfExercisesSolved();
        }
        System.out.println("Total Class Score: " + decimalFormat.format(totalScore));
        System.out.println("Average Class Score: " + decimalFormat.format(totalScore / roster.size()));
    }

}
