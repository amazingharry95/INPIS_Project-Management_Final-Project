drop table if exists ANAK;

drop table if exists ISTRI;

drop table if exists PERSONIL;

/*==============================================================*/
/* Table: ANAK                                                  */
/*==============================================================*/
create table ANAK
(
   ID_ANAK              int not null AUTO_INCREMENT,
   NRP                  varchar(10) not null,
   TANGGAL_LAHIR_ANAK   date,
   TEMPAT_LAHIR_ANAK    varchar(20),
   NAMA_ANAK            varchar(40),
   primary key (ID_ANAK)
);

/*==============================================================*/
/* Table: ISTRI                                                 */
/*==============================================================*/
create table ISTRI
(
   AGAMA_ISTRI          varchar(15),
   GOL_DARAH_ISTRI      varchar(2),
   ID_ISTRI             int not null AUTO_INCREMENT,
   NRP                  varchar(10) not null,
   KPI_ISTRI            varchar(20),
   KTA_JALASENASTRI     varchar(20),
   METODE_KB            varchar(10),
   PENDIDIKAN_TERAKHIR_ISTRI varchar(10),
   TEMPAT_LAHIR_ISTRI   varchar(3),
   NAMA_ISTRI           varchar(40),
   HOBBY1               varchar(30),
   HOBBY2               varchar(30),
   primary key (ID_ISTRI)
);

/*==============================================================*/
/* Table: PERSONIL                                              */
/*==============================================================*/
create table PERSONIL
(
   NRP                  varchar(10) not null,
   AGAMA_PERSONIL       varchar(75) not null,
   GOL_DARAH_PERSONIL   varchar(2) not null,
   JABATAN              varchar(100) not null,
   KORPS                varchar(5) not null,
   NAMA_PERSONIL        varchar(100) not null,
   NO_ASABRI            varchar(20) not null,
   NO_BPJS              varchar(15) not null,
   NO_KTA               varchar(20) not null,
   NO_NPWP              varchar(25) not null,
   NO_TELPON            varchar(15) not null,
   PANGKAT              varchar(30) not null,
   PENDIDIKAN_MILITER   varchar(15) not null,
   PENDIDIKAN_PENGEMBANG varchar(15),
   PENDIDIKAN_UMUM      varchar(5) not null,
   STATUS_KELUARGA      varchar(15) not null,
   STATUS_RUMAH         varchar(20) not null,
   TAMAT_JABATAN        date,
   TAMAT_TNI            date not null,
   TANGGAL_LAHIR_PERSONIL date not null,
   TEMPAT_LAHIR_PERSONIL varchar(25) not null,
   TMT_PANGKAT_PERTAMA  date,
   TMT_PANGKAT_TERAKHIR date,
   ALAMAT_PERSONIL      varchar(75),
   primary key (NRP)
);

alter table ANAK add constraint FK_MEMPUNYAI foreign key (NRP)
      references PERSONIL (NRP) on delete restrict on update restrict;

alter table ISTRI add constraint FK_MEMILIKI foreign key (NRP)
      references PERSONIL (NRP) on delete restrict on update restrict;
