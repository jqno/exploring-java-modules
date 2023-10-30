package nl.jqno.module;

public final class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Point other && x == other.x && y == other.y;
    }

    @Override
    public int hashCode() {
        return x + (31 * y);
    }
}
