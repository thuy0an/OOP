import java.util.Scanner;

public abstract class NhanVien {
	private String ten;
	private int ma;
	private Date ngayVao;
	private int viTri;
	private int loai;

	public NhanVien() {
		super();
	}

	public NhanVien(String ten, int ma, Date ngayVao, int viTri, int loai) {
		super();
		this.ten = ten;
		this.ma = ma;
		this.ngayVao = ngayVao;
		this.viTri = viTri;
		this.loai = loai;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getMa() {
		return ma;
	}

	public void setMa(int ma) {
		this.ma = ma;
	}

	public Date getNgayVao() {
		return ngayVao;
	}

	public void setNgayVao(Date ngayVao) {
		this.ngayVao = ngayVao;
	}

	public int getViTri() {
		return viTri;
	}

	public void setViTri(int viTri) {
		this.viTri = viTri;
	}

	public int getLoai() {
		return loai;
	}

	public void setLoai(int loai) {
		this.loai = loai;
	}
	public String toString() {
		System.out.printf("Ma nhan vien: %s", this.ten);
		System.out.printf("Ten nhan vien: %s\n", this.ten);
		System.out.println("Ngay vao lam: "+this.ngayVao.toString());
	}
	public void tinhLuong() {}
	

}
