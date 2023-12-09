import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NhanVienQuanLy extends NhanVien {
	public NhanVienQuanLy() {
		super();
	}
	public NhanVienQuanLy(String ma, String ten, Ngaythangnam ngayVao, String viTri, String loai,double ngayCong) {
		super(ma, ten, ngayVao, viTri, loai,ngayCong) ;
			
	}
	public void quanLySach() {
		TuSach tuSach = new TuSach();
		Scanner input = new Scanner(System.in);
		int luachon;
		do {
			System.out.print("\n\n");
			System.out.println("\n+---------------------------------------------------+");
			System.out.println("|                     QUAN LY SACH                  |");
			System.out.println("|---------------------------------------------------|");
			System.out.println("| Nhap 1 de hien thong tin sach con kinh doanh      |");
			System.out.println("| Nhap 2 de tim sach theo thong tin                 |");
			System.out.println("| Nhap 3 de chinh sua thong tin sach                |");
			System.out.println("| Nhap 4 de them sach                               |");
			System.out.println("| Nhap 0 de thoat quan ly sach                      |");
			System.out.println("+---------------------------------------------------+");
			System.out.print("\n\n*Nhap lua chon:");
			luachon = Integer.parseInt(input.nextLine());

			switch (luachon) {
			case 0:
				break;
			case 1:
				tuSach.hienThiSachDangKinhDoanh();
				input.nextLine();
				break;
			case 2:
				tuSach.timSach();
				input.nextLine();
				break;
			case 3:
				tuSach.chinhSuaThongTinSach();
				input.nextLine();
				break;
			case 4:
				tuSach.themSach();
				input.nextLine();
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
			System.out.print("\n\n");
			System.out.println("\n+---------------------------------------------------+");
			System.out.println("|                   QUAN LY DON HANG                |");
			System.out.println("|---------------------------------------------------|");
			System.out.println("| Nhap 1 de xem tat ca don hang                     |");
			System.out.println("| Nhap 2 de xem don hang chua xac nhan              |");
			System.out.println("| Nhap 3 de xem don hang da xac nhan                |");
			System.out.println("| Nhap 4 de xac nhan don hang                       |");
			System.out.println("| Nhap 0 de thoat quan ly don hang                  |");
			System.out.println("+---------------------------------------------------+");
			System.out.print("\n\n*Nhap lua chon: ");
			luachon = Integer.parseInt(input.nextLine());
			switch (luachon) {
			case 0:
				break;
			case 1:
				xemDonHang(1);
				input.nextLine();
				break;
			case 2:
				xemDonHang(2);
				input.nextLine();
				break;
			case 3:
				xemDonHang(3);
				input.nextLine();
				break;
			case 4:
				xacNhanDonHang();
				input.nextLine();
				break;
			}
		} while (luachon != 0);
	}

	@Override
	public void xemDonHang(int luachon) {
		ArrayList<CT_DonHang> dsDonHang = docDonHangTuFile();
		switch (luachon) {
		case 1:
			System.out.print("\n\n");
			System.out.println(
					"\n+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
			System.out.println(
					"|                                                                                               TAT CA DON HANG                                                                                                                                                                              |");
			System.out.println(
					"|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
			System.out.println(
					"| Ma don hang ||  Ma khach hang  ||           Dia chi            ||         Email        ||  Ngay dat hang  ||  PT thanh toan  ||  Tong tien  ||  Trang thai  || DS san pham ");
			System.out.println(
					"|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
			for (CT_DonHang donhang : dsDonHang) {
				System.out.printf("| %-11s || %-15s || %-28s || %-20s || %-15s || %-15s || %-11s || %-12s || %s\n",
						donhang.getMaDonHang(), donhang.getMaKH(), donhang.getDiaChi(), donhang.getEmail(),
						donhang.getNgayDH(), donhang.getPtThanhToan(), donhang.getTongTien(), donhang.getTrangThai(),
						donhang.getDsSanPham());
				try {
					Thread.sleep(150);
				} catch (InterruptedException e) {
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
					"|                                                                                               TAT CA DON HANG                                                                                                                                                                              |");
			System.out.println(
					"|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
			System.out.println(
					"| Ma don hang ||  Ma khach hang  ||           Dia chi            ||         Email        ||  Ngay dat hang  ||  PT thanh toan  ||  Tong tien  ||  Trang thai  || DS san pham ");
			System.out.println(
					"|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
			for (CT_DonHang donhang : dsDonHang) {
				if (donhang.getTrangThai() == 1)
					System.out.printf("| %-11s || %-15s || %-28s || %-20s || %-15s || %-15s || %-11s || %-12s || %s\n",
							donhang.getMaDonHang(), donhang.getMaKH(), donhang.getDiaChi(), donhang.getEmail(),
							donhang.getNgayDH(), donhang.getPtThanhToan(), donhang.getTongTien(),
							donhang.getTrangThai(), donhang.getDsSanPham());
				try {
					Thread.sleep(150);
				} catch (InterruptedException e) {
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
					"|                                                                                               TAT CA DON HANG                                                                                                                                                                              |");
			System.out.println(
					"|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
			System.out.println(
					"| Ma don hang ||  Ma khach hang  ||           Dia chi            ||         Email        ||  Ngay dat hang  ||  PT thanh toan  ||  Tong tien  ||  Trang thai  || DS san pham ");
			System.out.println(
					"|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
			for (CT_DonHang donhang : dsDonHang) {
				if (donhang.getTrangThai() > 1)
					System.out.printf("| %-11s || %-15s || %-28s || %-20s || %-15s || %-15s || %-11s || %-12s || %s\n",

							donhang.getMaDonHang(), donhang.getMaKH(), donhang.getDiaChi(), donhang.getEmail(),
							donhang.getNgayDH(), donhang.getPtThanhToan(), donhang.getTongTien(),
							donhang.getTrangThai(), donhang.getDsSanPham());
				try {
					Thread.sleep(150);
				} catch (InterruptedException e) {
				}
			}
			System.out.println(
					"|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
	
			break;

		default:
			break;
		}

	}

	@Override
	public void xacNhanDonHang() {

		String luachon;
		String maDon = "";
		Scanner input = new Scanner(System.in);
		do {
			ArrayList<CT_DonHang> dsDonHang = docDonHangTuFile();
			xemDonHang(2);
			System.out.print("\n\n");
			System.out.println("\n+------------------------------------------------------+");
			System.out.println("|                     XAC NHAN DON HANG                |");
			System.out.println("|------------------------------------------------------|");
			System.out.println("| Nhap e de thoat chuc nang xac nhan don hang          |");
			System.out.println("| Nhap ma so don hang de xac nhan                      |");
			System.out.println("+------------------------------------------------------+");
			System.out.print("\n\n*Moi ban nhap:");
			luachon = input.nextLine();
			if (!luachon.equalsIgnoreCase("e")) {
				int trangthai;
				do {
					System.out.println("\n+------------------------------------------------------+");
					System.out.println("|                     XAC NHAN                         |");
					System.out.println("|------------------------------------------------------|");
					System.out.println("| Nhap 0 de tro lai                                    |");
					System.out.println("| Nhap 1 de xac nhan don hang                          |");
					System.out.println("+------------------------------------------------------+");
					System.out.print("\n\n*Moi nhap lua chon");
					trangthai = Integer.parseInt(input.nextLine());
				} while (trangthai != 0 && trangthai != 1);
				if (trangthai != 0) {
					maDon = luachon;
					for (CT_DonHang donhang : dsDonHang) {
						System.out.printf("\n\n%s %s\n\n", donhang.getMaDonHang(), maDon);
						if (donhang.getMaDonHang().equals(maDon)) {
							if (donhang.getTrangThai() == 1) {
								donhang.setTrangThai(2);
								ghiDonVaoFile(dsDonHang);
								System.out.println("*Xac nhan don hang thanh cong! *");
							} else
								System.out.println("! Don hang da duoc xac nhan, khong the thay doi trang thai !");
							// 1: đang xử lý; 2: đã xác nhận , 3: đang giao; 4: đã nhận hàng
						} else
							System.out.println("? Khong tim thay don hang ?");
					}
				}
			}

		} while (luachon.equalsIgnoreCase("e") == false);

	}

	public void thongKeTheoLoai() {
		Scanner input = new Scanner(System.in);
		double tongDoanhThu = 0;
		ArrayList<CT_DonHang> dsDonHang = docDonHangTuFile();
		Map<String, double[]> thongKeTheLoai = new HashMap<>();
		ArrayList<String> dsSach = new ArrayList<>();
		for (CT_DonHang donhang : dsDonHang) {
			String[] dulieuSach = donhang.getDsSanPham().split(";");
			for (String dsSanPham : dulieuSach) {
				dsSach.add(dsSanPham);
			}
		}
		for (String dulieuSach : dsSach) {
			TuSach tusach = new TuSach();
			String[] thongtin = dulieuSach.split(" x ");
			int soLuong = Integer.parseInt(thongtin[2].trim());
			String maSach = thongtin[1].trim();
			if (tusach.timSachTheoID(maSach) != null) {
				Sach sach = new Sach(tusach.timSachTheoID(maSach));
				tongDoanhThu += soLuong * sach.getgia();
				if (thongKeTheLoai.containsKey(sach.getLoaiSach())) {
					double[] dulieu = thongKeTheLoai.get(sach.getLoaiSach());
					dulieu[0] += soLuong;
					dulieu[1] += soLuong * sach.getgia();
					thongKeTheLoai.put(sach.getLoaiSach(), dulieu);
				} else {
					double[] dulieu = new double[2];
					dulieu[0] = soLuong;
					dulieu[1] = soLuong * sach.getgia();
					thongKeTheLoai.put(sach.getLoaiSach(), dulieu);
				}
			}
		}
		System.out.println("\n+-------------------------------------------+");
		System.out.println("|            THONG KE LOAI SACH             |");
		System.out.println("| Loai Sach || So luong ban ra || Doanh Thu |");
		
		for (Map.Entry<String, double[]> set : thongKeTheLoai.entrySet()) {
			String loaiSach = set.getKey();
			double[] dulieu = set.getValue();
			System.out.printf("| %-9s || %-15s || %-10s|\n",loaiSach,Double.toString(dulieu[0]),Double.toString(dulieu[1]));
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
			}
		}
		System.out.println("*-------------------------------------------*");
		System.out.printf("|Tong doanh thu: %-27s|\n", Double.toString(tongDoanhThu));
		System.out.println("+-------------------------------------------+");
	}

	public void thongKeTheoTheLoai() {
		Scanner input = new Scanner(System.in);
		double tongDoanhThu = 0;
		ArrayList<CT_DonHang> dsDonHang = docDonHangTuFile();
		Map<String, double[]> thongKeTheLoai = new HashMap<>();
		ArrayList<String> dsSach = new ArrayList<>();
		for (CT_DonHang donhang : dsDonHang) {
			String[] dulieuSach = donhang.getDsSanPham().split(";");
			for (String dsSanPham : dulieuSach) {
				dsSach.add(dsSanPham);
			}
		}

		for (String dulieuSach : dsSach) {
			TuSach tusach = new TuSach();
			String[] thongtin = dulieuSach.split(" x ");
			int soLuong = Integer.parseInt(thongtin[2].trim());
			String maSach = thongtin[1].trim();
			if (tusach.timSachTheoID(maSach) != null) {
				Sach sach = new Sach(tusach.timSachTheoID(maSach));
				System.out.println(sach.getgia());
				tongDoanhThu += soLuong * sach.getgia();
				if (thongKeTheLoai.containsKey(sach.getTheLoai())) {
					double[] dulieu = thongKeTheLoai.get(sach.getTheLoai());
					dulieu[0] += soLuong;
					dulieu[1] += soLuong * sach.getgia();
					thongKeTheLoai.put(sach.getTheLoai(), dulieu);
				} else {
					double[] dulieu = new double[2];
					dulieu[0] = soLuong;
					dulieu[1] = soLuong * sach.getgia();
					thongKeTheLoai.put(sach.getTheLoai(), dulieu);
				}
			}
		}System.out.println("\n+------------------------------------------------+");
		System.out.println("|                THONG KE THE LOAI               |");
		System.out.println("|    The Loai    || So luong ban ra || Doanh Thu |");
		for (Map.Entry<String, double[]> set : thongKeTheLoai.entrySet()) {
			String theLoai = set.getKey();
			double[] dulieu = set.getValue();
			System.out.printf("| %-14s || %-15s || %-10s|\n",theLoai,Double.toString(dulieu[0]),Double.toString(dulieu[1]));

			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
			}
		}
		System.out.println("*------------------------------------------------*");
		System.out.printf("| Tong doanh thu: %-31s|\n", Double.toString(tongDoanhThu));
		System.out.println("+------------------------------------------------+");
	}

	public void thongKeTatCaSach() {
		Scanner input = new Scanner(System.in);
		double tongDoanhThu = 0;
		ArrayList<CT_DonHang> dsDonHang = docDonHangTuFile();
		Map<String, double[]> thongKeTheLoai = new HashMap<>();
		ArrayList<String> dsSach = new ArrayList<>();
		for (CT_DonHang donhang : dsDonHang) {
			String[] dulieuSach = donhang.getDsSanPham().split(";");
			for (String dsSanPham : dulieuSach) {
				dsSach.add(dsSanPham);
			}
		}

		for (String dulieuSach : dsSach) {
			TuSach tusach = new TuSach();
			String[] thongtin = dulieuSach.split(" x ");
			int soLuong = Integer.parseInt(thongtin[2].trim());
			String maSach = thongtin[1].trim();
			if (tusach.timSachTheoID(maSach) != null) {
				Sach sach = new Sach(tusach.timSachTheoID(maSach));
				System.out.println(sach.getgia());
				tongDoanhThu += soLuong * sach.getgia();
				if (thongKeTheLoai.containsKey(sach.getMaSach())) {
					double[] dulieu = thongKeTheLoai.get(sach.getMaSach());
					dulieu[0] += soLuong;
					dulieu[1] += soLuong * sach.getgia();
					thongKeTheLoai.put(sach.getMaSach(), dulieu);
				} else {
					double[] dulieu = new double[2];
					dulieu[0] = soLuong;
					dulieu[1] = soLuong * sach.getgia();
					thongKeTheLoai.put(sach.getMaSach(), dulieu);
				}
			}
		}
		System.out.println("\n+-------------------------------------------+");
		System.out.println("|            THONG KE TAT CA SACH           |");
		System.out.println("|  Ma Sach  || So luong ban ra || Doanh Thu |");
		System.out.println("|-------------------------------------------|");
		for (Map.Entry<String, double[]> set : thongKeTheLoai.entrySet()) {
			String maSach = set.getKey();
			double[] dulieu = set.getValue();
			System.out.printf("| %-9s || %-15s || %-10s|\n",maSach,Double.toString(dulieu[0]),Double.toString(dulieu[1]));
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
			}
		}
		System.out.println("*-------------------------------------------*");
		System.out.printf("| Tong doanh thu: %-26s|\n", Double.toString(tongDoanhThu));
		System.out.println("+-------------------------------------------+");
	}

	public void thongKeTheoKhoangTG() {

		Scanner input = new Scanner(System.in);
		double tongDoanhThu = 0;
		ArrayList<CT_DonHang> dsDonHang = docDonHangTuFile();
		Map<String, double[]> thongKeTheoTG = new HashMap<>();
		ArrayList<String> dsSach = new ArrayList<>();
		boolean[] matches = new boolean[3];
		matches[0] = matches[1] = true;
		matches[2] = false;
		String ngaybatdau;
		String ngayketthuc;
		String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
		Pattern pattern = Pattern.compile(regex);
		do {
			if (matches[0] == false || matches[1] == false)
				System.out.println("Vui long nhap dung dinh dang dd/mm/yyyy!");
			System.out.println("Nhap khoang thoi gian bat dau thong ke (nhap e de bo qua thoi gian bat dau): ");
			ngaybatdau = input.nextLine();
			System.out.println("Nhap khoang thoi gian ket thuc thong ke (nhap e de bo qua thoi gian ket thuc: ");
			ngayketthuc = input.nextLine();
			//
			if (ngaybatdau.equalsIgnoreCase("e") && ngayketthuc.equalsIgnoreCase("e")) {
				matches[2] = true;
			} else if (ngaybatdau.equalsIgnoreCase("e") == false && ngayketthuc.equalsIgnoreCase("e") == false) {
				matches[0] = pattern.matcher(ngaybatdau).matches();
				matches[1] = pattern.matcher(ngayketthuc).matches();
			} else if (ngaybatdau.equalsIgnoreCase("e") == false && ngayketthuc.equalsIgnoreCase("e") == true) {
				matches[0] = pattern.matcher(ngaybatdau).matches();
			} else if (ngaybatdau.equalsIgnoreCase("e") == true && ngayketthuc.equalsIgnoreCase("e") == false) {
				matches[1] = pattern.matcher(ngayketthuc).matches();
			}

		} while (matches[0] == false || matches[1] == false);
		if (matches[2]) {
			thongKeTatCaSach();
		} else if (ngaybatdau.equalsIgnoreCase("e") == true && ngayketthuc.equalsIgnoreCase("e") == false) {
			for (CT_DonHang donhang : dsDonHang) {
				Ngaythangnam tgDH = new Ngaythangnam(donhang.getNgayDH());

				Ngaythangnam tgSoSanh = new Ngaythangnam(ngayketthuc);

				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
				if (tgSoSanh.getNam() > tgDH.getNam()) {
					if (thongKeTheoTG.containsKey(donhang.getNgayDH())) {
						double[] dulieu = thongKeTheoTG.get(donhang.getNgayDH());
						dulieu[0] += 1;
						dulieu[1] += donhang.getTongTien();
						tongDoanhThu += dulieu[1];
						thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
					} else {
						double[] dulieu = new double[2];
						dulieu[0] = 1;
						dulieu[1] = donhang.getTongTien();
						tongDoanhThu += dulieu[1];
						thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
					}
				} else if (tgSoSanh.getNam() == tgDH.getNam()) {
					if (tgSoSanh.getThang() > tgDH.getThang()) {
						if (thongKeTheoTG.containsKey(donhang.getNgayDH())) {
							double[] dulieu = thongKeTheoTG.get(donhang.getNgayDH());
							dulieu[0] += 1;
							dulieu[1] += donhang.getTongTien();
							tongDoanhThu += dulieu[1];
							thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
						} else {
							double[] dulieu = new double[2];
							dulieu[0] = 1;
							dulieu[1] = donhang.getTongTien();
							tongDoanhThu += dulieu[1];
							thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
						}
					} else if (tgSoSanh.getThang() == tgDH.getThang()) {
						if (tgSoSanh.getNgay() >= tgDH.getNgay()) {
							if (thongKeTheoTG.containsKey(donhang.getNgayDH())) {
								double[] dulieu = thongKeTheoTG.get(donhang.getNgayDH());
								dulieu[0] += 1;
								dulieu[1] += donhang.getTongTien();
								tongDoanhThu += dulieu[1];
								thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
							} else {
								double[] dulieu = new double[2];
								dulieu[0] = 1;
								dulieu[1] = donhang.getTongTien();
								tongDoanhThu += dulieu[1];
								thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
							}
						}
					}
				}
			}
			System.out.println("\n+--------------------------------------------+");
			System.out.println("|            THONG KE THEO TG                |");
			System.out.println("|  Ngay DH  || So luong ban ra || Doanh Thu  |");
			System.out.println("|--------------------------------------------|");
		
			for (Map.Entry<String, double[]> set : thongKeTheoTG.entrySet()) {
				String ngayDH = set.getKey();
				double[] dulieu = set.getValue();
				System.out.printf("| %-10s || %-15s || %-10s|\n",ngayDH,Double.toString(dulieu[0]),Double.toString(dulieu[1]));
				try {
					Thread.sleep(150);
				} catch (InterruptedException e) {
				}
			}
		
			System.out.println("*--------------------------------------------*");
			System.out.printf("| Tong doanh thu: %-27s|\n", Double.toString(tongDoanhThu));
			System.out.println("+--------------------------------------------+");
		} else if (ngaybatdau.equalsIgnoreCase("e") == false && ngayketthuc.equalsIgnoreCase("e") == true) {
			for (CT_DonHang donhang : dsDonHang) {
				Ngaythangnam tgDH = new Ngaythangnam(donhang.getNgayDH());
				Ngaythangnam tgSoSanh = new Ngaythangnam(ngaybatdau);
				if (tgSoSanh.getNam() < tgDH.getNam()) {
					if (thongKeTheoTG.containsKey(donhang.getNgayDH())) {
						double[] dulieu = thongKeTheoTG.get(donhang.getNgayDH());
						dulieu[0] += 1;
						dulieu[1] += donhang.getTongTien();
						tongDoanhThu += dulieu[1];
						thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
					} else {
						double[] dulieu = new double[2];
						dulieu[0] = 1;
						dulieu[1] = donhang.getTongTien();
						tongDoanhThu += dulieu[1];
						thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
					}
				} else if (tgSoSanh.getNam() == tgDH.getNam()) {
					if (tgSoSanh.getThang() < tgDH.getThang()) {
						if (thongKeTheoTG.containsKey(donhang.getNgayDH())) {
							double[] dulieu = thongKeTheoTG.get(donhang.getNgayDH());
							dulieu[0] += 1;
							dulieu[1] += donhang.getTongTien();
							tongDoanhThu += dulieu[1];
							thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
						} else {
							double[] dulieu = new double[2];
							dulieu[0] = 1;
							dulieu[1] = donhang.getTongTien();
							tongDoanhThu += dulieu[1];
							thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
						}
					} else if (tgSoSanh.getThang() == tgDH.getThang()) {
						if (tgSoSanh.getNgay() <= tgDH.getNgay()) {
							if (thongKeTheoTG.containsKey(donhang.getNgayDH())) {
								double[] dulieu = thongKeTheoTG.get(donhang.getNgayDH());
								dulieu[0] += 1;
								dulieu[1] += donhang.getTongTien();
								tongDoanhThu += dulieu[1];
								thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
							} else {
								double[] dulieu = new double[2];
								dulieu[0] = 1;
								dulieu[1] = donhang.getTongTien();
								tongDoanhThu += dulieu[1];
								thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
							}
						}
					}
				}
			}
			System.out.println("\n+--------------------------------------------+");
			System.out.println("|            THONG KE THEO TG                |");
			System.out.println("|  Ngay DH  || So luong ban ra || Doanh Thu  |");
			System.out.println("|--------------------------------------------|");

			for (Map.Entry<String, double[]> set : thongKeTheoTG.entrySet()) {
				String ngayDH = set.getKey();
				double[] dulieu = set.getValue();
				System.out.printf("| %-10s || %-15s || %-10s|\n",ngayDH,Double.toString(dulieu[0]),Double.toString(dulieu[1]));
				try {
					Thread.sleep(150);
				} catch (InterruptedException e) {
				}
			}
		
			System.out.println("*--------------------------------------------*");
			System.out.printf("| Tong doanh thu: %-27s|\n", Double.toString(tongDoanhThu));
			System.out.println("+--------------------------------------------+");
		} else if (ngaybatdau.equalsIgnoreCase("e") == false && ngayketthuc.equalsIgnoreCase("e") == false) {
			for (CT_DonHang donhang : dsDonHang) {
				Ngaythangnam tgDH = new Ngaythangnam(donhang.getNgayDH());
				Ngaythangnam tgSoSanhDau = new Ngaythangnam(ngaybatdau);
				Ngaythangnam tgSoSanhCuoi = new Ngaythangnam(ngayketthuc);

				if (tgSoSanhDau.getNam() < tgDH.getNam() && tgSoSanhCuoi.getNam() > tgDH.getNam()) {

				} else if (tgSoSanhDau.getNam() == tgDH.getNam() && tgSoSanhCuoi.getNam() > tgDH.getNam()) {
					if (tgSoSanhDau.getThang() < tgDH.getThang()) {
						if (thongKeTheoTG.containsKey(donhang.getNgayDH())) {
							double[] dulieu = thongKeTheoTG.get(donhang.getNgayDH());
							dulieu[0] += 1;
							dulieu[1] += donhang.getTongTien();
							tongDoanhThu += dulieu[1];
							thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
						} else {
							double[] dulieu = new double[2];
							dulieu[0] = 1;
							dulieu[1] = donhang.getTongTien();
							tongDoanhThu += dulieu[1];
							thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
						}
					} else if (tgSoSanhDau.getThang() == tgDH.getThang()) {
						if (tgSoSanhDau.getNgay() <= tgDH.getNgay()) {
							if (thongKeTheoTG.containsKey(donhang.getNgayDH())) {
								double[] dulieu = thongKeTheoTG.get(donhang.getNgayDH());
								dulieu[0] += 1;
								dulieu[1] += donhang.getTongTien();
								tongDoanhThu += dulieu[1];
								thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
							} else {
								double[] dulieu = new double[2];
								dulieu[0] = 1;
								dulieu[1] = donhang.getTongTien();
								tongDoanhThu += dulieu[1];
								thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
							}
						}
					}
				} else if (tgSoSanhDau.getNam() < tgDH.getNam() && tgSoSanhCuoi.getNam() == tgDH.getNam()) {
					if (tgSoSanhCuoi.getThang() > tgDH.getThang()) {
						if (thongKeTheoTG.containsKey(donhang.getNgayDH())) {
							double[] dulieu = thongKeTheoTG.get(donhang.getNgayDH());
							dulieu[0] += 1;
							dulieu[1] += donhang.getTongTien();
							tongDoanhThu += dulieu[1];
							thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
						} else {
							double[] dulieu = new double[2];
							dulieu[0] = 1;
							dulieu[1] = donhang.getTongTien();
							tongDoanhThu += dulieu[1];
							thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
						}
					} else if (tgSoSanhCuoi.getThang() == tgDH.getThang()) {
						if (tgSoSanhCuoi.getNgay() >= tgDH.getNgay()) {
							if (thongKeTheoTG.containsKey(donhang.getNgayDH())) {
								double[] dulieu = thongKeTheoTG.get(donhang.getNgayDH());
								dulieu[0] += 1;
								dulieu[1] += donhang.getTongTien();
								tongDoanhThu += dulieu[1];
								thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
							} else {
								double[] dulieu = new double[2];
								dulieu[0] = 1;
								dulieu[1] = donhang.getTongTien();
								tongDoanhThu += dulieu[1];
								thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
							}
						}
					}
				} else if (tgSoSanhDau.getNam() == tgDH.getNam() && tgSoSanhCuoi.getNam() == tgDH.getNam()) {
					if (tgSoSanhDau.getThang() < tgDH.getThang() && tgSoSanhCuoi.getThang() > tgDH.getThang()) {
						if (thongKeTheoTG.containsKey(donhang.getNgayDH())) {
							double[] dulieu = thongKeTheoTG.get(donhang.getNgayDH());
							dulieu[0] += 1;
							dulieu[1] += donhang.getTongTien();
							tongDoanhThu += dulieu[1];
							thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
						} else {
							double[] dulieu = new double[2];
							dulieu[0] = 1;
							dulieu[1] = donhang.getTongTien();
							tongDoanhThu += dulieu[1];
							thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
						}
					} else if (tgSoSanhDau.getThang() == tgDH.getThang() && tgSoSanhCuoi.getThang() > tgDH.getThang()) {
						if (tgSoSanhDau.getNgay() <= tgDH.getNgay()) {
							if (thongKeTheoTG.containsKey(donhang.getNgayDH())) {
								double[] dulieu = thongKeTheoTG.get(donhang.getNgayDH());
								dulieu[0] += 1;
								dulieu[1] += donhang.getTongTien();
								tongDoanhThu += dulieu[1];
								thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
							} else {
								double[] dulieu = new double[2];
								dulieu[0] = 1;
								dulieu[1] = donhang.getTongTien();
								tongDoanhThu += dulieu[1];
								thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
							}
						}
					} else if (tgSoSanhDau.getThang() < tgDH.getThang() && tgSoSanhCuoi.getThang() == tgDH.getThang()) {
						if (tgSoSanhCuoi.getNgay() >= tgDH.getNgay()) {
							if (thongKeTheoTG.containsKey(donhang.getNgayDH())) {
								double[] dulieu = thongKeTheoTG.get(donhang.getNgayDH());
								dulieu[0] += 1;
								dulieu[1] += donhang.getTongTien();
								tongDoanhThu += dulieu[1];
								thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
							} else {
								double[] dulieu = new double[2];
								dulieu[0] = 1;
								dulieu[1] = donhang.getTongTien();
								tongDoanhThu += dulieu[1];
								thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
							}
						}
					} else if (tgSoSanhDau.getThang() == tgDH.getThang()
							&& tgSoSanhCuoi.getThang() == tgDH.getThang()) {
						if (tgSoSanhDau.getNgay() <= tgDH.getNgay() && tgSoSanhCuoi.getNgay() >= tgDH.getNgay()) {
							if (thongKeTheoTG.containsKey(donhang.getNgayDH())) {
								double[] dulieu = thongKeTheoTG.get(donhang.getNgayDH());
								dulieu[0] += 1;
								dulieu[1] += donhang.getTongTien();
								tongDoanhThu += dulieu[1];
								thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
							} else {
								double[] dulieu = new double[2];
								dulieu[0] = 1;
								dulieu[1] = donhang.getTongTien();
								tongDoanhThu += dulieu[1];
								thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
							}
						}
					}
				}

			}
			System.out.println("\n+--------------------------------------------+");
			System.out.println("|            THONG KE THEO TG                |");
			System.out.println("|  Ngay DH  || So luong ban ra || Doanh Thu  |");
			System.out.println("|--------------------------------------------|");

			for (Map.Entry<String, double[]> set : thongKeTheoTG.entrySet()) {
				String ngayDH = set.getKey();
				double[] dulieu = set.getValue();
				System.out.printf("| %-10s || %-15s || %-10s|\n",ngayDH,Double.toString(dulieu[0]),Double.toString(dulieu[1]));
				try {
					Thread.sleep(150);
				} catch (InterruptedException e) {
				}
			}
		
			System.out.println("*--------------------------------------------*");
			System.out.printf("| Tong doanh thu: %-27s|\n", Double.toString(tongDoanhThu));
			System.out.println("+--------------------------------------------+");
		}
	
	
	}

	public void luaChonThongKe() {
		int luachon;
		Scanner input = new Scanner(System.in);
		do {
			System.out.print("\n\n");
			System.out.println("\n+---------------------------------------------------+");
			System.out.println("|                     THONG KE                      |");
			System.out.println("|---------------------------------------------------|");
			System.out.println("| Nhap 1 de thong ke doanh thu theo the loai sach   |");
			System.out.println("| Nhap 2 de thong ke doanh thu theo loai sach       |");
			System.out.println("| Nhap 3 de thong ke doanh thu tat ca sach          |");
			System.out.println("| Nhap 4 de thong ke doanh thu theo khoang thoi gian|");
			System.out.println("| Nhap 0 de thoat menu                              |");
			System.out.println("+---------------------------------------------------+");
			System.out.print("\n\n*Xin moi nhap lua chon thong ke:");
			luachon = Integer.parseInt(input.nextLine());
			switch (luachon) {
			case 1:
				thongKeTheoTheLoai();
				input.nextLine();
				break;
			case 2:
				thongKeTheoLoai();
				input.nextLine();
				break;
			case 3:
				thongKeTatCaSach();
				input.nextLine();
				break;
			case 4:
				thongKeTheoKhoangTG();
				input.nextLine();
				break;
			}
		} while (luachon != 0);

	}

	public void quanLy() {
		Scanner input = new Scanner(System.in);
		int luachon;
		do {
			System.out.print("\n\n");
			System.out.println("\n+---------------------------------------------------+");
			System.out.println("|                     MENU THAO TAC                 |");
			System.out.println("|---------------------------------------------------|");
			System.out.println("| Nhap 1 de quan ly don hang                        |");
			System.out.println("| Nhap 2 de quan ly sach                            |");
			System.out.println("| Nhap 3 de thong ke                                |");
			System.out.println("| Nhap 0 de thoat menu thao tac                     |");
			System.out.println("+---------------------------------------------------+");
			System.out.print("Nhap lua chon cua ban:");
			luachon = Integer.parseInt(input.nextLine());

			switch (luachon) {
			case 1:
				quanLyDonHang();
				break;
			case 2:
				quanLySach();
				break;
			case 3:
				luaChonThongKe();
				break;
			default:
				break;
			}
			System.out.print("\n\n");
		} while (luachon != 0);
	}

}
