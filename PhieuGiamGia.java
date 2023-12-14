package BookStore;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class PhieuGiamGia {
    private String maPhieu;
    private int mucGiam;
    private double donToiThieu;
    private String doiTuong;
    private int soLuong;

    public PhieuGiamGia() {
    }

    public PhieuGiamGia(String maPhieu, int mucGiam, double donToiThieu, String doiTuong, int soLuong) {
        this.maPhieu = maPhieu;
        this.mucGiam = mucGiam;
        this.donToiThieu = donToiThieu;
        this.doiTuong = doiTuong;
        this.soLuong = soLuong;
    }

    public int getMucGiam() {
        return mucGiam;
    }

    public void setMucGiam(int mucGiam) {
        this.mucGiam = mucGiam;
    }

    public double getDonToiThieu() {
        return donToiThieu;
    }

    public void setDonToiThieu(double donToiThieu) {
        this.donToiThieu = donToiThieu;
    }

    public String getDoiTuong() {
        return doiTuong;
    }

    public void setDoiTuong(String doiTuong) {
        this.doiTuong = doiTuong;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }
    
    public void xuLyKhiChonGiamGia(String maGiamGia)
    {
        File file= new File("voucher.txt");
        StringBuilder cacPhieuGiam= new StringBuilder();
        try (Scanner scan= new Scanner(file))
        {
            while( scan.hasNextLine())
            {
                String dulieu=scan.nextLine();
                String thongtinPhieu[]=dulieu.split("#");
                if ( thongtinPhieu[0].equalsIgnoreCase(maGiamGia))
                    thongtinPhieu[4]=String.valueOf(Integer.parseInt(thongtinPhieu[4])-1);
                String phieu=String.join("#", thongtinPhieu);
                cacPhieuGiam.append(phieu).append("\n");
            }
        }
        catch (IOException ex) {
            System.out.println("Lỗi đọc file");
        }
        try (FileWriter FileWrt = new FileWriter(file,false))
        {
            FileWrt.write(cacPhieuGiam.toString());
            FileWrt.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("Lỗi ko tìm thấy file");
        } catch (IOException ex) {
            System.out.println("Lỗi file");
        }
    }
    
    public String[] docSachTuFile() {
    String[] dsSach = null;
    int i = 0;
    try {
        File file = new File("book.txt");
        Scanner scanner = new Scanner(file);
        int sodong = 0;
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            sodong++;
        }

        // Khởi tạo mảng với kích thước đã đếm được
        dsSach = new String[sodong];

        scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] sach = line.split("#");
            String maSach = sach[1];
            dsSach[i] = maSach;
            i++;
        }

        scanner.close();
    } catch (FileNotFoundException ex) {
        System.out.println("Không tìm thấy file");
    }

    return dsSach;
}
    
    public void themVoucher() {
        boolean flag = false; //Kiểm tra xem voucher đã có chưa
        Scanner scan = new Scanner(System.in);
        String dsSach[] = docSachTuFile();
        boolean ktraMaSach = false;
        int tieptuc = 0;
        do {
            try {
                System.out.println("-------Thêm voucher-------");
                System.out.println("Nhập mã voucher: ");
                this.setMaPhieu(scan.nextLine());
                System.out.println("Mức giảm(%): ");
                this.setMucGiam(Integer.parseInt(scan.nextLine()));
                System.out.println("Đơn tối thiểu(VNĐ): ");
                this.setDonToiThieu(Integer.parseInt(scan.nextLine()));
                System.out.println("Chọn đối tượng giảm giá: ");
                System.out.println("1. Sách || 2. Đơn hàng");
                // thêm đk cho chọn
                int chon = Integer.parseInt(scan.nextLine());
                switch (chon) {

                    case 1:
                        System.out.println("Nhập mã sách: ");
                        String maSach = scan.nextLine().trim();
                for (String sach : dsSach) {
                    if (maSach.equalsIgnoreCase(sach)) {
                        this.setDoiTuong(maSach);
                        ktraMaSach = true;
                    }
                }
                        if (!ktraMaSach) {
                            System.out.println("Mã sách không hợp lệ!");
                        }
                        break;
                    case 2: 
                        this.setDoiTuong("Hoa don");
                        break;
                }
                System.out.print("Số lượng sử dụng: ");
                this.setSoLuong(Integer.parseInt(scan.nextLine()));
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
                            sb.append(this.getMaPhieu()).append("#");
                            sb.append(this.getMucGiam()).append("#");
                            sb.append(this.getDonToiThieu()).append("#");
                            sb.append(this.getDoiTuong()).append("#");
                            sb.append(this.getSoLuong());
                            sb.append(System.lineSeparator());
                            fileWrite.write(sb.toString());
                            fileWrite.flush();
                        } catch (IOException e) {
                            System.out.println("Có lỗi khi ghi vào file: " + e.getMessage());
                        }
                        flag=true;
                        break;
                    case 2:
                        tieptuc=2;
                        break;
                }
                if (flag) {
                    System.out.println("Bạn muốn tiếp tục thêm voucher??");
                    System.out.println("1. Tiếp tục || 2. Thoát");
                    tieptuc = Integer.parseInt(scan.nextLine());
                }
            }
            catch(NumberFormatException ei)            {
                System.out.println("\n--Vui lòng nhập đúng nội dung !!!--\n");
                break;
            }

        } while (tieptuc != 2);
        if (flag) 
            System.out.println("Thêm voucher thành công :>");
    }

    public ArrayList<PhieuGiamGia> docVoucherTuFile() {
        ArrayList<PhieuGiamGia> voucherList = new ArrayList<>();
        File file= new File("voucher.txt");
        try (Scanner scanner = new Scanner(file))
        {
            while(scanner.hasNextLine()){ 
                String line = scanner.nextLine();
                String[] voucher = line.split("#");
                    String maphieu = voucher[0];
                    int mucgiam = Integer.parseInt(voucher[1]);
                    double dontoithieu = Double.parseDouble(voucher[2]);
                    String doituong = voucher[3];
                    int soluong = Integer.parseInt(voucher[4]);
                    PhieuGiamGia phieugiam = new PhieuGiamGia(maphieu, mucgiam, dontoithieu, doituong, soluong);
                    voucherList.add(phieugiam);  
                    
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Không tìm thấy file");
        }
        return voucherList;
    }
    
    public static void xemVoucher()
    {
        File file= new File("voucher.txt");
        try (Scanner scanner = new Scanner(file))
        {
            System.out.println("\n\t+------------------------------------------------------------------------------------+");
            System.out.println("\t|                                       PHIẾU GIẢM GIÁ                               |");
            System.out.println("\t|------------------------------------------------------------------------------------|");
            System.out.printf("\t| %-15s | %-15s | %-15s | %-10s | %-15s |\n","Mã giảm giá","Mức giảm giá","Đơn tối thiểu","Dành cho","Số lượng còn");
            System.out.println("\t|------------------------------------------------------------------------------------|");
            while(scanner.hasNextLine()){ 
                String line = scanner.nextLine();
                String[] thongtin = line.split("#");
                String magiamgia = thongtin[0];
                String mucgiam = thongtin[1];
                String dontoithieu = thongtin[2];
                String doituong=thongtin[3];
                String soluong = thongtin[4];
                System.out.printf("\t| %-15s | %-15s | %-15s | %-10s | %-15s |\n",magiamgia,mucgiam,dontoithieu,doituong,soluong);
                System.out.println("\t+------------------------------------------------------------------------------------+");
                try{
                    Thread.sleep(200);
                    }catch(InterruptedException e){}
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Không tìm thấy file");
        }
        catch (Exception e) {
            System.out.println("");
        }
        System.out.println();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t").append(this.getMaPhieu()).append("\t");
        sb.append("\t").append(this.getMucGiam()).append("%").append("\t");
        sb.append("\t").append(this.getDonToiThieu()).append("\t");
        sb.append("\t").append(this.getDoiTuong()).append("\t");
        sb.append("\t").append(this.getSoLuong());

        return sb.toString();
    }
    
}