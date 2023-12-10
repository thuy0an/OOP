/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStore;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class App {
    public static void taoFile()
    {
        try {
            File filebook= new File("book.txt");
            if ( !filebook.exists())
            {
                
            }
            File fileDonHang= new File("DonHang.txt");
            if ( !fileDonHang.exists())
                fileDonHang.createNewFile();
            File fileUser= new File("user.txt");
            if ( !fileUser.exists())
                fileUser.createNewFile();
            File fileUserLogin= new File("userLogin.txt");
            if (!fileUserLogin.exists())
                fileUserLogin.createNewFile();
        } 
        catch (IOException ex) {
            System.out.println("Lỗi IO");
        }
        
    }
    public static void startMenu()
    {
        System.out.println("\t+---------Chào mừng đến với Ứng dụng mua hàng BookStore-------+");
        System.out.printf("\t| %-60s|\n","1. Đăng nhập vào tài khoản");
        System.out.printf("\t| %-60s|\n","2. Tạo tài khoản");
        System.out.printf("\t| %-60s|\n","3. Dùng guest để truy cập vào app");
        System.out.printf("\t| %-60s|\n","4. Dành cho nhân viên");
        System.out.printf("\t| %-60s|\n","0. Thoát.");
        System.out.println("\t+-------------------------------------------------------------+");
    }
    
    public static void main(String[] args) throws IOException {
    
        taoFile();
        int choice=0;
        do {  
            TaiKhoanKhachHang demo= new TaiKhoanKhachHang();
            TaiKhoanNhanVien tk=new TaiKhoanNhanVien();
            startMenu();  
            FileWriter userLogin= new FileWriter("userLogin.txt");
            userLogin.write("");
            userLogin.flush();
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
                    case 4:
                        NhanVien nhanvien=tk.xacMinhTaiKhoanNhanVien();
                        if(nhanvien instanceof NhanVienGiaoHang) 
                        {
                            NhanVienGiaoHang nv=(NhanVienGiaoHang) nhanvien;
                            nv.quanLyDonHang();
			}else if(nhanvien instanceof NhanVienQuanLy) {
                            NhanVienQuanLy nv=(NhanVienQuanLy) nhanvien;
                            nv.quanLy();
			}
                    case 0:
                        FileWriter user= new FileWriter("userLogin.txt");
                            user.write("");
                            user.flush();
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
//                    try{
//                        Thread.sleep(1000);
//                    }catch(InterruptedException e){
//                        System.out.println("lỗi abc");
//                    }ring ngayVaoLam = nhanvien[2];