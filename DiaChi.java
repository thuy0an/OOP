/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class DiaChi {
    private String soNha;
    private String phuong;
    private String quan;
    private String thanhPho;

    public DiaChi() {
    }

    public DiaChi(String soNha, String phuong, String quan, String thanhPho) {
        this.soNha = soNha;
        this.phuong = phuong;
        this.quan = quan;
        this.thanhPho = thanhPho;
    }

    public String getSoNha() {
        return soNha;
    }

    public String getPhuong() {
        return phuong;
    }

    public String getQuan() {
        return quan;
    }

    public String getThanhPho() {
        return thanhPho;
    }

    public void setSoNha(String soNha) {
        this.soNha = soNha;
    }

    public void setPhuong(String phuong) {
        this.phuong = phuong;
    }

    public void setQuan(String quan) {
        this.quan = quan;
    }

    public void setThanhPho(String thanhPho) {
        this.thanhPho = thanhPho;
    }
    
    @Override
    public String toString()
    {
        return this.getSoNha() + "/" + this.getPhuong() + "/" + this.getQuan() +"/" + this.getThanhPho();
    }
    public void setInfo()
    {
        Scanner input= new Scanner(System.in);
        System.out.println("Nhập Thông Tin Địa Chỉ");
        System.out.print("Nhập số nhà: ");
        this.setSoNha(input.nextLine());
        System.out.print("Nhập phường: ");
        this.setPhuong(input.nextLine());
        System.out.print("Nhập quận: ");
        this.setQuan(input.nextLine());
        System.out.print("Nhập thành phố: ");
        this.setThanhPho(input.nextLine());
        
    }
}
