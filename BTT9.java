
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

// LOP CHA
abstract class Sach {

    protected String maSach;
    protected LocalDate ngayNhap;
    protected double donGia;
    protected int soLuong;
    protected String nhaXuatBan;

    protected static final Scanner sc = new Scanner(System.in);
    protected static final DateTimeFormatter df
            = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void nhapThongTinChung() {
        System.out.print("Nhap ma sach: ");
        maSach = sc.nextLine();
        System.out.print("Nhap ngay nhap (dd/MM/yyyy): ");
        ngayNhap = LocalDate.parse(sc.nextLine(), df);
        System.out.print("Nhap don gia: ");
        donGia = Double.parseDouble(sc.nextLine());
        System.out.print("Nhap so luong: ");
        soLuong = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap nha xuat ban: ");
        nhaXuatBan = sc.nextLine();
    }

    public void xuatThongTinChung() {
        System.out.println("Ma sach: " + maSach);
        System.out.println("Ngay nhap: " + ngayNhap.format(df));
        System.out.println("Don gia: " + donGia);
        System.out.println("So luong: " + soLuong);
        System.out.println("Nha xuat ban: " + nhaXuatBan);
    }

    public abstract double thanhTien();
}

// LOP SACH GIAO KHOA
class SachGiaoKhoa extends Sach {

    private String tinhTrang;

    @Override
    public void nhapThongTinChung() {
        super.nhapThongTinChung();
        System.out.print("Nhap tinh trang (Moi/Cu): ");
        tinhTrang = sc.nextLine();
    }

    @Override
    public void xuatThongTinChung() {
        super.xuatThongTinChung();
        System.out.println("Tinh trang: " + tinhTrang);
        System.out.println("Thanh tien: " + thanhTien());
    }

    @Override
    public double thanhTien() {
        if (tinhTrang.equalsIgnoreCase("Moi")) {
            return soLuong * donGia;
        } else {
            return soLuong * donGia * 0.5;
        }
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }
}

// LOP SACH THAM KHAO
class SachThamKhao extends Sach {

    private double thue;

    @Override
    public void nhapThongTinChung() {
        super.nhapThongTinChung();
        System.out.print("Nhap thue: ");
        thue = Double.parseDouble(sc.nextLine());
    }

    @Override
    public void xuatThongTinChung() {
        super.xuatThongTinChung();
        System.out.println("Thue: " + thue);
        System.out.println("Thanh tien: " + thanhTien());
    }

    @Override
    public double thanhTien() {
        return soLuong * donGia + thue;
    }
}

// LOP MAIN
public class BTT9 {

    public static void main(String[] args) {
        ArrayList<SachGiaoKhoa> dsSGK = new ArrayList<>();
        ArrayList<SachThamKhao> dsSTK = new ArrayList<>();

        // Nhap sach giao khoa
        System.out.print("Nhap so luong sach giao khoa: ");
        int n = Integer.parseInt(Sach.sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("\nNhap sach giao khoa thu " + (i + 1));
            SachGiaoKhoa sgk = new SachGiaoKhoa();
            sgk.nhapThongTinChung();
            dsSGK.add(sgk);
        }

        // Nhap sach tham khao
        System.out.print("\nNhap so luong sach tham khao: ");
        int m = Integer.parseInt(Sach.sc.nextLine());

        for (int i = 0; i < m; i++) {
            System.out.println("\nNhap sach tham khao thu " + (i + 1));
            SachThamKhao stk = new SachThamKhao();
            stk.nhapThongTinChung();
            dsSTK.add(stk);
        }

        // Xuat sach giao khoa
        System.out.println("\n===== DANH SACH SACH GIAO KHOA =====");
        for (SachGiaoKhoa s : dsSGK) {
            s.xuatThongTinChung();
            System.out.println("--------------------");
        }

        // Xuat sach tham khao
        System.out.println("\n===== DANH SACH SACH THAM KHAO =====");
        for (SachThamKhao s : dsSTK) {
            s.xuatThongTinChung();
            System.out.println("--------------------");
        }

        // Tong thanh tien sach giao khoa
        double tongSGK = 0;
        for (SachGiaoKhoa s : dsSGK) {
            tongSGK += s.thanhTien();
        }

        // Tong thanh tien sach tham khao
        double tongSTK = 0;
        for (SachThamKhao s : dsSTK) {
            tongSTK += s.thanhTien();
        }

        System.out.println("\n===== KET QUA =====");
        System.out.println("Tong thanh tien sach giao khoa: " + tongSGK);
        System.out.println("Tong thanh tien sach tham khao: " + tongSTK);

        // Trung binh cong don gia sach tham khao
        double tongDonGia = 0;

        for (SachThamKhao s : dsSTK) {
            tongDonGia += s.donGia;
        }

        if (m > 0) {
            System.out.println("Trung binh cong don gia sach tham khao: "
                    + tongDonGia / m);
        } else {
            System.out.println("Khong co sach tham khao.");
        }

        // Sach giao khoa cua nha xuat ban X
        System.out.println("\n===== SACH GIAO KHOA CUA NHA XUAT BAN X =====");

        boolean timThay = false;

        for (SachGiaoKhoa s : dsSGK) {
            if (s.getNhaXuatBan().equalsIgnoreCase("X")) {
                s.xuatThongTinChung();
                System.out.println("--------------------");
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay sach cua nha xuat ban X.");
        }
    }
}
