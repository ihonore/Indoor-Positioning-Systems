package nlateration;
//import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

import static java.lang.Math.*;
import static java.lang.System.out;
//import static lombok.AcessLevel.PRIVATE;

//@FieldDefaults(level = PRIVATE, makeFinal = true)
final class NLateration {

    static byte X = 0;
    static byte Y = 1;
    static byte Z = 2;
    static byte D = 3;
    static float[] p = new float[]{0,0,0};

    public static void main(final String[] args) {
        final float[][] tab = new float[4][4];
        tab[0] = new float[]{0.5f, 0.5f, 0.5f, 3};
        tab[1] = new float[]{4, 0, 0, 2};
        tab[2] = new float[]{4, 5, 5, 4.2f};
        tab[3] = new float[]{3, 3, 3, 2.5f};

        double dMin = 0;
        for (final float[] emitter : tab)
            dMin += abs(emitter[D] - distance(emitter[X], emitter[Y], emitter[Z]));

        final float[] dMax = new float[3];
        for (int i=0; i<3; i++) {
            final List<Float> max = new ArrayList<>();
            for (final float[] t : tab)
                max.add(t[i]);
            dMax[i] = Collections.max(max);
        }

        final float pos = 0.1f;

        for (float i=pos; i<dMax[X]; i+=pos)
            for (float j=pos; j<dMax[Y]; j+=pos)
                for (float k=pos; k<dMax[Z]; k+=pos) {
                    final double d = distance(i, j, k);
                    if (d < dMin) {
                        dMin = d;
                        p[X] = i;
                        p[Y] = j;
                        p[Z] = k;
                    }
                }

        out.println(dMin);
        out.println(Arrays.toString(p));
    }

    private static double distance(final float x, final float y, final float z) {
        return sqrt(pow(x - p[X], 2) + pow(y - p[Y], 2) + pow(z - p[Z], 2));
    }
}
