

drop database if exists MaBase;

CREATE DATABASE MaBase;

USE Mabase;

-- créer la table Pays

drop table if exists Pays;

CREATE TABLE Pays
(
    idPays integer not null auto_increment,
    Pays varchar(20) NOT NULL UNIQUE,

    Primary Key (IdPays)
);


-- insérer des enregistrements
insert into Pays values (1, 'Pays 1');

-- ou, avec des insertions multiples:
insert into Pays values
                     (2, 'Pays 2'),
                     (3, 'Pays 3'),
                     (4, 'Pays 4'),
                     (8, 'Pays 8'),
                     (9, 'Pays 9');


-- créer la table Societes
drop table if exists Societes;

CREATE TABLE Societes
(
    idSociete varchar(10) Primary Key,
    Societe varchar(20) NOT NULL UNIQUE,
    idPays int -- REFERENCES Pays(IdPays)
);

CREATE PROCEDURE change_salary_and_responsable
(IN salary FLOAT, responsable_id INT, employe_id INT)
BEGIN
UPDATE employes
SET SalaireMensuel=salary, idResponsable=responsable_id
WHERE employes.idEmploye = employe_id;
END
