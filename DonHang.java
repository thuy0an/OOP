
package BookStore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    private void xuLySoLuongSanPham(ArrayList<CT_GioHang> sanPhamDatHang)
    {
        File file= new File("book.txt");
        StringBuilder noiDungSach= new StringBuilder();
        try(Scanner scan= new Scanner(file))
        {   
           while (scan.hasNextLine())
           {
               String dulieu=scan.nextLine();
               String thongtinSach[]=dulieu.split("#");
               for( int i=0; i < sanPhamDatHang.size(); i++)
               {
                   if (thongtinSach[1].equalsIgnoreCase(sanPhamDatHang.get(i).getMaSach()) && sanPhamDatHang.get(i).getLoaiSach().equalsIgnoreCase("Giay"))
                       thongtinSach[13]=String.valueOf(Integer.parseInt(thongtinSach[13])-sanPhamDatHang.get(i).getSoLuong());
                   
                   String sach=String.join("#", thongtinSach);
                   noiDungSach.append(sach).append("\n");
               }
           }
           
           scan.close();
        }   
        catch (IOException ex) {
            System.out.println("Lỗi đọc file");
        }
        
        try (PrintWriter PrintWrt = new PrintWriter(file))
        {
            PrintWrt.println(noiDungSach.toString());
        } catch (FileNotFoundException ex) {
            System.out.println("Lỗi ko tìm thấy file");
        }
            
    }
    public void datHang(String tenfile) {
        this.chitietDonHang = new CT_DonHang();
        this.getChitietDonHang().setInfo();
        ArrayList<CT_GioHang> sanPhamDatHang=this.getChitietDonHang().chonSachTuDanhSach(tenfile);
        System.out.println("--BẠN CÓ XÁC NHẬN ĐẶT HÀNG?--");
        System.out.println("1. Đồng ý đặt hàng");
        System.out.println("2. Xem thêm sản phẩm");
        int chon = 0;
        do {
            Scanner scan = new Scanner(System.in);
            chon = Integer.parseInt(scan.nextLine());
            switch (chon){
                case 1:
                    this.getChitietDonHang().setTrangThai(1);
                    this.getChitietDonHang().setMaDonHang();
                    LocalDateTime myDateObj = LocalDateTime.now();   
                    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    this.getChitietDonHang().setNgayDH(String.valueOf(myDateObj.format(myFormatObj)));
                    try (FileWriter fileWriter = new FileWriter("DonHang.txt", true)) 
                    {
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.getChitietDonHang().getMaKH()).append("#");
                        sb.append(this.getChitietDonHang().getMaDonHang()).append("#");
                        sb.append(this.getChitietDonHang().getEmail()).append("#");
                        sb.append(this.getChitietDonHang().getDiaChi()).append("#");
                        sb.append(this.getChitietDonHang().getNgayDH()).append("#");
                        sb.append(this.getChitietDonHang().getDsSanPham()).append("#");
                        sb.append(this.getChitietDonHang().getTongTien()).append("#");
                        sb.append(this.getChitietDonHang().getPtThanhToan()).append("#");
                        sb.append(this.getChitietDonHang().getTrangThai());
                        sb.append(System.lineSeparator());
                        fileWriter.write(sb.toString());
                        fileWriter.flush(); 
                        System.out.println("ĐẶT HÀNG THÀNH CÔNG!");
                        xuLySoLuongSanPham(sanPhamDatHang);
                        chon=2;
                    }
                    catch (IOException e) 
                    {
                        System.out.println("Có lỗi khi ghi vào file: ");
                    }
                    
                    break;
                case 2:
                    break;   
            }
            if (chon < 1 || chon > 2)
                System.out.println("\n Vui lòng xác nhận đặt hàng! \n");
        } while (chon != 2);
    }   
    
    public  void xemDonHang()
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
                if( donhang[8].equalsIgnoreCase("1"))
                    trangthai="Dang xu ly";
                else if (donhang[8].equalsIgnoreCase("2"))
                    trangthai="Da xac nhan";
                else if (donhang[8].equalsIgnoreCase("3"))
                    trangthai="Dang giao";
                else if (donhang[8].equalsIgnoreCase("4"))
                    trangthai="Da nhan hang";
                System.out.printf("\t| %-10s\n| %-10s\n| %-20s\n| %-20s\n| %-10s\n| %-100s\n| %-10s \n| %-20s \n| %-5s |\n",maKH,maDon,email,diachi,ngaydat,sanpham,tongtien,pttt,trangthai);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Không tìm được file DonHang.txt");
        }
    }
   
    public static void main(String[] args) {
        DonHang demo= new DonHang();
        demo.datHang("GioHangDTA7656.txt");
    }
    
    
    
}