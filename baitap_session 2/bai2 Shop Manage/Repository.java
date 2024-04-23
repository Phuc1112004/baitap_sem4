import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Repository {
    List<Product> listProducts = new ArrayList<>();

    public Repository() {
        listProducts.add(new Product( "01", "Bánh Doraemon 3 vi", Category.FOOD, 108, 3588, 57));
        listProducts.add(new Product( "02", "Xúc xích sườn non", Category.FOOD, 150, 3500, 12));
        listProducts.add(new Product("03", "Thanh cua", Category.FOOD, 100, 5006, 85));
        listProducts.add(new Product("04", "Bánh khoai môn", Category.FOOD, 200, 42000, 78));
        listProducts.add(new Product( "05", "Thìa ăn cơm inox ma vàng", Category.HOUSEWARE, 50, 8000, 4));
        listProducts.add(new Product( "06", "Bát đựng gia vị", Category.HOUSEWARE, 65, 4000, 44));
        listProducts.add(new Product( "07", "Nước Hoa Hồng Soothing Facial Toner Simple", Category.COSMETICS, 148, 92800, 88));
        listProducts.add(new Product( "08", "Combo gội xả HAIRBURST", Category.COSMETICS, 188, 639880, 7));
        listProducts.add(new Product( "09", "Tinh chất dưỡng ẩm sâu Klairs Rich Moist Soothing Serum", Category.COSMETICS, 58, 249000, 24));
        listProducts.add(new Product( "10", "Kem dương ông thể Paula's Choice RESIST WEIGHTLESS BODY TREATMENT", Category.COSMETICS, 80, 715000, 63));
        listProducts.add(new Product( "11",  "Ao thun TSUN", Category.FASHION, 250, 320000, 146));
    }

    public void show(){
    //Sử dụng foreach
      for (Product product : listProducts) {
          System.out.println(product);
      }
//      Sử dụng lambda
//        listProducts.forEach(product -> System.out.println(product));
    }

    public void sortProductByName() {
        // Sử dụng Comparator
        listProducts.sort(new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getName().compareTo(p2.getName());
            }
        });

        // Sử dụng lambda
//        listProducts.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
    }

    public void filterProductByPrice(){
        for (Product product : listProducts) {
            if (product.getPrice() > 10000) {
                System.out.println(product);
            }
        }

        // Sử dụng lambda và stream
//        listProducts.stream()
//                .filter(product -> product.getPrice() > 10000)
//                .forEach(product -> System.out.println(product));
    }

    public void countProductsByAmountSale() {
        long count = listProducts.stream()
                .filter(product -> product.getAmountSale() >= 50)
                .count();
        System.out.println("Số lượng sản phẩm bán được từ 50 trở lên là: " + count);
    }


    // Phương thức để lọc và hiển thị sản phẩm theo loại sản phẩm
    public void showProductsByCategory(Category category) {
        List<Product> productsByCategory = listProducts.stream()          //chuyển đổi thành luồng (stream)
                .filter(product -> product.getCategory() == category)     //lọc sp từ luồng(stream)
                .collect(Collectors.toList());                            //tạo 1 danh sách mới khi lọc qua sp

        if (productsByCategory.isEmpty()) {
            System.out.println("Không có sản phẩm nào thuộc loại " + category);
        } else {
            System.out.println("DANH SÁCH SẢN PHẨM THUỘC LOẠI " + category + ":");
            showProductsByCategory(productsByCategory);
        }
    }
    public void showProductsByCategory(List<Product> productListByCategory) {
        for (Product product : productListByCategory) {
            System.out.println(product);
        }
    }

    public void sortProductsByAmountSale() {
        // Sử dụng Comparator để so sánh theo số lượng bán được
        Comparator<Product> amountSaleComparator = new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return Long.compare(p1.getAmountSale(), p2.getAmountSale());
            }
        };

        // Sắp xếp danh sách sản phẩm theo số lượng bán được
        listProducts.sort(amountSaleComparator);
        System.out.println("DANH SÁCH SẢN PHẨM SAU KHI SẮP XẾP THEO SỐ LƯỢNG BÁN ĐƯỢC:");
        show();   // Hiển thị danh sách sản phẩm sau khi sắp xếp
    }

    public Product getBestSellingProduct() {
        if (listProducts.isEmpty()) {
            return null;
        }
        Comparator<Product> amountSaleComparator = Comparator.comparingLong(Product::getAmountSale);
        // Sắp xếp danh sách sản phẩm theo số lượng bán được, sản phẩm đầu tiên sẽ là sản phẩm bán được nhiều nhất
        listProducts.sort(amountSaleComparator.reversed());
        // Trả về sản phẩm đầu tiên trong danh sách đã sắp xếp
        return listProducts.get(0);
    }
}
