Packet client -> serveur
-------------------

#### Header:

 Type | Taille | Description |
| :--- | :--- | :--- |
| short | 16 bits | Taille du message totale en bytes | 
| byte | 8 bits | Architecture (ID microservice?) |
| short | 16 bits | ID du message |

##### La suite du packet sont les données du message.

Packet serveur -> client
-------------------

#### Header:

 Type | Taille | Description |
| :--- | :--- | :--- |
| short | 16 bits | Taille du message totale en bytes | 
| short | 16 bits | ID du message |

##### La suite du packet sont les données du message.