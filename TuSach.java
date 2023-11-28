/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookstore_management;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class TuSach {
    private int soSach;
    private String danhGia;
    private int soSao;
    private ArrayList<Sach> books = new ArrayList<>();

    public TuSach() {
        this.soSach = 0;
    }

    public int getSoSach() {
        return soSach;
    }

    public void setSoSach(int soSach) {
        this.soSach = soSach;
    }

    public ArrayList<Sach> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Sach> books) {
        this.books = books;
    }

    public String getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(String danhGia) {
        this.danhGia = danhGia;
    }

    public int getSoSao() {
        return soSao;
    }

    public void setSoSao(int soSao) {
        this.soSao = soSao;
    }
    
    public void themSach() {
        Scanner input = new Scanner(System.in);
        String tiepTuc=null;
        do{
            Sach sach = null;
            System.out.println("Ban muon them loai sach nao?");
            System.out.println("1: Sach giay | 2: Sach mem");
            
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
            case 1:
                sach = new SachGiay();
                ((SachGiay) sach).nhapThongTinSachGiay();
                books.add(sach);
                soSach++;
                vietSachVaoFile(choice);
                break;
            case 2:
                sach = new SachMem();
                ((SachMem) sach).nhapThongTinSachMem();
                books.add(sach);
                soSach++;
                vietSachVaoFile(choice);
                break;
            default:
                System.out.println("Lua chon khong phu hop.....");
                break;
            }
            System.out.println("Ban co muon tiep tuc them sach?");
            System.out.println("Y/N");
            tiepTuc=input.nextLine();
        }while(!tiepTuc.equalsIgnoreCase("N"));  
    }
    
    public void vietSachVaoFile(int choice) {
        String fileName = "Sach.dat";
        File file = new File(fileName);

        try (FileWriter fileWriter = new FileWriter(file, true)) {
            for (Sach sach : books) {
                StringBuilder sb = new StringBuilder();
                sb.append(sach.getTenSach()).append("#");
                sb.append(sach.getMaSach()).append("#");
                sb.append(sach.getTacGia()).append("#");
                sb.append(sach.getSoTrang()).append("#");
                sb.append(sach.getTheLoai()).append("#");
                sb.append(sach.getNXB()).append("#");
                sb.append(sach.getDonGia()).append("#");
                sb.append(sach.getMoTa()).append("#");

                if (sach instanceof SachGiay && choice == 1) {
                    sb.append("paper").append("#");
                    sb.append(((SachGiay) sach).getKichThuoc()).append("#");
                    sb.append(((SachGiay) sach).getLoaiBia()).append("#");
                    sb.append("/////").append("#");
                    sb.append("/////").append("#");
                    sb.append(((SachGiay) sach).getHienCo());
                } else if (sach instanceof SachMem && choice == 2) {
                    sb.append(((SachMem) sach).getLoai()).append("#");
                    sb.append("/////").append("#");
                    sb.append("/////").append("#");
                    sb.append(((SachMem) sach).getKichCoDungLuong()).append("#");
                    sb.append(((SachMem) sach).getDungLuong()).append("#");
                    sb.append("/////");
                }

                sb.append(System.lineSeparator());
                fileWriter.write(sb.toString());
            }
            books.clear();
            fileWriter.flush();
            System.out.println("Viet sach vao file thanh cong.....");
        } catch (IOException e) {
            System.out.println("Khong hop le" + e.getMessage());
        }
    }
    public void xoaSachTheoID(){
        Scanner input = new Scanner(System.in);
        String canXoa = input.nextLine();
        try{
            File inputFile = new File("Sach.dat");
            File tempFile = new File("TempSach.dat");
            
            Scanner scanner = new Scanner(inputFile);
            FileWriter writer = new FileWriter(tempFile);
            
            while(scanner.hasNextLine()){
                String currentLine = scanner.nextLine();
                String[] bookDetails = currentLine.split("#");
                if(bookDetails.length>1 && bookDetails[1].equalsIgnoreCase(canXoa)){
                    continue; //Skip writing this line to the temporary file (delete it)
                }
                writer.write(currentLine + System.lineSeparator()); //Write into temporary file
            }
            writer.close();
            scanner.close();
            
            //Replace the original file with the updated one
            if(inputFile.delete()){
                if(!tempFile.renameTo(inputFile)){
                    throw new IOException("Khong the cap nhat ten file.....");
                }
                System.out.println("Xoa sach thanh cong <3");
            }else{
                throw new IOException("Khong the xoa file goc.....");
            }
        }catch(IOException e){
            System.out.println("Co loi khi thao tac voi file: " + e.getMessage());
        }
        
        
    }
    
    public void xoaSachTheoTen(){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap ten sach ban muon xoa: ");
        String tenSachCanXoa = input.nextLine();
        
        Iterator<Sach> iterator = books.iterator();
        while(iterator.hasNext()){
            Sach sach = iterator.next();
            if(sach.getTenSach().equalsIgnoreCase(tenSachCanXoa)){
                iterator.remove();
                soSach--;
                System.out.println("Xoa sach thanh cong <3");
                break;
            }
        }
    }
    public void timSachTheoTen(String bookName){
//        Scanner input = new Scanner(System.in);
//        System.out.println("Nhap ten sach ban muon tim: ");
//        String tenSach = input.nextLine();

        boolean found = false;
        try(DataInputStream dis = new DataInputStream(new FileInputStream("Sach.dat"))){
            while(dis.available()>0){
                String tenSach = dis.readUTF();
                String maSach = dis.readUTF();
                String tacGia = dis.readUTF();
                int soTrang = dis.readInt();
                String nXB = dis.readUTF();
                String moTa = dis.readUTF();
                double donGia = dis.readDouble();
                int soLuong = dis.readInt();
                
                if(tenSach.equalsIgnoreCase(bookName)){
                    System.out.println("Tim thay sach <3");
                    System.out.println("Thong tin sach: \n" + "Ten sach: " + tenSach +
                        "\nMa sach: " + maSach +
                        "\nTac gia: " + tacGia +
                        "\nSo trang: " + soTrang +
                        "\nNXB: " + nXB +
                        "\nMo ta: " + moTa +
                        "\nĐon gia: " + donGia +
                        "\nSo luong: " + soLuong);
                    found = true;
                    break; //ngừng tìm khi sách đã được tìm thấy
                }
            }
        }catch(IOException e){
            System.out.println("Khong doc duoc file.....\n" + e.getMessage());
        }
        
        if(!found) //(found) có nghĩa là cách viết khác của found==true, vậy !found tức là false
            System.out.println("Khong tim thay sach.....");
    }
    public void timSachTheoID(String bookID){
//        Scanner input = new Scanner(System.in);
//        System.out.println("Nhap ma sach ban muon tim: ");
//        String maSach = input.nextLine();
        
        boolean found = false;
        
        try(DataInputStream dis = new DataInputStream(new FileInputStream("Sach.dat"))){
            while(dis.available()>0){
                String tenSach = dis.readUTF();
                String maSach = dis.readUTF();
                String tacGia = dis.readUTF();
                int soTrang = dis.readInt();
                String nXB = dis.readUTF();
                String moTa = dis.readUTF();
                double donGia = dis.readDouble();
                int soLuong = dis.readInt();
                
                if(maSach.equalsIgnoreCase(bookID)){
                    System.out.println("Tim thay sach <3");
                    System.out.println("Thong tin sach: \n" + "Ten sach: " + tenSach +
                        "\nMa sach: " + maSach +
                        "\nTac gia: " + tacGia +
                        "\nSo trang: " + soTrang +
                        "\nNXB: " + nXB +
                        "\nMo ta: " + moTa +
                        "\nĐon gia: " + donGia +
                        "\nSo luong: " + soLuong);
                    found = true;
                    break; //ngừng tìm khi sách đã được tìm thấy
                }
            }
        }catch(IOException e){
            System.out.println("Khong doc duoc file.....\n" + e.getMessage());
        }
        
        if(!found)
            System.out.println("Khong tim thay sach.....");
    }
    public void timSachTheoTG(String author){
//        Scanner input = new Scanner(System.in);
//        System.out.println("Nhap ten tac gia ma ban muon tim: ");
//        String tenTG = input.nextLine();
        
        boolean found = false;
        
        try(DataInputStream dis = new DataInputStream(new FileInputStream("Sach.dat"))){
            while(dis.available()>0){
                String tenSach = dis.readUTF();
                String maSach = dis.readUTF();
                String tacGia = dis.readUTF();
                int soTrang = dis.readInt();
                String nXB = dis.readUTF();
                String moTa = dis.readUTF();
                double donGia = dis.readDouble();
                int soLuong = dis.readInt();
                
                if(tacGia.equalsIgnoreCase(author)){
                    System.out.println("Tim thay sach <3");
                    System.out.println("Thong tin sach: \n" + "Ten sach: " + tenSach +
                        "\nMa sach: " + maSach +
                        "\nTac gia: " + tacGia +
                        "\nSo trang: " + soTrang +
                        "\nNXB: " + nXB +
                        "\nMo ta: " + moTa +
                        "\nĐon gia: " + donGia +
                        "\nSo luong: " + soLuong);
                    found = true;
                    break; //ngừng tìm khi sách đã được tìm thấy
                }
            }
        }catch(IOException e){
            System.out.println("Khong doc duoc file.....\n" + e.getMessage());
        }
        
        if(!found)
            System.out.println("Khong tim thay sach.....");
    }
    public void timSachTheoNXB(String NXB){
//        Scanner input = new Scanner(System.in);
//        System.out.println("Nhap NXB ma ban muon tim: ");
//        String tenNXB = input.nextLine();
        
        boolean found = false;
        
        try(DataInputStream dis = new DataInputStream(new FileInputStream("Sach.dat"))){
            while(dis.available()>0){
                String tenSach = dis.readUTF();
                String maSach = dis.readUTF();
                String tacGia = dis.readUTF();
                int soTrang = dis.readInt();
                String nXB = dis.readUTF();
                String moTa = dis.readUTF();
                double donGia = dis.readDouble();
                int soLuong = dis.readInt();
                
                if(nXB.equalsIgnoreCase(NXB)){
                    System.out.println("Tim thay sach <3");
                    System.out.println("Thong tin sach: \n" + "Ten sach: " + tenSach +
                        "\nMa sach: " + maSach +
                        "\nTac gia: " + tacGia +
                        "\nSo trang: " + soTrang +
                        "\nNXB: " + nXB +
                        "\nMo ta: " + moTa +
                        "\nĐon gia: " + donGia +
                        "\nSo luong: " + soLuong);
                    found = true;
                    break; //ngừng tìm khi sách đã được tìm thấy
                }
            }
        }catch(IOException e){
            System.out.println("Khong doc duoc file.....\n" + e.getMessage());
        }
        
        if(!found)
            System.out.println("Khong tim thay sach.....");
    }
    public void timSachTheoKhoangGia(double minPrice, double maxPrice){
        boolean found = false;
        
        System.out.println("\nCac sach tu " + minPrice + " - " + maxPrice +": \n" );
//        for(Sach sach: books){
//            if(sach.getDonGia()>=minPrice && sach.getDonGia()<=maxPrice){
//                //System.out.println(sach.tenSach()); //Neu muon chi hien thi ten sach
//                System.out.println(sach.toString()); //Neu muon hein thi ca thong tin cua sach
//                found=true;
//            }
//        }
        try(DataInputStream dis = new DataInputStream(new FileInputStream("Sach.dat"))){
            while(dis.available()>0){    
                String tenSach = dis.readUTF();
                String maSach = dis.readUTF();
                String tacGia = dis.readUTF();
                int soTrang = dis.readInt();
                String nXB = dis.readUTF();
                String moTa = dis.readUTF();
                double donGia = dis.readDouble();
                int soLuong = dis.readInt();
                
                if(donGia>=minPrice&&donGia<=maxPrice){
                    System.out.println("Tim thay sach <3");
                    System.out.println("Thong tin sach: \n" + "Ten sach: " + tenSach +
                        "\nMa sach: " + maSach +
                        "\nTac gia: " + tacGia +
                        "\nSo trang: " + soTrang +
                        "\nNXB: " + nXB +
                        "\nMo ta: " + moTa +
                        "\nĐon gia: " + donGia /*+
                        "\nSo luong: " + soLuong*/);
                    found = true;
                    break; //ngừng tìm khi sách đã được tìm thấy
                }
            }
        }catch(IOException e){
            System.out.println("Khong doc duoc file.....\n" + e.getMessage());
        }
        System.out.println("\n----------------------------------------------------------------------\n");
        if(!found)
            System.out.println("\nKhong co sach trong khoang nay...");
    }
    public void timSach(){
        int code;
        String bookID;
        String nameOfBook;
        String author;
        String nXB;
        double min;
        double max;
        Scanner input = new Scanner(System.in);
        System.out.println("\n\n");
        System.out.println("\t\t+-------------------- Query Options ---------------------------+");
        System.out.println("\t\t|                                                              |");
        System.out.println("\t\t|               1.  Tim sach theo Ten                          |");
        System.out.println("\t\t|               2.  Tim sach theo Ma Sach                      |");
        System.out.println("\t\t|               3.  Tim sach theo Tac Gia                      |");
        System.out.println("\t\t|               4.  Tim sach theo NXB                          |");
        System.out.println("\t\t|               5.  Tim sach theo gia                          |");
        System.out.println("\t\t|                                                              |");
        System.out.println("\t\t+--------------------------------------------------------------+");
        System.out.print("\n\n Moi ban nhap ~$  ");
        code = Integer.parseInt(input.nextLine());
        
        switch(code){
            case 1:
                System.out.println("\n\n\t\t\tTIM SACH THEO TEN");
                System.out.print("Nhap Ten Sach:              ");
                nameOfBook=input.nextLine();
                timSachTheoTen(nameOfBook);
                break;
            case 2:
                System.out.println("\n\n\t\t\tTIM SACH THEO MA SACH");
                System.out.print("Nhap Ma Sach:              ");
                bookID=input.nextLine();
                timSachTheoID(bookID);
                break;
            case 3:
                System.out.println("\n\n\t\t\tTIM SACH THEO TAC GIA");
                System.out.print("Nhap Ten Tac Gia:              ");
                author=input.nextLine();
                timSachTheoTG(author);
                break;
            case 4:
                System.out.println("\n\n\t\t\tTIM SACH THEO NXB");
                System.out.print("Nhap NXB:              ");
                nXB=input.nextLine();
                timSachTheoTG(nXB);
                break;
            case 5:
                System.out.println("\n\n\t\t\tTIM SACH THEO KHOANG GIA");
                System.out.print("Nhap gia thap nhat:              ");
                min=Double.parseDouble(input.nextLine());
                System.out.print("Nhap gia cao nhat:              ");
                max=Double.parseDouble(input.nextLine());
                timSachTheoKhoangGia(min,max);
                break;
        }
        
    }
    
    public void hienThiTenSach(){
//        for(Sach sach: books)
//            System.out.println(sach.tenSach());
        
    }
    public void hienThongTinSach(){
        for(Sach sach: books)
            System.out.println(sach.toString());
    }
    public void hienThiSachDangKinhDoanh() { //có vấn đề
        File file= new File("Sach.txt");
        try (Scanner scanner = new Scanner(file)) 
        {
            System.out.println("\n\n+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("|                                                                    BOOK  DATABASE                                                                                                                                                                                 |");
            //System.out.println("|_____________________________________________________________________________________________________________________________________________________________________________________________________________________|");
            //System.out.printf("| %-50s| %-9s| %-30s| %-9d| %-15s| %-15s| %-10.3f| %50s| %-9s| %-4s| %-9s| %-4s| %-9s| %-9s| %n", "Ten Sach", "Ma Sach", "Tac Gia", "So Trang", "The Loai", "NXB", "Gia", "Mo Ta", "Loai Sach", "Kich Thuoc", "Loai Bia", "Kich Co Dung Luong", "Dung Luong", "So Luong");
            System.out.println("+---------------------------------------------------+----------+-------------------------------+----------+----------------+----------------+-----------+---------------------------------------------------+----------+-----+----------+-----+----------+----------+");

            while(scanner.hasNextLine()){   //.availabe: tra ve 1 luong byte co the doc, neu <=0 tuc la doc khong thanh cong
                String line = scanner.nextLine();
                String[] sachDuocDoc = line.split("#");
                String tenSach = sachDuocDoc[0];
                String maSach = sachDuocDoc[1];
                String tacGia = sachDuocDoc[2];
                int soTrang = Integer.parseInt(sachDuocDoc[3]);
                String theloai = sachDuocDoc[4];
                String nXB = sachDuocDoc[5];
                double Gia = Double.parseDouble(sachDuocDoc[6]);
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
                    soLuong=sachDuocDoc[13];
                }
                else if(loaiSach.toLowerCase().equalsIgnoreCase("PDf")||loaiSach.toLowerCase().equalsIgnoreCase("EPUB")){
                    kichThuoc="////";
                    loaiBia="////";
                    kichCoDungLuong = sachDuocDoc[11];
                    dungLuong =sachDuocDoc[12];
                    soLuong="////";
                }
//                int soLuong = Integer.parseInt(sachDuocDoc[11]);
//                if (loaiSach.equals("Giay")) 
//                    System.out.printf("| %-50s| %-9s| %-30s| %-9d| %-15s| %-15s| %-10.3f| %-50s| %-5s| %-5s| %-5s|%n",tenSach, maSach, tacGia, soTrang, theloai, nXB, donGia, moTa, loaiSach, kichThuoc, loaiBia, soLuong, "|");
//                else{
//                    System.out.printf("| %-50s| %-9s| %-30s| %-9d| %-15s| %-15s| %-10.2f| %-50s| %-5s| %-5s| %-5s| %n",tenSach, maSach, tacGia, soTrang, theloai, nXB, donGia, moTa, loaiSach, kichCoDungLuong, dungLuong, soLuong, "|");
//                }
                System.out.printf("| %-50s| %-9s| %-30s| %-9d| %-15s| %-15s| %-10.3f| %50s| %-9s| %-4s| %-9s| %-4s| %-9s| %-9s| %n", tenSach, maSach, tacGia, soTrang, theloai, nXB, Gia, moTa, loaiSach, kichThuoc, loaiBia, kichCoDungLuong, dungLuong,soLuong,"|");
            }
        }catch (FileNotFoundException e) {
        System.out.println("File not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("+---------------------------------------------------+---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+\n");
    }
    
    public void chinhSuaThongTinSach(){
        
    }
    public void danhGia(){
        Scanner nhapttsach = new Scanner(System.in);
        System.out.println("Moi ban danh gia: ");
        this.danhGia = nhapttsach.nextLine();

        System.out.println("Moi ban cho sao: ");
        this.soSao = Integer.parseInt(nhapttsach.nextLine());
        while (this.soSao < 0 || this.soSao > 5) {
            System.out.println("Moi ban nhap lai so sao (0-5): ");
            this.soSao = Integer.parseInt(nhapttsach.nextLine());
        }
    }
    public String danhGiaTuKhachHang(){
        StringBuilder sb = new StringBuilder();
        sb.append("Danh gia sach: ").append(this.danhGia).append("\n");
        sb.append("So sao: ").append(this.soSao).append("/5").append("\n");
        
        return sb.toString();
    }
    
    public static void main(String [] args){
        TuSach tuSach = new TuSach();
        Scanner input = new Scanner(System.in);
        
//        //Them sach cach 1
//        System.out.println("Nhap so luong sach ban muon them: ");
//        int soLuongSach = Integer.parseInt(input.nextLine());
//        for(int i =0;i<soLuongSach;i++){
//            Sach sach = new Sach(); //sach ở đây là instance variable, được tạo khi một đối tượng được tạo bằng việc sử dụng từ khóa new và sẽ bị phá hủy khi đối tượng bị phá hủy. 
//            sach.nhapThongTinSach();
//            tuSach.themSach(sach);
//        }
        //Them sach cach 2
        tuSach.themSach();
        //Viet sach vao file
        //tuSach.vietSachVaoFile("Sach.dat");
        //Hien thong tin tung quyen sach
        //tuSach.hienThongTinSach();
        //Hien thi nhung sach dang co
        //tuSach.hienThiSachDangKinhDoanh();
        //Cac phuong thuc tim sach khong co tham so
//        //Tim sach theo ten
//        tuSach.timSachTheoTen();
//        //Tim sach theo ma sach
//        tuSach.timSachTheoID();
//        //Tim sach theo ten tac gia
//        tuSach.timSachTheoTG();
//        //Tim sach theo ten NXB   
//        tuSach.timSachTheoNXB();
//        //Hien thi ten cac quyen sach
//        tuSach.hienThiTenSach();
        //Xoa sach theo ID
        tuSach.xoaSachTheoID();
//        //Xoa sach theo ten
//        tuSach.xoaSachTheoTen();
//        tuSach.hienThiSachDangCo();
//        //Danh gia sach
//        tuSach.danhGia();
//        String danhGiaTuKhachHang = tuSach.danhGiaTuKhachHang();
//        System.out.println(danhGiaTuKhachHang);
//        //Menu Tim Sach
//        tuSach.timSach();
        
       
    }
}
/*
    Đọc và viết file sử dụng DataOut(In)putStream:
     public void vietSachVaoFile(String tenFile) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(tenFile))) {
            for (Sach sach : books) {
                dos.writeUTF(sach.getTenSach());
                dos.writeUTF(sach.getMaSach());
                dos.writeUTF(sach.getTacGia());
                dos.writeInt(sach.getSoTrang());
                dos.writeUTF(sach.getNXB());
                dos.writeUTF(sach.getMoTa());
                dos.writeDouble(sach.getDonGia());
                dos.writeInt(sach.getSoLuong());
            }
            System.out.println("Viet sach vao file thanh cong.....");
        } catch (IOException e) {
            System.out.println("Viet sach vao file khong thanh cong....." + e.getMessage());
        }
    }

    public void hienThiSachDangKinhDoanh() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream("Sach.dat"))) {
            // Your existing code to display the table header

            while (dis.available() > 0) {
                // Read the data in the same order as you wrote it
                String tenSach = dis.readUTF();
                String maSach = dis.readUTF();
                String tacGia = dis.readUTF();
                int soTrang = dis.readInt();
                String nXB = dis.readUTF();
                String moTa = dis.readUTF();
                double donGia = dis.readDouble();
                int soLuong = dis.readInt();

                // Display the data as needed
                System.out.printf("| %-20s| %-9s| %-20s| %-9s| %-15s| %-20s| %-20s| %-8s|\n",
                        tenSach, maSach, tacGia, soTrang, nXB, donGia, moTa, soLuong, "|");
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
    
    Đọc và viết file sử dụng ObjectOut(In)putStream:
    public void vietSachVaoFile(String tenFile) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(tenFile))) {
            oos.writeObject(books);
            System.out.println("Viet sach vao file thanh cong.....");
        } catch (IOException e) {
            System.out.println("Viet sach vao file khong thanh cong....." + e.getMessage());
        }
    }

    public void hienThiSachDangKinhDoanh() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Sach.dat"))) {
            // Your existing code to display the table header

            @SuppressWarnings("unchecked")
            ArrayList<Sach> loadedBooks = (ArrayList<Sach>) ois.readObject();

            for (Sach sach : loadedBooks) {
                // Display the data as needed
                System.out.printf("| %-20s| %-9s| %-20s| %-9s| %-15s| %-20s| %-20s| %-8s|\n",
                        sach.getTenSach(), sach.getMaSach(), sach.getTacGia(), sach.getSoTrang(),
                        sach.getNXB(), sach.getDonGia(), sach.getMoTa(), sach.getSoLuong(), "|");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
!!!ObjectOut(In)putStream đòi hỏi những đối tượng được đọc phải được tuần tự hóa(Serialized), nếu không sẽ bị lỗi không đọc được
*/
/*
Using PrintWriter:
private static void inputAndWriteSachGiayWithPrintWriter() {
    Scanner input = new Scanner(System.in);
    SachGiay sachGiay = new SachGiay();
    sachGiay.nhapThongTinSachGiay();

    try (PrintWriter writer = new PrintWriter(new FileWriter("SachGiay_PrintWriter.data", true))) {
        writer.println(sachGiay.toString());
        System.out.println("SachGiay data written using PrintWriter to SachGiay_PrintWriter.data file.");
    } catch (IOException e) {
        System.out.println("An error occurred while writing SachGiay data using PrintWriter: " + e.getMessage());
    }
}

Using DataOutputStream:
private static void inputAndWriteSachMemWithDataOutputStream() {
    Scanner input = new Scanner(System.in);
    SachMem sachMem = new SachMem();
    sachMem.nhapThongTinSachMem();

    try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("SachMem_DataOutputStream.data", true))) {
        outputStream.writeUTF(sachMem.toString());
        System.out.println("SachMem data written using DataOutputStream to SachMem_DataOutputStream.data file.");
    } catch (IOException e) {
        System.out.println("An error occurred while writing SachMem data using DataOutputStream: " + e.getMessage());
    }
}

Using ObjectOutputStream:
private static void inputAndWriteSachGiayWithObjectOutputStream() {
    Scanner input = new Scanner(System.in);
    SachGiay sachGiay = new SachGiay();
    sachGiay.nhapThongTinSachGiay();

    try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("SachGiay_ObjectOutputStream.data", true))) {
        objectOutputStream.writeObject(sachGiay);
        System.out.println("SachGiay data written using ObjectOutputStream to SachGiay_ObjectOutputStream.data file.");
    } catch (IOException e) {
        System.out.println("An error occurred while writing SachGiay data using ObjectOutputStream: " + e.getMessage());
    }
}

*/
