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

	public void quanLySach() {
		TuSach tuSach = new TuSach();
		int luachon;
		do {
			System.out.println("Menu quan ly sach:");
			System.out.println("1.Hien thi thong tin tat ca sach");
			System.out.println("2.Hien thong tin sach con kinh doanh");
			System.out.println("3.Tim sach theo thong tin");
			System.out.println("4.Chinh sua thong tin sach");
			System.out.println("5.Them Sach");
			System.out.println("0.Thoat quan ly sach");
			System.out.print("Nhap lua chon");
			luachon = Integer.parseInt(input.nextLine());
			switch (luachon) {
			case 0:
				break;
			case 1:
				tuSach.hienThongTinSach();
				break;
			case 2:
				tuSach.hienThiSachDangKinhDoanh();
				break;
			case 3:
				tuSach.timSach();
				break;
			case 4:
				tuSach.chinhSuaThongTinSach();
				break;
			case 5:
				tuSach.themSach();
				break;
			default:
				System.out.println("Lua chon khong nam trong menu, vui long nhap lai");
				break;
			}
		} while (luachon != 0);
	}

	public void quanLyDonHang() {
		int luachon;
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("Menu quan ly don hang");
			System.out.println("1.Xem tat ca don hang");
			System.out.println("2.Xem don hang chua xac nhan");
			System.out.println("3.Xem don hang da xac nhan");
			System.out.println("4.Xem don hang da tu choi");
			System.out.println("5.Xac nhan don hang");
			System.out.println("0.Thoat quan ly don hang");
			System.out.print("Nhap lua chon: ");
			luachon = Integer.parseInt(input.nextLine());
			switch (luachon) {
			case 0:
				break;
			case 1:
				xemDonHang(1);
				break;
			case 2:
				xemDonHang(2);
				break;
			case 3:
				xemDonHang(3);
			case 4:
				xemDonHang(4);

			}
		} while (luachon != 0);
	}

	@Override
	public void xemDonHang(int luachon) {
		File file = new File("donhang.txt");
		try (Scanner scanner = new Scanner(file)) {

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] donHangFile = line.split("#");
				String maDonHang = donHangFile[0];
				String maKhachHang = donHangFile[1];
				String diaChi = donHangFile[2];
				String email = donHangFile[3];
				String ngayDH = donHangFile[4];
				String ptThanhToan = donHangFile[5];
				String tongTien = donHangFile[6];
				String trangThai = "";
				if (donHangFile[7] == "0")
					trangThai = "Chua xu ly";
				else if (donHangFile[7] == "1")
					trangThai = "Da xac nhan";
				else if (donHangFile[7] == "2")
					trangThai = "Da tu choi";

				String dsSanPham = donHangFile[8];
				switch (luachon) {
				case 1:
					System.out.println("Tat ca don hang");
					System.out.println(
							"Ma don hang || Ma khach hang || Dia chi || Email || Ngay dat hang || PT thanh toan || Tong tien || Trang thai || DS san pham ");
					System.out.printf("%-6s || %-6s || %-50s || %-20s || %-10s || %-15s || %-7s || %-15s || %s",
							maDonHang, maKhachHang, diaChi, email, ngayDH, ptThanhToan, tongTien, trangThai, dsSanPham);
					break;
				case 2:
					if (donHangFile[7] == "0") {
						System.out.println("Tat ca don hang chua xac nhan");
						System.out.println(
								"Ma don hang || Ma khach hang || Dia chi || Email || Ngay dat hang || PT thanh toan || Tong tien || Trang thai || DS san pham ");
						System.out.printf("%-6s || %-6s || %-50s || %-20s || %-10s || %-15s || %-7s || %-15s || %s");

					}
					break;

				case 3:
					if (donHangFile[7] == "1") {
						System.out.println("Tat ca don hang da xac nhan");
						System.out.println(
								"Ma don hang || Ma khach hang || Dia chi || Email || Ngay dat hang || PT thanh toan || Tong tien || Trang thai || DS san pham ");
						System.out.printf("%-6s || %-6s || %-50s || %-20s || %-10s || %-15s || %-7s || %-15s || %s");

					}
					break;
				case 4:
					if (donHangFile[7] == "2") {
						System.out.println("Tat ca don hang da tu choi");
						System.out.println(
								"Ma don hang || Ma khach hang || Dia chi || Email || Ngay dat hang || PT thanh toan || Tong tien || Trang thai || DS san pham ");
						System.out.printf("%-6s || %-6s || %-50s || %-20s || %-10s || %-15s || %-7s || %-15s || %s");

					}
					break;
				default:
					break;
				}

			}
		} catch (FileNotFoundException e) {
			System.out.println("Khong tim duoc file: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Da co loi xay ra: " + e.getMessage());
		}
	}

	@Override
	public void xacNhanDonHang() {

		String luachon = "";
		String maDon = "";
		Scanner input = new Scanner(System.in);
		do {
			ArrayList<DonHang> dsDonHang = docDonHangTuFile();
			xemDonHang(2);
			System.out.println("Nhap e de thoat chuc nang xac nhan don hang");
			System.out.println("Nhap ma so don hang de xac nhan");
			System.out.print("Moi ban nhap:");
			luachon = input.nextLine();
			if (luachon != "e") {
				System.out.println("Nhap 0 de tu choi don hang");
				System.out.println("Nhap 1 de xac nhan don hang");
				System.out.print("Moi nhap lua chon");
				int trangthai = Integer.parseInt(input.nextLine());
				maDon = luachon;
				for (DonHang donhang : dsDonHang) {
					if (donhang.getMaDonHang() == maDon) {
						if (donhang.getTrangThai() == 0) {
							donhang.setTrangThai(trangthai);
							ghiDonVaoFile(dsDonHang);
							System.out.println("Xac nhan don hang thanh cong! ");
						} else
							System.out.println("Don hang da duoc xac nhan, khong the thay doi trang thai");

					} else
						System.out.println("Khong tim thay don hang ");
				}

			}

		} while (luachon != "e");

	}

	public ArrayList<DonHang> docDonHangTuFile() {
		File file = new File("donhang.txt");
		ArrayList<DonHang> dsDonHang = new ArrayList<>();
		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] donHangFile = line.split("#");
				String maDonHang = donHangFile[0];
				String maKhachHang = donHangFile[1];
				String diaChi = donHangFile[2];
				String email = donHangFile[3];
				String ngayDH = donHangFile[4];
				String ptThanhToan = donHangFile[5];
				String tongTien = donHangFile[6];
				String trangThai = donHangFile[7];
				String[] dsSanPhamString = donHangFile[8].split(";");
				ArrayList<Sach> dsSanPham = new ArrayList<>();
				for (String dulieuSach : dsSanPhamString) {
					String[] temp = dulieuSach.split("x");
					Sach sach = new Sach(temp[0], Integer.parseInt(temp[1]));
					dsSanPham.add(sach);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Khong tim duoc file: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Da co loi xay ra: " + e.getMessage());
		}
		return dsDonHang;
	}

	@Override
	public void ghiDonVaoFile(ArrayList<DonHang> dsDonHang) {
		String fileName = "Donhang.txt";
		File file = new File(fileName);

		try (FileWriter fileWriter = new FileWriter(file, true)) {
			for (DonHang donhang : dsDonHang) {
				StringBuilder sb = new StringBuilder();
				sb.append(donhang.getMaDonHang()).append("#");
				sb.append(donhang.getMaKhachHang()).append("#");
				sb.append(donhang.getDiaChi()).append("#");
				sb.append(donhang.getEmail()).append("#");
				sb.append(donhang.getNgayDH()).append("#");
				sb.append(donhang.getPTThanhToan()).append("#");
				sb.append(donhang.getTongTien()).append("#");
				sb.append(donhang.getTrangThai()).append("#");
				ArrayList<Sach> dsSanPham = donhang.getDsSanPham();
				for (Sach sach : dsSanPham) {
					sb.append(sach.getTenSach()).append(" x");
					sb.append(sach.getSoLuongMua()).append(";");
				}
				sb.append("#").append(System.lineSeparator());

				fileWriter.write(sb.toString());
			}
			fileWriter.flush();
			System.out.println("Viet sach vao file thanh cong.....");
		} catch (IOException e) {
			System.out.println("Khong hop le" + e.getMessage());
		}
	}

	public void quanLy() {
		Scanner input = new Scanner(System.in);
		int luachon;
		System.out.println("Menu thao tac nhan vien");
		do {
			System.out.println("1.Quan ly don hang");
			System.out.println("2.Quan ly sach");
			System.out.println("0.Thoat menu thao tac");
			System.out.print("Nhap lua chon cua ban:");
			luachon = Integer.parseInt(input.nextLine());
			switch (luachon) {
			case 1:
				quanLyDonHang();
				break;
			case 2:
				quanLySach();
				break;
			default:
				break;
			}
		} while (luachon != 0);
	}

}
