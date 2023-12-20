
import java.util.ArrayList;
import java.util.Scanner;

public class NhanVienGiaoHang extends NhanVien {
	public NhanVienGiaoHang() {
		super();
	}

	public NhanVienGiaoHang(String ma, String ten, Ngaythangnam ngayVao, String viTri, String loai, double ngayCong) {
		super(ma, ten, ngayVao, viTri, loai, ngayCong);

	}

	private String trangThai(int so) {
		if (so == 1)
			return "Đang xử lý";
		else if (so == 2)
			return "Đã xử lý";
		else if (so == 3)
			return "Đang giao hàng";
		else if (so == 4)
			return "Đã nhận hàng";
		return "";
	}

	@Override
	public void xemDonHang(int luachon) {
		DonHang temp = new DonHang();
		ArrayList<CT_DonHang> dsDonHang = temp.docDonHangTuFile();
		ArrayList<CT_DonHang> dsSanPham = temp.docCTDonHangTuFile("ctdonhang.txt");
		TuSach tusach = new TuSach();
		switch (luachon) {
		case 1:

			System.out.print("\n\n");
			System.out.println(
					"\n+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
			System.out.println(
					"|                                                                                               TẤT CẢ ĐƠN HÀNG                                                                                                                                                                              |");
			System.out.println(
					"|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
			System.out.printf("| %-15s || %-15s || %-20s || %-15s || %-15s || %-15s || %-15s || %-10s || %s\n",
					"Mã đơn", "Mã khách hàng", "Địa chỉ", "Email", "Ngày đặt hàng", "PT thanh toán", "Tổng tiền",
					"Trạng thái", "Danh sách sản phẩm");
			System.out.println(
					"|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
			for (CT_DonHang donhang : dsDonHang) {
				String sp = "";
				if (donhang.getTrangThai() == 2) {
					for (CT_DonHang sanpham : dsSanPham) {
						Sach sach = tusach.timSachTheoID(sanpham.getDsSanPham().getMaSach());
						sp += sach.getMaSach() + " x " + sach.getTenSach() + ";";
					}
					System.out.printf("| %-15s || %-15s || %-20s || %-15s || %-15s || %-15s || %-15s || %-10s || %s|\n",
							donhang.getMaDonHang(), donhang.getMaKH(), donhang.getDiaChi(), donhang.getEmail(),
							donhang.getNgayDH(), donhang.getPtThanhToan(), donhang.getTongTien(),
							trangThai(donhang.getTrangThai()), sp);
				}

			}
			System.out.println(
					"|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
			break;
		case 2:

			System.out.print("\n\n");
			System.out.println(
					"\n+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
			System.out.println(
					"|                                                                                               TẤT CẢ ĐƠN HÀNG                                                                                                                                                                              |");
			System.out.println(
					"|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
			System.out.printf("| %-15s || %-15s || %-20s || %-15s || %-15s || %-15s || %-15s || %-10s || %s\n",
					"Mã đơn", "Mã khách hàng", "Địa chỉ", "Email", "Ngày đặt hàng", "PT thanh toán", "Tổng tiền",
					"Trạng thái", "Danh sách sản phẩm");
			System.out.println(
					"|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
			for (CT_DonHang donhang : dsDonHang) {
				String sp = "";
				if (donhang.getTrangThai() == 3) {
					for (CT_DonHang sanpham : dsSanPham) {
						Sach sach = tusach.timSachTheoID(sanpham.getDsSanPham().getMaSach());
						sp += sach.getMaSach() + " x " + sach.getTenSach() + ";";
					}
					System.out.printf("| %-15s || %-15s || %-20s || %-15s || %-15s || %-15s || %-15s || %-10s || %s|\n",
							donhang.getMaDonHang(), donhang.getMaKH(), donhang.getDiaChi(), donhang.getEmail(),
							donhang.getNgayDH(), donhang.getPtThanhToan(), donhang.getTongTien(),
							trangThai(donhang.getTrangThai()), sp);
				}

			}
			System.out.println(
					"|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
			break;
		case 3:

			System.out.print("\n\n");
			System.out.println(
					"\n+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
			System.out.println(
					"|                                                                                               TẤT CẢ ĐƠN HÀNG                                                                                                                                                                              |");
			System.out.println(
					"|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
			System.out.printf("| %-15s || %-15s || %-20s || %-15s || %-15s || %-15s || %-15s || %-10s || %s\n",
					"Mã đơn", "Mã khách hàng", "Địa chỉ", "Email", "Ngày đặt hàng", "PT thanh toán", "Tổng tiền",
					"Trạng thái", "Danh sách sản phẩm");
			System.out.println(
					"|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
			for (CT_DonHang donhang : dsDonHang) {
				String sp = "";
				if (donhang.getTrangThai() == 4) {
					for (CT_DonHang sanpham : dsSanPham) {
						Sach sach = tusach.timSachTheoID(sanpham.getDsSanPham().getMaSach());
						sp += sach.getMaSach() + " x " + sach.getTenSach() + ";";
					}
					System.out.printf("| %-15s || %-15s || %-20s || %-15s || %-15s || %-15s || %-15s || %-10s || %s|\n",
							donhang.getMaDonHang(), donhang.getMaKH(), donhang.getDiaChi(), donhang.getEmail(),
							donhang.getNgayDH(), donhang.getPtThanhToan(), donhang.getTongTien(),
							trangThai(donhang.getTrangThai()), sp);
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
			System.out.println("\n\t+---------------------------------------------------+");
			System.out.println("\t|                  QUẢN LÝ GIAO HÀNG                |");
			System.out.println("\t|---------------------------------------------------|");
			System.out.printf("\t| %-50s|\n", "1.Xem thông tin nhân viên");
			System.out.printf("\t| %-50s|\n", "2.Xem các đơn chưa giao");
			System.out.printf("\t| %-50s|\n", "3.Xem các đơn đang giao");
			System.out.printf("\t| %-50s|\n", "4.Xem các đơn đã nhận hàng");
			System.out.printf("\t| %-50s|\n", "5.Xác nhận đơn đã giao xong");
			System.out.printf("\t| %-50s|\n", "0.Thoát");
			System.out.println("\t+---------------------------------------------------+");
			try {
				System.out.print("*Nhập lựa chọn: ");
				luachon = Integer.parseInt(input.nextLine());
				switch (luachon) {
				case 1:
					System.out.println(this.toString());
					tinhLuong();
					break;
				case 2:
					xemDonHang(1);
					break;
				case 3:
					xemDonHang(2);
					break;
				case 4:
					xemDonHang(3);
					break;
				case 5:
					xacNhanDonHang();
					break;

				}
				if (luachon < 0 || luachon > 5)
					System.out.println("--Vui lòng nhập đúng các chức năng--");
			} catch (NumberFormatException ei) {
				System.out.println("\n--Vui lòng chọn đúng các thao tác đã hiển thị!!!--\n");
				luachon = 1;
			}

		} while (luachon != 0);
	}

	@Override
	public String toString() {
		String loai = "";
		if (this.getLoai().equalsIgnoreCase("pt"))
			loai = "Làm PartTime";
		else
			loai = "Làm FullTime";
		return "\nMã Nhân Viên: " + this.getMa() + "\nTên Nhân Viên: " + this.getTen() + "\nNgày vào làm: "
				+ this.getNgayVao().toString() + "\n" + loai + "\nChức vụ: " + this.getViTri();

	}

	@Override
	public void xacNhanDonHang() {
		String luachon;
		String maDon = "";
		int chon = -1, flag = 0; // flag kiểm tra mã đơn có tồn tại hay ko
		Scanner input = new Scanner(System.in);
		do {
			DonHang temp = new DonHang();
			ArrayList<CT_DonHang> dsDonHang = temp.docDonHangTuFile();
			xemDonHang(2);
			System.out.println("\n\t+------------------------------------------------------+");
			System.out.println("\t|                     XÁC NHẬN ĐƠN HÀNG                |");
			System.out.println("\t|------------------------------------------------------|");
			System.out.println("\t| Nhập mã đơn để xác nhận đơn hàng                     |");
			System.out.println("\t| Nhập 0 để thoát chức năng xác nhận đơn hàng          |");
			System.out.println("\t+------------------------------------------------------+");
			System.out.print("Nhập mã đơn: ");
			luachon = input.nextLine();
			if (!luachon.equalsIgnoreCase("0")) {
				do {
					System.out.println("\n\t+------------------------------------------------------+");
					System.out.println("\t|                     XÁC NHẬN                         |");
					System.out.println("\t|------------------------------------------------------|");
					System.out.println("\t|1. Xác nhận đơn hàng của khách                        |");
					System.out.println("\t|0. Trở lại phần xác nhận đơn                          |");
					System.out.println("\t+------------------------------------------------------+");
					try {
						System.out.print("Nhập lựa chọn: ");
						chon = Integer.parseInt(input.nextLine());
						if (chon < 0 || chon > 1)
							System.out.println("Vui lòng nhập đúng các chức năng");
					}

					catch (NumberFormatException ei) {
						System.out.println("\n--Vui lòng chọn đúng các thao tác đã hiển thị!!!--\n");
						chon = 0;
					}

				} while (chon != 0 && chon != 1);

				if (chon == 1) {
					maDon = luachon;
					for (CT_DonHang donhang : dsDonHang) {
						if (donhang.getMaDonHang().equals(maDon)) {
							if (donhang.getTrangThai() == 2) {
								flag = 1;
								donhang.setTrangThai(4);
								ghiDonVaoFile(dsDonHang);
								System.out.println("*Xác nhận đơn hàng thành công! *");
							} else
								System.out.println("! Đơn hàng đã được xác nhận, không thể thay đổi trang thái !");
							// 1: đang xử lý; 2: đã xác nhận , 3: đang giao; 4: đã nhận hàng
						}
					}
				}
				if (flag != 1)
					System.out.println("Mã đơn hàng này không tồn tại");
			}
			luachon = "0";
		} while (luachon.equalsIgnoreCase("0") == false);

	}

}