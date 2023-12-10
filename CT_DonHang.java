
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
    private int trangThai; //1: đang xử lý; 2: đã xác nhận , 3: đang giao; 4: đã nhận hàng
    private Double tongTien=0.0;
    private String dsSanPham="";
    
    public CT_DonHang() {
    }

    public CT_DonHang(String maKH, String maDonHang, String email, String diaChi, String ngayDH, String dsSanPham,Double tongTien,String ptThanhToan, int trangThai) {
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
   
    private String taoMaDH() {
        Random rand = new Random();
        int soNgauNhien = rand.nextInt(1000000); 
        String maSoNgauNhien = String.format("%06d", soNgauNhien);
        
        String maDonHang = "DH" + this.getMaKH() + maSoNgauNhien;
        return maDonHang;
    }
    
    public String getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang() {
        
        this.maDonHang = taoMaDH();
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
    public void chonPTTT() {
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
        this.setPtThanhToan(ptThanhtoan);
    }
   
    public void chonDiaChi() {
        Scanner scan=new Scanner(System.in);
        String diachiNguoidung="";
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
        
        this.setDiaChi(dchi[chon-1]);
    }
    
    public void setInfo() {
        System.out.println("-----THÔNG TIN ĐẶT HÀNG-----");
        chonDiaChi();
        chonPTTT();
    }
    
    public  ArrayList<CT_GioHang> docGioHangTuFile(String tenfile) {
        ArrayList<CT_GioHang> gioHangList = new ArrayList<>();
        File file= new File(tenfile);
        try (Scanner scanner = new Scanner(file))
        {
            while(scanner.hasNextLine()){ 
                String line = scanner.nextLine();
                String[] gioHang = line.split("#");
                if ( gioHang.length ==7)
                {
                    String maKh = gioHang[0];
                    String masach = gioHang[1];
                    String tenSach = gioHang[2];
                    String loaiSach = gioHang[3];
                    String giaSach=gioHang[4];
                    String soLuong = gioHang[5];
                    String thanhTien = gioHang[6];
                    CT_GioHang giohang = new CT_GioHang(maKh,masach,tenSach,loaiSach,Double.parseDouble(giaSach),Integer.parseInt(soLuong),Double.parseDouble(thanhTien));
                    gioHangList.add(giohang);  
                }
                    
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Không tìm thấy file");
        }
        return gioHangList;
    }
    
    public ArrayList<CT_GioHang> chonSachTuDanhSach(String tenfile) {
        ArrayList<CT_GioHang> danhsach = docGioHangTuFile(tenfile);
        GioHang gioHang= new GioHang();
        gioHang.setDsSanPham(danhsach);
        ArrayList<CT_GioHang> giohang_dachon = new ArrayList<>();
        int luachon;
        String sanPham="";
        Double tongtien=0.0;
        do
        {
            Scanner scan = new Scanner(System.in);
            boolean flag=false;
            if (gioHang.getDsSanPham().isEmpty()) {
            System.out.println("Giỏ hàng đang trống! Vui lòng thêm sách vào giỏ hàng! ");
            //return null;
            }
            gioHang.xemGioHang(tenfile);
            String maSachDuocChon;
            System.out.println("Chọn mã sách muốn đặt: " ); //cách bởi dấu ";"           
            maSachDuocChon = scan.nextLine();
            for( int i=0; i < gioHang.getDsSanPham().size(); i++)
            {
                if ( maSachDuocChon.equalsIgnoreCase(gioHang.getDsSanPham().get(i).getMaSach()))
                {
                    sanPham+=gioHang.getDsSanPham().get(i).getTenSach().concat(" x ").concat(gioHang.getDsSanPham().get(i).getMaSach()).concat(" x ").concat(String.valueOf(gioHang.getDsSanPham().get(i).getSoLuong()).concat(";"));
                    tongtien+=gioHang.getDsSanPham().get(i).getThanhTien();
                    giohang_dachon.add(gioHang.getDsSanPham().get(i));
                    gioHang.getDsSanPham().remove(gioHang.getDsSanPham().get(i));
                    gioHang.ghiGioHangVaoFile(tenfile);
                    flag=true;
                }
            }
            if (!flag)
                System.out.println("Vui lòng chọn đúng sách có trong giỏ!!!");
            System.out.println("Bạn muốn tiếp tục chon sản phẩm để thanh toán ?");
            System.out.println("1. Tiếp tục");
            System.out.println("2. Dừng lại");
            luachon=Integer.parseInt(scan.nextLine());
        }while(luachon !=2);
        this.setDsSanPham(sanPham);
        this.setTongTien(tongtien);
        System.out.println(giohang_dachon.toString());
        return giohang_dachon;
    }
    
    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       sb.append("\n");
       sb.append("\tMã khách hàng: ").append(this.getMaKH()).append("\n");
       sb.append("\tMã đơn: ").append(this.getMaDonHang()).append("\n");
       sb.append("\tEmail: ").append(this.getEmail()).append("\n");
       sb.append("\tĐịa chỉ: ").append(this.getDiaChi()).append("\n");
       sb.append("\tNgay dat: ").append(this.getNgayDH()).append("\n");
       sb.append("\tThong tin san pham: ").append(this.getDsSanPham()).append("\n");
       sb.append("\tTổng tiền: ").append(this.getTongTien()).append("\n");
       sb.append("\tPhương thức thanh toán: ").append(this.getPtThanhToan()).append("\n");
       if ( this.getTrangThai()==1)
           sb.append("\tTrang thai don: Dang xu ly").append("\n");
       else if ( this.getTrangThai()==2)
           sb.append("\tTrang thai don: Da xac nhan").append("\n");
       if ( this.getTrangThai()==3)
           sb.append("\tTrang thai don: Dang giao").append("\n");
       if ( this.getTrangThai()==4)
           sb.append("\tTrang thai don: Da nhan hang").append("\n");
       
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

}