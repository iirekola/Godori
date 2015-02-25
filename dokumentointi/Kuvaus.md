# Godori
## Lyhyt kuvaus

**Aihe:** Neopetsin [Godori](http://www.neopets.com/games/godori/index.phtml) on [Hanafuda](http://en.wikipedia.org/wiki/Hanafuda)-tyyppisillä korteilla pelattava peli, johon hullaannuin nuorena. Neopetsin Godorissa voi pelata vain tietokonetta vastaan. Suuri syy tähän projektiin onkin halu voida pelata toista ihmistä vastaan. Pelissä pyritään keräämään mahdollisimman paljon pisteitä yhdistämällä kortteja ja tekemällä niistä mahdollisimman hyviä yhdistelmiä.

Peliin kuuluu 48 korttia, joilla on kaikilla maa ja tyyppi, jotkin korteista edustavat useampaa tyyppiä. Jokaiseen maahan kuuluu neljä erilaista korttia. Pelatessa kortin ominaisuudet määrää maa, pistelaskussa sen tyyppi. Peli etenee erä kerrallaan ja erän aikan kertyneet pisteet jaetaan aina erän lopussa. Peli päättyy sen erän jälkeen, jossa jompikumpi pelaajista saavuttaa 50 pistettä.

**Säännöt:** http://www.neopets.com/games/godori/rules.phtml tai [Käyttöohje](https://github.com/iirekola/Godori/blob/master/dokumentointi/K%C3%A4ytt%C3%B6ohje.md)

**Käyttäjät:** pelaajat

**Käyttäjien toiminnot:**
Pelaajan toiminnot:
- uuden pelin aloittaminen
- Käsikorttien katsominen
- kortin pelaaminen
- uuden kierroksen aloittaminen
- luovuttaminen

**Rakenteen kuvaus:**
Pelin korttien jakamisen hoitaa Korttipakka, joka sisältää kaikki 48 korttia. Kortilla on nimi, maa, tyyppi ja sijainti. Peliin kuuluu pöytä, joka koostuu kahdestatoista ruudusta, sekä Nostopakka, joka sisältää listan nostettavista korteista. Lisäksi pelissä on kaksi pelaajaa. Pelaajilla on Käsi, joka koostuu 0-10 kortista, ja voittopakka, joka sisältää neljä korttilistaa, yhden kutakin tyyppiä kohti. 

Joka kierroksen alussa Pöytään jaetaan kahdeksan korttia, pelaajien käsiin kymmenen ja nostopakkaan loput. Voittopakat ovat tyhjiä. Pelin aikana kortteja siirretään kädestä pöytään, nostopakasta pöytään ja pöydästä pelaajan voittopakkaan. Kortin siirtäminen poistaa kortin edellisestä sijainnista ja lisää sen uuteen. Kortin sisäinen sijainti muuttuu vastaamaan uutta sijaintia. Pöydässä samaa maata olevat kortit laitetan samaan ruutuun. Kierroksen päättyessä pöytä, nostopakka ja pelaajien kädet ovat tyhjiä ja kaikki kortit ovat pelaajien voittopakoissa.

Kierroksen loputtua pisteet lasketaan korttien ominaisuuksien mukaan ja kirjataan muistiin Pelaajaan. Pelaajien voittopakat tyhjennetään ja mikäli kummankaan pelaajan pisteet eivät ylitä viittäkymmentä, Korttipakka sekoitetaan ja siitä jaetaan uudet aloituskortit. Kun pelaajan kierrosten aikana kertyneen pisteet ylittävät 50, peli päättyy. Palaaja, jolla on korkemmat pisteet julistetaan voittajaksi. Peli kysyy aloitetaanko uusi peli.
