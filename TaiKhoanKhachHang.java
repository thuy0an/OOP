/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStore;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/**
 *
 * @author Admin
 */
public class TaiKhoanKhachHang {
    private String username;
    private String userpassword;

    
    
    public TaiKhoanKhachHang() {
    }
    
    

    public TaiKhoanKhachHang(String username, String userpassword) {
        this.username = username;
        this.userpassword = userpassword;
    }

    public String getUsername() {
        return username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }
    
    public  void setInfo()
    {
        Scanner input= new Scanner(System.in);
        System.out.println("----Tạo tài khoản----");
        System.out.print("1.Tạo tên đăng nhập: ");
        this.setUsername(input.nextLine());;
        System.out.print("2.Tạo mật khẩu: ");
        this.setUserpassword(input.nextLine());;
        try (FileWriter fileWtr= new FileWriter("user.txt",true))
        {
            StringBuilder sb= new StringBuilder();
            sb.append(this.getUsername()).append("#").append(this.getUserpassword());
            sb.append(System.lineSeparator());
            fileWtr.write(sb.toString());
            fileWtr.flush();
        }catch (IOException e){
            System.out.println("File ko tồn tại");
        }
        System.out.println("Đã tạo tài khoản thành công!");
        
    }
    
    public static int kiemTraDangNhap()
    {
        int tieptuc=1, flag=0;
        do
        {
            Scanner input= new Scanner(System.in);
            String username, userpass;
            System.out.println("----Dăng nhập vào tài khoản----");
            System.out.print("1.Tên đăng nhập: ");
            username=input.nextLine();
            System.out.print("2.Mật khẩu: ");
            userpass=input.nextLine();
            File file= new File("user.txt");
            try (Scanner scan= new Scanner(file)){
                while (scan.hasNextLine())
                {
                    String dong=scan.nextLine();
                    String dulieu[]=dong.split("#");
                    String user=dulieu[0].trim();
                    String pass=dulieu[1].trim();
                    if ( user.equalsIgnoreCase(username.trim()) && pass.equalsIgnoreCase(userpass.trim()))
                    {
                        flag=1;
                        break;
                    } 
                }
                if ( flag ==1)
                {
                    System.out.println("Đăng nhập thành công !");
                    tieptuc=0;
                }
                else 
                {
                    do 
                    {
                    System.out.println("Tài khoản không tồn tại !");
                    System.out.println("Bạn có muốn nhập lại ?");
                    System.out.println("0.Không\t 1.Có");    
                    tieptuc=Integer.parseInt(input.nextLine());
                    if (tieptuc != 1 && tieptuc != 0)
                        System.out.println("Vui lòng chọn đúng thao tác !!");
                    }while (tieptuc != 1 && tieptuc != 0);
                        
                }
            } 
            catch (FileNotFoundException ex) {
               System.out.println("Khong tim thay file user.txt");
            }
            catch(NumberFormatException ei)
            {
                System.out.println("\n--Vui lòng không nhập ký tự!!!--\n");
            }
        }while(tieptuc==1);
        return flag;
    }
    
    public void timKiem(){
        
    }
    
    public void xemGioHang(){
        
    }
    
    public void xoaSanPhamTrongGioHang(){
        
    }
    
    public void themVaoGiohang(){
        
    }
    
    public void xemDonHang(){
        
    }
    
    public void themVaoDonHang(){
        
    }
    
    public void huyDonHang(){
        
    }
    
    public void lichSuDonHang(){
        
    }
    
    public static void chucNangNguoiDung(){
        Scanner input= new Scanner(System.in);
        KhachHang demo= new KhachHang();
        int choice=9;
        do {
            System.out.println("----------Chức năng người dùng---------");
            System.out.println("1. Xem thông tin cá nhân");
            System.out.println("2. Xem danh sách sản phẩm bán");
            System.out.println("3. Tìm kiếm sản phẩm");
            System.out.println("4. Thêm/xóa sản phẩm trong giỏ");
            System.out.println("5. Xem giỏ hàng");
            System.out.println("6. Đặt hàng");
            System.out.println("7. Xem đơn đã đặt");
            System.out.println("8. Hủy đơn");
            System.out.println("9. Thoát khỏi chức năng người dùng");
            System.out.print("Chọn thao tác: ");
            choice=Integer.parseInt(input.nextLine());
            switch(choice)
            {
                case 1:
                    if ( demo.toString().isEmpty())
                    {
                        System.out.println("Không có thông tin. Bạn có muốn nhập thông tin không ?");
                        System.out.print("1. Có || 0. Không ");
                        int choiceCase1=Integer.parseInt(input.nextLine());
                        if(choiceCase1==1)
                        {
                            demo.setInfo();
                            System.out.println(demo.toString());
                        }
                    }else System.out.println(demo.toString());
                   break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                 
                     

            }
        }while (choice!=9);
    }
    
        
    public static void giaodienKhachHang()
    {
        int choice=1;
        do {
            Scanner input= new Scanner(System.in);
            System.out.println("----------Giao diện của Khách Hàng----------");
            System.out.println("1. Chức năng người dùng");
            System.out.println("2. Thoát");
            try{
                do {
                    System.out.print("Chọn thao tác: ");
                    choice=Integer.parseInt(input.nextLine());
                    if ( choice != 1 && choice != 2)
                        System.out.println("Vui lòng chọn đúng thao tác đã hiển thị !!!");
                }while ( choice != 1 && choice!= 2);

                switch(choice)
                {
                    case 1:
                        chucNangNguoiDung();
                        break;
                    case 2:
                        break;
                }
            }
            catch(NumberFormatException ei)
            {
                System.out.println("\n--Vui lòng chọn đúng các thao tác đã hiển thị!!!--\n");
            }
            catch ( Exception e)
            {
                System.out.println(e.getMessage());
            }
            
        }while (choice !=2);
    }
    
    public static void main(String[] args) {
        TaiKhoanKhachHang demo = new TaiKhoanKhachHang();
        demo.setInfo();
    }
    
}
