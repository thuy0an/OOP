import java.util.ArrayList;
import java.util.Scanner;

public class NhanVienGiaoHang extends NhanVien {
	public NhanVienGiaoHang() {
		super();
	}

	public void xemDonHang(int luachon) {
		ArrayList<CT_DonHang> dsDonHang;
		switch (luachon) {
		case 1:
			dsDonHang = docDonHangTuFile();
			System.out.print("\n\n");
			System.out.println(
					"\n+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
			System.out.println(
					"|                                                                                               TAT CA DON HANG CHUA HANG                                                                                                                                                                    |");
			System.out.println(
					"|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
			System.out.println(
					"| Ma don hang ||  Ma khach hang  ||           Dia chi            ||         Email        ||  Ngay dat hang  ||  PT thanh toan  ||  Tong tien  ||  Trang thai  || DS san pham ");
			System.out.println(
					"|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
			for (CT_DonHang donhang : dsDonHang) {
				if (donhang.getTrangThai() == 2) {
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO: handle exception
					}
					System.out.printf("| %-11s || %-15s || %-28s || %-20s || %-15s || %-15s || %-11s || %-12s || %s\n",
							donhang.getMaDonHang(), donhang.getMaKH(), donhang.getDiaChi(), donhang.getEmail(),
							donhang.getNgayDH(), donhang.getPtThanhToan(), donhang.getTongTien(),
							donhang.getTrangThai(), donhang.getDsSanPham());

				}
			}
			System.out.println(
					"|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");

			break;
		case 2:
			dsDonHang = docDonHangTuFile();
			System.out.print("\n\n");
			System.out.println(
					"\n+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
			System.out.println(
					"|                                                                                               TAT CA DON HANG CHUA HANG                                                                                                                                                                    |");
			System.out.println(
					"|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
			System.out.println(
					"| Ma don hang ||  Ma khach hang  ||           Dia chi            ||         Email        ||  Ngay dat hang  ||  PT thanh toan  ||  Tong tien  ||  Trang thai  || DS san pham ");
			System.out.println(
					"|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
			for (CT_DonHang donhang : dsDonHang) {
				if (donhang.getTrangThai() == 3) {

					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO: handle exception
					}
					System.out.printf("| %-11s || %-15s || %-28s || %-20s || %-15s || %-15s || %-11s || %-12s || %s\n",
							donhang.getMaDonHang(), donhang.getMaKH(), donhang.getDiaChi(), donhang.getEmail(),
							donhang.getNgayDH(), donhang.getPtThanhToan(), donhang.getTongTien(),
							donhang.getTrangThai(), donhang.getDsSanPham());

				}
			}
			System.out.println(
					"|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");

			break;
		case 3:
			dsDonHang = docDonHangTuFile();
			System.out.print("\n\n");
			System.out.println(
					"\n+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
			System.out.println(
					"|                                                                                               TAT CA DON HANG CHUA HANG                                                                                                                                                                    |");
			System.out.println(
					"|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
			System.out.println(
					"| Ma don hang ||  Ma khach hang  ||           Dia chi            ||         Email        ||  Ngay dat hang  ||  PT thanh toan  ||  Tong tien  ||  Trang thai  || DS san pham ");
			System.out.println(
					"|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
			for (CT_DonHang donhang : dsDonHang) {
				if (donhang.getTrangThai() == 4) {
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO: handle exception
					}

					System.out.printf("| %-11s || %-15s || %-28s || %-20s || %-15s || %-15s || %-11s || %-12s || %s\n",
							donhang.getMaDonHang(), donhang.getMaKH(), donhang.getDiaChi(), donhang.getEmail(),
							donhang.getNgayDH(), donhang.getPtThanhToan(), donhang.getTongTien(),
							donhang.getTrangThai(), donhang.getDsSanPham());
				}
			}
			System.out.println(
					"|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");

			break;
		}
	}

	public void quanLyDonHang() {
		int luachon;
		Scanner input = new Scanner(System.in);
		ArrayList<CT_DonHang> dsDonHang;
		do {
			System.out.print("\n\n");
			System.out.println("\n+---------------------------------------------------+");
			System.out.println("|                  QUAN LY GIAO HANG                |");
			System.out.println("|---------------------------------------------------|");
			System.out.println("| Nhap 1 de xem cac don hang chua giao              |");
			System.out.println("| Nhap 2 de xem cac don hang dang giao              |");
			System.out.println("| Nhap 3 de xem cac don hang da nhan hang           |");
			System.out.println("| Nhap 0 de thoat menu quan ly giao hang            |");
			System.out.println("|---------------------------------------------------|");
			System.out.print("\n\n*Nhap lua chon: ");
			luachon = Integer.parseInt(input.nextLine());
			switch (luachon) {
			case 1:
				xemDonHang(1);
				break;
			case 2:
				xemDonHang(2);
				break;
			case 3:
				xemDonHang(3);
				break;
			default:
				break;
			}
		} while (luachon != 0);
	}

	public void xacNhanGiaoHang() {
		String luachon;
		String maDon;
		Scanner input = new Scanner(System.in);
		do {
			xemDonHang(1);
			ArrayList<CT_DonHang> dsDonHang = docDonHangTuFile();
			System.out.print("\n\n");
			System.out.println("\n+---------------------------------------------------+");
			System.out.println("|                 XAC NHAN GIAO HANG                |");
			System.out.println("|---------------------------------------------------|");
			System.out.println("| Nhap e de thoat xac nhan giao hang                |");
			System.out.println("| Nhap ma don hang de xac nhan giao hang            |");
			System.out.println("|---------------------------------------------------|");
			System.out.println("\n\n*Moi ban nhap: ");
			luachon = input.nextLine();
			if (luachon != "e") {
				int trangthai;
				do {
					System.out.print("\n\n");
					System.out.println("\n+---------------------------------------------------+");
					System.out.println("|                      XAC NHAN                     |");
					System.out.println("|---------------------------------------------------|");
					System.out.println("| Nhap 0 de quay lai                                |");
					System.out.println("Nhap 1 de xac nhan giao hang                        |");
					System.out.println("|---------------------------------------------------|");
					System.out.print("\n\n*Moi nhap lua chon:");
					trangthai = Integer.parseInt(input.nextLine());

				} while (trangthai != 0 && trangthai != 1);
				maDon = luachon;
				for (CT_DonHang donhang : dsDonHang) {
					if (donhang.getMaDonHang() == maDon) {
						if (donhang.getTrangThai() == 2) {
							donhang.setTrangThai(3);
							ghiDonVaoFile(dsDonHang);
							System.out.println("* Xac nhan giao hang thanh cong! * ");
						} else
							System.out.println("! Chi duoc xac nhan giao don hang co trang thai da xac nhan !");
						// 1: đang xử lý; 2: đã xác nhận , 3: đang giao; 4: đã nhận hàng
					} else
						System.out.println("? Khong tim thay don hang ?");
				}
			}
		} while (luachon != "e");
	}

}
