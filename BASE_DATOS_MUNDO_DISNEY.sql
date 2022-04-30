USE mundo_disney;

CREATE TABLE genero(
	id_genero INT NOT NULL AUTO_INCREMENT,
	descripcion VARCHAR(150),
    imagen TEXT,
    PRIMARY KEY (id_genero)
);

CREATE TABLE peliculas_series(
	id_peli_series INT NOT NULL AUTO_INCREMENT,
    imagen_peliculas TEXT,
    titulo VARCHAR(255),
    fecha_creacion DATE,
    calificacion FLOAT(2,1),
    PRIMARY KEY (id_peli_series)    
);

ALTER TABLE genero CHANGE imagen_genero imagen_genero TEXT ;
ALTER TABLE peliculas_series CHANGE imagen_peliculas imagen_peliculas TEXT ;

CREATE TABLE personajes(
	id_personaje INT NOT NULL AUTO_INCREMENT,
    imagen_personaje TEXT,
    nombre VARCHAR(255) NOT NULL, 
    edad INT, 
    peso FLOAT(5,2),
    historia TEXT,
    PRIMARY KEY (id_personaje)
);


CREATE TABLE personajes_peliculas(
	id_personaje INT NOT NULL, 
    id_peli_series INT NOT NULL, 
    id_genero	INT NOT NULL,
    FOREIGN KEY (id_genero) REFERENCES genero(id_genero),
    FOREIGN KEY (id_peli_series) REFERENCES peliculas_series(id_peli_series),
    FOREIGN KEY (id_genero) REFERENCES personajes(id_personaje),
    PRIMARY KEY (id_personaje,id_peli_series, id_genero)
);

SELECT * FROM genero;

USE mundo_disney;

INSERT INTO genero (descripcion, imagen_genero)
VALUES ('Fantasía','https://www.google.com/search?q=fantas%C3%ADa&client=ms-android-americamovil-co-revc&tbm=isch&sxsrf=APq-WBv8Pn1RiV87qmkXI0wGsf83hUekqA:1648940544696&source=lnms&sa=X&ved=2ahUKEwi_l7Cbvvb2AhUWQTABHXrRDDYQ_AUoAnoECAEQBA&biw=1920&bih=929&dpr=1#imgrc=1s77Q7181vhHCM');

INSERT INTO genero (descripcion, imagen_genero)
VALUES ('Acción','https://selectra.com.co/sites/selectra.com.co/files/styles/_default/public/mandolorian-750.png?itok=bOd22YS2');

INSERT INTO genero (descripcion, imagen_genero)
VALUES ('Infantil','https://static.wikia.nocookie.net/disney/images/2/2e/Antonio_Madrigal.jpg/revision/latest/smart/width/250/height/250?cb=20211119180254&path-prefix=es');

SELECT * FROM genero;	

UPDATE genero
SET imagen_genero = 'https://t1.uc.ltmcdn.com/es/posts/1/2/6/como_escribir_un_libro_de_fantasia_toma_nota_47621_orig.jpg'
WHERE id_genero = 1;

SELECT * FROM personajes;

INSERT INTO personajes (imagen_personaje, nombre, edad, peso, historia)
VALUES ('https://hips.hearstapps.com/es.h-cdn.co/fotoes/images/media/imagenes/reportajes/los-personajes-clave-de-harry-potter/harry-potter_/4661804-1-esl-ES/Harry-Potter_.jpg','Harry Potter',13,50.0,'is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.');

INSERT INTO personajes (imagen_personaje, nombre, edad, peso, historia)
VALUES ('https://static.wikia.nocookie.net/disney/images/a/ab/Kim.gif/revision/latest/top-crop/width/360/height/450?cb=20090424152434&path-prefix=es','Kim possible',18,50.0,'is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.');

INSERT INTO personajes (imagen_personaje, nombre, edad, peso, historia)
VALUES ('https://static.wikia.nocookie.net/disneyypixar/images/9/94/Mirabel_Madrigal_2.png/revision/latest?cb=20220104032317&path-prefix=es','Maribel Madrigal',17,55.0,'is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.');

INSERT INTO personajes (imagen_personaje, nombre, edad, peso, historia)
VALUES ('https://static.wikia.nocookie.net/warnerbros/images/a/af/Rony.jpg/revision/latest?cb=20120402152702&path-prefix=es','Ron Weasly',20,70.0,'is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.');


SELECT * FROM peliculas_series;

INSERT INTO peliculas_series (imagen_peliculas, titulo, fecha_creacion, calificacion)
VALUES ('https://cloudfront-us-east-1.images.arcpublishing.com/infobae/QNRAM7YSTJE5PHCXWU4FGQWV54.jpg','Harry Potter','2001-01-01',9.8);

INSERT INTO peliculas_series (imagen_peliculas, titulo, fecha_creacion, calificacion)
VALUES ('https://prod-ripcut-delivery.disney-plus.net/v1/variant/disney/FF679017804514E78F51F5D25E9079802A971CD243CCA9205110AC40958C08F5/scale?width=1200&aspectRatio=1.78&format=jpeg','Kim Possible','2002-01-01',8.5);

INSERT INTO peliculas_series (imagen_peliculas, titulo, fecha_creacion, calificacion)
VALUES ('https://pics.filmaffinity.com/Encanto-153413687-large.jpg','Encanto','2022-01-01',9.0);

SELECT * FROM personajes_peliculas;

INSERT INTO personajes_peliculas (id_genero, id_personaje, id_peli_series)
VALUES (1,1,1);

INSERT INTO personajes_peliculas (id_genero, id_personaje, id_peli_series)
VALUES (2,2,2);

INSERT INTO personajes_peliculas (id_genero, id_personaje, id_peli_series)
VALUES (3,3,3);

INSERT INTO personajes_peliculas (id_genero, id_personaje, id_peli_series)
VALUES (1,4,1);

SELECT p.imagen_personaje, p.nombre, p.edad, p.peso, p.historia FROM personajes p
JOIN personajes_peliculas pp
ON p.id_personaje = pp.id_personaje
WHERE p.nombre = 'Harry Potter';

SELECT p.imagen_personaje, p.nombre, p.edad, p.peso, p.historia, g.descripcion FROM personajes p
JOIN personajes_peliculas pp
ON p.id_personaje = pp.id_personaje
JOIN genero g
ON g.id_genero  = pp.id_genero
WHERE g.descripcion = 'Fantasía'; 

SELECT p.imagen_personaje, p.nombre, pe.titulo FROM personajes p
JOIN personajes_peliculas pp
ON p.id_personaje = pp.id_personaje
JOIN peliculas_series pe
ON pe.id_peli_series = pp.id_peli_series
WHERE pe.titulo = 'Harry Potter';








