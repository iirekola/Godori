15.1.2015 18-23
Projektin luominen NetBeansiin, omat ongelmansa siinä... Ei luonut gitignore tiedostoa ja valittaa:

> Your project has dependencies that are not resolved locally. Code completion in the IDE will not include classes from these dependencies or their transitive dependencies (unless they are among the open projects).
> Please download the dependencies, or install them manually, if not available remotely.
> 
> The artifacts are:
>  junit:junit:jar:4.10
> org.hamcrest:hamcrest-core:jar:1.1

tästä tää lähtee. Tänään siis ekan viikon asiat (miinus githubiin liittyvät, jotka tein tiistaina). 

18.1.2015 20-21
Luokkakaavion luonnostelua. Projektin aloittaminen tökkii. Tuntuu, ettei useankan luonnoksen jälkeen tullut tyydyttävää ratkaisua.

19.1.2015 15-16
Lisää luonnostelua. Vieläkään ei tunnu oikealta. Annan hautua, mutta hiukan alkaa aikataulut kuumotella jos ei pian inspaa.

21.1.2015 13-15
Epätoivoista räpeltämistä, jotta clean and build toimisi. Neuvojen kysymisen ja syvällisen googlettelun jälkeen ilmenee, että could not run program, error=13 johtuu riittämättömistä oikeuksista. Yritin tuloksetta fiksata.

21.1.2015 00-01
Räpel räpel räpel. MUTTA. Onnistuin fiksaamaan käyttöoikeudet, woop. Ja tsekkailin taas luokkakaaviota.

22.1.2015 20-01
Jee, luokkakaavion piirtämistä ja ohjelmointia(viimein!) Kello on nyt liikaa. Yritin generoida PITiä, mutta

> BUILD FAILURE
------------------------------------------------------------------------
Total time: 32.904s
Finished at: Fri Jan 23 00:42:30 EET 2015
Final Memory: 7M/19M
------------------------------------------------------------------------
Failed to execute goal org.pitest:pitest-maven:0.30:mutationCoverage (default-cli) on project Godori: Execution default-cli of goal org.pitest:pitest-maven:0.30:mutationCoverage failed: No mutations found. This probably means there is an issue with either the supplied classpath or filters.
See http://pitest.org for more details.
-> [Help 1]
>

johtuneeko siitä, että testejä on liian vähän vai jostain muusta, sitä selvitellään huomenna.
