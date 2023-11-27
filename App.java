/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStore;


import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class App {

    public static void startMenu()
    {
        System.out.println("---------Chào mừng đến với Ứng dụng mua hàng BookStore---------");
        System.out.println("1. Đăng nhập vào tài khoản");
        System.out.println("2. Tạo tài khoản");
        System.out.println("3. Dùng guest để truy cập vào app");
        System.out.println("4. Thoát.");
    }
    
    public static void main(String[] args) {
        int choice=0;
        do {
            Scanner input= new Scanner(System.in);
            startMenu();
            try {
                System.out.print("Chọn thao tác: ");
                choice=Integer.parseInt(input.nextLine());
                switch(choice)
                {
                    case 1:
                        int check=TaiKhoanKhachHang.kiemTraDangNhap();
                        if ( check==1)
                        {
                            TaiKhoanKhachHang.giaodienKhachHang();

                        }
                        break;
                        
                    case 2:
                        TaiKhoanKhachHang demo= new TaiKhoanKhachHang();
                        demo.setInfo();
                        break;
                    case 3:
                        System.out.println("Đăng nhập thành công");
                        break;
                    case 4:
                        FileWriter userLogin= new FileWriter("userLogin.txt");
                            userLogin.write("");
                            userLogin.flush();
                            break;
                        
                        
                }
                if ( choice < 1 || choice > 4)
                System.out.println("\n--Vui lòng chọn đúng các thao tác đã hiển thị!!!--\n");
            } 
            catch(NumberFormatException ei)
            {
                System.out.println("\n--Vui lòng chọn đúng các thao tác đã hiển thị!!!--\n");
            }
            catch ( Exception e)
            {
                System.out.println(e.getMessage());
            }
            
            if ( choice==4)
                System.out.println("Cảm ơn đã xử dụng dịch vụ ^^");
            
        }while (choice !=4);
    }
    
}

