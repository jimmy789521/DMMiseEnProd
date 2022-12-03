Le but de cette petite application est d'acceder à une base de donnée contenant des mots et de les trier dans l'ordre alphabétique. L'application devait permettre d'ajouter des mots à la base de donnée mais par manque de temps cela n'a pas été implémenté.

sur Mogenius, nous pouvons trouver un service pour l'application et pour la base de donnée faite avec postgres.

Le service pour l'application est généré à l'aide d'un dockerfile, ce dernier implémente tous les paramètres à passer au fichier application.properties.

Le service de la base de donnée à été généré via un template de postgres.

L'application comprend un back simple avec une entity, un repository et un controller implémentant une methode Get pour obtenir la liste triée de tous les mots.

Afin de lancer l'application en local, un docker-compose a été ajouter, il suffit de lancer la commande 'docker compose up --build' au niveau de la racine.
