package quanlisachthuvien;

import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;

public class Quanlisachthuvien {

    public static class Sach {
        private String masach;
        private String tensach;
        private String tacgia;
        private int namxb;
        private double dongia;
        private int soluong;
        private int loaisach; // 1: Giáo khoa, 2: Tham khảo, 3: Chuyên ngành, 4: Khác

        public Sach() {}

        // BÀI 1: Kiểm tra dữ liệu hợp lệ (Giá > 0, Số lượng >= 0, Năm XB <= năm hiện tại)
        public void nhapthongtin(Scanner sc) {
            System.out.print("Nhap ma sach: ");
            this.masach = sc.nextLine();

            System.out.print("Nhap ten sach: ");
            this.tensach = sc.nextLine();

            System.out.print("Nhap tac gia: ");
            this.tacgia = sc.nextLine();

            // Validation Năm xuất bản
            int namHienTai = Year.now().getValue();
            do {
                System.out.print("Nhap nam xuat ban (<= " + namHienTai + "): ");
                this.namxb = Integer.parseInt(sc.nextLine());
                if (this.namxb > namHienTai || this.namxb <= 0) {
                    System.out.println("Nam xuat ban khong hop le! Vui long nhap lai.");
                }
            } while (this.namxb > namHienTai || this.namxb <= 0);

            // Validation Đơn giá (> 0)
            do {
                System.out.print("Nhap don gia (> 0): ");
                this.dongia = Double.parseDouble(sc.nextLine());
                if (this.dongia <= 0) {
                    System.out.println("Don gia phai lon hon 0! Vui long nhap lai.");
                }
            } while (this.dongia <= 0);

            // Validation Số lượng (>= 0)
            do {
                System.out.print("Nhap so luong (>= 0): ");
                this.soluong = Integer.parseInt(sc.nextLine());
                if (this.soluong < 0) {
                    System.out.println("So luong khong duoc am! Vui long nhap lai.");
                }
            } while (this.soluong < 0);

            // BÀI 4: Chọn loại sách bằng Switch-Case
            do {
                System.out.println("Chon loai sach:");
                System.out.println("1. Sach giaokhoa");
                System.out.println("2. Sach tham khao");
                System.out.println("3. Sach chuyen nganh");
                System.out.println("4. Sach khac");
                System.out.print("Lua chon (1-4): ");
                this.loaisach = Integer.parseInt(sc.nextLine());
                if (this.loaisach < 1 || this.loaisach > 4) {
                    System.out.println("Lua chon khong hop le! Chon tu 1 den 4.");
                }
            } while (this.loaisach < 1 || this.loaisach > 4);
        }

        // BÀI 2: Phân loại giá
        public String phanLoaiGia() {
            if (this.dongia < 50000) {
                return "Sach gia thap";
            } else if (this.dongia <= 100000) {
                return "Sach gia trung binh";
            } else if (this.dongia <= 200000) {
                return "Sach gia cao";
            } else {
                return "Sach gia dac biet";
            }
        }

        // BÀI 3: Phân loại tồn kho
        public String phanLoaiTonKho() {
            if (this.soluong == 0) {
                return "Het sach";
            } else if (this.soluong <= 5) {
                return "Sap het";
            } else if (this.soluong <= 20) {
                return "Con it";
            } else {
                return "Con nhieu";
            }
        }

        // BÀI 4: Lấy tên loại sách dựa vào switch
        public String getTenLoaiSach() {
            switch (this.loaisach) {
                case 1:
                    return "Giao khoa";
                case 2:
                    return "Tham khao";
                case 3:
                    return "Chuyen nganh";
                case 4:
                default:
                    return "Khac";
            }
        }

        public double tinhthanhtien() {
            return this.soluong * this.dongia;
        }

        public double phivanchuyen() {
            return 0.05 * this.tinhthanhtien();
        }

        public double tongtiennhap() {
            return this.tinhthanhtien() + this.phivanchuyen();
        }

        public void xuatthongtin() {
            System.out.printf("%-8s %-18s %-15s %-10s %-8d %-12.2f %-8d %-18s %-12s %-12.2f\n",
                    this.masach,
                    this.tensach,
                    this.tacgia,
                    this.getTenLoaiSach(),
                    this.namxb,
                    this.dongia,
                    this.soluong,
                    this.phanLoaiGia(),
                    this.phanLoaiTonKho(),
                    this.tongtiennhap());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Sach> dsSach = new ArrayList<>();

        System.out.print("Nhap so luong sach can quan ly: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Nhap thong tin sach thu " + (i + 1) + " ---");
            Sach s = new Sach();
            s.nhapthongtin(sc);
            dsSach.add(s);
        }

        System.out.println("\n================================================ DANH SACH SACH THU VIEN ================================================");
        System.out.printf("%-8s %-18s %-15s %-10s %-8s %-12s %-8s %-18s %-12s %-12s\n",
                "Ma Sach", "Ten Sach", "Tac Gia", "Loai Sach", "Nam XB", "Don Gia", "So Luong", "Phan Loai Gia", "Ton Kho", "Tong Tien");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");

        double tongChiPhi = 0;
        for (Sach s : dsSach) {
            s.xuatthongtin();
            tongChiPhi += s.tongtiennhap();
        }

        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("TONG CHI PHI NHAP SACH CUA THU VIEN: %.2f VNĐ\n", tongChiPhi);

        sc.close();
    }
}