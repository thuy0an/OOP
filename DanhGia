
package BookStore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class DanhGia {
    public String binhLuan;
    public Float sao;
    private String maKhachHang;
    public String maSach;
    private String maDonHang;
    public String ngayDG;

    Scanner input = new Scanner(System.in);
    public DanhGia() {
    }

    public DanhGia(String maKhachHang, String maDonHang, String maSach, String ngayDG, Float sao, String binhLuan) {
        this.binhLuan = binhLuan;
        this.sao = sao;
        this.maKhachHang = maKhachHang;
        this.maSach = maSach;
        this.maDonHang = maDonHang;
        this.ngayDG = ngayDG;
    }
    
    public String getBinhLuan() {
        return binhLuan;
    }

    public void setBinhLuan(String binhLuan) {
        this.binhLuan = binhLuan;
    }
    
    // trả về rating trung bình sau khi tính toán của 1 sách
    public Float getSao() {
        return sao;
    }

    public void setSao(Float sao) {
        this.sao = sao;
    }
    
    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(String maDonHang) {
        this.maDonHang = maDonHang;
    }

    public String getNgayDG() {
        return ngayDG;
    }

    public void setNgayDG(String ngayDG) {
        this.ngayDG = ngayDG;
    }
    
    public void setInfo() {
        
        System.out.println("-----Đánh Giá-----");
        System.out.println("Nhập bình luận: ");
        this.setBinhLuan(input.nextLine());
        this.kiemTraNhapSoSao();
    }
    
    private void kiemTraNhapSoSao() {
        boolean flag = false;
        do {
            try {
                System.out.println("Nhập số sao (Từ 1->5): ");
                String nhap = input.nextLine().trim();
                this.sao = Float.parseFloat(nhap);
                if (this.sao < 0.0 || this.sao > 5.0) {
                    System.out.println("Số sao phải lớn hơn hoặc bằng 0 và nhỏ hơn hoặc bằng 5! Vui lòng nhập lại!");
                } else {
                    this.setSao(this.sao);
                    flag = true;
                }
            } catch(NumberFormatException e){
                System.out.println("Số sao không hợp lệ! Vui lòng nhập lại!");
            }
        } while(!flag);  
    }
    
    public static ArrayList<CT_DonHang> docDonHangTuFile(String tenfile) {
        ArrayList<CT_DonHang> donHangList = new ArrayList<>();
        File file= new File(tenfile);
        try (Scanner scanner = new Scanner(file))
        {
            while(scanner.hasNextLine()){ 
                String line = scanner.nextLine();
                String[] donhang = line.split("#");
                String maKH = donhang[0];
                String maDon = donhang[1];
                String email = donhang[2];
                String diachi = donhang[3];
                String ngaydat = donhang[4];
                String sanpham = donhang[5];
                Double tongtien = Double.parseDouble(donhang[6]);
                String pttt = donhang[7];
                Integer trangthai = Integer.parseInt(donhang[8]);
                CT_DonHang donHang = new CT_DonHang(maKH, maDon, email, diachi, ngaydat, sanpham, tongtien, pttt, trangthai);
                donHangList.add(donHang);  
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Không tìm thấy file");
        }
        return donHangList;
    }
    
    public void danhGia(String tenfile) {
        ArrayList<CT_DonHang> dsDonHang = DanhGia.docDonHangTuFile(tenfile);
        
        if (dsDonHang.isEmpty()) {
            System.out.println("Bạn không có đơn hàng nào cần đánh giá!!");
        } else {
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhập mã đơn hàng muốn đánh giá: " );
        String maDon = scan.nextLine();
        for (CT_DonHang donhang : dsDonHang) {
            if (maDon.equalsIgnoreCase(donhang.getMaDonHang()) && donhang.getTrangThai()== 4) {
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
    
    public static void xemDanhGiaTheoMaSach(String masach) {
      File fileDonHang= new File("DanhGia.txt");
        try (Scanner scan= new Scanner(fileDonHang)){
            System.out.println("\t+------------------------------------------------------------------+");
            System.out.println("\t|                          DANH GIA                                |");
            System.out.println("\t|------------------------------------------------------------------|");
            while ( scan.hasNextLine())
            {
                String line=scan.nextLine();
                String danhGia[]=line.split("#");
                if (masach.equalsIgnoreCase(danhGia[2]))
                {
                    String maKH = danhGia[0];
                    String maDon = danhGia[1];
                    String maSach = danhGia[2];
                    String ngayDG = danhGia[3];
                    Float soSao = Float.parseFloat(danhGia[4]);
                    String binhLuan = danhGia[5];
                    DanhGia danhgia= new DanhGia(maKH, maDon, maSach, ngayDG, soSao, binhLuan);
                    System.out.println(danhgia.toString());
                }  
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Không tìm được file DonHang.txt");
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("Mã khách hàng: ").append(this.getMaKhachHang()).append(";");
        sb.append("Ngày đánh giá: ").append(this.getNgayDG()).append("\n");
        sb.append("Sao: ").append(this.getSao()).append("\n");
        sb.append("Bình luận: ").append(this.getBinhLuan()).append("\n");
        return sb.toString();
    }
    
    public static void main(String[] args) {
        DanhGia danhgia = new DanhGia();
        danhgia.danhGia("DonHang.txt");
    }
}
