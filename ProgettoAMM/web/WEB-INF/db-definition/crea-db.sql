/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Argio
 * Created: 23-mag-2017
 */

--DB: Nerdbook ; user: Laura23 ; pass: 1234 ;
/*
CREATE TABLE utenti (
    utenti_id  INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    username VARCHAR(25) UNIQUE,
    nome VARCHAR(25) NOT NULL,
    cognome VARCHAR(25) NOT NULL,
    frasePres VARCHAR(256),
    imgProfilo VARCHAR(256),
    dataDiNascita date ,
    password VARCHAR(256) NOT NULL

);

CREATE TABLE postType (
    posttype_id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    posttype_name VARCHAR(32)
);

CREATE TABLE post (
    post_id  INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    content VARCHAR(1024) NULL,
    type INTEGER,
    FOREIGN KEY (type) REFERENCES postType(posttype_id),
    author INTEGER,
    FOREIGN KEY (author) REFERENCES utenti(utenti_id)
);

CREATE TABLE amicizie (
   follower INTEGER,
   FOREIGN KEY (follower) REFERENCES utenti(utenti_id),
   followed INTEGER,
   FOREIGN KEY (followed) REFERENCES utenti(utenti_id),
   PRIMARY KEY (follower, followed)
);
*/
                /*
                CREATE TABLE gruppi (

                );
                */
/*
--Modifica tabella post. Aggiunta colonna testo e si assume come content l'allegato(immagine,url).
ALTER TABLE post ADD testo VARCHAR(1026);

*/
/*
--Popolamento tabella utenti
INSERT INTO utenti (utenti_id, username, nome, cognome, frasePres, imgProfilo, datadinascita, password)
VALUES (default,
    'Lau23',
    'Laura',
    'Argiolu',
    'Non mi scoraggio perché ogni tentativo sbagliato scartato è un altro passo avanti.',
    'img/Foto1.jpg',
    '08/23/1995',
    '123');

INSERT INTO utenti (utenti_id, username, nome, cognome, frasePres, imgProfilo, datadinascita, password)
VALUES (default,
    'Auru92',
    'Aurora',
    'Russo',
    'Il futuro appartiene a coloro che credono nella bellezza dei propri sogni.',
    'img/Foto2.jpg',
    '03/08/1992',
    '1011');

INSERT INTO utenti (utenti_id, username, nome, cognome, frasePres, imgProfilo, datadinascita, password)
VALUES (default,
    'Fede89',
    'Federico',
    'Brundu',
    'Il segreto per andare avanti è iniziare.',
    'img/Foto3.jpg',
    '01/07/1989',
    '0000');

INSERT INTO utenti (utenti_id, username, nome, cognome, frasePres, imgProfilo, datadinascita, password)
VALUES (default,
    'incomp23',
    'Adalgiso',
    '',
    '',
    '',
    '01/02/1992',
    '0000');
*/
/*
--Popolamento tabella PostType
INSERT INTO posttype (posttype_id, posttype_name)
VALUES (default, 'TEXT');

INSERT INTO posttype (posttype_id, posttype_name)
VALUES (default, 'IMAGE');

INSERT INTO posttype (posttype_id, posttype_name)
VALUES (default, 'URL');

*/--Popolamento tabella Post

           /* 
            INSERT INTO post (post_id, content, type, author, testo)
            VALUES (default,
                    '',
                    1,
                    1,
                    'Solo il nostro gusto individuale, alla fine, riesce davvero a creare uno stile o una moda,
                    poiché non si preoccupa di seguire la scia degli altri. Perciò, indipendentemente dall’oggetto che il gusto individuale
                    ci fa scegliere, alla base ci deve essere una scelta profondamente personale');
*/

/*
INSERT INTO post (post_id, content, type, author, testo)
VALUES (default,
        'img/Foto4.jpg',
        2,
        2,
        'l’importante non è vincere..ma uscire dalla sconfitta a testa alta!!');

INSERT INTO post (post_id, content, type, author, testo)
VALUES (default,
        'https://it-it.facebook.com/',
        3,
        3,
        'La sincerità è l eventuale inganno di tutti i grandi uomini.');
*/

