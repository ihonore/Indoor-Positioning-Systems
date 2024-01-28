package nlateration;

public class Emitter {
    private Position position;
    private double d;

    public Emitter(Position position, double d) {
        this.position = position;
        this.d = d;
    }

    public Position getPosition() {
        return position;
    }

    public double getD() {
        return d;
    }
}
