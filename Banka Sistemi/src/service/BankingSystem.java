package service;

import model.User;
import model.Account;
import java.util.ArrayList;

public class BankingSystem {

    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Account> accounts = new ArrayList<>();
    public User currentUser = null;
    private Account currentAccount = null;

    private int findUserIndex(int id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void register(int id, String firstName, String lastName, String password) {
        // 1. Kontrol: Bu ID ile daha önce kayıt yapılmış mı?
        int userIndex = this.findUserIndex(id);

        if (userIndex != -1) {
            // Kullanıcı zaten varsa hata mesajı ver ve metottan çık
            System.out.println("Hata: Bu ID (" + id + ") ile kayıtlı bir kullanıcı zaten var!");
        } else {
            // 2. Güvenli Ekleme: Kullanıcı yoksa satır içi (inline) nesne üreterek listeye ekle
            users.add(new User(id, firstName, lastName, password));
            System.out.println("Kullanıcı başarıyla kaydoldu: " + firstName + " " + lastName);
        }
    }

    public boolean login(int id, String password) {
        int userIndex = this.findUserIndex(id);

        if (userIndex == -1) {
            System.out.println("Hata: Bu ID ile kayıtlı bir kullanıcı bulunamadı!");
            return false;
        } else {
            User user = users.get(userIndex);

            if (user.getPassword() != null && user.getPassword().equals(password)) {
                this.currentUser = user;
                System.out.println("Giriş başarılı! Hoş geldiniz, " + user.getFirstName());
                return true;
            } else {
                System.out.println("Hata: Şifre yanlış!");
                return false;
            }
        }
    }

    public void createAccount(String accountNumber, double initialBalance) {
        if (currentUser == null) {
            System.out.println("Önce giriş yapmalısınız!");
            return;
        }

        Account newAccount = new Account(accountNumber, initialBalance, currentUser);
        accounts.add(newAccount);
        currentAccount = newAccount;

        System.out.println(accountNumber + " numaralı hesabınız başarıyla açıldı. Bakiye: " + initialBalance);
    }

    public void deposit(double amount) {
        if (currentAccount == null) {
            System.out.println("Aktif bir hesabınız bulunamadı!");
            return;
        }
        if (amount <= 0) {
            System.out.println("Geçersiz miktar!");
            return;
        }
        // Mevcut bakiyeyi alıp üzerine ekliyoruz
        double newBalance = currentAccount.getBalance() + amount;
        currentAccount.setBalance(newBalance);
        System.out.println(amount + " TL yatırıldı. Güncel bakiye: " + currentAccount.getBalance());
    }

    public void withdraw(double amount) {
        if (currentAccount == null) {
            System.out.println("Aktif bir hesabınız bulunamadı!");
            return;
        }
        if (amount > currentAccount.getBalance()) {
            System.out.println("Yetersiz bakiye! Mevcut bakiye: " + currentAccount.getBalance());
            return;
        }
        // Mevcut bakiyeden düşüyoruz
        double newBalance = currentAccount.getBalance() - amount;
        currentAccount.setBalance(newBalance);
        System.out.println(amount + " TL çekildi. Güncel bakiye: " + currentAccount.getBalance());
    }

    public void showTransactions() {
        if (currentUser == null) {
            System.out.println("Giriş yapmış bir kullanıcı yok!");
            return;
        }
        System.out.println("--- MÜŞTERİ BİLGİLERİ ---");
        System.out.println("Müşteri: " + currentUser.getFirstName() + " " + currentUser.getLastName());
        if (currentAccount != null) {
            System.out.println("Hesap No: " + currentAccount.getAccountNumber());
            System.out.println("Bakiye: " + currentAccount.getBalance() + " TL");
        } else {
            System.out.println("Henüz açılmış bir hesabınız yok.");
        }
    }

    public void logoutUser() {
        if (currentUser != null) {
            System.out.println("Güle güle, " + currentUser.getFirstName());
            currentUser = null;
        } else {
            System.out.println("Zaten giriş yapmış bir kullanıcı yok.");
        }
    }
}

