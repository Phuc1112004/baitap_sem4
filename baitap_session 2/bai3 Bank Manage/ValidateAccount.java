public class ValidateAccount {
    // Kiểm tra đăng nhập
    public final String MOBILE = "123456789";
    public final String PASSWORD = "trinhvanphuc";

    public boolean checkAcount(String mobile, String password) {
        if (mobile.equals(MOBILE)) {
            if (password.equals(PASSWORD)) {
                System.out.println("Đăng nhập thành công!");
                return true;
            } else {
                System.out.println("Mật khẩu sai, vui lòng nhập lại");
                return false;
            }
        } else {
            System.out.println("Kiểm tra lại số điện thoại hoặc mật khẩu");
            return false;
        }
    }
}