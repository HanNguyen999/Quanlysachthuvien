/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quanlisachthuvien;

import java.util.Scanner;

public class Quanlisachthuvien {
    public class Sach  {
        private String masach;
        private String tensach;
        private String tacgia;
        private int namxb;
        private double dongia;
        private int soluong;
        public Sach(){}
        public Sach(String masach, String tensach, String tacgia, int namxb, double dongia, int soluong) {
        this.masach = masach;
        this.tensach = tensach;
        this.tacgia = tacgia;
        this.namxb = namxb;
        this.dongia = dongia;
        this.soluong = soluong;
}
        public void nhapthongtin(){
            Scanner sc = new Scanner(System.in);
            System.out.println("nhap ma sacch");
            this.masach=sc.nextLine();
            System.out.println("nhap ten sach");
            this.tensach=sc.nextLine();
            System.out.println("nhap tac gia");
            this.tacgia=sc.nextLine();
            System.out.print("nhap nam xuat ban ");
            this.namxb=Integer.parseInt(sc.nextLine());
            System.out.print("nhap don gia");
            this.dongia=Double.parseDouble(sc.nextLine());
            System.out.print("nhap so luong");
            this.soluong=Integer.parseInt(sc.nextLine());   
        }
        public void xuatthongtin(){
            
        }
        public double tinhthanhtien(){
            return this.soluong*this.dongia;
        }
        public double phivanchuyen(){
            return 0.05 * this.tinhthanhtien();
   
        }
        public double tongtiennhap(){
             return this.tinhthanhtien() + this.phivanchuyen();
        }
    
    public static void main(String[] args) {
        
        
            
             
        }
        // TODO code application logic here
    }
    
}
