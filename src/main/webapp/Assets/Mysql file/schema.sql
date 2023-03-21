CREATE DATABASE `trainease` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */



create table domaine
(
    code_domaine int auto_increment
        primary key,
    libelle      text null
);

create table formateur
(
    nom            char(250) null,
    prenom         char(250) null,
    code_formateur int auto_increment
        primary key,
    email          char(250) not null,
    telephone      int       null
);

create table formation
(
    code_formation      int auto_increment
        primary key,
    intitule            text null,
    nombre_jours        int  null,
    annee               int  null,
    mois                int  null,
    nombre_participants int  null,
    code_formateur      int  null,
    code_domaine        int  null,
    constraint formation_domaine_null_fk
        foreign key (code_domaine) references domaine (code_domaine),
    constraint formation_formateur_null_fk
        foreign key (code_formateur) references formateur (code_formateur)
);

create table profil
(
    code_profil int auto_increment
        primary key,
    libelle     text null
);

create table participant
(
    matricule_participant int auto_increment
        primary key,
    nom                   char(250) null,
    prenom                char(250) null,
    date_naissance        char(200) null,
    code_profil           int       null,
    constraint participant_profil_fk
        foreign key (code_profil) references profil (code_profil)
);

create table formation_participant
(
    code_formation        int                                not null,
    matricule_participant int                                not null,
    date_inscription      datetime default CURRENT_TIMESTAMP null,
    primary key (matricule_participant, code_formation),
    constraint formation_participant_formation_null_fk
        foreign key (code_formation) references formation (code_formation),
    constraint formation_participant_participant_null_fk
        foreign key (matricule_participant) references participant (matricule_participant)
);

create table role
(
    code_role int auto_increment
        primary key,
    libelle   text null
);

create table utilisateur
(
    code_utilisateur int auto_increment
        primary key,
    email            char(250) not null,
    password         text      not null,
    code_role        int       not null,
    constraint utilisateur_role_fk
        foreign key (code_role) references role (code_role)
);