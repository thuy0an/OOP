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
			System.out.println("Tat ca don hang chua giao");
			System.out.println(
					"Ma don hang || Ma khach hang || Dia chi || Email || Ngay dat hang || PT thanh toan || Tong tien || Trang thai || DS san pham ");
			for (CT_DonHang donhang : dsDonHang) {
				if (donhang.getTrangThai() == 2)
					System.out.printf("%-6s || %-6s || %-50s || %-20s || %-10s || %-15s || %-7s || %-15s || %s",
							donhang.getMaDonHang(), donhang.getMaKH(), donhang.getDiaChi(), donhang.getEmail(),
							donhang.getNgayDH(), donhang.getPtThanhToan(), donhang.getTongTien(),
							donhang.getTrangThai(), donhang.getDsSanPham());
			}
			break;
		case 2:
			dsDonHang = docDonHangTuFile();
			System.out.println("Tat ca don hang dang giao");
			System.out.println(
					"Ma don hang || Ma khach hang || Dia chi || Email || Ngay dat hang || PT thanh toan || Tong tien || Trang thai || DS san pham ");
			for (CT_DonHang donhang : dsDonHang) {
				if (donhang.getTrangThai() == 3)
					System.out.printf("%-6s || %-6s || %-50s || %-20s || %-10s || %-15s || %-7s || %-15s || %s",
							donhang.getMaDonHang(), donhang.getMaKH(), donhang.getDiaChi(), donhang.getEmail(),
							donhang.getNgayDH(), donhang.getPtThanhToan(), donhang.getTongTien(),
							donhang.getTrangThai(), donhang.getDsSanPham());
			}
			break;
		case 3:
			dsDonHang = docDonHangTuFile();
			System.out.println("Tat ca don hang da nhan hang");
			System.out.println(
					"Ma don hang || Ma khach hang || Dia chi || Email || Ngay dat hang || PT thanh toan || Tong tien || Trang thai || DS san pham ");
			for (CT_DonHang donhang : dsDonHang) {
				if (donhang.getTrangThai() == 4)
					System.out.printf("%-6s || %-6s || %-50s || %-20s || %-10s || %-15s || %-7s || %-15s || %s",
							donhang.getMaDonHang(), donhang.getMaKH(), donhang.getDiaChi(), donhang.getEmail(),
							donhang.getNgayDH(), donhang.getPtThanhToan(), donhang.getTongTien(),
							donhang.getTrangThai(), donhang.getDsSanPham());
			}
			break;
		}
	}

	public void quanLyDonHang() {
		int luachon;
		Scanner input = new Scanner(System.in);
		ArrayList<CT_DonHang> dsDonHang;
		do {
			System.out.println("Menu quan ly giao hang");
			System.out.println("1.Xem cac don hang chua giao");
			System.out.println("2.Xem cac don hang dang giao");
			System.out.println("3.Xem cac don hang da nhan hang");
			System.out.println("0.Thoat menu quan ly giao hang");
			System.out.print("Nhap lua chon: ");
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
			ArrayList<CT_DonHang> dsDonHang=docDonHangTuFile();
			System.out.println("Nhap e de thoat xac nhan giao hang");
			System.out.println("Nhap ma don hang de xac nhan giao hang");
			System.out.println("Moi ban nhap: ");
			luachon=input.nextLine();
			if (luachon != "e") {
				int trangthai;
				do {
					System.out.println("Nhap 0 de quay lai");
					System.out.println("Nhap 1 de xac nhan giao hang");
					System.out.print("Moi nhap lua chon:");
					trangthai = Integer.parseInt(input.nextLine());
					
				} while (trangthai != 0 && trangthai != 1);
				maDon = luachon;
				for (CT_DonHang donhang : dsDonHang) {
					if (donhang.getMaDonHang() == maDon) {
						if (donhang.getTrangThai() == 2) {
							donhang.setTrangThai(3);
							ghiDonVaoFile(dsDonHang);
							System.out.println("Xac nhan giao hang thanh cong! ");
						} else
							System.out.println("Chi duoc xac nhan giao don hang co trang thai da xac han");
						// 1: đang xử lý; 2: đã xác nhận , 3: đang giao; 4: đã nhận hàng
					} else
						System.out.println("Khong tim thay don hang ");
				}
			}
		} while (luachon != "e");
	}
}
