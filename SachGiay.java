    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package com.mycompany.bookstore_management;

import java.util.Scanner;

    /**
     *
     * @author ACER
     */
    public class SachGiay extends Sach{
        private String kichThuoc;
        private String loaiBia;
        private int hienCo;
        private String maSachGiay;

        public SachGiay() {
        }

        public SachGiay(String kichThuoc, String loaiBia, int hienCo) {
            this.kichThuoc = kichThuoc;
            this.loaiBia = loaiBia;
            this.hienCo = hienCo;
        }

        public String getKichThuoc() {
            return kichThuoc;
        }

        public void setKichThuoc(String kichThuoc) {
            this.kichThuoc = kichThuoc;
        }

        public String getLoaiBia() {
            return loaiBia;
        }

        public void setLoaiBia(String loaiBia) {
            this.loaiBia = loaiBia;
        }

        public int getHienCo() {
            return hienCo;
        }

        public void setHienCo(int hienCo) {
            this.hienCo = hienCo;
        }

        private void nhapVaCheckHienCo(){
            Scanner nhapttSachGiay = new Scanner(System.in);
            boolean validHienCo = false;
            do{
                try{
                    System.out.println("Nhap so luong: ");
                    String input = nhapttSachGiay.nextLine().trim();
                    this.setHienCo(Integer.parseInt(input));
                    int hienco = this.getHienCo();
                    if(hienco<=0){
                        System.out.println("So luong phai lon 0, moi ban nhap lai.....");
                        this.hienCo = Integer.parseInt(input); 
                    }
                    else{
                        validHienCo = true;
                    }
                }catch(NumberFormatException e){
                    System.out.println("So luong khong hop le, moi ban nhap lai.....");
                }
            }while(!validHienCo);
        }
        private void nhapVaCheckKichThuoc(){
            Scanner nhapttsach = new Scanner(System.in);
            boolean validSize = false;
            do{
                try{
                    System.out.println("Nhap kich thuoc sach (A4-A5): ");
                    String input = nhapttsach.nextLine().trim();
                    this.setKichThuoc(input);
                    String kichthuoC = this.getKichThuoc();
                    if(!kichthuoC.equalsIgnoreCase("A4")&&!kichthuoC.equalsIgnoreCase("A5")){
                        System.out.println("Kich thuoc khong hop le. Moi ban nhap lai.....");
                    }
                    else{
                        validSize = true;
                    }
                }catch(Exception e){
                    System.out.println("Kich thuoc khong hop le, moi ban nhap lai.....");
                }
            }while(!validSize);
        }
        private void nhapVaCheckLoaiBia(){
            Scanner nhapttsach = new Scanner(System.in);
            boolean validBia = false;
            do{
                try{
                    System.out.println("Nhap loai bia (Cung-Mem): ");
                    String input = nhapttsach.nextLine().trim();
                    this.setLoaiBia(input);
                    String loaibiA = this.getLoaiBia();
                    if(!loaibiA.toLowerCase().equalsIgnoreCase("Cung")&&!loaibiA.toLowerCase().equalsIgnoreCase("Mem")){
                        System.out.println("Loai bia khong hop le. Moi ban nhap lai.....");
                    }
                    else{
                        validBia = true;
                    }
                }catch(Exception e){
                    System.out.println("Loai bia khong hop le, moi ban nhap lai.....");
                }
            }while(!validBia);
        }
        

    @Override
    public void nhapThongTinSachChoNhanVien() {
        super.nhapThongTinSachChoNhanVien(); 
        Scanner nhapttSachGiay = new Scanner(System.in);

        nhapVaCheckKichThuoc();

        nhapVaCheckLoaiBia();

        nhapVaCheckHienCo();
    }
        
        @Override
        public String toString(){
            String superString = super.toString();
            StringBuilder sb = new StringBuilder(superString);
            sb.append("Kich thuoc: ").append(this.kichThuoc).append("\n");
            sb.append("Loai bia: ").append(this.loaiBia).append("\n");
            sb.append("Hien co: ").append(this.hienCo).append("\n");
            
            return sb.toString();
        }
        public static void main(String[] args){
            SachGiay sachgiay = new SachGiay();
            sachgiay.nhapThongTinSachChoNhanVien();
            System.out.println("Thong tin sach giay: " + sachgiay.toString());
        }

    }
