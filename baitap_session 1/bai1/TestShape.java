public class TestShape {
    public static  void main(String[] args){
        Rectangle rectangle = new Rectangle(3,4);
        Triangle triangle = new Triangle(6,3);

        System.out.println("Diện tích của hình chữ nhật: " + rectangle.getArea());
        System.out.println("Diện tích của tam giác: " + triangle.getArea());
    }
}
