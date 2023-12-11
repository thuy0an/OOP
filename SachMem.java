package com.mycompany.bookstore_management;


import com.mycompany.bookstore_management.Sach;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ACER
 */
public class SachMem extends Sach{
    private String loai;
    private String kichCoDungLuong;
    private double dungLuong;
    private String maSachMem;
    private String s1="kb";
    private String s2="mb";
    String input1;
    public SachMem() {
    }

    public SachMem(String loai, double dungLuong) {
        this.loai = loai;
        this.dungLuong = dungLuong;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getKichCoDungLuong() {
        return kichCoDungLuong;
    }

    public void setKichCoDungLuong(String kichCoDungLuong) {
        this.kichCoDungLuong = kichCoDungLuong;
    }

    public double getDungLuong() {
        return dungLuong;
    }

    public void setDungLuong(double dungLuong) {
        this.dungLuong = dungLuong;
    }

    
    private void nhapVaCheckLoaiSach(){
        Scanner nhapttsachmem = new Scanner(System.in);
        boolean validType = false;
        do{
            try{
                System.out.println("Nhap loai sach (PDF/EPUB): ");
                String input = nhapttsachmem.nextLine().trim();
                this.setLoai(input);
                String loaiMem=this.getLoai();
                if(!loaiMem.equalsIgnoreCase("PDF")&&!loaiMem.equalsIgnoreCase("EPUB")||loaiMem.isBlank()){
                    System.out.println("Loai sach khong hop le, moi ban nhap lai.....");
                }
                else{
                    validType = true;
                }
            }catch(Exception e){
                System.out.println("Loai sach khong hoo le, moi ban nhap lai.....");
            }
        }while(!validType);
    }
    public void nhapVaCheckDungLuong(){
        Scanner nhapttsachmem = new Scanner(System.in);
        boolean validSizeType = false;
        do{
            System.out.println("Nhap kich co dung luong (kb/mb): ");
            input1 = nhapttsachmem.nextLine().trim();
            
            if(!input1.equals(s1)&&!input1.equals(s2)){
                System.out.println("Kich co khong hop le, moi ban nhap lai.....");
            }
            else{
                if(input1.toLowerCase().equalsIgnoreCase(s1)){
                    this.setKichCoDungLuong(s1);
                    validSizeType = true;
                }
                else if(input1.toLowerCase().equalsIgnoreCase(s2)){
                    this.setKichCoDungLuong(s2);
                    validSizeType = true;
                }
            }
        }while(!validSizeType);
        
        // Prompt for size input based on the validated size type
        try{
            System.out.println("Nhap dung luong: ");
            String dungluong = nhapttsachmem.nextLine().trim();
            this.setDungLuong(Double.parseDouble(dungluong));
            Double dungluonG = this.getDungLuong();
            if(dungluonG<0){
                System.out.println("Dung luong phai lon hon hoac bang 0, moi ban nhap lai.....");
                nhapVaCheckDungLuong();
            }
        }catch(NumberFormatException e){
            System.out.println("Dung luong khong hop le, moi ban nhap lai.....");
            input1 = nhapttsachmem.nextLine().trim();
        }
    }
    @Override
    public void nhapThongTinSachChoNhanVien(){
        nhapVaCheckLoaiSach();
        super.nhapThongTinSachChoNhanVien();
        nhapVaCheckDungLuong();
       
    }
        
    @Override
    public String toString(){
        String superString = super.toString();
        StringBuilder sb = new StringBuilder(superString);
        sb.append("Loai sach: ").append(this.loai).append("\n");
        sb.append("Dung luong: ").append(this.dungLuong).append(input1).append("\n");
        return sb.toString();
    }
    
    public static void main(String[]args){
        SachMem sachmem = new SachMem();
        sachmem.nhapThongTinSachChoNhanVien();
        
        System.out.println(sachmem.toString());
    }
}
