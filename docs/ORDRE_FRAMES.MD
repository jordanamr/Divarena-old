A la connexion:
- [Client] **NetBasicsFrame** *(Tout le temps chargée)*
- [Client] **NetAuthenticationFrame** *(Au moment de cliquer sur le bouton connexion)* 
- [Serveur] **InitialFrame** *(Gère le check version et check login/pass)*

Quand le client a recu une connexion réussie:
- [Client] **NetInstanceFrame** (Recois les informations world?)
- [Client] **NetCoachFrame** (Création de coach, informations de coach, statistiques)
- [Client] **NetChatFrame**

Quand le client a recu le CoachCreationRequestMessage:
- [Serveur] **CoachCreationFrame**

Quand le client a recu le CoachInformationsMessage:
- [Client] **NetCoachUpdateFrame** (Mise à jour de l'équipement et de l'inventaire)

Quand le client a recu le EnterInstanceMessage **DYNAMIQUE = FALSE**:
- [Client] ~~NetCoachFrame~~
- [Client] **NetActorsFrame** (Spawn, despawn et mouvement d'actors)
- [Client] **NetFightInvitationFrame**
- [Client] **NetExchangeInvitationFrame**
- [Serveur] **WorldFrame**

Quand le client a recu le EnterInstanceMessage **DYNAMIQUE = TRUE**:
- [Client] ~~NetCoachFrame~~
- [Client] ~~NetFightInvitationFrame~~
- [Client] ~~NetExchangeInvitationFrame~~
- [Client] ~~NetTeamManagementFrame~~
