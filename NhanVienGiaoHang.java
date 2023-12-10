package BookStore;

import java.util.ArrayList;
import java.util.Scanner;

public class NhanVienGiaoHang extends NhanVien {
	public NhanVienGiaoHang() {
		super();
	}
	public NhanVienGiaoHang(String ma, String ten, Ngaythangnam ngayVao, String viTri, String loai,double ngayCong) {
		super(ma, ten, ngayVao, viTri, loai,ngayCong) ;
			
	}
        @Override
	public void xemDonHang(int luachon) {
		ArrayList<CT_DonHang> dsDonHang;
		switch (luachon) {
		case 1:
			dsDonHang = docDonHangTuFile();
			System.out.print("\n\n");
			System.out.println("\n+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
			System.out.println("|                                                                                               TẤT CẢ ĐƠN HÀNG CHƯA GIAO                                                                                                                                                                    |");
			System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
			System.out.printf("| %-15s || %-15s || %-20s || %-15s || %-15s || %-15s || %-15s || %-10s || %s\n","Mã đơn","Mã khách hàng","Địa chỉ","Email","Ngày đặt hàng","PT thanh toán","Tổng tiền","Trạng thái","Danh sách sản phẩm");
			System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
			for (CT_DonHang donhang : dsDonHang) {
				if (donhang.getTrangThai() == 2) {
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO: handle exception
					}
					System.out.printf("| %-15s || %-15s || %-20s || %-15s || %-15s || %-15s || %-15s || %-10s || %s|\n",
                                        		donhang.getMaDonHang(), donhang.getMaKH(), donhang.getDiaChi(), donhang.getEmail(),
							donhang.getNgayDH(), donhang.getPtThanhToan(), donhang.getTongTien(),
							donhang.getTrangThai(), donhang.getDsSanPham());

				}
			}
			System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");

			break;
		case 2:
			dsDonHang = docDonHangTuFile();
			System.out.print("\n\n");
			System.out.println("\n+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
			System.out.println("|                                                                                               TAT CA ĐƠN HÀNG ĐANG GIAO HÀNG                                                                                                                                                                    |");
			System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
			System.out.printf("| %-15s || %-15s || %-20s || %-15s || %-15s || %-15s || %-15s || %-10s || %s\n","Mã đơn","Mã khách hàng","Địa chỉ","Email","Ngày đặt hàng","PT thanh toán","Tổng tiền","Trạng thái","Danh sách sản phẩm");
			System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
			for (CT_DonHang donhang : dsDonHang) {
				if (donhang.getTrangThai() == 3) {

					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
					}
					System.out.printf("| %-15s || %-15s || %-20s || %-15s || %-15s || %-15s || %-15s || %-10s || %s|\n",
							donhang.getMaDonHang(), donhang.getMaKH(), donhang.getDiaChi(), donhang.getEmail(),
							donhang.getNgayDH(), donhang.getPtThanhToan(), donhang.getTongTien(),
							donhang.getTrangThai(), donhang.getDsSanPham());

				}
			}
			System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");

			break;
		case 3:
			dsDonHang = docDonHangTuFile();
			System.out.print("\n\n");
			System.out.println("\n+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
			System.out.println("|                                                                                               TAT CA ĐƠN HÀNG ĐÃ NHẬN                                                                                                                                                                    |");
			System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
			System.out.printf("| %-15s || %-15s || %-20s || %-15s || %-15s || %-15s || %-15s || %-10s || %s\n","Mã đơn","Mã khách hàng","Địa chỉ","Email","Ngày đặt hàng","PT thanh toán","Tổng tiền","Trạng thái","Danh sách sản phẩm");
			System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
			for (CT_DonHang donhang : dsDonHang) {
				if (donhang.getTrangThai() == 4) {
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
					}

					System.out.printf("| %-15s || %-15s || %-20s || %-15s || %-15s || %-15s || %-15s || %-10s || %s|\n",
                                                        donhang.getMaDonHang(), donhang.getMaKH(), donhang.getDiaChi(), donhang.getEmail(),
							donhang.getNgayDH(), donhang.getPtThanhToan(), donhang.getTongTien(),
							donhang.getTrangThai(), donhang.getDsSanPham());
				}
			}
			System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
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
                        System.out.printf("\t| %-50s|\n","1.Xem thông tin nhân viên");
                        System.out.printf("\t| %-50s|\n","2.Xem các đơn chưa giao");
			System.out.printf("\t| %-50s|\n","3.Xem các đơn đang giao");
			System.out.printf("\t| %-50s|\n","4.Xem các đơn đã nhận hàng");
			System.out.printf("\t| %-50s|\n","5.Xác nhận đơn đã giao xong");
			System.out.printf("\t| %-50s|\n","0.Thoát");
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
                            if (luachon <0 || luachon >5)
                                System.out.println("--Vui lòng nhập đúng các chức năng--");
                        }
                        catch(NumberFormatException ei)
                    {
                        System.out.println("\n--Vui lòng chọn đúng các thao tác đã hiển thị!!!--\n");
                        luachon=1;
                    }
			
		} while (luachon != 0);
	}

        @Override
        public String toString() {
            String loai="";
            if ( this.getLoai().equalsIgnoreCase("pt"))
                loai="Làm PartTime";
            else loai="Làm FullTime";
            return "\nMã Nhân Viên: "+this.getMa()+
                   "\nTên Nhân Viên: "+this.getTen()+
                   "\nNgày vào làm: "+this.getNgayVao().toString()+"\n"+loai+
                   "\nChức vụ: "+this.getViTri();

	}
        
        @Override
	public void xacNhanDonHang() {
		String luachon;
		String maDon;
                int flag=0;
		Scanner input = new Scanner(System.in);
		do {
			xemDonHang(1);
			ArrayList<CT_DonHang> dsDonHang = docDonHangTuFile();
			System.out.println("\n\t+---------------------------------------------------+");
			System.out.println("\t|                 XÁC NHẬN GIAO HÀNG                |");
			System.out.println("\t|---------------------------------------------------|");
			System.out.println("\t| Nhập mã đơn để xác nhận giao hàng                 |");
			System.out.println("\t| Nhập 0 để thoát chức năng xác nhận đơn hàng       |");
			System.out.println("\t|---------------------------------------------------|");
			System.out.println("Nhập mã đơn: ");
			luachon = input.nextLine();
			if (!luachon.equalsIgnoreCase("0")) {
				int trangthai;
				do {
					System.out.println("\n\t+---------------------------------------------------+");
					System.out.println("\t|                      XÁC NHẬN                     |");
					System.out.println("\t|---------------------------------------------------|");
					System.out.println("\t|1. Xác nhận giao hàng thành công                   |");
					System.out.println("\t|0. Trở lại phần xác nhận đơn                       |");
					System.out.println("\t|---------------------------------------------------|");
                                        try {
                                            System.out.println("Nhập lựa chọn: ");
                                            trangthai = Integer.parseInt(input.nextLine());
                                            if (trangthai <0 || trangthai >1)
                                            System.out.println("Vui lòng nhập đúng các chức năng");
                                        }
					catch(NumberFormatException ei){
                                            System.out.println("\n--Vui lòng chọn đúng các thao tác đã hiển thị!!!--\n");
                                            trangthai=0;
                                        }

				} while (trangthai != 0 && trangthai != 1);
                                
                                if( trangthai==1)
                                {
                                    maDon = luachon;
                                    for (CT_DonHang donhang : dsDonHang) 
                                    {
                                            if (donhang.getMaDonHang().equals(maDon)) 
                                            {
                                                    if (donhang.getTrangThai() == 2) 
                                                    {
                                                        flag=1;
                                                            donhang.setTrangThai(4);
                                                            ghiDonVaoFile(dsDonHang);
                                                            System.out.println("* Xác nhận giao hàng thành công! * ");
                                                    } else
                                                            System.out.println("! Chỉ được xác nhận đơn hàng đã xử lý !");
                                                    // 1: đang xử lý; 2: đã xác nhận , 3: đang giao; 4: đã nhận hàng
                                            }
                                    }
                                }

                            if (flag !=1)
                                    System.out.println("Mã đơn hàng này không tồn tại");    
			}
                        luachon="0";
		} while (luachon.equalsIgnoreCase("0")==false);
	}

}