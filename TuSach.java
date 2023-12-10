/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BookStore;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class TuSach {
    private int soSach;
    private static int sachDaHienThi = 0;
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
    
    public void themSach() {
        Scanner input = new Scanner(System.in);
        String tiepTuc=null;
        do{
            Sach sach = null;
            System.out.println("Ban muon them loai sach nao?");
            System.out.println("1: Sach giay | 2: Sach mem");
            
            String choice = input.nextLine();
            if(!choice.equalsIgnoreCase("1")&&!choice.equalsIgnoreCase("2")){
                System.out.println("Lua chon khong hop le, moi ban nhap lai.....");
                themSach();
            }
            switch (choice) {
            case "1":
                sach = new SachGiay();
                ((SachGiay) sach).nhapThongTinSachChoNhanVien();
                books.add(sach);
                soSach++;
                vietSachVaoFile(choice);
                break;
            case "2":
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
            System.out.println("Ban co muon tiep tuc them sach? (Y/N)");
            tiepTuc=input.nextLine();
        }while(!tiepTuc.equalsIgnoreCase("N"));  
    }
    public void vietSachVaoFile(String choice) {
        String fileName = "book.txt";
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
                sb.append(sach.getgia()).append("#");
                sb.append(sach.getMoTa()).append("#");

                if (sach instanceof SachGiay) {
                    sb.append("Giay").append("#");
                    sb.append(((SachGiay) sach).getKichThuoc()).append("#");
                    sb.append(((SachGiay) sach).getLoaiBia()).append("#");
                    sb.append("////").append("#");
                    sb.append("////").append("#");
                    sb.append(((SachGiay) sach).getHienCo());
                } else if (sach instanceof SachMem) {
                    sb.append(((SachMem) sach).getLoai()).append("#");
                    sb.append("////").append("#");
                    sb.append("////").append("#");
                    sb.append(((SachMem) sach).getKichCoDungLuong()).append("#");
                    sb.append(((SachMem) sach).getDungLuong()).append("#");
                    sb.append("////");
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
            File inputFile = new File("book.txt");
            File tempFile = new File("TempBook.txt");
            
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
    public void timSachTheoTen(){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap ten sach ban muon tim: ");
        String tenSachCanTim = input.nextLine();
        while(!tenSachCanTim.matches("^[a-zA-Z0-9\\s]+$")||tenSachCanTim.trim().isEmpty()){
            System.out.println("Lua chon khong phu hop, vui long nhap lai.....");
            tenSachCanTim=input.nextLine();
        }
        boolean found = false;
        String fileName = "book.txt";
        File file = new File(fileName);
        try(Scanner scanner = new Scanner(file)){
            System.out.println("\n+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("|                                                                    THONG TIN SACH                                                                                                                                                                                 |");
            System.out.println("|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
//            System.out.println("|"+"                      Ten Sach                     |" +"  Ma Sach "+"|" + "          Tac Gia              |"+"So Trang  "+"|"+ "     The Loai   |"+ "       NXB      "+"|"+ "    Gia    |"+"                            Mo Ta                  |"+ " Loai Sach|"+ " Size|"+ " Loai Bia |"+ "FSize|"+ "Dung Luong|"+ " So Luong |");
            System.out.printf("| %-50s| %-10s| %-30s| %-9s| %-15s| %-15s| %-10s| %-45s| %-9s| %-4s| %-9s| %-6s| %-10s| %-10s| %n", "Ten Sach", "Ma Sach", "Tac Gia", "So Trang", "The Loai", "NXB", "Gia", "Mo Ta", "Loai Sach","Size","Loai Bia","FSize","Dung Luong","So Luong", "|");
            System.out.println("+---------------------------------------------------+-----------+-------------------------------+----------+----------------+----------------+-----------+----------------------------------------------+----------+-----+----------+-------+-----------+-----------+");
            while(scanner.hasNextLine()){   //từ đây đến else if là để input dữ liệu từ chuỗi thông tin về sách vào các mục tương ứng
                String line=scanner.nextLine();
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
                if(tenSach.toLowerCase().contains(tenSachCanTim)){  //phần này để xét điều kiện để chọn các sách phù hợp yêu cầu để hiển thị
                    System.out.printf("| %-50s| %-10s| %-30s| %-9d| %-15s| %-15s| %-10.3f| %-45s| %-9s| %-4s| %-9s| %-6s| %-10s| %-10s| %n", tenSach, maSach, tacGia, soTrang, theloai, nXB, Gia, moTa, loaiSach, kichThuoc, loaiBia, kichCoDungLuong, dungLuong,soLuong,"|");
                    System.out.println("+---------------------------------------------------+-----------+-------------------------------+----------+----------------+----------------+-----------+----------------------------------------------+----------+-----+----------+-------+-----------+-----------+");
                    found = true;
                   //break; //ngừng tìm khi sách đã được tìm thấy
                }
            }
            
        }catch(IOException e){
            System.out.println("Khong doc duoc file.....\n" + e.getMessage());
        }
        
        if(!found) //(found) có nghĩa là cách viết khác của found==true, vậy !found tức là false
            System.out.println("Khong tim thay sach.....");
    }
    public void timSachTheoID(){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap ma sach ban muon tim: ");
        String maSachCanTim = input.nextLine();
        while(!maSachCanTim.matches("^[a-zA-Z0-9\\s]+$")||maSachCanTim.trim().isEmpty()){
            System.out.println("Lua chon khong phu hop, vui long nhap lai.....");
            maSachCanTim=input.nextLine();
        }
        boolean found = false;
        String fileName = "book.txt";
        File file = new File(fileName);
        try(Scanner scanner = new Scanner(file)){
            System.out.println("\n+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("|                                                                    THONG TIN SACH                                                                                                                                                                                 |");
            System.out.println("|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
//            System.out.println("|"+"                      Ten Sach                     |" +"  Ma Sach "+"|" + "          Tac Gia              |"+"So Trang  "+"|"+ "     The Loai   |"+ "       NXB      "+"|"+ "    Gia    |"+"                            Mo Ta                  |"+ " Loai Sach|"+ " Size|"+ " Loai Bia |"+ "FSize|"+ "Dung Luong|"+ " So Luong |");
            System.out.printf("| %-50s| %-10s| %-30s| %-9s| %-15s| %-15s| %-10s| %-45s| %-9s| %-4s| %-9s| %-6s| %-10s| %-10s| %n", "Ten Sach", "Ma Sach", "Tac Gia", "So Trang", "The Loai", "NXB", "Gia", "Mo Ta", "Loai Sach","Size","Loai Bia","FSize","Dung Luong","So Luong", "|");
            System.out.println("+---------------------------------------------------+-----------+-------------------------------+----------+----------------+----------------+-----------+----------------------------------------------+----------+-----+----------+-------+-----------+-----------+");
            while(scanner.hasNextLine()){
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
                
                if(maSach.toLowerCase().contains(maSachCanTim)){
                    System.out.printf("| %-50s| %-10s| %-30s| %-9d| %-15s| %-15s| %-10.3f| %-45s| %-9s| %-4s| %-9s| %-6s| %-10s| %-10s| %n", tenSach, maSach, tacGia, soTrang, theloai, nXB, Gia, moTa, loaiSach, kichThuoc, loaiBia, kichCoDungLuong, dungLuong,soLuong,"|");
                    System.out.println("+---------------------------------------------------+-----------+-------------------------------+----------+----------------+----------------+-----------+----------------------------------------------+----------+-----+----------+-------+-----------+-----------+");
                    found = true;
                }
            }
        }catch(IOException e){
            System.out.println("Khong doc duoc file.....\n" + e.getMessage());
        }
        
        if(!found)
            System.out.println("Khong tim thay sach.....");
    }
    public Sach timSachTheoID(String id){
        String maSachCanTim = id;
        Sach foundSach=null;
        while(!maSachCanTim.matches("^[a-zA-Z0-9\\s]+$") || maSachCanTim.trim().isEmpty()){
            return foundSach;
        }
        String fileName = "book.txt";
        File file = new File(fileName);
        try(Scanner scanner = new Scanner(file)){
           while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] sachDuocDoc = line.split("#");
                String tenSach = sachDuocDoc[0];
                String maSach = sachDuocDoc[1];
                String tacGia = sachDuocDoc[2];
                int soTrang = Integer.parseInt(sachDuocDoc[3]);
                String theLoai = sachDuocDoc[4];
                String NXB = sachDuocDoc[5];
                double gia = Double.parseDouble(sachDuocDoc[6]);
                String moTa = sachDuocDoc[7];
                String loaiSach = sachDuocDoc[8];
                String kichThuoc="";
                String loaiBia="";
                String kichCoDungLuong="";
                String dungLuong="";
                int soLuong=0;
                if ( loaiSach.equals("Giay")){
                    kichThuoc = sachDuocDoc[9];
                    loaiBia = sachDuocDoc[10];
                    kichCoDungLuong="////";
                    dungLuong="////";
                    soLuong=Integer.parseInt(sachDuocDoc[13]);
                }
                else if(loaiSach.toLowerCase().equalsIgnoreCase("PDF")||loaiSach.toLowerCase().equalsIgnoreCase("EPUB")){
                    kichThuoc="////";
                    loaiBia="////";
                    kichCoDungLuong = sachDuocDoc[11];
                    dungLuong =sachDuocDoc[12];
                    soLuong=0;
                }
//                (String tenSach,String maSach,String tacGia,int soTrang,String theLoai,String NXB,double gia,String moTa,String loaiSach,int soLuong)
                if(maSach.equalsIgnoreCase(maSachCanTim)){
                    foundSach=new Sach(tenSach,maSach,tacGia,soTrang,theLoai,NXB,gia,moTa,loaiSach,soLuong);
                }
            }
        }catch(IOException e){
            System.out.println("Khong doc duoc file.....\n" + e.getMessage());
        }
        return foundSach;
    }
    public void timSachTheoTG(){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap ten tac gia ma ban muon tim: ");
        String tgCanTim = input.nextLine();
        while(!tgCanTim.matches("^[a-zA-Z\\s]+$")||tgCanTim.trim().isEmpty()){
            System.out.println("Lua chon khong phu hop, vui long nhap lai.....");
            tgCanTim=input.nextLine();
        }
        boolean found = false;
        String fileName = "book.txt";
        File file = new File(fileName);
        try(Scanner scanner = new Scanner(file)){               
            System.out.println("\n+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("|                                                                    THONG TIN SACH                                                                                                                                                                                 |");
            System.out.println("|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
//            System.out.println("|"+"                      Ten Sach                     |" +"  Ma Sach "+"|" + "          Tac Gia              |"+"So Trang  "+"|"+ "     The Loai   |"+ "       NXB      "+"|"+ "    Gia    |"+"                            Mo Ta                  |"+ " Loai Sach|"+ " Size|"+ " Loai Bia |"+ "FSize|"+ "Dung Luong|"+ " So Luong |");
            System.out.printf("| %-50s| %-10s| %-30s| %-9s| %-15s| %-15s| %-10s| %-45s| %-9s| %-4s| %-9s| %-6s| %-10s| %-10s| %n", "Ten Sach", "Ma Sach", "Tac Gia", "So Trang", "The Loai", "NXB", "Gia", "Mo Ta", "Loai Sach","Size","Loai Bia","FSize","Dung Luong","So Luong", "|");
            System.out.println("+---------------------------------------------------+-----------+-------------------------------+----------+----------------+----------------+-----------+----------------------------------------------+----------+-----+----------+-------+-----------+-----------+");
            while(scanner.hasNextLine()){
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
                
                if(tacGia.toLowerCase().contains(tgCanTim)){
                    System.out.printf("| %-50s| %-10s| %-30s| %-9d| %-15s| %-15s| %-10.3f| %-45s| %-9s| %-4s| %-9s| %-6s| %-10s| %-10s| %n", tenSach, maSach, tacGia, soTrang, theloai, nXB, Gia, moTa, loaiSach, kichThuoc, loaiBia, kichCoDungLuong, dungLuong,soLuong,"|");
                    System.out.println("+---------------------------------------------------+-----------+-------------------------------+----------+----------------+----------------+-----------+----------------------------------------------+----------+-----+----------+-------+-----------+-----------+");
                    found = true;
                }
            }
        }catch(IOException e){
            System.out.println("Khong doc duoc file.....\n" + e.getMessage());
        }
        
        if(!found)
            System.out.println("Khong tim thay sach.....");
    }
    public void timSachTheoNXB(){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap NXB ma ban muon tim: ");
        String nxbCanTim = input.nextLine();
        while(!nxbCanTim.matches("^[a-zA-Z\\s]+$")||nxbCanTim.trim().isEmpty()){
            System.out.println("Lua chon khong phu hop, vui long nhap lai.....");
            nxbCanTim=input.nextLine();
        }
        boolean found = false;
        String fileName = "book.txt";
        File file = new File(fileName);
        try(Scanner scanner = new Scanner(file)){
            System.out.println("\n+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("|                                                                    THONG TIN SACH                                                                                                                                                                                 |");
            System.out.println("|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
//            System.out.println("|"+"                      Ten Sach                     |" +"  Ma Sach "+"|" + "          Tac Gia              |"+"So Trang  "+"|"+ "     The Loai   |"+ "       NXB      "+"|"+ "    Gia    |"+"                            Mo Ta                  |"+ " Loai Sach|"+ " Size|"+ " Loai Bia |"+ "FSize|"+ "Dung Luong|"+ " So Luong |");
            System.out.printf("| %-50s| %-10s| %-30s| %-9s| %-15s| %-15s| %-10s| %-45s| %-9s| %-4s| %-9s| %-6s| %-10s| %-10s| %n", "Ten Sach", "Ma Sach", "Tac Gia", "So Trang", "The Loai", "NXB", "Gia", "Mo Ta", "Loai Sach","Size","Loai Bia","FSize","Dung Luong","So Luong", "|");
            System.out.println("+---------------------------------------------------+-----------+-------------------------------+----------+----------------+----------------+-----------+----------------------------------------------+----------+-----+----------+-------+-----------+-----------+");
            while(scanner.hasNextLine()){
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
                
                if(nXB.toLowerCase().contains(nxbCanTim)){
                    System.out.printf("| %-50s| %-10s| %-30s| %-9d| %-15s| %-15s| %-10.3f| %-45s| %-9s| %-4s| %-9s| %-6s| %-10s| %-10s| %n", tenSach, maSach, tacGia, soTrang, theloai, nXB, Gia, moTa, loaiSach, kichThuoc, loaiBia, kichCoDungLuong, dungLuong,soLuong,"|");
                    System.out.println("+---------------------------------------------------+-----------+-------------------------------+----------+----------------+----------------+-----------+----------------------------------------------+----------+-----+----------+-------+-----------+-----------+");
                    found = true;
                }
            }
        }catch(IOException e){
            System.out.println("Khong doc duoc file.....\n" + e.getMessage());
        }
        
        if(!found)
            System.out.println("Khong tim thay sach.....");
    }
    public void timSachTheoKhoangGia(){
        boolean found = false;
        String fileName = "book.txt";
        File file = new File(fileName);
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap gia thap nhat: ");
        Double min = Double.parseDouble(input.nextLine());
        System.out.println("Nhap gia cao nhat: ");
        Double max = Double.parseDouble(input.nextLine());
        System.out.println("\nCac sach tu " + min + " - " + max +": \n" );
        try(Scanner scanner = new Scanner(file)){              
            System.out.println("\n+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("|                                                                    THONG TIN SACH                                                                                                                                                                                 |");
            System.out.println("|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
//            System.out.println("|"+"                      Ten Sach                     |" +"  Ma Sach "+"|" + "          Tac Gia              |"+"So Trang  "+"|"+ "     The Loai   |"+ "       NXB      "+"|"+ "    Gia    |"+"                            Mo Ta                  |"+ " Loai Sach|"+ " Size|"+ " Loai Bia |"+ "FSize|"+ "Dung Luong|"+ " So Luong |");
            System.out.printf("| %-50s| %-10s| %-30s| %-9s| %-15s| %-15s| %-10s| %-45s| %-9s| %-4s| %-9s| %-6s| %-10s| %-10s| %n", "Ten Sach", "Ma Sach", "Tac Gia", "So Trang", "The Loai", "NXB", "Gia", "Mo Ta", "Loai Sach","Size","Loai Bia","FSize","Dung Luong","So Luong", "|");
            System.out.println("+---------------------------------------------------+-----------+-------------------------------+----------+----------------+----------------+-----------+----------------------------------------------+----------+-----+----------+-------+-----------+-----------+");
            while(scanner.hasNextLine()){    
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
                if(Gia>=min&&Gia<=max){
                    System.out.printf("| %-50s| %-10s| %-30s| %-9d| %-15s| %-15s| %-10.3f| %-45s| %-9s| %-4s| %-9s| %-6s| %-10s| %-10s| %n", tenSach, maSach, tacGia, soTrang, theloai, nXB, Gia, moTa, loaiSach, kichThuoc, loaiBia, kichCoDungLuong, dungLuong,soLuong,"|");
                    System.out.println("+---------------------------------------------------+-----------+-------------------------------+----------+----------------+----------------+-----------+----------------------------------------------+----------+-----+----------+-------+-----------+-----------+");
                    found = true;
                }
            }
        }catch(IOException e){
            System.out.println("Khong doc duoc file.....\n" + e.getMessage());
        }
        if(!found)
            System.out.println("\nKhong co sach trong khoang nay...");
    }
    public void timSachTheoTheLoai(){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap the loai ban muon tim kiem: ");
        String theLoaiCanTim = input.nextLine();
        while(!theLoaiCanTim.matches("^[a-zA-Z\\s]+$")||theLoaiCanTim.trim().isEmpty()){
            System.out.println("Lua chon khong phu hop, vui long nhap lai.....");
            theLoaiCanTim=input.nextLine();
        }
        boolean found = false;
        String fileName = "book.txt";
        File file = new File(fileName);
        try(Scanner scanner = new Scanner(file)){
            System.out.println("\n\n+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("|                                                                    THONG TIN SACH                                                                                                                                                                                 |");
            System.out.println("|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
//            System.out.println("|"+"                      Ten Sach                     |" +"  Ma Sach "+"|" + "          Tac Gia              |"+"So Trang  "+"|"+ "     The Loai   |"+ "       NXB      "+"|"+ "    Gia    |"+"                            Mo Ta                  |"+ " Loai Sach|"+ " Size|"+ " Loai Bia |"+ "FSize|"+ "Dung Luong|"+ " So Luong |");
            System.out.printf("| %-50s| %-10s| %-30s| %-9s| %-15s| %-15s| %-10s| %-45s| %-9s| %-4s| %-9s| %-6s| %-10s| %-10s| %n", "Ten Sach", "Ma Sach", "Tac Gia", "So Trang", "The Loai", "NXB", "Gia", "Mo Ta", "Loai Sach","Size","Loai Bia","FSize","Dung Luong","So Luong", "|");
            System.out.println("+---------------------------------------------------+-----------+-------------------------------+----------+----------------+----------------+-----------+----------------------------------------------+----------+-----+----------+-------+-----------+-----------+");
            while(scanner.hasNextLine()){ 
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
                
                if(theloai.toLowerCase().contains(theLoaiCanTim)){
                    System.out.printf("| %-50s| %-10s| %-30s| %-9d| %-15s| %-15s| %-10.3f| %-45s| %-9s| %-4s| %-9s| %-6s| %-10s| %-10s| %n", tenSach, maSach, tacGia, soTrang, theloai, nXB, Gia, moTa, loaiSach, kichThuoc, loaiBia, kichCoDungLuong, dungLuong,soLuong,"|");
                    System.out.println("+---------------------------------------------------+-----------+-------------------------------+----------+----------------+----------------+-----------+----------------------------------------------+----------+-----+----------+-------+-----------+-----------+");
                    found = true;
                }
            }
        }catch(IOException e){
            System.out.println("Khong doc duoc file.....\n" + e.getMessage());
        }
        if(!found)
            System.out.println("Khong tim thay sach.....");
    }
    public void timSach(){
        String code;
        Scanner input = new Scanner(System.in);
        
        System.out.println("\n");
        System.out.println("\t+---------- Query Options ----------+");
        System.out.println("\t|     1. Tim sach theo Ten          |");
        System.out.println("\t|     2. Tim sach theo Ma Sach      |");
        System.out.println("\t|     3. Tim sach theo Tac Gia      |");
        System.out.println("\t|     4. Tim sach theo NXB          |");
        System.out.println("\t|     5. Tim sach theo Gia          |");
        System.out.println("\t|     6. Tim sach theo The Loai     |");
        System.out.println("\t+-----------------------------------+");
        System.out.print("\n Moi ban nhap:  ");
        code = input.nextLine();
        while(!code.equals("1")&&!code.equals("2")&&!code.equals("3")&&!code.equals("4")&&!code.equals("5")&&!code.equals("6")){
            System.out.println("Lua chon khong hop le, vui long nhap lai.....");
            code=input.nextLine();
        }
        switch(code){
            case "1":
                System.out.println("\n\n\t\t\tTIM SACH THEO TEN");
                timSachTheoTen();
                break;
            case "2":
                System.out.println("\n\n\t\t\tTIM SACH THEO MA SACH");
                timSachTheoID();
                break;
            case "3":
                System.out.println("\n\n\t\t\tTIM SACH THEO TAC GIA");
                timSachTheoTG();
                break;
            case "4":
                System.out.println("\n\n\t\t\tTIM SACH THEO NXB");
                timSachTheoNXB();
                break;
            case "5":
                System.out.println("\n\n\t\t\tTIM SACH THEO KHOANG GIA");
                timSachTheoKhoangGia();
                break;
            case "6":
                System.out.println("\n\n\t\t\tTIM SACH THEO THE LOAI");
                timSachTheoTheLoai();
                break;
        }
        System.out.println("Ban co muon tiep tuc tim kiem? (Y/N)");
        String opt=input.nextLine();
        while(!opt.toLowerCase().equalsIgnoreCase("N")&&!opt.toLowerCase().equalsIgnoreCase("Y")&&!opt.toLowerCase().equalsIgnoreCase("No")&&!opt.toLowerCase().equalsIgnoreCase("Yes")){
                        System.out.println("Lua chon khong phu hop, vui long nhap lai.....");
                        opt = input.nextLine();
                    }
        if(opt.toLowerCase().equalsIgnoreCase("Y")||opt.toLowerCase().equalsIgnoreCase("Yes"))
            timSach();
    }

    public static void hienThiSachDangKinhDoanh() { 
        File file= new File("book.txt");
        try (Scanner scanner = new Scanner(file)) 
        {
            System.out.println("\n\n+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("|                                                                    BOOK  DATABASE                                                                                                                                                                                 |");
            System.out.println("|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
//            System.out.println("|"+"                      Ten Sach                     |" +"  Ma Sach "+"|" + "          Tac Gia              |"+"So Trang  "+"|"+ "     The Loai   |"+ "       NXB      "+"|"+ "    Gia    |"+"                            Mo Ta                  |"+ " Loai Sach|"+ " Size|"+ " Loai Bia |"+ "FSize|"+ "Dung Luong|"+ " So Luong |");
            System.out.printf("| %-50s| %-10s| %-30s| %-9s| %-15s| %-15s| %-10s| %-45s| %-9s| %-4s| %-9s| %-6s| %-10s| %-10s| %n", "Ten Sach", "Ma Sach", "Tac Gia", "So Trang", "The Loai", "NXB", "Gia", "Mo Ta", "Loai Sach","Size","Loai Bia","FSize","Dung Luong","So Luong", "|");
            System.out.println("+---------------------------------------------------+-----------+-------------------------------+----------+----------------+----------------+-----------+----------------------------------------------+----------+-----+----------+-------+-----------+-----------+");
            while(scanner.hasNextLine()){   //.availabe: tra ve 1 luong byte co the doc, neu <=0 tuc la doc khong thanh cong
                sachDaHienThi++;
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
//                System.out.println("+---------------------------------------------------+----------+-------------------------------+----------+----------------+----------------+-----------+---------------------------------------------------+----------+-----+----------+-----+----------+----------+");
                System.out.printf("| %-50s| %-10s| %-30s| %-9d| %-15s| %-15s| %-10.3f| %-45s| %-9s| %-4s| %-9s| %-6s| %-10s| %-10s| %n", tenSach, maSach, tacGia, soTrang, theloai, nXB, Gia, moTa, loaiSach, kichThuoc, loaiBia, kichCoDungLuong, dungLuong,soLuong,"|");
                System.out.println("+---------------------------------------------------+-----------+-------------------------------+----------+----------------+----------------+-----------+----------------------------------------------+----------+-----+----------+-------+-----------+-----------+");


                if(sachDaHienThi%10==0){
                    System.out.println("Ban co muon tiep tuc hien thi? (Y/N)");
                    Scanner input = new Scanner(System.in);
                    String opt = input.nextLine();
                    
                    while(!opt.toLowerCase().equalsIgnoreCase("N")&&!opt.toLowerCase().equalsIgnoreCase("Y")&&!opt.toLowerCase().equalsIgnoreCase("No")&&!opt.toLowerCase().equalsIgnoreCase("Yes")){
                        System.out.println("Lua chon khong phu hop, vui long nhap lai.....");
                        opt = input.nextLine();
                    }
                    if(opt.toLowerCase().equalsIgnoreCase("N")||opt.toLowerCase().equalsIgnoreCase("No")){
                        sachDaHienThi=0;
                        break;
                    }
                    System.out.println("+---------------------------------------------------+----------+-------------------------------+----------+----------------+----------------+-----------+---------------------------------------------------+----------+-----+----------+-----+----------+----------+");

                }
            }
        }catch (FileNotFoundException e) {
        System.out.println("File not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }
    
    public void chinhSuaThongTinSach(){
       
    }
    public static void taoFileTuDong(){
        File file = new File("book.txt");
        if(!file.exists()){
            try(FileWriter write = new FileWriter(file,true)){
                StringBuilder sb = new StringBuilder();
                sb.append("Giai thich ngu phap tieng Anh#001P#M.L Huong;H.T Uyen#560#Giao duc#Da Nang#220.000#Sach danh cho viec on luyen ngu phap#Giay#A4#Mem#\\\\\\\\#\\\\\\\\#20\n" +
"");
                sb.append("Giai thich ngu phap tieng Anh#002P#M.L Huong;H.T Uyen#560#Giao duc#Da Nang#285.000#Sach danh cho viec on luyen ngu phap#Giay#A4#Cung#\\\\\\\\#\\\\\\\\#5\n" +
"");
                sb.append("Su im lang cua bay cuu#003P#Thomas Harris#359#Trinh tham#Hoi Nha Van#115.000#Tieu thuyet trinh tham kinh di day hap dan#Giay#A4#Mem#\\\\\\\\#\\\\\\\\#15\n" +
"");
                sb.append("Su im lang cua bay cuu#004P#Thomas Harris#359#Trinh tham#Hoi Nha Van#185.000#Tieu thuyet trinh tham kinh di day hap dan#Giay#A4#Cung#\\\\\\\\#\\\\\\\\#5\n" +
"");
                sb.append("Nhan gui mot toi nguoi da yeu em#005P#Otono Yomoji#235#Tinh cam#Ha Noi#128.000#Cau truyen tinh cam va noi buon#Giay#A5#Mem#\\\\\\\\#\\\\\\\\#30\n" +
"");
                sb.append("Nhan gui tat ca cac em nguoi toi da yeu#006P#Otono Yomoji#235#Tinh cam#Ha Noi#128.000#Cau truyen tinh cam va noi buon#Giay#A5#Mem#\\\\\\\\#\\\\\\\\#30\n" +
"");
                sb.append("5centimet tren giay#007P#Shinkai Makoto#188#Tinh cam#Ha Noi#50.000#Cau truyen tinh cam tuoi thanh xuan#Giay#A5#Mem#\\\\\\\\#\\\\\\\\#30\n" +
"");
                sb.append("Thi va su phoi hop thi trong tieng Anh#008P#M.L Huong; N.T.T Tam#183#Giao duc#Da Nang#56.800#Sach danh cho viec on luyen ngu phap#Giay#A4#Mem#\\\\\\\\#\\\\\\\\#22\n" +
"");
                sb.append("Thi va su phoi hop thi trong tieng Anh#009P#M.L Huong; N.T.T Tam#183#Giao duc#Da Nang#122.000#Sach danh cho viec on luyen ngu phap#Giay#A4#Cung#\\\\\\\\#\\\\\\\\#5\n" +
"");
                sb.append("Dong tu bat quy tac & ngu phap tieng Anh co ban#010P#M.LHuong#200#Giao duc#Da Nang#34.400#Sach danh cho viec on luyen ngu phap#Giay#A4#Mem#\\\\\\\\#\\\\\\\\#10\n" +
"");
                sb.append("Hieu ve trai tim#011P#Minh Niem#480#Tam ly#TP.HCM#158.000#Hieu them ve tam ly cua ban than#Giay#A4#Mem#\\\\\\\\#\\\\\\\\#10\n" +
"");
                sb.append("Atomic Habits#012P#James Clear#200#Tam ly#NXB The Gioi#186.000#Hieu them ve tam ly cua ban than#Giay#A4#Mem#\\\\\\\\#\\\\\\\\#20\n" +
"");
                sb.append("Atomic Habits#013P#James Clear#200#Tam ly#NXB The Gioi#250.000#Hieu them ve tam ly cua ban than#Giay#A4#Cung#\\\\\\\\#\\\\\\\\#4\n" +
"");
                sb.append("Dam nghi lai#014P#Adam Grant#336#Tam ly#NXB Dan Tri#153.000#Hieu them ve tam ly cua ban than#Giay#A4#Mem#\\\\\\\\#\\\\\\\\#20\n" +
"");
                sb.append("Thay doi cuoc song than so hoc#015P#L.D.Q Huong#240#Tam ly#NXB HaNoi#342.000#Hieu them ve tam ly cua ban than#Giay#A4#Mem#\\\\\\\\#\\\\\\\\#15\n" +
"");
                sb.append("Toi thay hoa vang tren co xanh#016P#Nguyen Nhat Anh#378#Truyen ngan#NXB Tre#82.000#Nhung cau truyen thu vi hap dan#Giay#A5#Mem#\\\\\\\\#\\\\\\\\#16\n" +
"");
                sb.append("Toi thay hoa vang tren co xanh#017P#Nguyen Nhat Anh#378#Truyen ngan#NXB Tre#150.000#Nhung cau truyen thu vi hap dan#Giay#A5#Cung#\\\\\\\\#\\\\\\\\#3\n" +
"");
                sb.append("Co hai con meo ngoi ben cua so#018P#Nguyen Nhat Anh#210#Truyen ngan#NXB Tre#71.500#Nhung cau truyen thu vi hap dan#Giay#A5#Mem#\\\\\\\\#\\\\\\\\#16\n" +
"");
                sb.append("Mat biec#019P#Nguyen Nhat Anh#300#Truyen ngan#NXB Tre#75.400#Nhung cau truyen thu vi hap dan#Giay#A5#Mem#\\\\\\\\#\\\\\\\\#12\n" +
"");
                sb.append("Cho toi xin mot ve di tuoi tho#020P#Nguyen Nhat Anh#208#Truyen ngan#NXB Tre#72.000#Nhung cau truyen thi vi hap dan#Giay#A5#Mem#\\\\\\\\#\\\\\\\\#13\n" +
"");
                sb.append("Tuoi tre dang gia bao nhieu#021P#Rosie Nguyen#283#Tam ly#Hoi Nha Vien#80.000#Hieu them ve tam ly cua ban than#Giay#A4#Mem#\\\\\\\\#\\\\\\\\#7\n" +
"");
                sb.append("O quan ca phe cua tuoi tre lac loi#022P#Patrick Modiano#153#Truyen ngan#NXB Van Hoc#59.000#Nhung cau truyen thi vi hap dan#Giay#A5#Mem#\\\\\\\\#\\\\\\\\#4\n" +
"");
                sb.append("Vo nhat#023P#Kim Lan#242#Truyen ngan#NXB Van Hoc#41.500#Nhung cau truyen thi vi hap dan#Giay#A4#Mem#\\\\\\\\#\\\\\\\\#4\n" +
"");
                sb.append("Lap trinh ngon ngu C++#024P#V.V Vu; P.T.T Hien#300#Giao duc#NXB KHKT#108.000#Lap trinh ngon ngu may tinh#Giay#A4#Mem#\\\\\\\\#\\\\\\\\#18\n" +
"");
                sb.append("Lap trinh huong doi tuong#025P#P.V At; L.T Thong#488#Giao duc#NXB BKHN#168.000#Lap trinh huong doi tuong#Giay#A4#Mem#\\\\\\\\#\\\\\\\\#4\n" +
"");
                sb.append("Tra hoa nu#026P#Alexandre Dumas#303#Tinh cam#Hoi Nha Van#60.000#nhung cau truyen tinh yeu lang man#Giay#A4#Mem#\\\\\\\\#\\\\\\\\#8\n" +
"");
                sb.append("Rung Na Uy#027P#Naruki Murakami#556#Tinh cam#Hoi Nha Van#126.000#nhung cau truyen tinh yeu lang man#Giay#A4#Mem#\\\\\\\\#\\\\\\\\#12\n" +
"");
                sb.append("An mang tren song Nile#028P#Agatha Christie#336#Trinh tham#NXB Tre#147.000#Nhung cau truyen ly ki hap dan#Giay#A4#Mem#\\\\\\\\#\\\\\\\\#22\n" +
"");
                sb.append("An mang tren chuyen tau toc hanh Phuong Dong#029P#Agatha Christie#306#Trinh Tham#NXb Tre#110.000#Nhung cau truyen ly ki hap dan#Giay#A4#Mem#\\\\\\\\#\\\\\\\\#2\n" +
"");
                sb.append("Giai thich ngu phap tieng Anh#030SP#M.L Huong;H.T Uyen#560#Giao duc#Da Nang#110.000#Sach danh cho viec on luyen ngu phap#pdf#\\\\\\\\#\\\\\\\\#mb#4.5#\\\\\\\\\n" +
"");
                sb.append("Giai thich ngu phap tieng Anh#031SE#M.L Huong;H.T Uyen#560#Giao duc#Da Nang#110.000#Sach danh cho viec on luyen ngu phap#epub#\\\\\\\\#\\\\\\\\#mb#4.2#\\\\\\\\\n" +
"");
                sb.append("Su im lang cua bay cuu#032SP#Thomas Harris#359#Trinh tham#Hoi Nha Van#74.000#Tieu thuyet trinh tham kinh di day hap dan#pdf#\\\\\\\\#\\\\\\\\#mb#2.2#\\\\\\\\\n" +
"");
                sb.append("Su im lang cua bay cuu#033SE#Thomas Harris#359#Trinh tham#Hoi Nha Van#72.000#Tieu thuyet trinh tham kinh di day hap dan#epub#\\\\\\\\#\\\\\\\\#mb#1.4#\\\\\\\\\n" +
"");
                sb.append("Nhan gui mot toi nguoi da yeu em#034SP#Otono Yomoji#235#Tinh cam#Ha Noi#84.000#Cau truyen tinh cam va noi buon#pdf#\\\\\\\\#\\\\\\\\#mb#3#\\\\\\\\\n" +
"");
                sb.append("Nhan gui mot toi nguoi da yeu em#034SP#Otono Yomoji#235#Tinh cam#Ha Noi#84.000#Cau truyen tinh cam va noi buon#pdf#\\\\\\\\#\\\\\\\\#mb#3#\\\\\\\\\n" +
"");
                sb.append("Nhan gui tat ca cac em nguoi toi da yeu#035SP#Otono Yomoji#235#Tinh cam#Ha Noi#84.000#Cau truyen tinh cam va noi buon#pdf#\\\\\\\\#\\\\\\\\#mb#3#\\\\\\\\\n" +
"");
                sb.append("5centimet tren giay#036SP#Shinkai Makotokai#188#Tinh cam#Ha Noi#25.000#Cau truyen tinh cam tuoi thanh xuan#pdf#\\\\\\\\#\\\\\\\\#mb#3.7#\\\\\\\\\n" +
"");
                sb.append("Thi va su phoi hop thi trong tieng Anh#037SP#M.L Huong; N.T.T Tam#183#Giao duc#Da Nang#30.000#Sach danh cho viec on luyen ngu phap#pdf#\\\\\\\\#\\\\\\\\#mb#2.8#\\\\\\\\\n" +
"");
                sb.append("Thi va su phoi hop thi trong tieng Anh#038SE#M.L Huong; N.T.T Tam#183#Giao duc#Da Nang#60.000#Sach danh cho viec on luyen ngu phap#epub#\\\\\\\\#\\\\\\\\#mb#2.4#\\\\\\\\\n" +
"");
                sb.append("Dong tu bat quy tac & ngu phap tieng Anh co ban#039SP#M.LHuong#200#Giao duc#Da Nang#20.000#Sach danh cho viec on luyen ngu phap#pdf#\\\\\\\\#\\\\\\\\#mb#2.4#\\\\\\\\\n" +
"");
                sb.append("Hieu ve trai tim#040SP#Minh Niem#480#Tam ly#TP.HCM#78.000#Hieu them ve tam ly cua ban than#pdf#\\\\\\\\#\\\\\\\\#mb#3.3#\\\\\\\\\n" +
"");
                sb.append("Atomic Habits#041SP#James Clear#200#Tam ly#NXB The Gioi#100.000#Hieu them ve tam ly cua ban than#pdf#\\\\\\\\#\\\\\\\\#mb#2.2#\\\\\\\\\n" +
"");
                sb.append("Atomic Habits#042SE#James Clear#200#Tam ly#NXB The Gioi#95.000#Hieu them ve tam ly cua ban than#epub#\\\\\\\\#\\\\\\\\#mb#2.2#\\\\\\\\\n" +
"");
                sb.append("Dam nghi lai#043SP#Adam Grant#336#Tam ly#NXB Dan Tri#65.000#Hieu them ve tam ly cua ban than#pdf#\\\\\\\\#\\\\\\\\#mb#1.4#\\\\\\\\\n" +
"");
                sb.append("Thay doi cuoc song than so hoc#044SP#L.D.Q Huong#240#Tam ly#NXB HaNoi#200.000#Hieu them ve tam ly cua ban than#pdf#\\\\\\\\#\\\\\\\\#mb#4.2#\\\\\\\\\n" +
"");
                sb.append("Toi thay hoa vang tren co xanh#045SP#Nguyen Nhat Anh#378#Truyen ngan#NXB Tre#40.000#Nhung cau truyen thu vi hap dan#pdf#\\\\\\\\#\\\\\\\\#mb#4.7#\\\\\\\\\n" +
"");
                sb.append("Toi thay hoa vang tren co xanh#046SE#Nguyen Nhat Anh#378#Truyen ngan#NXB Tre#80.000#Nhung cau truyen thu vi hap dan#epub#\\\\\\\\#\\\\\\\\#mb#4.4#\\\\\\\\\n" +
"");
                sb.append("Co hai con meo ngoi ben cua so#047SE#Nguyen Nhat Anh#210#Truyen ngan#NXB Tre#52.500#Nhung cau truyen thu vi hap dan#epub#\\\\\\\\#\\\\\\\\#mb#4.2#\\\\\\\\\n" +
"");
                sb.append("Mat biec#048SP#Nguyen Nhat Anh#300#Truyen ngan#NXB Tre#55.200#Nhung cau truyen thu vi hap dan#pdf#\\\\\\\\#\\\\\\\\#mb#4.7#\\\\\\\\\n" +
"");
                sb.append("Cho toi xin mot ve di tuoi tho#049SP#Nguyen Nhat Anh#208#Truyen ngan#NXB Tre#64.000#Nhung cau truyen thi vi hap dan#pdf#\\\\\\\\#\\\\\\\\#mb#2.2#\\\\\\\\\n" +
"");
                sb.append("Tuoi tre dang gia bao nhieu#050SP#Rosie Nguyen#283#Tam ly#Hoi Nha Vien#63.000#Hieu them ve tam ly cua ban than#pdf#\\\\\\\\#\\\\\\\\#mb#2.2#\\\\\\\\\n" +
"");
                sb.append("O quan ca phe cua tuoi tre lac loi#051SP#Patrick Modiano#153#Truyen ngan#NXB Van Hoc#27.000#Nhung cau truyen thi vi hap dan#pdf#\\\\\\\\#\\\\\\\\#mb#1.4#\\\\\\\\\n" +
"");
                sb.append("Vo nhat#052SP#Kim Lan#242#Truyen ngan#NXB Van Hoc#20.000#Nhung cau truyen thi vi hap dan#pdf#\\\\\\\\#\\\\\\\\#mb#1.4#\\\\\\\\\n" +
"");
                sb.append("Lap trinh ngon ngu C++#053SP#V.V Vu; P.T.T Hien#300#Giao duc#NXB KHKT#70.000#Lap trinh ngon ngu may tinh#pdf#\\\\\\\\#\\\\\\\\#mb#3.3#\\\\\\\\\n" +
"");
                sb.append("Lap trinh huong doi tuong#054SP#P.V At; L.T Thong#488#Giao duc#NXB BKHN#80.000#Lap trinh huong doi tuong#pdf#\\\\\\\\#\\\\\\\\#mb#4.4#\\\\\\\\\n" +
"");
                sb.append("Tra hoa nu#055SP#Alexandre Dumas#303#Tinh cam#Hoi Nha Van#50.000#nhung cau truyen tinh yeu lang man#pdf#\\\\\\\\#\\\\\\\\#mb#2.7#\\\\\\\\\n" +
"");
                sb.append("Rung Na Uy#056SP#Naruki Murakami#556#Tinh cam#Hoi Nha Van#110.000#nhung cau truyen tinh yeu lang man#pdf#\\\\\\\\#\\\\\\\\#mb#2.2#\\\\\\\\\n" +
"");
                sb.append("An mang tren song Nile#057SP#Agatha Christie#336#Trinh tham#NXB Tre#120.000#Nhung cau truyen ly ki hap dan#pdf#\\\\\\\\#\\\\\\\\#mb#4.7#\\\\\\\\\n" +
"");
                sb.append("An mang tren chuyen tau toc hanh Phuong Dong#058SP#Agatha Christie#306#Trinh Tham#NXb Tre#90.000#Nhung cau truyen ly ki hap dan#pdf#\\\\\\\\#\\\\\\\\#mb#4.8#\\\\\\\\\n" +
"");
                write.write(sb.toString());
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}