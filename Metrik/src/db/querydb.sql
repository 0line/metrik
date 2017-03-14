CREATE TABLE usuario(
	id_usuario SERIAL NOT NULL PRIMARY KEY,
	nom_usuario VARCHAR(20) NOT NULL,
	ape_pat VARCHAR(20) NOT NULL,
	ape_mat VARCHAR(20) NOT NULL,
	usuario VARCHAR(20) NOT NULL,
	password VARCHAR(20) NOT NULL,
	correo_e VARCHAR(50) NOT NULL,
	tipo_usuario VARCHAR(30) NOT NULL
);

INSERT INTO usuario(nom_usuario,ape_pat,ape_mat,usuario,password,correo_e,tipo_usuario) VALUES('Jorge','Madero','Morales','madero','madero1','madero@utcv.edu.mx','Lider SQA');
INSERT INTO usuario(nom_usuario,ape_pat,ape_mat,usuario,password,correo_e,tipo_usuario) VALUES('Roberto','Flores','Rosas','flores','flores1','flores@utcv.edu.mx','Miembro SQA');
INSERT INTO usuario(nom_usuario,ape_pat,ape_mat,usuario,password,correo_e,tipo_usuario) VALUES('Ernesto','Santillana','Torres','santillana','santillana1','santillana@utcv.edu.mx','Administrador');

CREATE TABLE proyecto(
	id_proyecto SERIAL NOT NULL PRIMARY KEY,
	nom_proyecto VARCHAR(100) NOT NULL,
	descripcion VARCHAR(200) NOT NULL,
	objetivos VARCHAR(200) NOT NULL,
	cliente VARCHAR(30) NOT NULL,
	fecha_inicio DATE NOT NULL,
	fecha_fin DATE NOT NULL,
	ciclo_vida VARCHAR(100) NOT NULL,
	tecnologia VARCHAR(100) NOT NULL,
	modelo_est VARCHAR(100) NOT NULL,
	lider_proyecto INT NOT NULL REFERENCES usuario(id_usuario) ON UPDATE CASCADE ON DELETE CASCADE,
	lider_proyecto_c VARCHAR(100) NOT NULL,
	tarifa FLOAT NOT NULL,
	otros_costos FLOAT NOT NULL
);

CREATE TABLE metrica(
	id_metrica SERIAL NOT NULL PRIMARY KEY,
	nom_metrica VARCHAR(20)
)

CREATE TABLE proyecto_metrica(
	id_proyecto INT NOT NULL REFERENCES proyecto ON UPDATE CASCADE ON DELETE CASCADE,
	id_metrica INT NOT NULL REFERENCES metrica ON UPDATE CASCADE ON DELETE CASCADE,
	PRIMARY KEY (id_proyecto, id_metrica)
)
