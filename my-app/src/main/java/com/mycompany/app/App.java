package com.mycompany.app;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    static List<Stok> stokList = new ArrayList();
    static List<Satis> satisList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DosyadanOku();
        urunEkle(scan);

        while (true) {
            siradakiIslem();
            int secim2 = scan.nextInt();
            if (secim2 == 1) {
                StokSorgusuYap();
            } else if (secim2 == 2) {
                UrunSatinAl();
            } else if (secim2 == 3) {
                urunEkle(scan);
            }
        }
    }

    private static void urunEkle(Scanner scan) {
        System.out.println("Eklenecek ürün seçiniz;");
        System.out.println("1. Havuc");
        System.out.println("2. Erik");

        int secim = scan.nextInt();
        if (secim == 1) {
            HavucEkle(scan);
        } else if (secim == 2) {
            ErikEkle(scan);
        }
    }

    private static void siradakiIslem() {
        System.out.println("Yapmak istediğiniz işlemi seçiniz");
        System.out.println("1. Stok sorgusu");
        System.out.println("2. Ürün satış");
        System.out.println("3. Ürün eklemeye devam edin");
    }

    private static void UrunSatinAl() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Satın almak istediğiniz ürünü seçiniz");
        System.out.println("1. Havuç");
        System.out.println("2. Erik");

        int secim = scan.nextInt();

        if (secim == 1) {

            System.out.println("Satın almak istediğiniz miktarı giriniz (ADET) ");
            int satinAlinacakMiktar = scan.nextInt();
            Satis satis = new Satis();
            Urun havuc = new Havuc();
            satis.setUrun(havuc);

            System.out.println("Müşteri adını giriniz");
            String musteriAdi = scan.nextLine();
            Musteri musteri = new Musteri();
            musteri.setMusteriAdi(musteriAdi);
            satis.setMusteri(musteri);
            satis.setMiktar(satinAlinacakMiktar);

            satisList.add(satis);

            System.out.println("toplam satış miktarı:");
            System.out.println(havuc.getClass().getSimpleName() + " " + satis.getMiktar() + "(ADET)");
        }
        else if (secim == 2){

            System.out.println("Satın almak istediğiniz miktarı giriniz (ADET) ");
            int satinAlinacakMiktar = scan.nextInt();
            Satis satis1 = new Satis();
            Urun erik = new Erik();
            satis1.setUrun(erik);

            System.out.println("Müsteri adını giriniz");
            String musteriAdi = scan.nextLine();
            Musteri musteri1 = new Musteri();
            musteri1.setMusteriAdi(musteriAdi);
            satis1.setMusteri(musteri1);
            satis1.setMiktar(satinAlinacakMiktar);

            satisList.add(satis1);
            System.out.println("---------------------");
            System.out.println("Toplam satış miktarı:");
            System.out.println(erik.getClass().getSimpleName() + " " + satis1.getMiktar() + "(ADET)");
            System.out.println("---------------------");
        }
    }

    private static void StokSorgusuYap() {

        System.out.println("--------------- Ürün Listesi -------------------");
        int toplamHavucMiktari = 0;
        int toplamErikMiktari = 0;
        int yeniHavucMiktarı = 0;
        int yeniErikMiktarı = 0;

        for (Stok stok : stokList) {

            if (stok.getUrun().getClass().getSimpleName().equals("Havuc")) {

                toplamHavucMiktari = toplamHavucMiktari + stok.getMiktar();

                if (satisList.size() > 0) {
                    for (Satis satis : satisList) {
                        if(satis.getUrun().getClass().getSimpleName().equals("Havuc")) {
                            yeniHavucMiktarı = toplamHavucMiktari - satis.getMiktar();
                        }else{
                            yeniHavucMiktarı = stok.getMiktar();
                        }
                    }
                    stok.setMiktar(yeniHavucMiktarı);
                }
                System.out.println("Toplam havuc miktarı = " + yeniHavucMiktarı);
                if (satisList.size() == 0) {
                    System.out.println("Toplam havuc miktarı = " + toplamHavucMiktari);
                    System.out.println("----------------------------------------------------");
                }

            } else if (stok.getUrun().getClass().getSimpleName().equals("Erik")) {

                toplamErikMiktari = toplamErikMiktari + stok.getMiktar();

                if (satisList.size() > 0) {
                    for (Satis satis : satisList) {
                        if(satis.getUrun().getClass().getSimpleName().equals("Erik")) {

                            yeniErikMiktarı = toplamErikMiktari - satis.getMiktar();
                        }else{
                            yeniErikMiktarı = stok.getMiktar();
                        }
                    }
                    stok.setMiktar(yeniErikMiktarı);
                }
                System.out.println("Toplam erik miktarı = " + yeniErikMiktarı);
                System.out.println("----------------------------------------------------");
                if (satisList.size() == 0) {
                    System.out.println("Toplam erik miktarı = " + toplamErikMiktari);
                    System.out.println("----------------------------------------------------");
                }
            }
        }

    }

    static void HavucEkle(Scanner scan) {

        Urun havuc = new Havuc();
        havuc.setMiktarTuru(EnumMiktarTuru.ADET);
        havuc.setFiyat(10);
        System.out.println("id giriniz");
        int id = scan.nextInt();
        havuc.setId(id);

        Personel personel = new Personel();
        System.out.println("personel adı giriniz");
        Scanner scanner = new Scanner(System.in);
        String personelAdi = scanner.nextLine();
        personel.setPersonelAdi(personelAdi);

        Stok havucStok = new Stok();
        havucStok.setPersonel(personel);
        havucStok.setUrun(havuc);
        System.out.println("miktar giriniz (ADET)");
        int miktar = scan.nextInt();
        havucStok.setMiktar(miktar);

        stokList.add(havucStok);
        DosyayaYaz();

        System.out.println("-----------------------------");
        System.out.println("ürün başarıyla eklendi eklendi");
        System.out.println("-----------------------------");
    }

    private static void ErikEkle(Scanner scan) {
        Urun erik = new Erik();
        erik.setMiktarTuru(EnumMiktarTuru.ADET);
        erik.setFiyat(15);
        System.out.println("id giriniz");
        int id = scan.nextInt();
        erik.setId(id);

        Personel personel = new Personel();
        System.out.println("personel adı giriniz");
        Scanner scanner = new Scanner(System.in);
        String personelAdi = scanner.nextLine();
        personel.setPersonelAdi(personelAdi);

        Stok erikStok = new Stok();
        erikStok.setPersonel(personel);
        erikStok.setUrun(erik);
        System.out.println("miktar giriniz (ADET)");
        int miktar = scan.nextInt();
        erikStok.setMiktar(miktar);

        stokList.add(erikStok);
        DosyayaYaz();

        System.out.println("-----------------------------");
        System.out.println("ürün başarıyla eklendi");
        System.out.println("-----------------------------");
    }

    private static void DosyayaYaz() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\FiratUlgay\\Desktop\\HalApp\\Txt\\stok.txt");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(stokList);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void DosyadanOku(){
        try (FileInputStream fileInputStream = new FileInputStream("C:\\Users\\FiratUlgay\\Desktop\\HalApp\\Txt\\stok.txt");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
            stokList = (List<Stok>) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("--------Dosyadan Okunan Mevcut Ürünler------");
        for (Stok stok : stokList) {
            System.out.println(stok.getUrun().getClass().getSimpleName()+" "+stok.getMiktar()+"(ADET)");
        }
        System.out.println("-------------------------------");
    }
}
