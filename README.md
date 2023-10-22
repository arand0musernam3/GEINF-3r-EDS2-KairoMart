## Explicació del diagrama de classes en brut
- Verd: patró Strategy per determinar el comportament de la EA. La funció de càlcul seria Modify(input:Input), i la da canvi de patró serà setBehaviour(b:Behaviour), de EAPlayer. Input consistirà en un struct generat a partir de l'input d'un corredor.

- Taronja: interfícies i implementacions d'aquestes (Driver i EADriver) que gestionen els inputs dels Player i EAPlayer respectivament.

- Groc: son classes per gestionar la logística fora in-game.
	- Race (Singleton) és el lobby que conté totes les dades de la carrera. Permet afegir usuaris a partir de addUser(u:User). Quan han entrat tots els usuaris, es crida startDraft(), que omple les posicions restants del lobby (addEA()), i inicia el draft, on tots els jugadors (EA o no) escolleixen primer personatge i després vehicle. També conté totes les instàncies constants de motors (_motors[]) i personatges (_characters[]). Un cop un vehicle ha realitzat _max_laps, la cursa acaba amb endRace().
	- User: conté les dades necessàries del client (nom i mail) i permet a aquest unir-se a una Race.
	- Launcher és el client: permet identificar-se com a usuari o registrar-se. El password no es guarda a User, sinó que Launcher l'utilitza per identificar a l'usuari a BBDD.

- Rosa: classes constants de personatges, motors de vehicles, circuit, terrenys i les adaptabilitats entre aquests. Les classes d'associació, s'implementaran com maps indexats per Motor.

- Blau: TODO!!!