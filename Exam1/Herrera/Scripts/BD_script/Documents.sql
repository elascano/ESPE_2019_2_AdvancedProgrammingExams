PGDMP                     	    w            Avanzada    11.5    11.5 
               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false                       1262    16393    Avanzada    DATABASE     �   CREATE DATABASE "Avanzada" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Ecuador.1252' LC_CTYPE = 'Spanish_Ecuador.1252';
    DROP DATABASE "Avanzada";
             postgres    false            �            1259    24591    Products    TABLE     �   CREATE TABLE public."Products" (
    prod_id integer NOT NULL,
    prod_name character varying(50) NOT NULL,
    prod_descripcion character varying(50) NOT NULL,
    prod_stock integer NOT NULL,
    prod_price double precision
);
    DROP TABLE public."Products";
       public         postgres    false            �            1259    16394    Student    TABLE     �   CREATE TABLE public."Student" (
    name_stu character varying(30) NOT NULL,
    lastname_stu character varying(30) NOT NULL,
    cedula_stu character varying(10) NOT NULL
);
    DROP TABLE public."Student";
       public         postgres    false            �
          0    24591    Products 
   TABLE DATA               b   COPY public."Products" (prod_id, prod_name, prod_descripcion, prod_stock, prod_price) FROM stdin;
    public       postgres    false    197   .
       �
          0    16394    Student 
   TABLE DATA               G   COPY public."Student" (name_stu, lastname_stu, cedula_stu) FROM stdin;
    public       postgres    false    196   �
       �
           2606    24598    Products Products_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public."Products"
    ADD CONSTRAINT "Products_pkey" PRIMARY KEY (prod_id);
 D   ALTER TABLE ONLY public."Products" DROP CONSTRAINT "Products_pkey";
       public         postgres    false    197            �
           2606    16398    Student Student_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public."Student"
    ADD CONSTRAINT "Student_pkey" PRIMARY KEY (cedula_stu);
 B   ALTER TABLE ONLY public."Student" DROP CONSTRAINT "Student_pkey";
       public         postgres    false    196            �
   w   x�Uʱ
�0���ܧ�	B{QGqp:�ˡ����T�>�A����1�K"�Gt*慙8V˥Q����e�>qf.h6�_�t���:�wG�ɪ1m�ρ�1��\�?Ba7'"o@�&�      �
   !   x�s/���I-����H-*J-J�4����� s5o     