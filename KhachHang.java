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
        String Sdt="";
        boolean flag=false;
        while (!flag)
        {
            flag=true; // cho số đt là lun đúng
            for( int i=0; i < sdt.length();i++)
                if ( !Character.isDigit(sdt.charAt(i)))
                {
                    flag=false;
                    System.out.println("Số điện thoại không hợp lệ. Vui lòng chỉ nhập số.");
                    sdt=input.nextLine();
                    break;
                }
            if (flag)
                Sdt=sdt;
        }
        return Sdt;
    }
    
    public KhachHang() {
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
    
    public DiaChi getDiachi()
    {
        return this.diaChi.get(0);
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
    //    DiaChi dchi= new DiaChi();
    //    dchi.setInfo();
    //    this.setDiachi(dchi);
        taoMaKH();
    }
    
    @Override
    public String toString()
    {
        if ( this.getMaKH() == null || this.getMaKH().isEmpty()){
            return "";
        }
        return "--Thông tin của Khách Hàng--\n"
            + "1.Mã khách Hàng: " + this.getMaKH() +"\n"
            + "2.Họ tên: " + this.getTenKH() +"\n"
            + "3.Số điện thoại: " + this.getSdt() +"\n" 
            + "4.Email: " + this.getEmail()+"\n";
            //+ "5.Địa chỉ: " +this.getDiachi().toString() +"\n";
        
    }

    public static void main(String[] args) {

     
    }
    
}
