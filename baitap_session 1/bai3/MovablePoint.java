public class MovablePoint implements Movable {
    private int x;
    private int y;
    private int xSpeed;
    private int ySpeed;

    public MovablePoint(int x, int y,int xSpeed,int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed =ySpeed;
    }

    @Override
    public void moveUp() {
        y++;
    }
    @Override
    public void moveDown() {
        y--;
    }

    @Override
    public void moveLeft() {
        x--;
    }
    @Override
    public void moveRight() {
        x++;
    }

    @Override
    public String toString() {
        return "MovablePoint{x=" + x + ", y=" + y + ", xSpeed = " +xSpeed+ ", ySpeed = " + ySpeed + '}';
    }
}
