
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class DanhGia {
    private String maKhachHang;
    private String maSach;
    private String binhLuan;
    private float sao;
    private String ngayDG;


    public DanhGia() {
    }

    public DanhGia(String maKhachHang, String maSach, String ngayDG, float sao, String binhLuan) {
        this.binhLuan = binhLuan;
        this.sao = sao;
        this.maKhachHang = maKhachHang;
        this.maSach = maSach;
        this.ngayDG = ngayDG;
    }
    
    public String getBinhLuan() {
        return binhLuan;
    }

    public void setBinhLuan(String binhLuan) {
        this.binhLuan = binhLuan;
    }
    
    public float getSao() {
        return sao;
    }

    public void setSao(float sao) {
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

    public String getNgayDG() {
        return ngayDG;
    }

    public void setNgayDG(String ngayDG) {
        this.ngayDG = ngayDG;
    }
    
    
    private void kiemTraNhapSoSao() {
        Scanner input = new Scanner(System.in);
        boolean flag = false;
        do {
            float sosao;
            try {
                System.out.println("Nhập số sao (Từ 1->5): ");
                String nhap = input.nextLine().trim();
                sosao = Float.parseFloat(nhap);
                if (sosao < 0.0 || sosao > 5.0) {
                    System.out.println("Số sao phải lớn hơn hoặc bằng 0 và nhỏ hơn hoặc bằng 5! Vui lòng nhập lại!");
                } else {
                    this.setSao(sosao);
                    flag = true;
                }
            } catch(NumberFormatException e){
                System.out.println("Số sao không hợp lệ! Vui lòng nhập lại!");
            }
        } while(!flag);  
    }
    
    public void danhGia(String tenfile) {
        boolean flag=false; // biến cờ kiểm tra người dùng đã đánh giá hay  chưa
        boolean ktraTrangThai=false; // kiểm tra xem có đơn nào đã nhận chưa
        boolean ktraMaDon=false; // kiểm tra xem mã đơn được nhập có đúng ko
        int tieptuc=0;
        DonHang donhang = new DonHang();
        ArrayList<CT_DonHang> dsCTDH = DonHang.docCTDonHangTuFile(tenfile);
        ArrayList<CT_DonHang> dsDonHang = donhang.docDonHangTuFile(this.getMaKhachHang());
        
        if (dsDonHang.isEmpty())
        {
            System.out.println("Bạn không có sản phẩm để đánh giá!!");
            return ;
        }
        do
        {
            Scanner scan = new Scanner(System.in);
            for (CT_DonHang donHang: dsDonHang) {
                if ( this.getMaKhachHang().equalsIgnoreCase(donHang.getMaKH()) && donHang.getTrangThai()==4)
                {
                    System.out.println(donHang.toString());
                    ktraTrangThai=true;
                }
            }
            System.out.print("\n");
            if( ktraTrangThai)
            {
                System.out.println("Nhập mã đơn hàng muốn đánh giá: " );
                String maDon = scan.nextLine();
                
                for (CT_DonHang donHang : dsDonHang) {
                    if ( maDon.equalsIgnoreCase(donHang.getMaDonHang())&& donHang.getTrangThai()==4) 
                    { 
                        ktraMaDon=true;
                        System.out.println("Nhập mã sách muốn đánh giá: ");
                        String maSachDanhGia = scan.nextLine();
                        for (CT_DonHang don : dsCTDH) {
                            int chon = 0;
                            if (don.getMaDonHang().equalsIgnoreCase(donHang.getMaDonHang()) && maSachDanhGia.equalsIgnoreCase(don.getDsSanPham().getMaSach())) {
                                flag=true;
                                System.out.println("-------Đánh Giá-------");
                                System.out.println("Nhập bình luận: ");
                                this.setBinhLuan(scan.nextLine());
                                this.kiemTraNhapSoSao();
                                System.out.println("Bạn muốn lưu đánh giá??");
                                System.out.println("1. Lưu đánh giá || 2. Bỏ lưu đánh giá");
                                chon = Integer.parseInt(scan.nextLine());
                                switch (chon) {
                                    case 1: 
                                        LocalDateTime myDateObj = LocalDateTime.now();   
                                        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                                        this.setNgayDG(myDateObj.format(myFormatObj));   
                                        String fileName = "DanhGia.txt";
                                        File file = new File(fileName);
                                        try (FileWriter fileWriter = new FileWriter(file, true))
                                        {
                                            StringBuilder sb = new StringBuilder();
                                            sb.append(this.getMaKhachHang()).append("#");
                                            sb.append(don.getDsSanPham().getMaSach()).append("#");
                                            sb.append(this.getNgayDG()).append("#");
                                            sb.append(this.getSao()).append("#");
                                            sb.append(this.getBinhLuan());
                                            sb.append(System.lineSeparator()); //Xuống dòng
                                            fileWriter.write(sb.toString()); //Ghi chuỗi thông tin vào file
                                            fileWriter.flush(); 
                                        }  
                                        catch (IOException e){
                                            System.out.println("Có lỗi khi ghi vào file: " + e.getMessage());
                                        }
                                        break;
                                    case 2:
                                        break;
                                }
                            }
                        }

                        if( !flag)
                        {
                            System.out.println("Mã sách không đúng");
                            tieptuc=2;
                        }
                    }
                }
                
                if (flag){
                    System.out.println("Bạn có muốn tiếp tục đánh giá sách khác không ?");
                    System.out.println("1.Tiếp tục đánh giá\t2.Ngừng lại");
                    tieptuc=Integer.parseInt(scan.nextLine());
                }
                if(!ktraMaDon){
                    System.out.println("Mã đơn hàng không hợp lệ");
                    break;
                }
            }
            else{
                System.out.println("Bạn không có sản phẩm nào cần đánh giá!!\n");
                break;
            }
        }while( tieptuc !=2);
        if ( flag )
            System.out.println("Cảm ơn bạn đã đánh giá ^^");
    } 
    
    public void xemDanhGia() {
        Scanner input= new Scanner(System.in);
        boolean flag=false;
        System.out.print("Chọn mã sách xem đánh giá: ");
        String masach=input.nextLine();
        File fileDonHang= new File("DanhGia.txt");
        try (Scanner scan= new Scanner(fileDonHang)){
            System.out.println("\t+------------------------------------------------------------------------------+");
            System.out.println("\t|                                      ĐÁNH GIÁ                                |");
            System.out.println("\t+------------------------------------------------------------------------------+");
            while ( scan.hasNextLine())
            {
                String line=scan.nextLine();
                String danhGia[]=line.split("#");
                if (masach.equalsIgnoreCase(danhGia[1]))
                { 
                    flag=true;
                    String maKH = danhGia[0];
                    String maSacha = danhGia[1];
                    String ngayDGa = danhGia[2];
                    float soSao = Float.parseFloat(danhGia[3]);
                    String binhLuana = danhGia[4];
                    DanhGia danhgia= new DanhGia(maKH, maSacha, ngayDGa, soSao, binhLuana);
                    System.out.println(danhgia.toString());
                    try{
                    Thread.sleep(200);
                    }catch(InterruptedException e){}
                }  
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Không tìm được file DonHang.txt");
        }
        if ( !flag)
            System.out.println("\tRất tiếc sách chưa có đánh giá :<\n");
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\tKhách hàng: ").append(this.getMaKhachHang()).append("\t");
        sb.append("\tNgày: ").append(this.getNgayDG()).append("\t");
        sb.append("\tSao: ").append(this.getSao()).append("\n");
        sb.append("\tBình luận: ").append(this.getBinhLuan()).append("\n");
        return sb.toString();
    }
    
}