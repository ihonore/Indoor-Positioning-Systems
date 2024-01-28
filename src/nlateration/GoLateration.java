package nlateration;

public class GoLateration {
    public static void main(String[] args) {

        Emitter tab[] = new Emitter[4];

        // Declaring Emitter positions
        tab[0] = new Emitter(new Position(0.5,0.5,0.5),3.0);
        tab[1] = new Emitter(new Position(4.0,0.0,0.0),2.0);
        tab[2] = new Emitter(new Position(4.0,5.0,5.0),4.2);
        tab[3] = new Emitter(new Position(3.0,3.0,3.0),2.5);

        double Dmin;
        double D;

        Position p = new Position(0,0,0);

        // Initialisation of Dmin
        Dmin = Math.abs(Math.sqrt( ( Math.pow(0 - tab[0].getPosition().getX(),2) ) + ( Math.pow(0 - tab[0].getPosition().getY(),2) ) + ( Math.pow(0 - tab[0].getPosition().getZ(),2) )) - tab[0].getD())
                + Math.abs(Math.sqrt( ( Math.pow(0 - tab[1].getPosition().getX(),2) ) + ( Math.pow(0 - tab[1].getPosition().getY(),2) ) + ( Math.pow(0 - tab[1].getPosition().getZ(),2) )) - tab[1].getD())
                + Math.abs(Math.sqrt( ( Math.pow(0 - tab[2].getPosition().getX(),2) ) + ( Math.pow(0 - tab[2].getPosition().getY(),2) ) + ( Math.pow(0 - tab[2].getPosition().getZ(),2) )) - tab[2].getD())
                + Math.abs(Math.sqrt( ( Math.pow(0 - tab[3].getPosition().getX(),2) ) + ( Math.pow(0 - tab[3].getPosition().getY(),2) ) + ( Math.pow(0 - tab[3].getPosition().getZ(),2) )) - tab[3].getD());

        double dx_max, dy_max, dz_max;
        dx_max = dy_max = dz_max = 10.0;

        double pos = 0.1;

        for (double i=pos; i<dx_max; i+=pos) {
            for (double j=pos; j<dy_max; j+=pos) {
                for (double k=pos; k<dz_max; k+=pos) {
                    D = Math.abs(Math.sqrt( ( Math.pow(p.getX()-i,2) ) + ( Math.pow(p.getY()-j,2) ) + ( Math.pow(p.getX()-i,2) ) ) );
                    if (D < Dmin) {
                        Dmin = D;
                        p.setPosition(i,j,k);
                    }
                }
            }
        }

        System.out.println(Dmin);
        p.printPosition();
    }
}

