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
Adatbázis alapú Univerzum építő alkalmazás, ahol a felhasználó saját univerzumát képes kialakítani, égitestekkel, bolygókkal, csillagokkal, naprendszerekkel. Továbbá eme égitestek felvétele, szerkesztése, törlése, összehasonlítása.

## 2. Projekt Terv
### 2.1 Projektmunkások
-   Sulyok Tamás
-   Sulyok Balázs

## 3. Üzleti Folyamatok Modellje
### 3.1 Üzleti szereplők
A felhasználó, aki képes a saját univerzumát kialakítani.
### 3.2 Üzleti folyamatok

Bejelentkezés: a ’Belépés’ menüpontra kattintva megjelenik a ’Felhasználó név’ és ’Jelszó’ beviteli űrlap. A mezők kitöltése után a ’Belépés’ gombra kattint a felhasználó. Ha az azonosítás sikeres, akkor a felhasználó belépett és megjelenik számára a saját univerzuma. Ha nem sikerül az azonosítás, hibaüzenet jelenik meg.
## 4. Követelmények
Az alkalmazás funkcióinak eléréséhez belépésre van szükség. Csak ezután lehet hozzáférni az univerzumhoz, égitestet felvenni, szerkeszteni, törölni, összehasonlítani.

## 5. Funkcionális Terv

## 6. Architekturális Terv
Az adatok tárolása a MySql adatbázis szerveren történik. A felhasználói felület Java ablakos alkalmazás.
## 7. Adatbázis Terv
Galaxy egyedet jellemzi:
-   név
-   átmérő
-   tömeg
- csillagok száma

Planet egyedet jellemzi:
-   név
-   átmérő
-   tömeg
- távolság
- keringési idő

Star egyedet jellemzi:
-   név
-   átmérő
-   tömeg
- fényesség

Felhasználó
- név
- csillagok
- bolygók
- galaxisok
## 8. Implementációs terv


## 9. Teszt Terv

## 10. Telepítési Terv

## 11. Karbantartási Terv
