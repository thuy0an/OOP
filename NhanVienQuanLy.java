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

	public void quanLySach() {
		TuSach tuSach = new TuSach();
		Scanner input = new Scanner(System.in);
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
				//
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
		ArrayList<CT_DonHang> dsDonHang = docDonHangTuFile();
		switch (luachon) {
		case 1:
			System.out.println("Tat ca don hang");
			System.out.println(
					"Ma don hang || Ma khach hang || Dia chi || Email || Ngay dat hang || PT thanh toan || Tong tien || Trang thai || DS san pham ");
			for (CT_DonHang donhang : dsDonHang) {
				System.out.printf("%-6s || %-6s || %-50s || %-20s || %-10s || %-15s || %-7s || %-15s || %s",
						donhang.getMaDonHang(), donhang.getMaKH(), donhang.getDiaChi(), donhang.getEmail(),
						donhang.getNgayDH(), donhang.getPtThanhToan(), donhang.getTongTien(), donhang.getTrangThai(),
						donhang.getDsSanPham());
			}
			break;
		case 2:

			System.out.println("Tat ca don hang chua xac nhan");
			System.out.println(
					"Ma don hang || Ma khach hang || Dia chi || Email || Ngay dat hang || PT thanh toan || Tong tien || Trang thai || DS san pham ");
			for (CT_DonHang donhang : dsDonHang) {
				if (donhang.getTrangThai() == 1)
					System.out.printf("%-6s || %-6s || %-50s || %-20s || %-10s || %-15s || %-7s || %-15s || %s",
							donhang.getMaDonHang(), donhang.getMaKH(), donhang.getDiaChi(), donhang.getEmail(),
							donhang.getNgayDH(), donhang.getPtThanhToan(), donhang.getTongTien(),
							donhang.getTrangThai(), donhang.getDsSanPham());
			}

			break;

		case 3:
			System.out.println("Tat ca don hang da xac nhan");
			System.out.println(
					"Ma don hang || Ma khach hang || Dia chi || Email || Ngay dat hang || PT thanh toan || Tong tien || Trang thai || DS san pham ");
			for (CT_DonHang donhang : dsDonHang) {
				if (donhang.getTrangThai() != 1)
					System.out.printf("%-6s || %-6s || %-50s || %-20s || %-10s || %-15s || %-7s || %-15s || %s",
							donhang.getMaDonHang(), donhang.getMaKH(), donhang.getDiaChi(), donhang.getEmail(),
							donhang.getNgayDH(), donhang.getPtThanhToan(), donhang.getTongTien(),
							donhang.getTrangThai(), donhang.getDsSanPham());
			}

			break;

		default:
			break;
		}

	}

	@Override
	public void xacNhanDonHang() {

		String luachon = "";
		String maDon = "";
		Scanner input = new Scanner(System.in);
		do {
			ArrayList<CT_DonHang> dsDonHang = docDonHangTuFile();
			xemDonHang(2);
			System.out.println("Nhap e de thoat chuc nang xac nhan don hang");
			System.out.println("Nhap ma so don hang de xac nhan");
			System.out.print("Moi ban nhap:");
			luachon = input.nextLine();
			if (luachon != "e") {
				int trangthai;
				do {
					System.out.println("Nhap 0 de tu choi don hang");
					System.out.println("Nhap 1 de xac nhan don hang");
					System.out.print("Moi nhap lua chon");
					trangthai = Integer.parseInt(input.nextLine());
				} while (trangthai != 0 && trangthai != 1);
				maDon = luachon;
				for (CT_DonHang donhang : dsDonHang) {
					if (donhang.getMaDonHang() == maDon) {
						if (donhang.getTrangThai() == 1) {
							donhang.setTrangThai(trangthai);
							ghiDonVaoFile(dsDonHang);
							System.out.println("Xac nhan don hang thanh cong! ");
						} else
							System.out.println("Don hang da duoc xac nhan, khong the thay doi trang thai");
						// 1: đang xử lý; 2: đã xác nhận , 3: đang giao; 4: đã nhận hàng
					} else
						System.out.println("Khong tim thay don hang ");
				}

			}

		} while (luachon != "e");

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
			String[] thongtin = dulieuSach.split(";");
			int soLuong = Integer.parseInt(thongtin[2]);
			String maSach = thongtin[1];
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
		System.out.println("Loai Sach ||So luong ban ra || Doanh Thu");
		for (Map.Entry<String, double[]> set : thongKeTheLoai.entrySet()) {
			String loaiSach = set.getKey();
			double[] dulieu = set.getValue();
			System.out.println(loaiSach + "\t" + dulieu[0] + "\t" + dulieu[1] + "\n");
		}
		System.out.println("Tong doanh thu: " + tongDoanhThu);
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
			String[] thongtin = dulieuSach.split(";");
			int soLuong = Integer.parseInt(thongtin[2]);
			String maSach = thongtin[1];
			Sach sach = new Sach(tusach.timSachTheoID(maSach));
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
		System.out.println("The Loai||So luong ban ra || Doanh Thu");
		for (Map.Entry<String, double[]> set : thongKeTheLoai.entrySet()) {
			String theLoai = set.getKey();
			double[] dulieu = set.getValue();
			System.out.println(theLoai + "\t" + dulieu[0] + "\t" + dulieu[1] + "\n");
		}
		System.out.println("Tong doanh thu: " + tongDoanhThu);
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
			String[] thongtin = dulieuSach.split(";");
			int soLuong = Integer.parseInt(thongtin[2]);
			String maSach = thongtin[1];
			Sach sach = new Sach(tusach.timSachTheoID(maSach));
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
		System.out.println("Ma sach||So luong ban ra || Doanh Thu");
		for (Map.Entry<String, double[]> set : thongKeTheLoai.entrySet()) {
			String maSach = set.getKey();
			double[] dulieu = set.getValue();
			System.out.println(maSach + "\t" + dulieu[0] + "\t" + dulieu[1] + "\n");
		}
		System.out.println("Tong doanh thu: " + tongDoanhThu);
	}

	public void thongKeTheoKhoangTG() {
		Scanner input = new Scanner(System.in);
		double tongDoanhThu = 0;
		ArrayList<CT_DonHang> dsDonHang = docDonHangTuFile();
		Map<String, double[]> thongKeTheoTG = new HashMap<>();
		ArrayList<String> dsSach = new ArrayList<>();
		boolean[] matches = new boolean[3];
		matches[0] = matches[1] = true;
		matches[3] = false;
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
			if (ngaybatdau != "e" && ngayketthuc != "e") {
				matches[0] = pattern.matcher(ngaybatdau).matches();
				matches[1] = pattern.matcher(ngayketthuc).matches();
			} else {
				matches[3] = true;
			}
		} while (matches[0] == false || matches[1] == false);
		if (matches[3]) {
			thongKeTatCaSach();
		} else if (ngaybatdau == "e" && ngayketthuc != "e") {
			for(CT_DonHang donhang:dsDonHang) {
				Ngaythangnam tgDH=new Ngaythangnam(donhang.getNgayDH());
				Ngaythangnam tgSoSanh=new Ngaythangnam(ngayketthuc);
				if(tgSoSanh.getNam()>tgDH.getNam()) {
					if(thongKeTheoTG.containsKey(donhang.getNgayDH())) {
						double[] dulieu=thongKeTheoTG.get(donhang.getNgayDH());
						dulieu[0]+=1;
						dulieu[1]+=donhang.getTongTien();
					}else {
						double[] dulieu=new double[2];
						dulieu[0]=1;
						dulieu[1]=donhang.getTongTien();
					}
				}else if(tgSoSanh.getNam()==tgDH.getNam()) {
					if(tgSoSanh.getThang()>tgDH.getThang()) {
						if(thongKeTheoTG.containsKey(donhang.getNgayDH())) {
							double[] dulieu=thongKeTheoTG.get(donhang.getNgayDH());
							dulieu[0]+=1;
							dulieu[1]+=donhang.getTongTien();
						}else {
							double[] dulieu=new double[2];
							dulieu[0]=1;
							dulieu[1]=donhang.getTongTien();
						}
					}else if(tgSoSanh.getThang()==tgDH.getThang()) {
						if(tgSoSanh.getNgay()>=tgDH.getNgay()) {
							if(thongKeTheoTG.containsKey(donhang.getNgayDH())) {
								double[] dulieu=thongKeTheoTG.get(donhang.getNgayDH());
								dulieu[0]+=1;
								dulieu[1]+=donhang.getTongTien();
							}else {
								double[] dulieu=new double[2];
								dulieu[0]=1;
								dulieu[1]=donhang.getTongTien();
							}
						}
					}
				}
			}
		}
		else if(ngaybatdau!="e" &&ngaykethuc=="e") {
			
		}
	}

	public void luaChonThongKe() {
		int luachon;
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("Nhap 1 de thong ke doanh thu theo the loai sach");
			System.out.println("Nhap 2 de thong ke doanh thu theo loai sach");
			System.out.println("Nhap 3 de thong ke doanh thu tat ca sach");
			System.out.println("Nhap 4 de thong ke doanh thu theo khoang thoi gian");
			System.out.println("Nhap 0 de thoat menu");
			System.out.print("Xin moi nhap lua chon thong ke:");
			luachon = Integer.parseInt(input.nextLine());
			switch (luachon) {
			case 1:
				thongKeTheoTheLoai();
				break;
			case 2:
				thongKeTheoLoai();
				break;
			case 3:
				thongKeTatCaSach();
				break;
			case 4:
				thongKeTheoKhoangTG();
				break;
			}
		} while (luachon != 0);

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
