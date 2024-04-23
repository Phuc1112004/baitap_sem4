import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws Exception {

        Repository repository = new Repository();
        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true;

        while (continueLoop) {
            Menu.mainMenu();
            int choose = scanner.nextInt();
            switch (choose) {
                case 0:
                    continueLoop = false;
                    break;

                case 1:
                    System.out.println("DANH SÁCH SẢN PHẨM");
                    repository.show();
                    break;

                case 2:
                    System.out.println("Các sản phẩm có giá trên 10000: ");
                    repository.filterProductByPrice();
                    break;

                case 3:
                    repository.countProductsByAmountSale();
                    break;

                case 4:
                    System.out.println("Nhập loại sản phẩm muốn hiển thị (FOOD, HOUSEWARE, COSMETICS, FASHION): ");
                    String categoryInput = scanner.next();
                    Category category = Category.valueOf(categoryInput.toUpperCase());     //categoryInput.toUpperCase() chuển đổi thành chữ in hoa
                    repository.showProductsByCategory(category);
                    break;

                case 5:
                    repository.sortProductsByAmountSale();
                    break;

                case 6:
                    Product bestSellingProduct = repository.getBestSellingProduct();
                    if (bestSellingProduct != null) {
                        System.out.println("Sản phẩm bán được nhiều nhất:");
                        System.out.println(bestSellingProduct);
                    } else {
                        System.out.println("Không có sản phẩm nào trong cửa hàng.");
                    }
                    break;

                case 7:
                    repository.sortProductByName();
                    System.out.println("Sản phẩm sau khi sắp xếp: ");
                    repository.show();
                    break;

                default:
                    System.out.println("Mục bạn chọn không hợp lệ. Vui lòng chọn lại!");
                    break;
            }
        }
        scanner.close();
    }
}