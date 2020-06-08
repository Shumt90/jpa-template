create table CATALOG
(
    ID BINARY not null
        primary key,
    NAME VARCHAR(255),
    PARENT_ID BINARY,
    constraint FK_CATALOG_PARENT_ID
        foreign key (PARENT_ID) references CATALOG (ID)
);

create table PRODUCT
(
    ID BINARY not null
        primary key,
    NAME VARCHAR(255),
    CATALOG_ID BINARY,
    constraint FK_PRODUCT_CATALOG_ID
        foreign key (CATALOG_ID) references CATALOG (ID)
);



