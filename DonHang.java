
package BookStore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DonHang {
    private CT_DonHang chitietDonHang;

    public DonHang() {
    }

    public CT_DonHang getChitietDonHang() {
        return chitietDonHang;
    }

    public void setChitietDonHang(CT_DonHang chitietDonHang) {
        this.chitietDonHang = chitietDonHang;
    }


/*
public void datHang() {
        System.out.println("--BẠN CÓ XÁC NHẬN ĐẶT HÀNG?--");
        System.out.println("1. Đồng ý đặt hàng");
        this.getChitietDonHang().ch
        this.getChitietDonHang().chonDiaChi();
        this.getChitietDonHang().chonPTTT();
        System.out.println("2. Xem thêm sản phẩm");
        int chon = 0;
        do {
            Scanner scan = new Scanner(System.in);
            chon = Integer.parseInt(scan.nextLine());
            switch (chon){
                case 1:
                    donhang.setTrangThai(1);
                    donhang.setMaDonHang(donhang.taoMaDH());
                    donhang.getDsSanPham();
                    donhang.setTongTien(donhang.tinhTongTien()); 
                            LocalDateTime myDateObj = LocalDateTime.now();   
                            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            donhang.setNgayDH(myDateObj.format(myFormatObj));
                            try (FileWriter fileWriter = new FileWriter("DonHang.txt", true)) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(donhang.getKhachHang().getMaKH()).append("#");
                                    sb.append(donhang.getMaDonHang()).append("#");
                                    sb.append(donhang.getKhachHang().getEmail()).append("#");
                                    sb.append(donhang.chonDiaChi()).append("#");
                                    sb.append(donhang.getNgayDH()).append("#");
                                    ArrayList<Sach> dsSanPham = donhang.getDsSanPham();
                                    for (Sach sach : dsSanPham) {
                                        sb.append(sach.getTenSach()).append(" x").append(sach.getSoLuongMua()).append(";");
                                    }
                                    sb.append("#");
                                    sb.append(donhang.tinhTongTien()).append("#");
                                    sb.append(donhang.getTrangThai()).append("#");
                                    sb.append(System.lineSeparator()); //Xuống dòng
                                    fileWriter.write(sb.toString()); //Ghi chuỗi thông tin vào file
                                    fileWriter.flush(); 
                                    System.out.println("ĐẶT HÀNG THÀNH CÔNG!");
                                    //phương thức cập nhật số lượng sách tồn kho
                            }
                                catch (IOException e) {
                                    System.out.println("\n ĐẶT HÀNG KHÔNG THÀNH CÔNG! \n");
                                    System.out.println("Có lỗi khi ghi vào file: " + e.getMessage());
                            }
                            break;
                        case 2:
                             //ve trang chu    
                    }
                    if (chon < 1 || chon > 2)
                            System.out.println("\n Vui lòng xác nhận đặt hàng! \n");
                } while (chon != 3);
    }
*/
    
/*    
    public void ghiDsDonHangVaoFile() {
        String fileName = "DonHang.txt";
        File file = new File(fileName);
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            for (CT_DonHang donhang : this.getChitietDonHang())
                {
                StringBuilder sb = new StringBuilder();
                sb.append(donhang.getMaKH()).append("#");
                sb.append(donhang.getMaDonHang()).append("#");
                sb.append(donhang.getEmail()).append("#");
                sb.append(donhang.getDiaChi()).append("#");
                sb.append(donhang.getNgayDH()).append("#");
                sb.append(donhang.getDsSanPham()).append("#");
                sb.append(donhang.getTongTien()).append("#");
                sb.append(donhang.getTrangThai()).append("#");
                sb.append(System.lineSeparator()); //Xuống dòng
                fileWriter.write(sb.toString()); //Ghi chuỗi thông tin vào file
                fileWriter.flush(); 
                }  
            } 
        catch (IOException e) {
            System.err.println("Có lỗi khi ghi vào file: " + e.getMessage());
        }   
    }
*/
    
/*    
        public void datHang(String tenfile) {
            if (null!= this.getDsSanPham()) {
                
                this.setInfo();
                System.out.println("--BẠN CÓ XÁC NHẬN ĐẶT HÀNG?--");
                System.out.println("1. Đồng ý đặt hàng");
                System.out.println("2. Xem thêm sản phẩm");
                int chon = 0;
                do {
                    Scanner scan = new Scanner(System.in);
                    chon = Integer.parseInt(scan.nextLine());
                    switch (chon) {
                        case 1:
                            this.setTrangThai(0);
                            this.setMaDonHang(taoMaDH());
                            this.hienThiSanPham(tenfile);
                            this.setTongTien(this.tinhTongTien(tenfile)); 
                            LocalDateTime myDateObj = LocalDateTime.now();   
                            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            this.setNgayDH(myDateObj.format(myFormatObj));
                            try (FileWriter fileWriter = new FileWriter("DonHang.txt", true)) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(this.getMaKH()).append("#");
                                    sb.append(this.getMaDonHang()).append("#");
                                    sb.append(this.getEmail()).append("#");
                                    sb.append(this.chonDiaChi()).append("#");
                                    sb.append(this.getNgayDH()).append("#");
                                    sb.append(this.hienThiSanPham(tenfile)).append("#");
                                    sb.append(this.tinhTongTien(tenfile)).append("#");
                                    sb.append(this.chonPTTT()).append("#");
                                    sb.append(this.getTrangThai()).append("#");
                                    sb.append(System.lineSeparator()); //Xuống dòng
                                    fileWriter.write(sb.toString()); //Ghi chuỗi thông tin vào file
                                    fileWriter.flush(); 
                                    System.out.println("ĐẶT HÀNG THÀNH CÔNG!");
                                    //phương thức cập nhật số lượng sách tồn kho
                            }
                                catch (IOException e) {
                                    System.out.println("\n ĐẶT HÀNG KHÔNG THÀNH CÔNG! \n");
                                    System.out.println("Có lỗi khi ghi vào file: " + e.getMessage());
                            }
                            break;
                        case 2:
                             break; 
                    }
                    if (chon < 1 || chon > 2)
                            System.out.println("\n Vui lòng xác nhận đặt hàng! \n");
                } while (chon != 3);
            }
    }
    
    public String hienThiSanPham(String tenfile) {
        String dsSanPham = null;
        ArrayList<CT_GioHang> giohang = this.chonSachTuDanhSach(tenfile);
        for (CT_GioHang giohang1 : giohang) {
            dsSanPham = giohang1.getTenSach() + " x" + giohang1.getMaSach() + " x" + giohang1.getSoLuong() + " ;";
        }
        return dsSanPham;
    }
    
    private Double tinhTongTien(String tenfile) {
        Double tongTien = null;
        ArrayList<CT_GioHang> giohang = this.chonSachTuDanhSach(tenfile);
        for (CT_GioHang giohang1 : giohang) {
            tongTien += giohang1.getThanhTien();
        }
        return tongTien;
    }
    
*/    
    public static void xemDonHang()
    {
        File fileDonHang= new File("DonHang.txt");
        try (Scanner scan= new Scanner(fileDonHang);){
            System.out.println("\t+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("\t|                                                                                                   DON HANG CUA BAN                                                         |");
            System.out.println("\t|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
            System.out.printf("\t| %-10s| %-10s| %-20s| %-20s| %-10s| %-100s| %-10s | %-20s | %-5s |\n", "Ma Khach", "Ma don", "Email", "Dia chi", "Ngay dat","Thong tin san pham","Tong tien","PTTT","Trang thai don");
            System.out.println("\t+-----------+-----------+---------------------+---------------------+-----------+-----------------------------------------------------------------------------------------------------+------------+---------+");
            while ( scan.hasNextLine())
            {
                String line=scan.nextLine();
                String donhang[]=line.split("#");
                String maKH=donhang[0];
                String maDon=donhang[1];
                String email=donhang[2];
                String diachi=donhang[3];
                String ngaydat=donhang[4];
                String sanpham=donhang[5];
                String tongtien=donhang[6];
                String pttt=donhang[7];
                String trangthai="";
                if( donhang[8].equalsIgnoreCase("0"))
                    trangthai="Dang xu ly";
                else if (donhang[8].equalsIgnoreCase("1"))
                    trangthai="Da xac nhan";
                else if (donhang[8].equalsIgnoreCase("2"))
                    trangthai="Dang giao";
                else if (donhang[8].equalsIgnoreCase("4"))
                    trangthai="Da nhan hang";
                System.out.printf("\t| %-10s| %-10s| %-20s| %-20s| %-10s| %-100s| %-10s | %-20s | %-5s |\n",maKH,maDon,email,diachi,ngaydat,sanpham,tongtien,pttt,trangthai);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Không tìm được file DonHang.txt");
        }
    }
   
    public static void main(String[] args) {
        xemDonHang();
    }
    
    
    
}