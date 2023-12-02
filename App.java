/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStore;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class App {
    public static void startMenu()
    {
        System.out.println("\t+---------Chào mừng đến với Ứng dụng mua hàng BookStore-------+");
        System.out.printf("\t| %-60s|\n","1. Đăng nhập vào tài khoản");
        System.out.printf("\t| %-60s|\n","2. Tạo tài khoản");
        System.out.printf("\t| %-60s|\n","3. Dùng guest để truy cập vào app");
        System.out.printf("\t| %-60s|\n","0. Thoát.");
        System.out.println("\t+-------------------------------------------------------------+");
    }
    
    public static void main(String[] args) {
    
        int choice=0;
        do {  
            TaiKhoanKhachHang demo= new TaiKhoanKhachHang();
            startMenu();    
            Scanner input= new Scanner(System.in);
            try {

                System.out.print("Chọn thao tác: ");
                choice=Integer.parseInt(input.nextLine());
                switch(choice)
                {
                    case 1:
                        int check=demo.kiemTraDangNhap();
                        if ( check==1)
                            demo.giaodienKhachHang();
                        break;
                        
                    case 2:
                        demo.setInfo();
                        break;
                    case 3:
                        demo.chucNangChoKhach();
                        break;
                    case 0:
                        FileWriter userLogin= new FileWriter("userLogin.txt");
                            userLogin.write("");
                            userLogin.flush();
                            break;    
                }
                if ( choice < 0 || choice > 3)
                System.out.println("\n--Vui lòng chọn đúng các thao tác đã hiển thị!!!--\n");

            } 
            catch(NumberFormatException ei)
            {
                System.out.println("\n--Vui lòng chọn đúng các thao tác đã hiển thị!!!--\n");
            }
            catch ( IOException e)
            {
                System.out.println("Lỗi không tìm được file");
            }
            
            if ( choice==0)
                System.out.println("Cảm ơn đã xử dụng dịch vụ ^^");
            
        }while (choice !=0);
    }
    
}

