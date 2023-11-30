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
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Admin
 */
public class TaiKhoanKhachHang {
    private String username;
    private String userpassword;
    private KhachHang khachhang;
    private ArrayList<GioHang> dsgioHang = new ArrayList<>();
    
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

    public KhachHang getKhachhang() {
        return khachhang;
    }

    public ArrayList<GioHang> getDsgioHang() {
        return dsgioHang;
    }

    public void setKhachhang(KhachHang khachhang) {
        this.khachhang = khachhang;
    }

    public void setDsgioHang(ArrayList<GioHang> dsgioHang) {
        this.dsgioHang = dsgioHang;
    }
    
    
    
    public  void setInfo()
    {
        Scanner input= new Scanner(System.in);
        System.out.println("----------Tạo tài khoản----------");
        System.out.print("1.Tạo tên đăng nhập: ");
        this.setUsername(input.nextLine());;
        System.out.print("2.Tạo mật khẩu: ");
        this.setUserpassword(input.nextLine());;
        try (FileWriter fileWtr= new FileWriter("user.txt",true))
        {
            StringBuilder sb= new StringBuilder();
            sb.append(this.getUsername()).append("#").append(this.getUserpassword());
            KhachHang thongtin= new KhachHang();
            thongtin.setInfo();
            sb.append("#").append(thongtin.getMaKH()).append(("#")).append(thongtin.getTenKH()).append(("#")).append(thongtin.getSdt()).append("#").append(thongtin.getEmail()).append("#");
            for ( int i=0; i< thongtin.getDiaChi().size();i++)
             sb.append(thongtin.getDiaChi().get(i)).append(";");
            sb.append(System.lineSeparator());
            fileWtr.write(sb.toString());
            fileWtr.flush();
        }catch (IOException e){
            System.out.println("File ko tồn tại");
        }
        System.out.println("Đã tạo tài khoản thành công!");
        
    }
    
    public  int kiemTraDangNhap()
    {
        int tieptuc=1, flag=0;
        do
        {
            Scanner input= new Scanner(System.in);
            System.out.println("----------Dăng nhập vào tài khoản----------");
            String tenDangNhap, matKhau;
            System.out.print("1.Tên đăng nhập: ");
            tenDangNhap=input.nextLine();
            System.out.print("2.Mật khẩu: ");
            matKhau=input.nextLine();
            File file= new File("user.txt");
            try (Scanner scan= new Scanner(file)){
                String dong, dulieu[] = null, user, pass;
                while (scan.hasNextLine())
                {
                    dong=scan.nextLine();
                    dulieu=dong.split("#");
                    user=dulieu[0].trim();
                    pass=dulieu[1].trim();
                    if ( user.equalsIgnoreCase(tenDangNhap.trim()) && pass.equalsIgnoreCase(matKhau.trim()))
                    {
                        flag=1;
                        break;
                    } 
                }
                if ( flag ==1)
                {
                    System.out.println("Đăng nhập thành công !");
                    this.setUsername(tenDangNhap.trim());
                    this.setUserpassword(matKhau.trim());
                    this.khachhang = new KhachHang(dulieu[2],dulieu[3],dulieu[4],dulieu[5],dulieu[6]);
                    FileWriter fileWrt= new FileWriter("userLogin.txt",true);
                    StringBuilder StrBld= new StringBuilder();
                    StrBld.append(this.getUsername()).append("#").append(this.getUserpassword());
                    fileWrt.write(StrBld.toString());
                    fileWrt.flush();
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
            } catch (IOException ex) {
                System.out.println("Khong tim thay file userLogin.txt");
            } 
        }while(tieptuc==1);
        return flag;
    }


    private boolean checkSanPhamTrongGio(String maKhachHang,String maSanPham, int soLuong)
    {
        boolean flag=false;
        try {
            
            File fileSach= new File("GioHang.txt");
            StringBuilder sanPham= new StringBuilder();
            Scanner scan= new Scanner(fileSach);
            while ( scan.hasNextLine())
            {
                String dong=scan.nextLine();
                String dulieu[]=dong.split("#");
                if ( maKhachHang.equalsIgnoreCase(dulieu[0]) && maSanPham.equalsIgnoreCase(dulieu[1]))
                {
                    dulieu[4]=String.valueOf(Integer.parseInt(dulieu[4])+soLuong);
                    System.out.println("Doc duoc du lieu");
                    flag=true;
                }
                sanPham.append(String.join("#", dulieu));
                sanPham.append(System.lineSeparator());
            }
            if (flag)
            {
                try (PrintWriter gioHang = new PrintWriter("GioHang.txt")) {
                    gioHang.println(sanPham.toString());
                }
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Không tìm được file");
        }
        return flag;
    }
    
    public  void themVaoGiohang(){
    File fileSach=new File("book.txt");
        try {
            Scanner docFileSach= new Scanner(fileSach);
            Scanner input= new Scanner(System.in);
            String maSanPham;
            int soLuongSanPham, kiemTraSach=0;
            System.out.print("Chọn mã sản phẩm để thêm vào giỏ: ");
            maSanPham=input.nextLine();
            while ( docFileSach.hasNextLine())
            {
                String Sach=docFileSach.nextLine();
                String thongTinSach[]=Sach.split("#");
                if ( maSanPham.equalsIgnoreCase(thongTinSach[1]))
                {
                    kiemTraSach=1;
                    System.out.print("Chọn số lượng muốn thêm vào giỏ: ");
                    soLuongSanPham=Integer.parseInt(input.nextLine());
                    if ( checkSanPhamTrongGio(this.khachhang.getMaKH(), maSanPham, soLuongSanPham)==true)
                    {
                        System.out.println("Bạn đã thêm sách thành công với sách đã có ^^");
                    }
                    else 
                    {
                        FileWriter fileWrt= new FileWriter("GioHang.txt",true);
                        StringBuilder StrBuilder= new StringBuilder();
                        StrBuilder.append(this.khachhang.getMaKH());
                        StrBuilder.append("#").append(maSanPham);
                        StrBuilder.append("#").append(thongTinSach[0]);
                        StrBuilder.append("#").append(thongTinSach[8]);
                        StrBuilder.append("#").append(soLuongSanPham);
                        StrBuilder.append("#").append(Double.parseDouble(thongTinSach[6])*soLuongSanPham);
                        StrBuilder.append(System.lineSeparator());
                        fileWrt.write(StrBuilder.toString());
                        fileWrt.flush();
                        System.out.println("Bạn đã thêm sách thành công ^^");
                    }              
                }   
            }
            if (kiemTraSach != 1)
                System.out.println("Không có mã sách này trong kho !!!");
        } catch (FileNotFoundException ex) {
            System.out.println("Không tìm thấy file !!!");
        } catch (IOException ex) {
            System.out.println("Không tìm thấy file !!!");
        }
              
    }
    
    
    public void xoaSanPhamTrongGioHang(){
        Scanner input= new Scanner(System.in);
        File fileGioHang= new File("GioHang.txt");
        
    }
        
        
    public void xemDonHang(){
        
    }
    
    public void DatDonHang(){
        
        
    }
    
    public void huyDonHang(){
        
    }
    
    public void lichSuDonHang(){
        
    }
    
    
    
    public  void chucNangNguoiDung(){
        Scanner input= new Scanner(System.in);
        File file= new File("user.txt");
        int choice;
        
        do {
            System.out.println("\t+---------------------------------------------Chức năng người dùng---------------------------------------------+");
            System.out.printf("\t| %-35s| %-35s| %-35s|\n","1.Xem thông tin cá nhân","2.Xem danh sách sản phẩm bán","3.Tìm kiếm sản phẩm");
            System.out.printf("\t| %-35s| %-35s| %-35s|\n","4.Thêm sản phẩm trong giỏ","5.Xem giỏ hàng","6.Xóa sản phẩm trong giỏ hàng");
            System.out.printf("\t| %-35s| %-35s| %-35s|\n","7.Đặt đơn hàng","8.Xem đơn đã đặt","9.Hủy đơn hàng");
            System.out.printf("\t| %-109s|\n", "0.Thoát khỏi chức năng người dùng  |");
            System.out.println("\t+--------------------------------------------------------------------------------------------------------------+");
            System.out.print("Chọn thao tác: ");
            choice=Integer.parseInt(input.nextLine());
            switch(choice)
            {
                case 1:
                    if ( this.khachhang.toString().isEmpty())
                    {
                        System.out.println("Không có thông tin. Bạn có muốn nhập thông tin không ?");
                        System.out.print("1. Có || 0. Không ");
                        int choiceCase1=Integer.parseInt(input.nextLine());
                        if(choiceCase1==1)
                        {
                            this.khachhang.setInfo();
                            
                            System.out.println(this.khachhang.toString());
                        }
                    }else System.out.println(this.khachhang.toString());
                   break;
                case 2:
                    TuSach.hienThiSachDangKinhDoanh();
                    break;
                case 3:
                    TuSach.timSach();
                    break;
                case 4:
                    themVaoGiohang();
                    break;
                case 5:
                    GioHang.xemGioHang();
                    break;
                case 6:
                    xoaSanPhamTrongGioHang();
                    break;
                case 7:
                    CT_DonHang demo= new CT_DonHang();
                    demo.setInfo();
                    break;
                case 8:
                    break;
                 
                     

            }
        }while (choice!=0);
    }
    
        
    public void giaodienKhachHang()
    {
        int choice=1;
        do {
            Scanner input= new Scanner(System.in);
            System.out.println("\t+-------------Giao diện của Khách Hàng---------+");
            System.out.printf("\t| %-45s|\n","1. Chức năng người dùng");
            System.out.printf("\t| %-45s|\n","0. Thoát");
            System.out.println("\t+----------------------------------------------+");
            
            try{
                do {
                    System.out.print("Chọn thao tác: ");
                    choice=Integer.parseInt(input.nextLine());
                    if ( choice != 1 && choice != 0)
                        System.out.println("Vui lòng chọn đúng thao tác đã hiển thị !!!");
                }while ( choice != 1 && choice!= 0);

                switch(choice)
                {
                    case 1:
                        chucNangNguoiDung();
                        break;
                    case 0:
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
            
        }while (choice !=0);
    }
    
    
}
