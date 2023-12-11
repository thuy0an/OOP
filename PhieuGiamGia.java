package BookStore;


import BookStore.Sach;
import BookStore.TuSach;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class PhieuGiamGia {
    private int mucGiam;
    private Double donToiThieu;
    private String doiTuong;

    public PhieuGiamGia() {
    }

    public PhieuGiamGia(int mucGiam, Double donToiThieu, String doiTuong) {
        this.mucGiam = mucGiam;
        this.donToiThieu = donToiThieu;
        this.doiTuong = doiTuong;
    }

    public int getMucGiam() {
        return mucGiam;
    }

    public void setMucGiam(int mucGiam) {
        this.mucGiam = mucGiam;
    }

    public Double getDonToiThieu() {
        return donToiThieu;
    }

    public void setDonToiThieu(Double donToiThieu) {
        this.donToiThieu = donToiThieu;
    }

    public String getDoiTuong() {
        return doiTuong;
    }

    public void setDoiTuong(String doiTuong) {
        this.doiTuong = doiTuong;
    }
    
    private void kiemTraNhapMucGiam() {
        
    }
    
    private void kiemTraNhapDonToiThieu() {
        
    }
    
    public static ArrayList<Sach> docSachTuFile() {
        ArrayList<Sach> dsSach = new ArrayList<>();
        File file= new File("book.txt");
        try (Scanner scanner = new Scanner(file)) 
        {
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] sachDuocDoc = line.split("#");
                String tenSach = sachDuocDoc[0];
                String maSach = sachDuocDoc[1];
                String tacGia = sachDuocDoc[2];
                int soTrang = Integer.parseInt(sachDuocDoc[3]);
                String theloai = sachDuocDoc[4];
                String nXB = sachDuocDoc[5];
                double gia = Double.parseDouble(sachDuocDoc[6]);
                String moTa = sachDuocDoc[7];
                String loaiSach = sachDuocDoc[8];
                String kichThuoc="";
                String loaiBia="";
                String kichCoDungLuong="";
                String dungLuong="";
                String soLuong="";
                if ( loaiSach.equals("Giay")){
                    kichThuoc = sachDuocDoc[9];
                    loaiBia = sachDuocDoc[10];
                    kichCoDungLuong="////";
                    dungLuong="////";
                    soLuong= sachDuocDoc[13];
                }
                else if(loaiSach.toLowerCase().equalsIgnoreCase("PDf")||loaiSach.toLowerCase().equalsIgnoreCase("EPUB")){
                    kichThuoc="////";
                    loaiBia="////";
                    kichCoDungLuong = sachDuocDoc[11];
                    dungLuong =sachDuocDoc[12];
                    soLuong="////";
                }
                Sach sach = new Sach(tenSach, maSach, tacGia, soTrang, theloai, nXB, gia, moTa, loaiSach, Integer.parseInt(soLuong));
                dsSach.add(sach);            
            }

         } catch (FileNotFoundException ex) {
            System.out.println("Không tìm thấy file");
        }
        return dsSach;
    }
    
    public void themVoucher() {
        boolean flag = false; //Kiểm tra xem voucher đã có chưa
        ArrayList<Sach> dsSach = docSachTuFile();
        int tieptuc = 0;
        do {
            System.out.println("-------Thêm voucher-------");
            Scanner scan = new Scanner(System.in);
            System.out.println("Mức giảm(%): ");
            this.kiemTraNhapMucGiam();
            System.out.println("Đơn tối thiểu(VNĐ): ");
            this.kiemTraNhapDonToiThieu();
            System.out.println("Chọn đối tượng giảm giá: ");
            System.out.println("1. Thể loại || 2. Sách || 3. Hoá đơn");
            int chon = Integer.parseInt(scan.nextLine());
            switch (chon) {
                case 1: 
                    System.out.println("Nhập thể loại sách: ");
                    String theLoai = scan.nextLine().trim();
                    for (Sach sach : dsSach) {
                        if (theLoai.equalsIgnoreCase(sach.getTheLoai())) {
                            this.setDoiTuong(theLoai);
                        }   
                    }
                    break;
                case 2: 
                    System.out.println("Nhập mã sách: ");
                    String maSach = scan.nextLine().trim();
                    for (Sach sach : dsSach) {
                        if (maSach.equalsIgnoreCase(sach.getMaSach())) {
                            this.setDoiTuong(maSach);
                        }   
                    }
                    break;
                case 3: 
                    this.setDoiTuong(null);
                    break;
            }
            
            System.out.println("Bạn muốn lưu voucher??"); 
            System.out.println("1. Lưu voucher || 2. Bỏ lưu");
            int choice = Integer.parseInt(scan.nextLine());
            switch (choice) {
                case 1:
                    String fileName = "voucher.txt";
                    File file = new File(fileName);
                    try (FileWriter fileWrite = new FileWriter(file, true)) 
                    {
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.getMucGiam()).append("#");
                        sb.append(this.getDonToiThieu()).append("#");
                        sb.append(this.getDoiTuong()).append("#");
                        sb.append(System.lineSeparator());
                        fileWrite.write(sb.toString());
                        fileWrite.flush();
                    } catch (IOException e) {
                        System.out.println("Có lỗi khi ghi vào file: " + e.getMessage());
                    }
                    break;
                case 2:
                    break;
            }
            
        } while (tieptuc != 2);
        if (flag) 
            System.out.println("Thêm voucher thành công :>");
    }
    
    public void xemMaGiamGia() {
        
    }
}
