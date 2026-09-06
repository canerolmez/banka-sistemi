# Banka Sistemi

Java ile geliştirilmiş, konsol üzerinden çalışan temel bir banka sistemi uygulamasıdır. Nesne yönelimli programlama pratiği yapmak amacıyla hazırlanmıştır.

## Özellikler

* Kullanıcı kaydı oluşturma
* Kullanıcı girişi
* Banka hesabı açma
* Para yatırma
* Para çekme
* Müşteri ve hesap bilgilerini görüntüleme
* Güvenli çıkış

## Kullanılan Teknolojiler

* Java
* ArrayList
* Apache NetBeans
* Visual Studio Code
* Git ve GitHub

## Proje Yapısı

```text
Banka Sistemi/
├── src/
│   ├── main/
│   │   └── Main.java
│   ├── model/
│   │   ├── Account.java
│   │   ├── Transaction.java
│   │   └── User.java
│   ├── service/
│   │   └── BankingSystem.java
│   └── util/
│       └── FileManager.java
├── build.xml
└── manifest.mf
```

## Çalıştırma

Depoyu bilgisayarınıza indirin:

```bash
git clone https://github.com/canerolmez/banka-sistemi.git
```

Visual Studio Code ile `Banka Sistemi` klasörünü açın. Ardından `src/main/Main.java` dosyasındaki **Run** seçeneğine basın.

Visual Studio Code üzerinde **Extension Pack for Java** eklentisinin kurulu olması gerekir.

## Gelecekte Eklenebilecek Özellikler

* İşlem geçmişini kaydetme
* Hesaplar arası para transferi
* Verileri dosyada veya veritabanında saklama
* Hata yönetimi
* Birim testleri

## Geliştirici

**Caner Ölmez**

GitHub: [canerolmez](https://github.com/canerolmez)
