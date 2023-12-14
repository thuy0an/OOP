/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStore;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class KhachHang {
    private String tenKH;
    private String sdt;
    private String email;
    private ArrayList<DonHang> donHang = new ArrayList<>();
    private ArrayList<DiaChi> diaChi = new ArrayList<>();
    private String MaKH;

    private void taoMaKH(){
        String taoma="";
        String tentat[]=this.getTenKH().split(" ");
        for( String tmp : tentat)
            taoma+=tmp.charAt(0);
        taoma+=this.getSdt().substring(this.sdt.length()-4, this.sdt.length());
        this.MaKH=taoma;
    }
  
    private String chuanHoaHoTen(String hoTen) {
        // Tách chuỗi ra thành các từ
        String[] tu = hoTen.trim().split("\\s+");
        for (int i = 0; i < tu.length; i++) {
            // Viết hoa chữ cái đầu và viết thường các chữ cái khác
            tu[i] = tu[i].substring(0, 1).toUpperCase() + tu[i].substring(1).toLowerCase();
        }
        // Nối lại các từ đã được chuẩn hóa
        return String.join(" ", tu);
    }
    
    private String ktraSdt(String sdt){
        Scanner input= new Scanner(System.in);
        String Sdt=sdt;
        boolean flag=false;
        do
        {
            flag=true; // cho số đt là lun đúng
            if ( Sdt.length()<0 ||Sdt.length() >10)
            {
                System.out.println("Vui lòng nhập đủ 10 số !!!");
                System.out.print("Nhập số điện thoại: ");
                Sdt=input.nextLine();
                flag=false;
            }
            for( int i=0; i < Sdt.length();i++)
                if ( !Character.isDigit(Sdt.charAt(i)))
                {
                    flag=false;
                    System.out.println("Số điện thoại không hợp lệ. Vui lòng chỉ nhập số.");
                    System.out.print("Nhập số điện thoại: ");
                    Sdt=input.nextLine();
                }
            if (flag)
                Sdt=sdt;
        }while (flag==false);
        return Sdt;
    }
    
    public KhachHang() {
    }

    public KhachHang(String MaKH,String tenKH, String sdt, String email,String diachi) {
        this.tenKH = tenKH;
        this.sdt = sdt;
        this.email = email;
        this.MaKH = MaKH;
        
        String dulieu[]=diachi.split(";");
        for (String dulieu1: dulieu) 
        {
            String dulieuDiaChi[]=dulieu1.split("/");
            this.diaChi.add( new DiaChi(dulieuDiaChi[0],dulieuDiaChi[1],dulieuDiaChi[2],dulieuDiaChi[3]));
        }

    }

    public KhachHang(String tenKH, String sdt, String email, ArrayList<DonHang> donHang, ArrayList<DiaChi> diaChi, String MaKH) {
        this.tenKH = tenKH;
        this.sdt = sdt;
        this.email = email;
        this.donHang = donHang;
        this.diaChi = diaChi;
        this.MaKH = MaKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public String getSdt() {
        return sdt;
    }

    public String getEmail() {
        return email;
    }
    
    public String getMaKH() {
        return MaKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public ArrayList<DiaChi> getDiaChi() {
        return diaChi;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setDiachi(DiaChi dchi)
    {
        this.diaChi.add(dchi);
    }

   
    
    
    
    public void setInfo(){
        Scanner input= new Scanner(System.in);
        System.out.println("----Tạo Thông Tin Khách Hàng----");
        System.out.print("Nhập họ tên khách hàng: ");
        this.setTenKH(chuanHoaHoTen(input.nextLine()));
        System.out.print("Nhập số điện thoại: ");
        this.setSdt(ktraSdt(input.nextLine()));
        System.out.print("Nhập email: ");
        this.setEmail(input.nextLine());
        int flag=0;
        while(flag==0)
        {
            System.out.print("Nhập số lượng địa chỉ (tối đa 3): ");
            int soluong=Integer.parseInt(input.nextLine().trim());
            if (soluong >=1 && soluong <=3)
            {
                for( int i=1; i <=soluong; i++)
                {
                    DiaChi dchi= new DiaChi();
                    dchi.setInfo();
                    this.setDiachi(dchi);
                }
                flag=1;
            }
                
            else 
                System.out.println("Vui lòng nhập đúng!!!");
        }
        taoMaKH();  
    }
    
    
    
    @Override
    public String toString()
    {
        if ( this.getMaKH() == null || this.getMaKH().isEmpty()){
            return "";
        }
        
        StringBuilder thongtin= new StringBuilder();
        thongtin.append("--Thông tin của Khách Hàng--\n");
        thongtin.append("1.Mã khách Hàng: ").append(this.getMaKH()).append("\n");
        thongtin.append("2.Họ tên: ").append(this.getTenKH()).append("\n");
        thongtin.append("3.Số điện thoại: ").append(this.getSdt()).append("\n");
        thongtin.append("4.Email: ").append(this.getEmail()).append("\n");
        thongtin.append("5.Dịa chỉ:\n");
        for( int i=0; i <this.getDiaChi().size();i++)
            thongtin.append("Địa chỉ ").append(i+1).append(": ").append(this.getDiaChi().get(i)).append("\n");
        return thongtin.toString();
    }
}
