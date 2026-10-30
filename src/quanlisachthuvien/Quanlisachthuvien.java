package quanlisachthuvien;

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

        public Sach() {}

        public Sach(String masach, String tensach, String tacgia, int namxb, double dongia, int soluong) {
            this.masach = masach;
            this.tensach = tensach;
            this.tacgia = tacgia;
            this.namxb = namxb;
            this.dongia = dongia;
            this.soluong = soluong;
        }

        public void nhapthongtin(Scanner sc) {
            System.out.print("nhap ma sach: ");
            this.masach = sc.nextLine();
            System.out.print("nhap ten sach: ");
            this.tensach = sc.nextLine();
            System.out.print("nhap tac gia: ");
            this.tacgia = sc.nextLine();
            System.out.print("nhap nam xuat ban: ");
            this.namxb = Integer.parseInt(sc.nextLine());
            System.out.print("nhap don gia: ");
            this.dongia = Double.parseDouble(sc.nextLine());
            System.out.print("nhap so luong: ");
            this.soluong = Integer.parseInt(sc.nextLine());
        }

        public void xuatthongtin() {
            System.out.printf("%-10s %-20s %-15s %-10d %-10.2f %-10d %-12.2f %-15.2f %-15.2f\n",
                    this.masach, this.tensach, this.tacgia, this.namxb,
                    this.dongia, this.soluong, this.tinhthanhtien(),
                    this.phivanchuyen(), this.tongtiennhap());
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
        
        System.out.printf("%-10s %-20s %-15s %-10s %-10s %-10s %-12s %-15s %-15s\n",
                "Ma Sach", "Ten Sach", "Tac Gia", "Nam XB", "Don Gia", "So Luong", "Thanh Tien", "Phi Van Chuyen", "Tong Tien");
        

        double tongChiPhi = 0;
        for (Sach s : dsSach) {
            s.xuatthongtin();
            tongChiPhi += s.tongtiennhap();
        }

        
        System.out.printf("TONG CHI PHI NHAP SACH CUA THU VIEN: %.2f VNĐ\n", tongChiPhi);

        sc.close();
    }
}