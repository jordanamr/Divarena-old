Le package ``com.ankamagames.baseImpl.client.proxyclient.base.network`` contiens les classes importantes pour le décodage et encodage de packets.

``protocol/AbstractClientMessageDecoder`` contiens le décodeur abstrait pour le décodage de packets de base reçu du serveur vers un objet ``Message``. 

L'abstraction est faite dans le package ``com.ankamagames.dofusarena.client.network.protocol``, la classe ``protocol/DofusArenaMessageDecoder`` gère le reste des packets.

La lecture des packets selon leur msgId est réalisée par des Frames enregistrées par le client. Ces frames fonctionnent comme des listeners. Une fois enregistrée dans le client, quand un message est décodé et son msgId identifié, le client appelle chaque frame dans sa fonction onMessage pour que la frame agisse en conséquence.

Une frame pour des messages basique (concernant le proxy) est disponible dans ``com.ankamagames.baseImpl.client.proxyclient.base.network.protocol.frame.NetBasicsFrame``

Le reste des frames est disponible dans ``com.ankamagames.dofusarena.client.network.protocol.frame``

Par exemple, lors de l'appui du bouton connexion, ``com.ankamagames.dofusarena.client.network.event.DofusArenaNetworkEventsHandler`` push la ``NetAuthenticationFrame`` puis envoie les informations de connexion.

Les pipes (équivalent des canaux dofus 2) du chat sont enregistrées dans ``ChatInitializer``