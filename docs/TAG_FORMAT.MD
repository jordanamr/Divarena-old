Format propriétaire d'ankama "TAG"
-------------------

### Header du fichier:

 Type | Taille | Description |
| :--- | :--- | :--- |
| String | 24 bits | Signature du fichier en 3 lettres, MAJ = pas compressé| 
| byte | 8 bits | Version du fichier |
| int | 32 bits | Taille du fichier |

Les fichiers de ce format sont composés d'une suite de "tags" qui semblent être des actions qui dépendant de l'implémentation du format. Exemple : Le format graphique SBA (utilisé pour les sprites de cartes?) semble utiliser ce format TAG. Le package ``com.ankamagames.framework.fileFormat.tag`` semble abstraire un ``SBATagDecoder`` pour lire des tags en rapport avec le format SBA.

#### Header d'un tag:

 Type | Taille | Description |
| :--- | :--- | :--- |
| short | 16 bits | code | 
| ? | ? bits | length |

Le "code" et la "taille" du prochain tag dans le document est déterminé de cette manière:
```java
int codeAndLength = stream.readUI16();
this.m_code = (short)(codeAndLength >> 6);
this.m_length = codeAndLength & 0x3F;
if (this.m_length == 63) {
    this.m_length = (int)stream.readUI32();
}
```

Ensuite, le lecteur alloue une byte array contenant m_length bytes de la suite du fichier. Le TagReader lance ensuite la lecture du tag en utilisant le décodeur de tag en rapport avec le fichier (SBATagDecoder pour les .sba)

nique ta mère la pute ankama (j'ai pas réussi à avancer)