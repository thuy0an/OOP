
package BookStore;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class DonHang {
    private CT_DonHang chitietDonHang =new CT_DonHang();;

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
                   if (thongtinSach[1].equalsIgnoreCase(sanPhamDatHang.get(i).getMaSach()) && sanPhamDatHang.get(i).getLoaiSach().equalsIgnoreCase("Giay"))
                       thongtinSach[13]=String.valueOf(Integer.parseInt(thongtinSach[13])-sanPhamDatHang.get(i).getSoLuong());
               
                String sach=String.join("#", thongtinSach);
                noiDungSach.append(sach).append("\n");
           }
        }   
        catch (IOException ex) {
            System.out.println("Lỗi đọc file");
        }

        try (FileWriter FileWrt = new FileWriter(file,false))
        {
            FileWrt.write(noiDungSach.toString());
            FileWrt.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("Lỗi ko tìm thấy file");
        } catch (IOException ex) {
            System.out.println("Lỗi file");
        }
            
    }
    
    private void xuLyChuaDatHang(String tenfile,ArrayList<CT_GioHang> sanPhamDaHang)
    {
            StringBuilder sanPham= new StringBuilder();
            File file= new File(tenfile);
            try {
                Scanner scan= new Scanner(file);
                while( scan.hasNextLine())
                {
                    String dong=scan.nextLine();
                    if ( !dong.isEmpty())
                    {
                        sanPham.append(dong);
                        sanPham.append(System.lineSeparator());
                    }
                }
            } 
            catch (FileNotFoundException ex) {
            System.out.println("Lỗi ko đọc được file");
            }
            
            
         
            try {
                FileWriter FileWrt= new FileWriter(tenfile,false);
                for( int i=0; i < sanPhamDaHang.size();i++)
                {
                    sanPham.append(sanPhamDaHang.get(i).getMaKhachhang()).append("#");
                    sanPham.append(sanPhamDaHang.get(i).getMaSach()).append("#");
                    sanPham.append(sanPhamDaHang.get(i).getTenSach()).append("#");
                    sanPham.append(sanPhamDaHang.get(i).getLoaiSach()).append("#");
                    sanPham.append(sanPhamDaHang.get(i).getGiaSach()).append("#");
                    sanPham.append(sanPhamDaHang.get(i).getSoLuong()).append("#");
                    sanPham.append(sanPhamDaHang.get(i).getThanhTien()).append("#");
                    sanPham.append(System.lineSeparator());
                }
                FileWrt.write(sanPham.toString());
                FileWrt.flush();
            } catch (IOException ex) {
                System.out.println("Lỗi ko đọc được file");
            }
        
    }
    
    
    
    
    public void datHang(String tenfile) {
        
        ArrayList<CT_GioHang> sanPhamDatHang=this.getChitietDonHang().chonSachTuDanhSach(tenfile);
        if ( sanPhamDatHang!= null && !sanPhamDatHang.isEmpty())
        {
            this.getChitietDonHang().setInfo();
            System.out.println("Thong tin san pham dat: " + sanPhamDatHang);
            System.out.println("\nTổng tiền: " + this.getChitietDonHang().getTongTien() +"\n");
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
                    
                    //ghi file CT_DonHang.txt
                    try (FileWriter fileWriter = new FileWriter("CT_DonHang.txt", true)) 
                    {
                        StringBuilder CTDH = new StringBuilder();
                        for (int i=0; i < sanPhamDatHang.size(); i++) {
                            CTDH.append(this.getChitietDonHang().getMaKH()).append("#");
                            CTDH.append(sanPhamDatHang.get(i).getMaSach()).append("#");
                            CTDH.append(sanPhamDatHang.get(i).getTenSach()).append("#");
                            CTDH.append(sanPhamDatHang.get(i).getSoLuong()).append("#");
                            fileWriter.write(CTDH.toString());
                            fileWriter.flush();
                        }
                    } catch (IOException e) 
                    {
                        System.out.println("Có lỗi khi ghi vào file: ");
                    }
                    
                    //ghi file DonHang.txt
                    try (FileWriter fileWriter = new FileWriter("DonHang.txt", true)) 
                    {
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.getChitietDonHang().getMaKH()).append("#");
                        sb.append(this.getChitietDonHang().getMaDonHang()).append("#");
                        sb.append(this.getChitietDonHang().getEmail()).append("#");
                        sb.append(this.getChitietDonHang().getDiaChi()).append("#");
                        sb.append(this.getChitietDonHang().getNgayDH()).append("#");
                        sb.append(this.getChitietDonHang().getTongTien()).append("#");
                        sb.append(this.getChitietDonHang().getPtThanhToan()).append("#");
                        sb.append(this.getChitietDonHang().getTrangThai());
                        sb.append(System.lineSeparator());
                        fileWriter.write(sb.toString());
                        fileWriter.flush(); 
                        System.out.println("ĐẶT HÀNG THÀNH CÔNG!\n");
                        xuLySoLuongSanPham(sanPhamDatHang);
                        chon=2;
                    }
                    catch (IOException e) 
                    {
                        System.out.println("Có lỗi khi ghi vào file: ");
                    }
                    
                    break;
                case 2:
                    xuLyChuaDatHang(tenfile,sanPhamDatHang);
                    break;   
            }
            if (chon < 1 || chon > 2)
                System.out.println("\n Vui lòng xác nhận đặt hàng! \n");
        } while (chon != 2);
        }
        else
            System.out.println("Không có sản phẩm để đặt hàng !!!!\n");
        
    }   
    
    
    public void huyDonhang(String maKhach)
    {
        Scanner input= new Scanner(System.in);
        File file= new File("DonHang.txt");
        try (Scanner scan= new Scanner(file)){
            ArrayList<CT_DonHang> danhsachDon= new ArrayList<>();
            while( scan.hasNextLine())
            {
                String dong= scan.nextLine();
                String thongtinDon[]=dong.split("#");
                danhsachDon.add(new CT_DonHang(thongtinDon[0],thongtinDon[1],thongtinDon[2],thongtinDon[3],thongtinDon[4], Double.parseDouble(thongtinDon[5]), thongtinDon[6],Integer.parseInt(thongtinDon[7])));
            }
            System.out.println("\t+-----------------------------------------------------------+");
            System.out.println("\t|                       ĐƠN HÀNG CỦA TÔI                    |");
            System.out.println("\t+-----------------------------------------------------------+");
            for( CT_DonHang donHang : danhsachDon)
            {
                if ( donHang.getMaKH().equalsIgnoreCase(maKhach))
                    System.out.println(donHang.toString());
                try{
                    Thread.sleep(200);
                    }catch(InterruptedException e){}
            }
            
            System.out.print("Chọn mã đơn mà bạn muốn hủy đặt: ");
            String maDon=input.nextLine();
            boolean daXoa=false, timkiem=false, trangthai=false; // kiểm tra nếu 
            for(int i=0; i < danhsachDon.size();i++)
                if (danhsachDon.get(i).getMaDonHang().equalsIgnoreCase(maDon))
                {
                    trangthai=true;
                    if (danhsachDon.get(i).getTrangThai()!=3 && danhsachDon.get(i).getTrangThai()!=4)
                    {
                        danhsachDon.remove(i);
                        //Xoá trong file CT_DonHang.txt
                        File fileCTDH= new File("DonHang.txt");
                        try (Scanner scanner= new Scanner(fileCTDH)){
                            ArrayList<CT_DonHang> dsCTDH= new ArrayList<>();
                             while(scanner.hasNextLine())
                            {
                                String dong= scan.nextLine();
                                String thongtinCTDH[]=dong.split("#");
                                for (int j=0; j < dsCTDH.size();j++) {
                                    if (danhsachDon.get(i).getMaDonHang().equalsIgnoreCase(dsCTDH.get(j).getMaDonHang()))
                                        dsCTDH.remove(j);
                                }
                            }    
                        } catch (FileNotFoundException ex) {
                            System.out.println("Ko có file chi tiết đơn hàng");
                        }
                        daXoa=true;
                        timkiem=true;
                        System.out.println("Đơn hàng đã hủy thành công\n");
                        break;
                    }
                } 
            if (timkiem)
            {
                if (daXoa){
                    try(FileWriter fileWrt= new FileWriter("Donhang.txt",false))
                    {
                        StringBuilder don= new StringBuilder();
                        for( CT_DonHang donHang: danhsachDon)
                        {
                            don.append(donHang.getMaKH()).append("#");
                            don.append(donHang.getMaDonHang()).append("#");
                            don.append(donHang.getEmail()).append("#");
                            don.append(donHang.getDiaChi()).append("#");
                            don.append(donHang.getNgayDH()).append("#");
                            don.append(donHang.getTongTien()).append("#");
                            don.append(donHang.getPtThanhToan()).append("#");
                            don.append(donHang.getTrangThai()).append("#");
                            don.append(System.lineSeparator());
                        }
                        fileWrt.write(don.toString());
                        fileWrt.flush();
                    }
                    catch (IOException ex) {
                        System.out.println("Lỗi khi ghi vào file");
                    }
                } else 
                {
                    System.out.println("Mã đơn của bạn không đúng");
                }
            }
            else 
            {
                if (trangthai)
                    System.out.println("Đơn đang giao hoặc đã nhận hàng thì không thể hủy đơn !!!");
                else 
                    System.out.println("Mã đơn không tồn tại");
            }
                
        } catch (FileNotFoundException ex) {
            System.out.println("Ko có file đơn hàng");
        }
        
    }
    
    public void xemDonHang(String maKhach)
    {
        File fileDonHang= new File("DonHang.txt");
        try (Scanner scan= new Scanner(fileDonHang)){
            System.out.println("\t+-----------------------------------------------------------+");
            System.out.println("\t|                   ĐƠN HÀNG CỦA TÔI                        |");
            System.out.println("\t|-----------------------------------------------------------|");
            while ( scan.hasNextLine())
            {
                String line=scan.nextLine();
                String donhang[]=line.split("#");
                if (maKhach.equalsIgnoreCase(donhang[0]))
                {
                    CT_DonHang thongtin= new CT_DonHang(donhang[0],donhang[1],donhang[2],donhang[3],donhang[4], Double.parseDouble(donhang[5]), donhang[6],Integer.parseInt(donhang[7]));
                    System.out.println(thongtin.toString());
                }
                try{
                    Thread.sleep(200);
                    }catch(InterruptedException e){}
                
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Không tìm được file DonHang.txt");
        }
    }
    
    public ArrayList<CT_DonHang> docDonHangTuFile(String maKhach)
    {
        ArrayList<CT_DonHang> dsSp = new ArrayList<>();
        File fileDonHang= new File("DonHang.txt");
        try (Scanner scan= new Scanner(fileDonHang)){
            while ( scan.hasNextLine())
            {
                String line=scan.nextLine();
                String donhang[]=line.split("#");
                if (maKhach.equalsIgnoreCase(donhang[0]))
                {
                    CT_DonHang thongtin= new CT_DonHang(donhang[0],donhang[1],donhang[2],donhang[3],donhang[4], Double.parseDouble(donhang[5]), donhang[6],Integer.parseInt(donhang[7]));
                    dsSp.add(thongtin);
                } 
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Không tìm được file DonHang.txt");
        }
        return dsSp;
    }
    
    public void xemChiTietDonHang(String makhach) {
        Scanner scanner = new Scanner(System.in);
        xemDonHang(makhach);
        int chon = 0;
        do {
        System.out.println("Bạn có muốn xem chi tiết đơn hàng???");
        System.out.println("1. Có || 2. Không");
        chon = Integer.parseInt(scanner.nextLine());
        switch (chon) {
            case 1: 
                ArrayList<CT_DonHang> dsSp = docDonHangTuFile(makhach);
                File fileCTDH= new File("CT_DonHang.txt");
                ArrayList<CT_DonHang> dsCTDH = new ArrayList<>();
                boolean flag = false;
                try (Scanner scan = new Scanner(fileCTDH)) {
                    System.out.println("Nhập mã đơn muốn xem chi tiết đơn hàng: ");
                    String madon = scan.nextLine();
                    System.out.println("\t+-----------------------------------------------------------+");
                    System.out.println("\t|                   CHI TIẾT ĐƠN HÀNG                       |");
                    System.out.println("\t|-----------------------------------------------------------|");
                        while ( scan.hasNextLine())
                        {
                            for (int i=0; i < dsSp.size(); i++) {
                                String line=scan.nextLine();
                                String donhang[]=line.split("#");
                                if (dsSp.get(i).getMaDonHang().equalsIgnoreCase(madon) && madon.equalsIgnoreCase(donhang[0]))   
                                {
                                    System.out.println(donhang[2] + " x " + donhang[1] + " x " + donhang[3] + "/n");
                                    CT_GioHang dsSach = new CT_GioHang(donhang[1], donhang[2], Integer.parseInt(donhang[3]));
                                    dsCTDH.add(new CT_DonHang(donhang[0], dsSach));
                                    flag = true;
                                } 
                            } 
                        }
                        if (flag) 
                            System.out.println("Đơn hàng không tồn tại!");
                } catch (FileNotFoundException ex) {
                    System.out.println("Không tìm được file DonHang.txt");
                }
            case 2:
                break;
        }
        } while(chon < 1 || chon > 2);
    }
    }
