
import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;

class Sach {

    private String maSach;
    private String tieuDe;
    private String tacGia;
    private int namXuatBan;
    private int soLuong;

    public Sach(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        setNamXuatBan(namXuatBan);
        setSoLuong(soLuong);
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        int currentYear = Year.now().getValue();

        if (namXuatBan > 0 && namXuatBan <= currentYear) {
            this.namXuatBan = namXuatBan;
        } else {
            System.out.println("Nam xuat ban khong hop le!");
        }
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        if (soLuong >= 0) {
            this.soLuong = soLuong;
        } else {
            System.out.println("So luong khong duoc am!");
        }
    }

    public void HienThiThongTin() {
        System.out.println("------ THONG TIN SACH -----");
        System.out.println("Ma sach: " + maSach);
        System.out.println("Tieu de: " + tieuDe);
        System.out.println("Tac Gia: " + tacGia);
        System.out.println("Nam xuat ban: " + namXuatBan);
        System.out.println("So luong: " + soLuong);

    }
}

public class BTT7_8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Sach> danhSach = new ArrayList<>();

        //Nhap so luong sach
        System.out.println("Nhap so luong sach");
        int n = Integer.parseInt(sc.nextLine());

        // Nhap thong tin tung cuon sach
        for (int i = 0; i < n; i++) {
            System.out.println("\nNhap thong tin sach thu " + (i + 1));

            System.out.print("Ma sach: ");
            String maSach = sc.nextLine();

            System.out.print("Tieu de: ");
            String tieuDe = sc.nextLine();

            System.out.print("Tac gia: ");
            String tacGia = sc.nextLine();

            System.out.print("Nam xuat ban: ");
            int namXuatBan = Integer.parseInt(sc.nextLine());

            System.out.print("So luong: ");
            int soLuong = Integer.parseInt(sc.nextLine());

            // Tao doi tuong sach
            Sach s = new Sach(maSach, tieuDe, tacGia, namXuatBan, soLuong);

            // Them vao danh sach
            danhSach.add(s);
        }
        for (Sach s : danhSach) {
            s.HienThiThongTin();
        }
    }
}
