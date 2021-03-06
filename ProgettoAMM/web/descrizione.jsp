<%-- 
    Document   : descrizione.jsp
    Created on : 9-mag-2017, 13.48.07
    Author     : Argio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="it">
    <head>
        <title> Nerdbook </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="ArgioluLaura">
        <meta name="keywords" content="Nerdbook social network amicizie foto like.">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    
    <body>
        <c:set var="page" value = "descrizione" scope = "request" />
        <jsp:include page="header.jsp"/>
        <div id="info">
            <ul>
                <li><a href="#descrizione"> Descrizione Social Network </a>
                <ul>
                    <li><a href="#nuoveconos">Permette Nuove Conoscenze</a></li>
                    <li><a href="#profilo">Profilo Personale</a></li>
                    <li><a href="#condivisione">Possibilita' di Condivisione</a></li>
                </ul>
                </li>
                <li><a href="#iscrizione"> Come iscriversi? </a>
                    <ul>
                        <li><a href="#scaric">Scaricando l'app o accedendo al sito ufficiale</a>
                        <li><a href="#crea">Crea nuovo account</a></li>
                        <li><a href="#possibilit">Possibilita' di esplorare tutto il mondo che facebook ti riserva</a></li>
                    </ul>
                </li>                
                <li><a href="#utenti">A chi e' rivolto? </a>
                    <ul>
                        <li><a href="#stud">Studenti</a></li>
                        <li><a href="#imp">Impiegati</a></li>
                        <li><a href="#disoc">disoccupati</a></li>
                        <li><a href="#casal">Casalinghe</a></li>
                    </ul>
                </li>                
                <li><a href="#modalita"> Gratis o a pagamento? </a>
                    <ul>
                        <li><a href="#costo">Costo pari a zero!!</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <div id="divBody">
            <div id="descrizione">
                <h2>Descrizione Social Network</h2>
                <p>Facebook è un servizio di rete sociale lanciato il 4 febbraio 2004, posseduto e gestito dalla società Facebook Inc.,
                   basato su una piattaforma software scritta in vari linguaggi di programmazione. Il sito, fondato ad Harvard negli Stati Uniti
                   da Mark Zuckerberg, Eduardo Saverin, Andrew McCollum, Dustin Moskovitz e Chris Hughes, era originariamente stato progettato
                   esclusivamente per gli studenti dell'Università di Harvard, ma fu presto aperto anche agli studenti di altre scuole della zona di
                   Boston, della Ivy League e della Stanford University.
                   Successivamente fu aperto anche agli studenti delle scuole superiori e poi a chiunque dichiarasse di avere più di 13 anni di età.
                   Da allora Facebook raggiunse un enorme successo: secondo Alexa è il terzo sito più visitato al mondo dopo Google e YouTube.
                   Ha cambiato profondamente molti aspetti legati alla socializzazione e all'interazione tra individui, sia sul piano privato che quello economico e commerciale.
                   È disponibile in oltre 100 lingue (in italiano dal 14 maggio 2008) e a luglio 2016 contava circa 1,7 miliardi di utenti attivi mensilmente, classificandosi come primo
                   servizio di rete sociale per numero di utenti attivi.
                </p>
                <div id="nuoveconos">
                    <ul>
                        <li> <h3> Permette Nuove Conoscenze:</h3> 
                            <p>Il nome "Facebook" prende spunto da un elenco con nome e fotografia degli studenti, che alcune università statunitensi distribuiscono all'inizio dell'anno accademico per
                               aiutare gli iscritti a socializzare tra loro.
                               Gli utenti possono accedere al servizio previa una registrazione gratuita, durante la quale vengono richiesti dati personali come nome, cognome, data di nascita e indirizzo email.
                               Il sito web chiarisce che l'inserimento obbligatorio della data di nascita serve esclusivamente "per favorire una maggiore autenticità e consentire l'accesso ai vari contenuti in base all'età".
                            </p>
                        </li>
                    </ul>
                </div>
                <div id="profilo">
                    <ul>
                        <li> <h3> Profilo Personale:</h3> 
                            <p>Completata la registrazione, gli utenti possono creare un profilo personale, includere altri utenti nella propria rete sociale, aggiungendoli come "amici", e scambiarsi messaggi,
                               anche via chat, incluse le notifiche automatiche quando questi aggiornano i propri profili. Per personalizzare il proprio profilo l'utente può caricare una foto, chiamata immagine del profilo,
                               con la quale può rendersi riconoscibile. Può inoltre fornire ulteriori informazioni, come il comune di nascita e quello di residenza, la scuola frequentata, il proprio datore di lavoro,
                               l'orientamento religioso e quello politico, la propria situazione sentimentale e molte altre.
                            </p>
                        </li>
                    </ul>
                </div>
                <div id="condivisione">
                    <ul>
                        <li><h3> Possibilita' di Condivisione:</h3>
                            <p>Inoltre gli utenti possono fondare e unirsi a gruppi per condividere interessi in comune con altri utenti, organizzati secondo il luogo di lavoro, la scuola, l'università o altre caratteristiche,
                               condividere contenuti multimediali ed utilizzare varie applicazioni presenti sul sito.
                               Recentemente milioni di utenti usano Facebook come una piattaforma simile a quella di YouTube ovvero, mettere in mostra i propri video, creando un pubblico numeroso.
                               Facebook non è solo per le persone fisiche e la loro vita privata ma, attraverso un servizio dedicato (Facebook for Business), è anche un strumento di social marketing.
                            </p>
                        </li>
                    </ul>                
                </div>
            </div>
            <div id="iscrizione">
                <h2>Come iscriversi</h2>
                <p>Fare l’ iscrizione a Facebook è un gioco da ragazzi e si può fare in pochi e semplici passi.
                    Facebook è il social network per eccellenza perché è utilizzato praticamente da tutti, anche dagli insospettabili come persone anziani o sacerdoti.
                    Infatti mentre altri social network come Twitter rimangono ad appannaggio delle star del cinema, di politici, e comunque di personaggi pubblici,
                    Facebook è il social network per la persona comune che vuole mettere in vetrina un po di se ma che comunque è orientato particolarmente all’aspetto sociale
                    e comunicativo piuttosto informativo e formale. In questa semplice guida ci siamo presi la briga di mostrarvi come ci si iscrive a Facebook e come gestire le varie opzioni disponibili durante questa fase come
                    la sincronizzazione dei contatti email oppure la scelta degli amici a cui fare la richiesta di amicizia.Bastano pochi e piccoli passaggi riportati di seguito.
                </p>
                <div id="scaric">
                    <ul>
                        <li><h3>Scaricando l'app o accedendo al sito ufficiale:</h3> 
                            <p>Apri lo store del tuo telefonino (Google Play Store se utilizzi un terminale Android, App Store se utilizzi un iPhone o Windows Phone Store se hai un Windows Phone),
                               cerca Facebook all’interno di quest’ultimo e avvia il download dell’applicazione pigiando sull’apposito pulsante.Al termine del download, avvia la app ufficiale di Facebook pigiando sulla sua icona comparsa in home screen
                               (la schermata principale dello smartphone in cui ci sono le icone delle applicazioni).
                            </p>
                        </li>
                    </ul>
                </div>
                <div id="crea">
                    <ul>
                        <li> <h3> Crea nuovo account:</h3> 
                            <p>
                                Dopodiché fai “tap” sulla voce Crea un nuovo account Facebook o Iscriviti a Facebook e pigia sul pulsante Avanti/Inizia per avviare il processo di creazione del tuo profilo sul social network.
                                Ora devi scegliere se iscriverti utilizzando il tuo numero di cellulare (digitandolo nel campo di testo che compare al centro dello schermo) o se creare un account utilizzando il tuo indirizzo email (pigiando sull’apposito bottone che si trova in basso).
                                Dopo aver scelto una delle due opzioni e aver dunque fornito il tuo indirizzo email o il numero di cellulare, vai avanti, digita nome e cognome negli appositi campi di testo e vai ancora avanti.
                                Immetti quindi la password che desideri utilizzare per accedere a Facebook, indica la tua data di nascita nel menu a tendina che compare sullo schermo e comunica all’applicazione se sei un uomo o una donna.
                                Per concludere, imposta una foto del profilo selezionando una foto dallo smartphone o scattandone una in tempo reale.
                            </p>
                        </li>
                    </ul>
                </div>
                <div id="possibilit">
                    <ul>
                        <li> <h3> Possibilita' di esplorare tutto il mondo che facebook ti riserva</h3> 
                            <p>
                                Missione compiuta! Ora hai un tuo profilo personale su Facebook e puoi usarlo per metterti in contatto con amici, parenti, colleghi, personalità e aziende che si trovano in ogni angolo del mondo
                            </p>
                        </li>
                    </ul>                
                </div>
            </div>
            <div id="utenti">
                <h2>A chi e' rivolto?</h2>
                    <p>In italia la percentuale di popolazione iscritta si facebook arriva al 44% per un totale di 27 milioni di scritti,dandoci la possibilità di inserirci al 9° posto nella classifica degli iscritti nel nostro paese.
                       Gli utenti creano profili che solitamente contengono fotografie e liste di interessi personali, scambiano messaggi privati o pubblici.
                       Possono creare e prendere parte a "Gruppi", in cui si condividono interessi, e a "Pagine" legate a cose o persone di loro gradimento.
                       Secondo TechCrunch, "circa l'85% degli studenti dei college ha un profilo sul sito. Di quelli che sono iscritti il 60% accede al sito quotidianamente.
                       Circa l'85% almeno una volta la settimana, e il 93% almeno una volta al mese". Secondo Chris Hughes, il portavoce per Facebook, "Le persone passano circa 19 minuti al giorno su Facebook".
                       I nostri utenti sono principalemente:
                    </p>
                             
                <div id="stud">
                    <ul><li><h3>Studenti</h3></li></ul>
                </div>
                <div id="imp">
                    <ul><li><h3>Impiegati</h3></li></ul>
                </div>
                <div id="disoc">
                    <ul><li><h3>Disoccupati</h3></li></ul>
                </div>
                <div id="casal">
                    <ul><li><h3>Casalinghe</h3></li></ul>
                </div> 
            </div>
            <div id="modalita">
                <h2>Gratis o a pagamento?</h2>
                <div id="costo">
                    <ul>
                        <li><h3>Costo pari a zero!!</h3>                         
                            <p>Il costo della procedura è pari a zero. Al contrario di quello che vorrebbero far credere alcuni truffatori online,
                               Facebook è un servizio totalmente gratuito (che si sostenta grazie alle pubblicità) e non prevede alcun account Pro o Premium.
                               Inoltre non ha scadenze e può essere usato liberamente da qualsiasi dispositivo.
                               Il servizio è gratuito per gli utenti e trae guadagno dalla pubblicità, inclusi i banner
                               Molti analisti invece sostengono che i ricavi monetari di Facebook non siano così elevati rispetto
                               alle potenzialità di un servizio di rete sociale, aggirandosi intorno ai 230 milioni di dollari nel 2009.
                               Infatti solo nel 2009, dopo 5 anni dalla sua nascita, il portale è riuscito a chiudere il primo bilancio in attivo.
                               I ricavi commerciali derivanti dalla pubblicità riescono a coprire solo in parte i costi fissi di gestione del sito 
                               (archiviazione, server, ecc.) tanto da rendere necessario l'apporto dei soci (tra cui l'1,6% di Microsoft). 
                            </p>
                        </li>
                    </ul>
                </div>
            </div>
        </div>                      
    </body>
      
</html>