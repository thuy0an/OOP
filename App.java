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
        System.out.printf("\t| %-60s|\n","0. Thoát.");
        System.out.println("\t+-------------------------------------------------------------+");
    }
    
    public static void main(String[] args) {
    
        taoFile();
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

/*   public void danhGia(String tenfile) {
        ArrayList<CT_DonHang> dsDonHang = DanhGia.docDonHangTuFile(tenfile);
        
        if (dsDonHang.isEmpty()) {
            System.out.println("Bạn không có đơn hàng nào cần đánh giá!!");
        } else {
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhập mã đơn hàng muốn đánh giá: " );
        String maDon = scan.nextLine();
        for (CT_DonHang donhang : dsDonHang) {
            if (maDon.equalsIgnoreCase(donhang.getMaDonHang()) && donhang.getTrangThai()== 4) 
{

                System.out.println("Nhập mã sách muốn đánh giá: ");
                String maSach = scan.nextLine();
                String dulieu[] = donhang.getDsSanPham().split(" ;");
                for (String dulieu1 : dulieu) {
                    String sach[] = dulieu1.split(" x");
                    if (maSach.equalsIgnoreCase(sach[1])) {
                        this.setInfo();
                        System.out.println("Bạn muốn lưu đánh giá??");
                        System.out.println("1. Lưu đánh giá || 2. Bỏ lưu đánh giá");
                        int chon = 0;
                        switch (chon) {
                            case 1: 
                             LocalDateTime myDateObj = LocalDateTime.now();   
                             DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                             this.setNgayDG(myDateObj.format(myFormatObj));   
                             String fileName = "DanhGia.txt";
                             File file = new File(fileName);
                             try (FileWriter fileWriter = new FileWriter(file, true)) {
                                {
                                StringBuilder sb = new StringBuilder();
                                sb.append(this.getMaKhachHang()).append("#");
                                sb.append(this.getMaDonHang()).append("#");
                                sb.append(this.getMaSach()).append("#");
                                sb.append(this.getNgayDG()).append("#");
                                sb.append(this.getSao()).append("#");
                                sb.append(this.getBinhLuan()).append("#");
                                sb.append(System.lineSeparator()); //Xuống dòng
                                fileWriter.write(sb.toString()); //Ghi chuỗi thông tin vào file
                                fileWriter.flush(); 
                                }  
                             } catch (IOException e) {
                                    System.out.println("Có lỗi khi ghi vào file: " + e.getMessage());
                                }
                            case 2:
                                break;
                            }
                        } else {
                            System.out.println("Không thể đánh giá! Vui lòng nhập lại");
                            break;
                        }
                    }
                } else {
                    System.out.println("Mã đơn hàng không phù hợp! Vui lòng nhập lại!");
                    break;
                }
            } 
        }
    }
*/
