Progtech beadandó rendszerterv alap:

Rendszer célja:
A rendszer célja, egy adott vállalkozás üzemeinek, azok részlegeinek, és dolgozóinak a nyilvántartásának megvalósítása. 
Adatbázisban tárolja a vállalkozás, az üzemek, a részlegek, és a dolgozók adatait, innen olvashatóak vissza, illetve
tervben van egy autentikációs rendszer, amely keretein belül a 'vezető' minősítésű dolgozók, egy bejelentkezést követően
az adatbázisban tárolt dolgozókat módosítani, illetve törölni tudja.

Projektterv:
A projekt elkészítése páros programozással igyekszünk megoldani az implementációt, közösen készítjük az alábbiakat:
adatbázis tervezése, létrehozása
alkalamzáslogika implementálása
grafikus felület elkészítése
logolás implementálása 
tesztelés megvalósítása

Üzleti folyamatok modellje: 
Követelmények, funkcionális követelmények:
Az adott részlegeken dolgozók nyilvántartása
Részlegek, gyárak nyilvántartása
A dolgozók adatait törölni/módosítani csak az arra jogosultak tudják (autentikáció)
Letisztult felhasználói felület
Menüpontok gyors és kézenfekvő elérése
Működés közben a program logfájlokban tárolja a fontosabb műveleteket

Funkcionális terv:
A program indításakor egy ablak jelenik meg, ahol lehetőség van a részlegek és az ott dolgozók megtekintésére. 
Ezen az ablakon található egy Bejelentkező gomb is, mellyel autentikáció után módosítani/törölni is enged a rendszer.
A CRUD funkciók megvalósításához külön mellékablakokat szeretnénk készíteni, melyeken bizonyos adatok megadása után
lehet az adatbázisban tárolt rekordokat kezelni.
Bezáráskor a program automatikusan kijelentkezteti a felhasználót.

Fizikai környezet:
Az alkalmazás Java programnyelven íródik, a grafikus felület Swing GUI segítségével tervezzük elkészíteni.
Az adatbázis MariaDB szervert használ, melyet XAMPP-on keresztül ér el, illetve az adatbázishoz való hozzáférést
JDBC segítségével szeretnénk megoldani.

Fejlesztői eszközök
IntelliJ IDEA Ultimate
XAMPP

Adatbázis terv: 
(ki kellene egészíteni vezetői boolal a workert, és egy user-password párossal)
Ezután egy SQL-es logikai ábrát beszúrni majd ide!

Implementációs terv:
1.: Adatbázis megtervezése, elkészítése localhost-on MariaDB szerveren.
2.: Swing GUI megvalósítása, Main Window elkészítése, és az ebből nyíló frontend ablakok megvalósítása.
3.: frontend ablakok adatbázissal való kommunikálásának megvalósítása
4.: objektumosztályok/konténerek elkészítése, tervezési minták implementálása

Tesztterv:
Unit-tesztek alkalmazása, legtöbb esetben a frontend és az adatbázis kommunikálásának tesztelésére.
Az ablakokból tesztrekordok elérésével/módosításával
Ezentúl a frontend és az alkalmazáslogika kommunikálását is hasonlóan tesztelnénk

Telepítési terv:
Release verziót egy *.exe tömörített bináris telepítő segítségével jutattnánk el a felhasználókhoz. (???)

Karbantartási terv:
A tesztelési folyamaton esetlegesen átcsúszó problémákat a felhasználói feedback alapján beazonosítjuk,
és a logolás, illetve unit-tesztek segítségével próbáljuk felfedni az okát, majd javítani.
