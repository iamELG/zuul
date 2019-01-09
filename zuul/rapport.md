**Guilloton Elvin**

Votre but: trouver le trésor dans le château de Beewick!

Pour cela vous devrez entrer dans le chateau, trouver la salle du trésor puis prendre le trésor et sortir du chateau.
Bien évidemment, il y aura des obstacles sur votre chemin.
 
La carte ainsi que la javadoc est disponible sur https://perso.esiee.fr/~guillote/

Roger (le personnage que vous allez incarner) a dans sa besace des cookies.
Roger ne connait pas le château. S'il fonce tête baissée, il ne trouvera probablement pas le trésor.

Condition de victoire: Roger sort du château en vie, avec le trésor.
Condition de non défaite: Roger sort du château en vie.
Condition de défaite: Roger meurt.

###EXO 7.11
La fonction getLongDescription renvoie un String avec la description de la pièce et les sorties de cette pièce.

###EXO 7.14
La procédure look a été créée. Le mot "look" a été ajouté à la liste des commandes.Il y a des eu des erreurs à l'exécution (null pointer) mais elles ont disparu sans rien faire!

###EXO 7.15
La procédure eat a été créée, le mot "eat" a été ajouté à la liste des commandes.

###EXO 7.16
Ajout de la procédure showCommands; certaines procédures d'affichage sont devenues des static car ces méthodes n'avaient pas besoin d'être instanciées.

###EXO 7.18
Ajout de la méthode getCommandListe. Problème à la compilation "non static method cannot be referenced from a static context". Résolution en créant un objet CommandWord temporaire pour pouvoir appeler une méthode non static dessus.

###EXO 7.18.8
Des dificultés à trouver sur internet la class pour faire des boutons. Création d'un bouton pour manger "eat", Il est positionné à l'ouest. Des warnings au début de l'exécution du programme mais pas de bug dans le jeu (à ma connaissance); c'était dû à blueJ sur linux.

###EXO 7.19.2
Les images chargent bien. Il y a deux fois la même images pour les deux cryptes. Les images n'ont pas toutes la même taille. Donc le GUI change de taille à chaque changement de salle. 

###EXO 7.20
Création de la class Item, ajout d'un constructeur sans Item dans la class room.

###EXO 7.21
Ajout de la méthode toString à la class Item, modification de la longDescription d'une Room.

###EXO 7.22
Ajout d'une hashmap pour mettre plusieurs Item dans une Room. Ajout de addItem() pour ajouter un Item dans une Room.

###EXO 7.22.2
Ajout d'Item dans la salle de départ et dans la salle dead-end, il y a 3 Item. Pour l'instant, seul un seul Item est utile dans le senario (la clef).


###EXO 7.26
La commande Back a directement été implémentée avec une Stack. La Stack est une pile, comme une pile d'assiettes... On peut en rajouter une au-dessus (push), on peut enlever celle du dessus (pop), on peut regarder s'il y a des assiettes (empty).

###EXO 7.26.1
La doc a été générée et est actuelement en ligne sur mon site:
https://perso.esiee.fr/~guillote/

###EXO 7.28.1
Création de la méthode test et du fichier test.txt. La méthode marche, par contre ne pas faire d'appel récursif avec le fichier text (i.e. mettre "test test.txt" dans le fichier test.txt). Je n'ai pas encore trouvé comment empêcher cette boucle infinie.

###EXO 7.28.2
Ajout des fichiers text court.txt et long.txt. Le fichier court fait des petits déplacements, le fichier long va explorer toutes les pièces. Le fichier test va aller chercher la clef (pas encore implémenté) puis chercher le trésor pour sortir.

###EXO 7.29
Aout de l'atribut aName pour la class Item. Un Item a maintenant un nom et une description. Ajout de la class Player.

###EXO 7.30
Ajout des deux actions take et drop dans la class GameEngine.
Pas encore de commande pour voir son inventaire.

###EXO 7.31
La class Player a directement été implémenté avec une Hashmap d'Item; donc il n'y a pas besoin de la modifier pour qu'un joueur puisse prendre plusieurs Item.

###EXO 7.31.1
Ajout de la class ItemList.
----------------
###EXO 7.32
les methode take et drop on ete modifier pour que les regle de poi soi respecter, currentweight < maxweight.

###EXO 7.33
ajout de la methode items pour voir sont inventaire 

###EXO 7.34
ajout d'un magic cookie dans le tavern.

###EXO 7.35
le classe CommandWord a ete cree et est fonctionel.

###EXO 7.41.2
la java doc a ete mis a jour
```bash
javadoc -d userdoc -author -version *.java
javadoc -d progdoc -author -version -private -linksource *.java
```
###EXO 7.42
ajout d'une mimite de 35 mouvement valide pour finir le jeux
(7.42.1 optionel temps reel)

###EXO 7.42.2
 la décision de vous contenter de l'IHM actuelle.
 si j'arrive a ratraper mon retard peut etre que je ferai un nouvelle interfqce homme machine
 
###EXO 7.43
creation d'un treap door pour rentrer dans la taverne mais ne pas resortir.
une locked door a ete fait en meme temps, entre le premier niveau de la crypte et le deuxieme il faut la "key" dans la "dead end"


