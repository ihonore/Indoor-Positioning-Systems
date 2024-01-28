package markov;

import java.util.Scanner;

public class InitMarkov {

    public static void main(String[] args) {

        // variables
        final int nbR = 5, nbC = 6;
        int max_cell = 0;
        Cell MM[][] = new Cell[nbR][nbC];

        // reset display
        int prev = -1, curr = 0;
        int nextPage = -1;

        for (int i=0; i<nbR; ++i) {
            for (int j=0; j<nbC; ++j) {
                MM[i][j] = new Cell(0,0);
            }
        }

        while (true) {
            // information display
            System.out.println("You are from: " + prev + "\nWhere you are: " + curr);

            // read in the next page
            Scanner sc = new Scanner(System.in);
            System.out.println("Next page (exit the program " + nbR + ") : ");
            nextPage = sc.nextInt();

            while (nextPage < 0 || nextPage >= nbR) {
                if (nextPage == nbR) {
                    System.out.println("Exit the program");
                    System.exit(1);
                }

                System.out.println("Enter next page (Exit the program with <" + nbR + ">): ");
                nextPage = sc.nextInt();
            }
            prev = curr;
            curr = nextPage;
            MM[prev][curr].nb += 1;
            MM[prev][nbC-1].nb += 1;

            for (int k=0; k<nbC; ++k) {
                MM[prev][k].stat = (float)(MM[prev][k].nb) / (float)(MM[prev][nbC-1].nb);
            }

            displayTab(MM, nbC, nbR);
            System.out.println("\n");
        }

    }

    public static void displaySeperator(int n, int start_row) {
        int i;

        // tabulation before each row for titles
        for (i=0; i<start_row; i++)
            System.out.print(" ");

        for (i=0; i<n; i++)
            System.out.print("[-----------------");
        System.out.print("]");
    }

    public static void displayTab(Cell tab[][], int col, int row) {
        int i,j;
        String sep = "[-----------------";
        String prev = "       0";

        for (int k=0; k<prev.length(); k++)
            System.out.print(" ");

        // Display titles
        for (i=0; i<col-1; i++) {
            String title = "   " + i;
            System.out.print(title);
            for (int k=0; k<sep.length() - title.length(); k++)
                System.out.print(" ");
        }

        System.out.print(" Totals : ");
        System.out.print("\n");

        // display the rows and columns
        for (i=0; i<row; i++) {
            prev = " " + i;
            displaySeperator(col, prev.length());
            System.out.print("\n");

            for (j=0; j<col; j++) {
                if(j == 0)
                    System.out.print(prev);

                String content = "|    " + tab[i][j].nb + ", " + tab[i][j].stat*100 + "%";
                System.out.print(content);

                for (int k=0; k<sep.length() - content.length(); k++)
                    System.out.print(" ");
            }

            System.out.print("|");
            System.out.print("\n");
        }

        displaySeperator(col, prev.length());
    }
}
