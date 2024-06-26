public class TestMovablePoint {
    public static void main(String[] args) {
        MovablePoint point = new MovablePoint(3, 5);

        System.out.println("Initial point: " + point);
        point.moveUp();
        System.out.println("After moving up: " + point);
        point.moveLeft();
        System.out.println("After moving left: " + point);
        point.moveDown();
        System.out.println("After moving down: " + point);
        point.moveRight();
        System.out.println("After moving right: " + point);
    }
}
