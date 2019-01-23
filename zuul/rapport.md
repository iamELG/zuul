**Guilloton Elvin**

Zuul est un projet d'informatique qui permet de commencer la programmation avec une approche différente des méthodes classiques. En effet, le projet Zuul est un façon ludique de commencer à programmer en faisant son propre jeu. Il permet de comprendre des concepts importants de la programmation orientée objet comme ce qu'est un object, une instance, des méthodes, etc. Il permet de manipuler des types tel que des int, boolean et String mais aussi des types un peu plus avancés comme des Stack, ArrayList, HashMap, etc.

##Mon Projet Zuul

Votre but: trouver le trésor dans le château de Beewick!

Pour cela vous devrez entrer dans le chateau, trouver la salle du trésor puis prendre le trésor et sortir du chateau.
Bien évidemment, il y aura des obstacles sur votre chemin.
 
La carte ainsi que la javadoc est disponible sur https://perso.esiee.fr/~guillote/

Roger (le personnage que vous allez incarner) ne connait pas le château. S'il fonce tête baissée, il ne trouvera probablement pas le trésor.

Condition de victoire: Roger sort du château en vie, avec le trésor.
Condition de non défaite: Roger sort du château en vie.
Condition de défaite: Roger ne sort pas du chateau en 35 mouvements.


####Comment gagner:
Il faut aller dans la pièce dead end pour prendre la clef.
Ensuite il faut aller à la salle du trésor et décendre dans la crypte(qui n'est pas verouillée car vous avez la clef);prendre le trésor et ressortir.

####Room:
La taverne est un pièce particulière; la taverne a la sortie west et sud qui reviennent dans la taverne. La sortie east est une "trap door", c'est à dire que depuis la "empty room" on peut aller vers l'ouest vers la "tavern" mais depuis la taverne on ne peut pas ressortir vers "empty room". Le seul moyen de ressortir est d'aller vers le nord pour retomber dans la "main entrance". 
"The entrance of the mine" est un "transporter room"; c'est à dire que si vous en ressortez vous allez atterrir à un endroit aléatoire.
Entre la "treasure room" et la "Crypt" il y a une "locked door".

####Item:
 Dans la "main entrance" se trouve un "cube" inutile.
      Dans "l'armoury" se trouve un "beamer". Il pourrait vous être utile.
      Dans la "deadend" se trouve une "cape" un "hat", un "key" and a "heavy item" seul le "key" est un item utile.
      Dans la taverne, il y a un "magic cookie" qui double la capacité que le personage peut porter. 
      Dans la "crypte", il y a un trésor qui est nécessaire pour gagner.
      
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

###EXO 7.32
Les méthodes take et drop ont été modifiées pour que les règles de poids soient respectées, currentZeight inférieur maxZeight.

###EXO 7.33
Ajout de la méthode items pour voir son inventaire. 

###EXO 7.34
Ajout d'un magic cookie dans la taverne.

###EXO 7.35
La classe CommandWord a été créée et est fonctionelle.

###EXO 7.42
Ajout d'une limite de 35 mouvements valides pour finir le jeu.

###EXO 7.42.2
L'interface homme machine de départ me convient donc je ne l'ai pas changée.
 
###EXO 7.43
Création d'un trap door pour rentrer dans la taverne sans pouvoir ressortir. La foncion back ne permet pas de repasser dans les trap door.
Une locked door a été faite en même temps. Entre le premier niveau de la crypte et le deuxième, il faut la "key" dans la "dead end".

###EXO 7.44
Le beamer a été créé; la commande back ne permet pas de refaire le mouvement de beamer dans l'autre sens.

###EXO 7.46
Ajout de la class transporter room, la méthode getExit() a été @override. La commande alea a été ajouter, elle n'est utilisable aue par un fichier .txt .
