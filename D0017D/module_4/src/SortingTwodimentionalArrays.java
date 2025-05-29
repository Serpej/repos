import java.util.Arrays;

/**
 * This is a program that shows how to sort a twodimentional array using bubble sort.
 */

public class SortingTwodimentionalArrays {
    final static int NAMES = 2;
    final static int F_NAME = 0;
    final static int L_NAME = 1;
    final static int NUM_STUDENTS = 5;

    public static void main(String[] args) {
        String studentNames[][] = new String[NUM_STUDENTS][NAMES];
        int studentGrades[] = new int[NUM_STUDENTS];


        studentNames[0][F_NAME] = "Jesper";
        studentNames[0][L_NAME] = "Hagerman Borgström";
        studentGrades[0] = 90;

        studentNames[1][F_NAME] = "Markus";
        studentNames[1][L_NAME] = "Zetterberg Ahl";
        studentGrades[1] = 80;

        studentNames[2][F_NAME] = "Elisabeth";
        studentNames[2][L_NAME] = "Grund";
        studentGrades[2] = 60;

        studentNames[3][F_NAME] = "Illis";
        studentNames[3][L_NAME] = "Matte";
        studentGrades[3] = 15;

        studentNames[4][F_NAME] = "Top";
        studentNames[4][L_NAME] = "Person";
        studentGrades[4] = 110;


        String[][] tempStudentNames = new String[NUM_STUDENTS][2];
        System.arraycopy(studentNames, 0, tempStudentNames, 0, studentNames.length);

        int[] tempStudentGrades = new int[NUM_STUDENTS];
        System.arraycopy(studentGrades, 0, tempStudentGrades, 0, studentGrades.length);
        int n = tempStudentGrades.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (tempStudentGrades[j] > tempStudentGrades[j + 1]) {
                    int temp = tempStudentGrades[j + 1];
                    tempStudentGrades[j + 1] = tempStudentGrades[j];
                    tempStudentGrades[j] = temp;

                    String[] temp2 = tempStudentNames[j + 1];
                    tempStudentNames[j + 1] = tempStudentNames[j];
                    tempStudentNames[j] = temp2;
                }
            }
        }

        for (int i = 0; i < NUM_STUDENTS; i++) {
            System.out.printf("Student name: %s %s Grade: %d/100.%n", studentNames[i][F_NAME], studentNames[i][L_NAME], studentGrades[i]);
        }
        System.out.println("\n");
        for (int i = 0; i < NUM_STUDENTS; i++) {
            System.out.printf("Student name: %s %s Grade: %d/100.%n", tempStudentNames[i][F_NAME], tempStudentNames[i][L_NAME], tempStudentGrades[i]);
        }

    }

    // Observera att detta inte går, eftesom du bara kan returna ett value (och därför kan du inte få med båda arraysen.). Överkurs är att göra en ny class i methoden och returna den.
    // public static int[] sortGrades(int[] a, String[][] s) {
    //     String[] tempStudentNames = new String[NUM_STUDENTS];
    //     System.arraycopy(s, 0, tempStudentNames, 0, s.length);

    //     int[] tempStudentGrades = new int[NUM_STUDENTS];
    //     System.arraycopy(a, 0, tempStudentGrades, 0, a.length);
    //     int n = tempStudentGrades.length;
    //     for (int i = 0; i < n - 1; i++) {
    //         for (int j = 0; j < n - i - 1; j++) {
    //             if (tempStudentGrades[j] > tempStudentGrades[j + 1]) {
    //                 int temp = tempStudentGrades[j + 1];
    //                 tempStudentGrades[j + 1] = tempStudentGrades[j];
    //                 tempStudentGrades[j] = temp;

    //                 String temp2 = tempStudentNames[j + 1];
    //                 tempStudentNames[j + 1] = tempStudentNames[j];
    //                 tempStudentNames[j] = temp2;
    //             }
    //         }
    //     }

    //     return tempStudentGrades;
    // }
}
