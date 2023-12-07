/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStore;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Ngaythangnam {
    private int ngay;
    private int thang;
    private int nam;

    public Ngaythangnam()
    {
        
    }
    
    public Ngaythangnam(int ngay, int thang, int nam) {
        this.ngay = ngay;
        this.thang = thang;
        this.nam = nam;
    }

    public Ngaythangnam(String ngaythangnam)
    {
        String dulieu[] = ngaythangnam.split("/");
        this.ngay = Integer.parseInt(dulieu[0]);
        this.thang = Integer.parseInt(dulieu[1]);
        this.nam = Integer.parseInt(dulieu[2]));
    }
    
    public int getNgay() {
        return ngay;
    }

    public void setNgay(int ngay) {
        this.ngay = ngay;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getNam() {
        return nam;
    }

    // Getter và Setter cho từng thuộc tính
    // ...
    public void setNam(int nam) {
        this.nam = nam;
    }
    public void info()
    {
        Scanner input= new Scanner(System.in);
        System.out.println("Nhập ngày: ");
        this.setNgay(input.nextInt());
        System.out.println("Nhập tháng: ");
        this.setThang(input.nextInt());
        System.out.println("Nhập năm: ");
        this.setNam(input.nextInt());
    }
    @Override
    public String toString() {
        return ngay + "/" + thang + "/" + nam;
    }
}
