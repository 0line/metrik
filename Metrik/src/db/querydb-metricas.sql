insert into metrica values (default,'Tasa de errores');
ALTER TABLE metrica ALTER COLUMN nom_metrica TYPE varchar(300);
insert into metrica values (default,'Eficacia de la eliminación de defectos');
insert into metrica values (default,'Madurez en casos de prueba');
insert into metrica values (default,'Facilidad de uso del sistema');
insert into metrica values (default,'Integridad');
insert into metrica values (default,'Adecuidad');
insert into metrica values (default,'Costo por cantidad de líneas de código');
insert into metrica values (default,'Índice de productividad del equipo de desarrollo');

INSERT INTO public.proyecto(
            id_proyecto, nom_proyecto, descripcion, objetivos, cliente, fecha_inicio, 
            fecha_fin, ciclo_vida, tecnologia, modelo_est, lider_proyecto, 
            lider_proyecto_c, tarifa, otros_costos)
    VALUES (Default,'Desarrollo de un sitio de comercio electrónico', 'descrupción', 'test insert', 'julian', '2017-03-11', 
            '2017-03-14', 5, 'Angular', 'lorem', 2,'jesus lozano','30000.00', '5000.00');

INSERT INTO public.proyecto(
            id_proyecto, nom_proyecto, descripcion, objetivos, cliente, fecha_inicio, 
            fecha_fin, ciclo_vida, tecnologia, modelo_est, lider_proyecto, 
            lider_proyecto_c, tarifa, otros_costos)
    VALUES (Default,'Desarrollo de una plataforma web', 'descripción', 'test insert', 'julian', '2017-03-11', 
            '2017-03-14', 5, 'Ionic', 'lorem', 2,'jesus lozano','30000.00', '5000.00');

 insert into proyecto_metrica values (2,1);
 insert into proyecto_metrica values (3,4);


 select nom_proyecto,nom_metrica from 
 proyecto p, proyecto_metrica pm, metrica m
 where pm.id_proyecto=p.id_proyecto and pm.id_metrica=m.id_metrica;

 select * from proyecto;
 select * from metrica;