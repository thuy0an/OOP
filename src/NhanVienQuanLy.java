import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class NhanVienQuanLy extends NhanVien {
	public NhanVienQuanLy() {
		super();
	}

	public void xemDonHang() {
		File file = new File("D:\\New folder\\OOP\\donhang.txt");
		ArrayList<DonHang> dsDonHang = new ArrayList<>();
		try (Scanner sc = new Scanner(file)) {
			while (sc.hasNextLine()) {
				String dong = sc.nextLine();
				String[] dulieu = dong.split("#");

			}
		} catch (FileNotFoundException e) {
			System.out.println("Khong the doc file: " + e.getMessage());
		}
		int luachon;
		String label = "Thong tin don hang ";
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("Nhap 1 de xem tat ca don hang\n");
			System.out.println("Nhap 2 de xem don hang chua xac nhan\n");
			System.out.println("Nhap 3 de xem don hang da xac nhan\n");
			System.out.println("Nhap 0 de thoat chuc nang xem don hang");
			luachon = Integer.parseInt(input.nextLine());
			switch (luachon) {
			case 0:
				break;
			case 1:
				System.out.println(label + ":");
				for (DonHang donHang : dsDonHang) {
					System.out.println(donHang.toString() + "\n");
				}
				break;
			case 2:
				System.out.println(label + "chua xac nhan:\n");
				for (DonHang donHang : dsDonHang) {
					if (donHang.trangThai == 0) {
						System.out.println(donHang.toString() + "\n");
					}
					break;
				}
			case 3:
				System.out.println(label + "da xac nhan");
				for (DonHang donHang : dsDonHang) {
					if (donHang.trangThai == 1) {
						System.out.println(donHang.toString() + "\n");
					}
				}
				break;
			default:
				System.out.println("Lua chon xem hang khong hop le!");
				break;
			}
		} while (luachon != 0);

	}

	public void xemDonHang(int luachon) {

		File file = new File("D:\\New folder\\OOP\\donhang.txt");
		ArrayList<DonHang> dsDonHang = new ArrayList<>();
		try (Scanner sc = new Scanner(file)) {
			while (sc.hasNextLine()) {
				String dong = sc.nextLine();
				String[] dulieu = dong.split("#");
			}
		} catch (FileNotFoundException e) {
			System.out.println("Khong the doc file: " + e.getMessage());
		}
		String label = "Thong tin cac don hang ";
		switch (luachon) {
		case 1:
			System.out.println(label + "chua xac nhan:\n");
			for (DonHang donHang : dsDonHang) {
				if (donHang.trangThai == 0) {
					System.out.println(donHang.toString() + "\n");
				}
			}
		case 2:
			System.out.println(label + "da xac nhan");
			for (DonHang donHang : dsDonHang) {
				if (donHang.trangThai == 1) {
					System.out.println(donHang.toString() + "\n");
				}
			}
		}

	}

	public void xacNhanDonHang() {
		File file = new File("D:\\New folder\\OOP\\donhang.txt");
		ArrayList<DonHang> dsDonHang = new ArrayList<>();
		try (Scanner sc = new Scanner(file)) {
			while (sc.hasNextLine()) {
				String dong = sc.nextLine();
				String[] dulieu = dong.split("#");
			}
		} catch (FileNotFoundException e) {
			System.out.println("Khong the doc file: " + e.getMessage());
		}
		xemDonHang(1);
		
	}
	public void themSach() {
		Scanner input =new Scanner(System.in);
	
		int soLuong;
		System.out.println("Nhap vao so luong sach can them: ");
		soLuong=Integer.parseInt(input.nextLine());
		for(int i=0;i<soLuong;i++) {
			try(FileWriter fileWriter=new FileWriter("Sach.txt",true)){
			StringBuilder sb=new StringBuilder();
			System.out.println("Nhap ten sach: ");
			sb.append(input.nextLine()).append("#");
			System.out.println("Nhap vao tac gia: ");
			sb.append(input.nextLine()).append("#");
			System.out.println("Nhap vao nha xuat ban: ");
			sb.append(input.nextLine()).append("#");
			System.out.println("Nhap vao gia sach");
			sb.append(input.nextLine()).append("#");
			System.out.println("Nhap vao mo ta sach:");
			sb.append(input.nextLine()).append("#");
			sb.append(System.lineSeparator());
			fileWriter.write(sb.toString());
			fileWriter.flush();
			}
			catch(IOException e) {
				System.err.println("Khong the ghi file: "+e.getMessage());
			}
		}
	}

}
