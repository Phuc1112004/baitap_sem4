public class MovableCircle implements Movable{
    private int x;
    private int y;
    private int xSpeed;
    private int ySpeed;

    public MovableCircle(int x, int y,int xSpeed,int ySpeed) {
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
}
