package fingerprint;

import java.lang.reflect.Array;
import java.util.Arrays;

public class GoFingerPrint {

    public static void main(String[] args) {

        Cell Tf[][] = new Cell[3][3];

        // Creation of 9 cells
        Tf[0][0] = new Cell(new int[]{-38, -27, -54, -13});
        Tf[0][1] = new Cell(new int[]{-74, -62, -48, -33});
        Tf[0][2] = new Cell(new int[]{-13, -28, -12, -40});
        Tf[1][0] = new Cell(new int[]{-34, -27, -38, -41});
        Tf[1][1] = new Cell(new int[]{-64, -48, -72, -35});
        Tf[1][2] = new Cell(new int[]{-45, -37, -20, -15});
        Tf[2][0] = new Cell(new int[]{-17, -50, -44, -33});
        Tf[2][1] = new Cell(new int[]{-27, -28, -32, -45});
        Tf[2][2] = new Cell(new int[]{-30, -20, -60, -40});

        // Creation of Mobile Terminal
//        Cell TM = new Cell(new int[]{-26,-42,-13,-46});

        Cell TM = new Cell(new int[]{-22,-27,-35,-60});

        int kcases[][] = new int[4][2];
        boolean presence = false;

        int sum = 99999;
        int max[] = new int[2];

        for (int i=0; i<3; ++i) {
            for (int j=0; j<3; ++j) {
                if (Tf[i][j].sum() < sum) {
                    max[0] = i;
                    max[1] = j;
                }
            }
        }

        for (int k=0; k<4; k++) {

            kcases[k][0] = max[0];
            kcases[k][1] = max[1];

            for (int i=0; i<3; ++i) {
                for (int j=0; j<3; ++j) {

                    for(int l=0; l<k; ++l) {
                        if (kcases[l][0] == i && kcases[l][1] == j)
                            presence = true;

                    }

                    if (!presence) {
                        if ( Math.abs(Tf[i][j].sum() - TM.sum()) < Math.abs(Tf[kcases[k][0]][kcases[k][1]].sum() - TM.sum()) ) {
                            kcases[k][0] = i;
                            kcases[k][1] = j;
                        }
                    }

                    // Reinitialisation of k
                    presence = false;
                }
            }
        }

        int avg_x, avg_y;
        avg_x = avg_y = 0;

        for (int element[]:kcases) {
            element[0] = element[0]*4 + 2;
            element[1] = element[1]*4 + 2;

            avg_x += element[1];
            avg_y += element[0];

            System.out.println("K nearest: " + element[1] + "," + element[0]);
        }

        System.out.println("Gravity Centre: " + avg_x/4 + "," + avg_y/4);
    }
}
