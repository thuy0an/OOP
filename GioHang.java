
package BookStore;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import BookStore.KhachHang;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GioHang {
    private ArrayList<CT_GioHang> dsSanPham= new ArrayList<>();

    public GioHang() {
        
    }

    public ArrayList<CT_GioHang> getDsSanPham() {
        return dsSanPham;
    }

    public void setDsSanPham(CT_GioHang GioHang) {
        this.dsSanPham.add(GioHang);
    }

    public void setDsSanPham(ArrayList<CT_GioHang> dsSanPham) {
        this.dsSanPham = dsSanPham;
    }
    
    
    
    
    public void ghiGioHangVaoFile(String fileGioHang) {

        try (PrintWriter printWriter = new PrintWriter(fileGioHang)) {
            StringBuilder sb = new StringBuilder();
            for (CT_GioHang giohang : this.getDsSanPham()) {

                sb.append(giohang.getMaKhachhang()).append("#");
                sb.append(giohang.getMaSach()).append("#");
                sb.append(giohang.getTenSach()).append("#");
                sb.append(giohang.getLoaiSach()).append("#");
                sb.append(giohang.getGiaSach()).append("#");
                sb.append(giohang.getSoLuong()).append("#");
                sb.append(giohang.getThanhTien());
                sb.append(System.lineSeparator()); //Xuống dòng
            }
            printWriter.println(sb.toString());
        } catch (IOException e) {
            System.out.println("Khong hop le" + e.getMessage());
        }
    }
    
    
    
    public void xemGioHang(String fileGioHang) {
        File file= new File(fileGioHang);
        try (Scanner scanner = new Scanner(file))
        {
            System.out.println("\t+-------------------------------------------------------------------------------------------------+");
            System.out.println("\t|                                           GIO HANG CUA BAN                                      |");
            System.out.println("\t|-------------------------------------------------------------------------------------------------|");
            System.out.printf("\t| %-50s| %-8s| %-10s| %-10s |%-10s| %-10s| \n", "Ten Sach", "Ma Sach", "Loai Sach","Gia sach" ,"So Luong", "Thanh Tien");
            System.out.println("\t+---------------------------------------------------+---------+-----------+-----------+-----------+");
            while(scanner.hasNextLine()){ 
                String line = scanner.nextLine();
                String[] gioHang = line.split("#");
                String maSach = gioHang[1];
                String tenSach = gioHang[2];
                String loaiSach = gioHang[3];
                String giaSach=gioHang[4];
                String soLuong = gioHang[5];
                String thanhTien = gioHang[6];
                System.out.printf("\t| %-50s| %-8s| %-10s| %-10s | %-10s| %-10s| %n",tenSach, maSach, loaiSach,giaSach,soLuong, thanhTien,"|");
                System.out.println("\t+---------------------------------------------------+---------+-----------+-----------+-----------+");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Không tìm thấy file");
        }
        catch (Exception e) {
            System.out.println("");
        }
        
    }
    /*
    private boolean timGioHangTheoMaKhachHang(String maKhachHang) {
        File user= new File("user.txt");
        File userLogin= new File("userLogin.txt");
        try {
            Scanner scan= new Scanner(user);
            Scanner scan2= new Scanner(userLogin);
            String taikhoanDangNhap=scan2.nextLine();
            String tkDangNhap[]=taikhoanDangNhap.split("#");
            while ( scan.hasNextLine())
            {
                String dulieuTaiKhoan=scan.nextLine();
                String taiKhoan[]=dulieuTaiKhoan.split("#");
                if ( taiKhoan[0].equalsIgnoreCase(tkDangNhap[0]) && taiKhoan[1].equalsIgnoreCase(tkDangNhap[1]) && taiKhoan[2].equalsIgnoreCase(maKhachHang))
                    return true;
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("Không tìm thấy file !!!");
        }
        return false;
    }
    */
}    
 