import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private static long balanceNumber = 1000000;
    List<TransactionHistory> listHistory = new ArrayList<TransactionHistory>();;
    public long getBalanceNumber(){
        return balanceNumber;
    }
    public static long transfer(long money) {
        //Kiểm tra nếu số tiền nhỏ hơn 50.000 thì thông báo số tiền chuyển tối thiểu phải là 50.000
        // Nếu số tiến chuyến lớn hơn số dư thì thông báo tài khoản không đủ
        // Nếu chuyển thành công, thì thông báo chuyển khoản thành công, in ra số dư mới và thêm lịch sử giao dịch này
        if(balanceNumber< 50000){
            System.out.println("Số tiền tối thiểu phải là 50.000");
        }else if (money > balanceNumber){
            System.out.println("Số dư tài khoản Không đủ");
        }else {
            balanceNumber -= money;
        }

        return balanceNumber;
    }

    public void actionTransfer() {
        // Thực hiện các công việc như nhập số tài khoản thụ hưởng, số tiền mô tả tại đây
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số tk hưởng thụ:");
        String beneficiaryAccount = scanner.nextLine();
        System.out.println("Nhập số tiền cần chuyển:");
        long money = scanner.nextLong();
        System.out.print("Mô tả: ");
        String description = scanner.nextLine();
        System.out.println("Chuyển khoản thành công tới số tài khoản " + beneficiaryAccount + "!\n");
        LocalDate dayTrading = LocalDate.now();
        transfer(money);
        listHistory.add(new TransactionHistory(IdGenerate.getNewID(),dayTrading,description,beneficiaryAccount,money));
    }

    public void getHistory(){
        // In danh sách lịch sử giao dich
        // sử dụng foreach:
        for (TransactionHistory history : listHistory){
            System.out.println("Danh sách lịch sử giao dịch:" + history);
        }
    }
    //Định dạng số tiền theo mình mong muốn
    public static String formatMoney (long money) {
        DecimalFormat formatter = new DecimalFormat("###,###,##0.00");
        //100000->100,000.00
        return formatter.format(money);
    }
}
