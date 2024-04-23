public enum Category {
    FOOD("Thực Phẩm"),HOUSEWARE("Đồ gia dụng"),COSMETICS("Mỹ phẩm"),FASHION("Thời trang");

    private String value;

    Category(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
