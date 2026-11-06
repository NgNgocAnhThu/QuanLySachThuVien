
import java.util.Scanner;

public class BTT3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String maSach, tenSach, tacGia;
        int namXuatBan, soLuong;
        double donGia;
        // Bai 1: Nhap thong tin sach
        System.out.print("Nhap ma sach: ");
        maSach = sc.nextLine();
        System.out.print("Nhap ten sach: ");
        tenSach = sc.nextLine();
        System.out.print("Nhap tac gia: ");
        tacGia = sc.nextLine();
        System.out.print("Nhap nam xuat ban: ");
        namXuatBan = sc.nextInt();
        System.out.print("Nhap don gia: ");
        donGia = sc.nextDouble();
        System.out.print("Nhap so luong: ");
        soLuong = sc.nextInt();
        // Bai 2: Tinh thanh tien
        double thanhTien = donGia * soLuong;
        // Bai 3: Tinh phi van chuyen
        double phiVanChuyen = thanhTien * 0.05;
        // Bai 4: Tinh tong tien nhap
        double tongTienNhap = thanhTien + phiVanChuyen;

        // Bai 1.4: Kiem tra du lieu
        if (donGia <= 0) {
            System.out.println("Don gia phai lon hon 0!");
            return;
        }
        if (soLuong < 0) {
            System.out.println("So luong phai lon hon hoac bang 0!");
            return;
        }
        if (namXuatBan <= 0 || namXuatBan > 2026) {
            System.out.println("Nam xuat ban khong hop le!");
            return;
        }
        // Bai 2.4: Phan loai gia sach
        String loaiGia;
        if (donGia < 50000) {
            loaiGia = "Sach gia thap";
        } else if (donGia <= 100000) {
            loaiGia = "Sach gia trung binh";
        } else if (donGia <= 200000) {
            loaiGia = "Sach gia cao";
        } else {
            loaiGia = "Sach gia dac biet";
        }
        // Bai 3.4: Phan loai tinh trang ton kho
        String tonKho;
        if (soLuong == 0) {
            tonKho = "Het sach";
        } else if (soLuong <= 5) {
            tonKho = "Sap het";
        } else if (soLuong <= 20) {
            tonKho = "Con it";
        } else {
            tonKho = "Con nhieu";
        }

        // Bai 4.4: Su dung switch chon loai sach
        System.out.println("\n--- CHON LOAI SACH ---");
        System.out.println("1. Sach giao khoa");
        System.out.println("2. Sach tham khao");
        System.out.println("3. Sach chuyen nganh");
        System.out.println("4. Sach khac");
        System.out.print("Nhap loai sach: ");
        int loaiSach = sc.nextInt();

        String tenLoaiSach;
        switch (loaiSach) {
            case 1:
                tenLoaiSach = "Sach giao khoa";
                break;
            case 2:
                tenLoaiSach = "Sach tham khao";
                break;
            case 3:
                tenLoaiSach = "Sach chuyen nganh";
                break;
            case 4:
                tenLoaiSach = "Sach khac";
                break;
            default:
                tenLoaiSach = "Loai sach khong hop le";
                break;
        }

        // Hien thi thong tin sach
        System.out.println("\n--- THONG TIN SACH ---");
        System.out.println("Ma sach: " + maSach);
        System.out.println("Ten sach: " + tenSach);
        System.out.println("Tac gia: " + tacGia);
        System.out.println("Nam xuat ban: " + namXuatBan);
        System.out.println("Don gia: " + donGia);
        System.out.println("So luong: " + soLuong);
        System.out.println("Loai sach: " + tenLoaiSach);

        // Hien thi ket qua tinh toan
        System.out.println("\n--- KET QUA TINH TOAN ---");
        System.out.printf("Thanh tien: %.2f%n", thanhTien);
        System.out.printf("Phi van chuyen (5%%): %.2f%n", phiVanChuyen);
        System.out.printf("Tong tien nhap: %.2f%n", tongTienNhap);

        // Hien thi phan loai sach
        System.out.println("\n--- PHAN LOAI SACH ---");
        System.out.println("Phan loai gia: " + loaiGia);
        System.out.println("Tinh trang ton kho: " + tonKho);
    }
}
