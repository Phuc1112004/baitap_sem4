import java.sql.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception{
        Customer customer = new Customer();
        int choose=0;
        Scanner input=new Scanner(System.in);
        try {
            do {
                System.out.println("Menu choose :");
                System.out.println("1. Create new customer");
                System.out.println("2. Show all customer");
                System.out.println("3. Update customer");
                System.out.println("4. Delete customer");
                System.out.print("Enter your choice: ");

                choose=input.nextInt();
                switch (choose){
                    case 1:{
                        Customer cus = new Customer();
                        cus.inputData();
                        createCustomers(cus);
                    }
                    break;
                    case 2:{
                        getAllCustomer();
                    }
                    break;
                    case 3:{
                        System.out.println("Enter customer id to update:");
                        int id = input.nextInt();
                        updateCustomer(id);
                    }
                    break;
                    case 4: {
                        System.out.println("Enter customer id to delete:");
                        int id = input.nextInt();
                        deleteCustomer(id);
                    }
                    break;
                    default:
                        System.out.println("Invalid choice!");
                }
            }while (true);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void getAllCustomer() throws  Exception{
        // gọi đối tượng connection từ lớp khác
        Connection connection = MySQLConnectionDB.getMySQLConnection();
        // tạo statement để thực thi truy vấn
        Statement stm = connection.createStatement();
        // cau lẹnh truy van csdl(sql engine)
        String query = "SELECT * FROM customers";
        // thực thi truy, ket qua trả về ResultSet
        ResultSet rs  = stm.executeQuery(query);
        //Doc ban ghi cho den het

        while (rs.next()){
            System.out.println("==============");
            System.out.println("Customer id:" +rs.getInt(1));
            System.out.println("name:" +rs.getString(2));
            System.out.println("name:" +rs.getString(3));
            System.out.println("email:" +rs.getString(4));
        }
        connection.close();
    }

    public static void createCustomers(Customer customer) throws Exception{
//        ...
        try {
            Connection connection = MySQLConnectionDB.getMySQLConnection();
            String query = "INSERT INTO customers(customer_id,first_name,last_name,email) VALUES (?,?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1,customer.getId());
            pstmt.setString(2, customer.getFirstName());
            pstmt.setString(3, customer.getLastName());
            pstmt.setString(4, customer.getEmail());

            int updated = pstmt.executeUpdate();
            if (updated > 0 ){
                System.out.println("New customer added successfully! \n");
            }
            pstmt.close();
            connection.close();

        }catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

    public static Customer findCustomerById(int id) throws Exception{
        Customer cus = null;
        try{
            Connection connection = MySQLConnectionDB.getMySQLConnection();
            PreparedStatement pstmt = connection.prepareStatement(
                    "SELECT * FROM customers WHERE customer_id = ?"
            );

            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()){     // phương tức next() trả về giá trị boolean (true,false)
                cus = new Customer(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                );
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return cus;
    }
    public static void updateCustomer(int id) throws Exception{
//        ...
        try {
            Customer updateCus = Main.findCustomerById(id);
            if (updateCus != null) {
                updateCus.inputData();

                Connection connection = MySQLConnectionDB.getMySQLConnection();
                PreparedStatement pstmt = connection.prepareStatement(
                        "UPDATE customers SET first_name = ?,last_name = ?,email = ? WHERE customer_id = ?"
                );

                pstmt.setString(1, updateCus.getFirstName());
                pstmt.setString(2, updateCus.getLastName());
                pstmt.setString(3, updateCus.getEmail());
                pstmt.setInt(4, updateCus.getId());

                int updated = pstmt.executeUpdate();
                if (updated > 0) {
                    System.out.println("Update Person success!!! \n");
                }

                pstmt.close();
                connection.close();
            }else  {
                System.out.println("Person not found");
            }


        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public static void deleteCustomer(int id) throws Exception{
//        ...
        try {
            Connection connection = MySQLConnectionDB.getMySQLConnection();
            Statement stm = connection.createStatement();
            String query = "DELETE FROM customers WHERE customer_id="+id;
            int deleted = stm.executeUpdate(query);
            if (deleted > 0){
                System.out.println("Customer with ID " + id + " deleted successfully.");
            } else {
                System.out.println("Customer with ID " + id + " not found.");
            }
            stm.close();
            connection.close();

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}