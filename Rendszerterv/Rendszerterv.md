# Rendszerterv - Univerzum Építő

## Tartalomjegyzék:

### [1. Rendszer Célja](https://github.com/SulyokTams/ProgTech_Project-ST_SB/blob/main/Rendszerterv/Rendszerterv.md#1-rendszer-c%C3%A9lja)

### [2. Projekt Terv](https://github.com/SulyokTams/ProgTech_Project-ST_SB/blob/main/Rendszerterv/Rendszerterv.md#2-projekt-terv)

### [3. Üzleti Folyamatok Modellje](https://github.com/SulyokTams/ProgTech_Project-ST_SB/blob/main/Rendszerterv/Rendszerterv.md#3-%C3%BCzleti-folyamatok-modellje)

### [4. Követelmények](https://github.com/SulyokTams/ProgTech_Project-ST_SB/blob/main/Rendszerterv/Rendszerterv.md#4-k%C3%B6vetelm%C3%A9nyek)

### [5. Funkcionális Terv](https://github.com/SulyokTams/ProgTech_Project-ST_SB/blob/main/Rendszerterv/Rendszerterv.md#5-funkcion%C3%A1lis-terv)

### [6. Fizikai Környezet](https://github.com/SulyokTams/ProgTech_Project-ST_SB/blob/main/Rendszerterv/Rendszerterv.md#6-fizikai-k%C3%B6rnyezet)

### [7. Absztrakt Domain Modell](https://github.com/SulyokTams/ProgTech_Project-ST_SB/blob/main/Rendszerterv/Rendszerterv.md#7-absztrakt-domain-modell)

### [8. Architekturális Terv](https://github.com/SulyokTams/ProgTech_Project-ST_SB/blob/main/Rendszerterv/Rendszerterv.md#8-architektur%C3%A1lis-terv)

### [9. Adatbázis Terv](https://github.com/SulyokTams/ProgTech_Project-ST_SB/blob/main/Rendszerterv/Rendszerterv.md#9-adatb%C3%A1zis-terv)

### [10. Implementációs terv](https://github.com/SulyokTams/ProgTech_Project-ST_SB/blob/main/Rendszerterv/Rendszerterv.md#10-implement%C3%A1ci%C3%B3s-terv)

### [11. Teszt Terv](https://github.com/SulyokTams/ProgTech_Project-ST_SB/blob/main/Rendszerterv/Rendszerterv.md#11-teszt-terv)

### [12. Telepítési Terv](https://github.com/SulyokTams/ProgTech_Project-ST_SB/blob/main/Rendszerterv/Rendszerterv.md#12-telep%C3%ADt%C3%A9si-terv)

### [13. Karbantartási Terv](https://github.com/SulyokTams/ProgTech_Project-ST_SB/blob/main/Rendszerterv/Rendszerterv.md#13-karbantart%C3%A1si-terv)

----------

## 1. Rendszer Célja
A cél egy olyan program készítése, amely képes égítesteket részleteiben leírni és tárolni egy adatbázisban. A programot főleg kezdő csillagászoknak tervezzük, akik megfigyeléseiket, felfedezéseiket könnyen és egyszerűen feltudják jegyezni és összehasonlítani másokéval.

A felhasználó képes saját univerzumát kialakítani, amely tartalmaz égítesteket, mint galaxisok, bolygók, csillagok, naprendszerek. 
A felhasználó az adatbázisba képes felvenni, szerkeszteni, törölni, valamint összehasonlítani az égitesteket.

## 2. Projekt Terv
### 2.1. Projektszerepkörök, Felelősségek
- Scrum Master: A személy aki felelős a projekt minőségéért, az idő jó beosztásáért, és a igényes munkavégzésért.
- Backend: A program, valamint adatbázis azon részének kialakítása amelyet a felhasználó nem lát.
- Frontend: A program azon része amellyel a felhasználó interaktivál.

### 2.2. Projektmunkások és Felelősségeik
- Sulyok Tamás: Scrum Master, Frontend - Felelős a projekt időbeni készenlétéért, valamint a program Frontend-jért.
- Sulyok Balázs: Backend - Az adatbázist és a program Backend-jéért felelős.

### 2.3. Ütemterv:
| Funkció      | Feladat     | Prioritás | Becslés | Eltelt idő | Hátralévő idő |
| -----------  | ----------- | --------- | ------- | ---------- | ------------- |
| Rendszerterv | A projekt részletes leírása | 3 | 5 | 3 | 2 |  
| Adatbázis    | Adatbázis megtervezése | 2 | 0.5 | 0.5 | 0 |
| | Adatbázis megvalósítása | 2 | 1 | 1 | 0 |
| Login Felület | Felület megtervezése | 1 | 0.5 | 0.5 | 0 |
| | GUI felület megvalósítása | 1 | 1 | 1 | 0 |
| | Adatok elküldése az adatbázisnak | 1 | 0.5 | 0.5 | 0 |
| | Felület Frontend szépítése | 1 | 1 | 0 | 1 | 
| Regisztrációs felület | Felület megtervezése | 1 | 0.5 | 0.5 | 0 |
| | GUI felület megvalósítása | 1 | 1 | 1 | 0 |
| | Adatok elküldése az adatbázisnak | 1 | 0.25 | 0.25 | 0 |
| | Felület Frontend szépítése | 1 | 1 | 0 | 1 |
| Univerzumok felület | Felület megtervezése | 1 | 0.5 | 0.5 | 0 |
| | GUI felület megvalósítása | 1 | 1 | 1 | 0 |
| | Adatok elküldése az adatbázisnak | 1 | 0.25 | 0.25 | 0 |
| | Felület Frontend szépítése | 1 | 1 | 0 | 1 |
| Saját univerzum felület | Felület megtervezése | 1 | 0.5 | 0.5 | 0 |
| | GUI felület megvalósítása | 1 | 1 | 1 | 0 |
| | Adatok elküldése az adatbázisnak | 1 | 0.25 | 0.25 | 0 |
| | Felület Frontend szépítése | 1 | 1 | 0 | 1 |
| Tesztelés | A program tesztelése Unit Tesztekkel | 2 | 3 | 0 | 3 |
| Loggolás | A program főbb funkcióinak futtatáskori eredményei számontartása | 2 | 2 | 0 | 2 |


### 2.4. Mérföldkövek:
1. GitHub és Trello létrehozása
2. Rendszerterv megírása
3. Adatbázis elkészítése
4. Program GUI kialakítsa
5. Program Backend megírása
6. Program tesztelése és loggolása
7. Program Frontend szépítése


## 3. Üzleti Folyamatok Modellje
### 3.1. Üzleti Szereplők

- Felhasználó: Képes saját univerzumait létrehozni, szerkeszteni, törölni. Azon belül égitesteket, bolygókat, galaxisokat, csillagok létrehozni, szekeszteni és törölni, valamint összehasonlítani őket.

### 3.2. Üzleti Folyamatok

- Bejelentkezés: A felhasználó már regisztrált adataival képes tovább lépni a programban az 'Univerzumok' oldalra.
- Regisztrálás: A felhasználó létrehoz egy új profilt, ami hozzáadodik az adatbázishoz és onnantól kezdve bármikor be tud lépni a programba.
- Univerzumok: Az alap oldal bejelentkezés után, a felhasználó képes új univerzumok hozzáadni, nevét megváltoztatni, valamint törölni.
- Égitestek: Egy univerzumban lévő égitestek listáját mutatja, a felhasználó képes égitesteket létrehozni, szerkeszteni, törölni, valamint összehasonlítani.

### 3.3. Üzleti Entitások
- Bejelentkezés
- Regisztrálás
- Univerzum
- Bolygó
- Galaxis
- Csillag
- Gomb
- Lista

## 4. Követelmények

### 4.1. Funkcionális követelmények:
- Rendszerterv elkészítése
- Adatok tárolása adatbázisban
- Java Swing GUI alkalmazás
- Autentikációs rendszer alkalmazása
- Felhasználó mindenhez hozzáfér
- Egyszerű és gyors kezelés
- Bővíthető

### 4.2. Nem funkcionális követelmények:
- Az adattárolás ne legyen túl komoly.
- Nem egy részletes égitest elemző és tároló alkalmazás, hanem egy egyszerű, gyorsan használható tároló.
- Felhasználónak ne kelljen semmilyen komolyabb tudással rendelkeznie a használatához.

### 4.3. Törvényi előírások, szabványok: 
- GNU General Public License v3.0
- Bárki, bárhogyan felhasználhatja ezt a programot nyíltforrású célokra.

## 5. Funkcionális Terv

### 5.1. Rendszerszereplők
- Felhasználó

### 5.2. Rendszerhasználati esetek és lefutásaik
- Felhasználó
  - Regisztrálás
  - Bejelentkezés
  - Univerzum felvétele, szekesztése, törlése
  - Égitestek felvétele, szekesztése, törlése, összehasonlítása

### 5.3. Határ osztályok
- Regisztrálás
  - Név
  - Jelszó
  - Jelszó újra
  - Regisztrálás gomb
  - Vissza gomb
- Bejelentkezés
  - Név
  - Jelszó
  - Bejelentkezés gomb
  - Regisztrálás gomb
- Univerzumok
  - Új létrehozása
  - Szerkesztése
  - Törlése
  - Univerzum lista
  - Input mező
- Égitestek
  - Új Bolygó, Csillag, Galaxis létrehozása
  - Szerkesztése
  - Törlése
  - Égitestek listái
  - Égitestek összehasonlítása

### 5.4. Menühierarchiák
- Bejelentkezés
  - Regisztrálás
  - Univerzumok
    - Égitestek

### 5.5. Képernyőtervek
![Login](https://github.com/SulyokTams/ProgTech_Project-ST_SB/blob/main/Rendszerterv/Képek/LoginKépernyőterv.png)

![Register](https://github.com/SulyokTams/ProgTech_Project-ST_SB/blob/main/Rendszerterv/Képek/RegisterKépernyőterv.png)

![Univerzumok](https://github.com/SulyokTams/ProgTech_Project-ST_SB/blob/main/Rendszerterv/Képek/UniverzumokKépernyőterv.png)

![Égitestek](https://github.com/SulyokTams/ProgTech_Project-ST_SB/blob/main/Rendszerterv/Képek/ÉgitestekKépernyőterv.png)

## 6. Fizikai környezet

### 6.1. Vásárolt softwarekomponensek és külső rendszerek
- A szoftware ingyenes, nem szükséges semmit venni hozzá.
- Nem szükséges semmilyen külső rendszer.
### 6.2. Hardver és hálózati topológia
- Windows operációs rendszerrel futó számítógép.
- Van tűzfal a hálózaton, minden portot engedélyez.
### 6.3. Fizikai alrendszerek
- Nincsen
### 6.4. Fejlesztő eszközök
- IntelliJ IDEA Ultimate edition: Egyetemi hallgatóként használata ingyenes, Java applikáció készítésére.
- XAMPP: ingyene, lokális adatbázis készítése.
### 6.5. Keretrendszer
- A program nem használ semmilyen keretrendszert.

## 7. Absztrakt domain modell

### 7.1. Fogalomszótár
| Fogalom | Magyarázat |
| ------- | ---------- |
| Backend | A kiszolgáló, ahonnan az alkalmazást el lehet érni. |
| Frontend | Egy réteg ami feladata a rendszerből kijutó adatok prezentálása, illetve a bejövő adatok fogadása. |
| Bug | Fejlesztési hiba ami által a program nem a várt eredményt hozza. | 
| Felület | Olyan környezet, ahol megjelenik a leprogramozott, és stílusolt oldal. |
| Felhasználó | Olyan személy aki használja a programot. |
| Bejelentkezés | A felhasználók itt tudnak belépni a rendszerbe, egy felhasználónév és egy jelszó segítségével. |
| Regisztrálás | A felhasználó itt tud létrehozni egy profilt az adatbázisban, amivel bejelentkezhet. |
| Jelszó | Betűkből, számokból, szimbólumokból álló, a felhasználó átlat választott titkosított szöveg. |
| Univerzum | Égitesteket tároló adattábla, a felhaszáló sokat képes csinálni belőle. |
| Égitest | Bolygo, Csillag, Galaxis össz fogalma. |
| Szerkesztés | A felhasználó az adatbázis elemeit tudja módosítani. |

### 7.2. Kapcsolatok
| Komponens | Kapcsolatai |
| ------- | ---------- |
| Felhasználó | Szerepkör |
| | Bejelentkezés |
| | Regisztárlás |
| | Univerzumok |
| | Égitestek |
| | Szerkesztés |
| Bejelentkezés | Regisztárlás |
| | Univerzumok |
| Regisztárlás | Bejelentkezés |
| Univerzumok | Bejelentkezés |
| | Égitestek |
| Égitestek | Univerzumok |

## 8. Adatbázis Terv
- Univerzum egyedet jellemzi
  - Név
  - user_id

- Galaxis egyedet jellemzi:
  - Név
  - Átmérő
  - Tömeg
  - Csillagok száma

- Bolygó egyedet jellemzi:
  - Név
  - Átmérő
  - Tömeg
  - Távolság
  - Keringési idő

- Csillag egyedet jellemzi:
  - Név
  - Átmérő
  - Tömeg
  - Fényesség

- Fekete lyuk egyedet jellemzi:
  - Név
  - Átmérő
  - Tömeg
  - Galaxis
  - Távolság

Felhasználó egyedet jellemzi:
- Név
- Jelszó
  
## 9. Implementációs terv

### 9.1. Perzisztencia osztályok
- Adatbázis:
  - Univerzumok tábla
  - Galaxisok tábla
  - Bolygók tábla
  - Csillagok tábla
  - Felhasználók tábla
- XAMPP phpMyAdmin adatbázis tervező
### 9.2. Üzleti logika osztályai
- Backend
  - Java GUI osztályok
  - Adatbázis kapcsolat
  - Abstract Factory tervezési minta használata
  - Observer Tervezési minta használata
  - Singleton használata
  - SOLID elvek betartása
- Frontend
  - Java GUI könnyű kezelése
  - Java GUI szépítése
- Tesztelés és Loggolás
  - Unit tesztek használata
  - Főbb funkciók kiíratása text fájlba
### 9.3. Kliens oldal osztályai
- Bejelentkezés
  - Beviteli mezők
  - Login és Register gombok
- Regisztrálás
  - Beviteli mezők
  - Register és vissza gombok
- Univerzumok
  - Univerzumok listája
  - Szerkesztési gombok
  - Beviteli mező
  - Vissza gomb
- Égitestek
  - Égitestek listái
  - Szerkesztési gombok
  - Beviteli mezők
  - Vissza gomb

## 10. Teszt Terv

A tesztelések célja a rendszer és komponensei funkcionalitásának teljes vizsgálata, ellenőrzése, a rendszer által megvalósított üzleti szolgáltatások verifikálása. 

### <strong>Tesztelési eljárások</strong>:

### Unit teszt:

Ahol csak lehetséges, szükséges már a fejlesztési idő alatt is tesztelni, hogy a metódusok megfelelően működnek-e.
Ezért a metódusok megfelelő működésének biztosítására mindegyikhez írni kell Unit teszteket, a minnél nagyobb kódlefedettséget szem előtt tartva. A metódusok akkor vannak kész, ha a tesztesetek hiba nélkül lefutnak az egyes metódusokon.

### Alfa teszt:

A teszt elsődleges célja: az eddig meglévő funkcióknak a különböző böngészőkkel, és androidokkal való kompatibilitásának tesztelése. A tesztet a fejlesztők végzik.
Az eljárás sikeres, ha különböző böngészőkben és különböző androidokon is megfelelően működnek a különböző funkciók. A teszt időtartama egy hét. 

## <strong>Tesztelendő funkciók</strong>:

- Adatbázis kapcsolat: A programnak képesnek kell lennie kapcsolódni az adatbázishoz.
- Bejelentkezés: A már adatbázisban lévő adatokkal képes legyen bejelentkeznie a felhasználónak.
- Regisztráció: A jelszavaknak megkell egyezniük, az adatbázisba új adatnak kell létre jönni.
- Univerzum: Univerzum szerkesztésekor változzon az adatbázis.
- Égitestek: Égitestek szerkesztésekor változzon az adatbázis, a bevitt érétkek megfelelőek legyenek.

## 11. Telepítési Terv



## 12. Karbantartási Terv
