package main;

import service.BankingSystem;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BankingSystem bankingSystem = new BankingSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            if (bankingSystem.currentUser == null) {
                System.out.println("\n1. Kayıt Ol (Register)");
                System.out.println("2. Giris Yap (Login)");
                System.out.println("0. Sistemi Kapat");
                System.out.print("Seciminiz: ");
                int choice = scanner.nextInt();

                if (choice == 1) {
                    System.out.print("ID (Sayısal): ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ad: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Soyad: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Şifre: ");
                    String password = scanner.nextLine();

                    bankingSystem.register(id, firstName, lastName, password);
                } else if (choice == 2) {
                    System.out.print("ID'niz: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Şifreniz: ");
                    String password = scanner.nextLine();

                    bankingSystem.login(id, password);
                } else if (choice == 0) {
                    System.out.println("Banka sistemi kapatılıyor.");
                    break;
                } else {
                    System.out.println("Geçersiz seçim!");
                }
            } else {
                System.out.println("\n--- YAPMAK İSTEDİĞİNİZ İŞLEMİ SEÇİN ---");
                System.out.println("1. Hesap Aç");
                System.out.println("2. Para Yatırma");
                System.out.println("3. Para Çekme");
                System.out.println("4. İşlem Geçmişi");
                System.out.println("5. Güvenli Çıkış");
                System.out.print("Seçiminiz: ");
                int operationChoice = scanner.nextInt();
                scanner.nextLine();

                switch (operationChoice) {
                    case 1:
                        System.out.print("Yeni Hesap Numarası: ");
                        String accountNumber = scanner.nextLine();
                        System.out.print("İlk Yatırılacak Tutar: ");
                        double initialBalance = scanner.nextDouble();
                        bankingSystem.createAccount(accountNumber, initialBalance);
                        break;

                    case 2:
                        System.out.print("Yatırılacak Miktar: ");
                        double depositAmount = scanner.nextDouble();
                        bankingSystem.deposit(depositAmount);
                        break;

                    case 3:
                        System.out.print("Çekilecek Miktar: ");
                        double withdrawalAmount = scanner.nextDouble();
                        bankingSystem.withdraw(withdrawalAmount);
                        break;

                    case 4:
                        bankingSystem.showTransactions();
                        break;

                    case 5:
                        bankingSystem.logoutUser();
                        break;

                    default:
                        System.out.println("Geçersiz işlem seçimi!");
                        break;
                }
            }
        }
    }
}

