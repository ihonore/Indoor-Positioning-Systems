package fingerprint;

public class Cell {

    int[] tpr;

    public Cell(int[] tpr) {
        this.tpr = tpr;
    }

    public int sum() {
        int sum = 0;

        for (int i=0; i<tpr.length; i++) {
            sum += tpr[i];
        }

        return sum;
    }
}
