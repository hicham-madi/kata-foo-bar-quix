# Kata FOO BAR QUIX

### Pré-requis :

Merci d'utiliser les technologies suivantes pour réaliser le kata :

- Maven
- Java ou Kotlin
- Spring boot
- Angular
- Bootstrap 5

Le kata doit être publié sur github et contenir deux dossiers :

<ul>
<li>un dossier kata-backend dans lequel la commande 'mvn spring-boot:run' permet de lancer le backend</li>
<li>un dossier kata-frontend dans lequel la commande 'npm start' permet de lancer le frontend</li>
</ul>

### Enoncé backend

Ecrire un algorithme qui transforme une nombre (compris entre 0 et 100) en une chaîne de characters.
Cet algorithme doit suivre les règles suivantes :

<ul>
<li>Si le nombre est divisible par 3 ou s'il contient 3, la chaîne  de characters doit contenir "FOO"</li>
<li>Si le nombre est divisible par 5 ou s'il contient 5, la chaîne  de characters doit contenir "BAR"</li>
<li>Si le nombre contient 7, la chaîne  de characters doit contenir "QUIX"</li>
<li>La règle "divisible par" est plus prioritaire que la règle "contient"</li>
<li>Le contenu est analysé de gauche à droite</li>
<li>Si aucune des règles n'est vérifiée, retourner la nombre en entrée sous forme de chaîne de characters</li>
</ul>


Exemples :

| Input | Output      |
|-------|-------------|
| 1     | "1"         |
| 3     | "FOOFOO"    |
| 5     | "BARBAR"    |
| 7     | "QUIX"      |
| 9     | "FOO"       |
| 51    | "FOOBAR"    |
| 53    | "BARFOO"    |
| 33    | "FOOFOOFOO" |
| 33    | "FOOFOOFOO" |
| 15    | "FOOBARBAR" |

Cet algorithme doit être exposé par un controller rest prenant en entrée le nombre et retournant la chaîne de
characters.

### Enoncé backend

Créer une page contenant l'énoncé du kata et un bouton permettant de tester l'api backend.
Ce bouton doit ouvrir une modal contenant un formulaire permettant de saisir le nombre en entrée.
Cet input doit être validé dans le front end.
