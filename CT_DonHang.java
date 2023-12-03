
package BookStore;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CT_DonHang {
    private String maDonHang;
    private String maKH;
    private String diaChi;
    private String email;
    private String ngayDH;
    private String ptThanhToan;
    private int trangThai; //1: chờ xử lý (đã đặt hàng); 2: đã xử lý , 3: đang giao; 4: đã nhận hàng; 5: đã huỷ đơn
    private Double tongTien=0.0;
    private String dsSanPham="";
    
    public CT_DonHang() {
    }

    public CT_DonHang(String maDonHang, String maKH, String diaChi, String email, String ngayDH, String ptThanhToan, int trangThai, Double tongTien, String dsSanPham) {
        this.maDonHang = maDonHang;
        this.maKH = maKH;
        this.diaChi = diaChi;
        this.email = email;
        this.ngayDH = ngayDH;
        this.ptThanhToan = ptThanhToan;
        this.trangThai = trangThai;
        this.tongTien = tongTien;
        this.dsSanPham = dsSanPham;
    }
   
    public String taoMaDH() {
        Random rand = new Random();
        int soNgauNhien = rand.nextInt(1000000); 
        String maSoNgauNhien = String.format("%06d", soNgauNhien);
        
        String maDonHang = "DH" + this.getMaKH() + maSoNgauNhien;
        return maDonHang;
    }
    
    public String getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(String maDonHang) {
        this.maDonHang = maDonHang;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNgayDH() {
        return ngayDH;
    }

    public void setNgayDH(String ngayDH) {
        this.ngayDH = ngayDH;
    }

    public String getPtThanhToan() {
        return ptThanhToan;
    }

    public void setPtThanhToan(String ptThanhToan) {
        this.ptThanhToan = ptThanhToan;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }
    
    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getDsSanPham() {
        return dsSanPham;
    }

    public void setDsSanPham(String dsSanPham) {
        this.dsSanPham=this.dsSanPham.concat(dsSanPham);
    }
      
    //
    public String chonPTTT() {
        Scanner scan=new Scanner(System.in);
        String ptThanhtoan = "";
        int chon=0;
        do {
            try {
                System.out.println(" Chọn phương thức thanh toán: ");
                System.out.println("1. Tiền mặt || 2. Chuyển khoản ");
                chon = Integer.parseInt(scan.nextLine());
                    if (chon == 1) {
                        ptThanhtoan = "tiền mặt";
                        break;
                    }
                    if (chon == 2) {
                        ptThanhtoan = "chuyển khoản";
                        break;
                    }   
                if (chon < 1 || chon > 2)
                System.out.println(" Vui long chon phuong thuc thanh toan! ");
            } catch(NumberFormatException e)
                {
                    System.out.println("Vui lòng chọn đúng các thao tác đã hiển thị!!!");
                }
                catch ( Exception e)
                {
                    System.out.println(e.getMessage());
                }
            } while (chon != 2);
        return ptThanhtoan;
    }
   
    public String chonDiaChi() {
        Scanner scan=new Scanner(System.in);
        String diachiNguoidung="";
        String emailNguoidung;
        File file= new File("user.txt");
        File fileLogin= new File("userLogin.txt");
        try 
        {
            Scanner login= new Scanner(fileLogin);
            Scanner scanner = new Scanner(file);
            String dangNhap=login.nextLine();
            String infoLogin[]=dangNhap.split("#");
             while(scanner.hasNextLine())
            { 
                String line = scanner.nextLine();
                String[] khachhang = line.split("#");
                if ( khachhang[0].equalsIgnoreCase(infoLogin[0]) && khachhang[1].equalsIgnoreCase(infoLogin[1]))
                {
                    this.setMaKH(khachhang[2]);
                    this.setEmail(khachhang[5]);
                    diachiNguoidung= khachhang[6];
                }
            } 
        }
        catch (FileNotFoundException ex) {
            System.out.println("Không tìm thấy file !!!");
        }
        
        String dchi[] = diachiNguoidung.split(";");
        int chon = 0;
        do{
            try{
                System.out.println(" Chọn địa chỉ nhận hàng: ");
                for (int i = 0; i < dchi.length; i++)
                    System.out.println((i+1) + ". " + dchi[i]);
                chon = Integer.parseInt(scan.nextLine());
                
                if(chon < 1 || chon > dchi.length)
                    System.out.println("Vui lòng chọn đúng các địa chỉ của bạn");
                
            } 
            catch(NumberFormatException e){
                System.out.println("Vui lòng chọn đúng các thao tác đã hiển thị!!!");
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
                    
        }while (chon != 1 && chon!= 2);
        
        return dchi[chon];
    }
    
    public void setInfo() {
        System.out.println("-----THÔNG TIN ĐẶT HÀNG-----");
        this.setDiaChi(this.chonDiaChi());
        this.setPtThanhToan(this.chonPTTT());
    }
    
    public static ArrayList<CT_GioHang> docGioHangTuFile(String tenfile) {
        ArrayList<CT_GioHang> gioHangList = new ArrayList<>();
        File file= new File(tenfile);
        try (Scanner scanner = new Scanner(file))
        {
            while(scanner.hasNextLine()){ 
                String line = scanner.nextLine();
                String[] gioHang = line.split("#");
                    String maKH = gioHang[0];
                    String maSach = gioHang[1];
                    String tenSach = gioHang[2];
                    String loaiSach = gioHang[3];
                    String giaSach=gioHang[4];
                    String soLuong = gioHang[5];
                    String thanhTien = gioHang[6];
                    CT_GioHang giohang = new CT_GioHang(gioHang[0], gioHang[1], gioHang[2], gioHang[3], Double.parseDouble(gioHang[4]), Integer.parseInt(gioHang[5]),Double.parseDouble(gioHang[6]));
                    gioHangList.add(giohang);  
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Không tìm thấy file");
        }
        return gioHangList;
    }
    
    public ArrayList<CT_GioHang> chonSachTuDanhSach(String tenfile) {
        ArrayList<CT_GioHang> giohang = CT_DonHang.docGioHangTuFile(tenfile);
        ArrayList<CT_GioHang> giohang_dachon = new ArrayList<>();
        
        if (giohang.isEmpty()) {
            System.out.println("Giỏ hàng đang trống! Vui lòng thêm sách vào giỏ hàng! ");
            return null;
        }
        Scanner scan = new Scanner(System.in);
        int soluong = -1, vitri=-1;
        do {
            
            System.out.println("Nhập STT sách muốn đặt: " ); //cách bởi dấu ";"
            while ( vitri <0 && vitri >giohang.size())
            {                 
                vitri = Integer.parseInt(scan.nextLine());
                if (vitri <0 && vitri >giohang.size())
                    System.out.println("Vui lòng chọn đúng sách có trong giỏ!!!");
            }
            String sanPham=giohang.get(vitri).getTenSach().concat(" x ").concat(String.valueOf(giohang.get(vitri).getSoLuong()));
            this.setDsSanPham(sanPham);
            this.setTongTien(this.getTongTien()+giohang.get(vitri).getThanhTien());
            
            // đoạn này có thể chọn số lượng của 1 sản phẩm trong giỏ để đặt hàng (rất khó xử lý)
            //System.out.println("Nhập số lượng sản phẩm: ");
            //while (soluong <0 && soluong >giohang.get(vitri).getSoLuong())
            //{
            //    soluong = Integer.parseInt(scan.nextLine().trim());
            //    if( soluong >giohang.get(vitri).getSoLuong())
            //    System.out.println("Vui lòng chọn đúng số lượng của sản phẩm trong giỏ!!!");
            //}
            
            // Chọn sản phẩm đặt rùi xóa nó khỏi giỏ
            giohang_dachon.add(giohang.get(vitri));
            giohang.remove(giohang.get(vitri));
            GioHang gio= new GioHang();
            gio.setDsSanPham(giohang_dachon);
            //String tenfileGioHang="GioHang";
            //tenfileGioHang=tenfileGioHang.concat(gio.getDsSanPham().get(1).getMaKhachhang()).concat(".txt");
            //gio.ghiGioHangVaoFile(tenfileGioHang);
            
            
        } while (vitri==-1);
        return giohang_dachon;
    }
    
            

    
    @Override
    public String toString() {
       if (this.getTrangThai() == 0 || this.getDsSanPham()== null) return " ";
       StringBuilder sb = new StringBuilder();
       sb.append("\n");
       sb.append("Mã khách hàng: ").append(this.getMaKH()).append("\n");
       sb.append("Mã đơn: ").append(this.getMaDonHang()).append("\n");
       sb.append("Email: ").append(this.getEmail()).append("\n");
       sb.append("Địa chỉ: ").append(this.getDiaChi()).append("\n");
       sb.append("Ngày đặt hàng: ").append(this.getNgayDH()).append("\n");
       sb.append("Mô tả sản phẩm: \n");
       
       sb.append("Tổng tiền: ").append(this.getTongTien()).append("\n");
       sb.append("Phương thức thanh toán: ").append(this.getPtThanhToan()).append("\n");
       sb.append("Trạng thái: ").append(this.getTrangThai()).append("\n");
       return sb.toString();
        
    }
    
        
//    public double giamGia() {
//        if (this.tinhTongTien() >= 500000) {
//            return (10/100)*this.tinhTongTien();
//        } else { 
//            if (this.tinhTongTien() >= 300000) {
//                return (5/100)*this.tinhTongTien();
//            } else return 0;
//        }
//    }
//        
//    public double giaSauKhiGiam() {
//        this.tongTien = this.tinhTongTien() - this.giamGia();
//        return this.tongTien;
//    }

     public static void main(String[] args) {
       
        CT_DonHang donhang = new CT_DonHang();
        donhang.setInfo();
    }

}