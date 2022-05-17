--
-- PostgreSQL database cluster dump
--

SET default_transaction_read_only = off;

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;

--
-- Drop databases (except postgres and template1)
--

DROP DATABASE concursomusica;
DROP DATABASE concursomusicacompleto;




--
-- Drop roles
--

DROP ROLE postgres;


--
-- Roles
--

CREATE ROLE postgres;
ALTER ROLE postgres WITH SUPERUSER INHERIT CREATEROLE CREATEDB LOGIN REPLICATION BYPASSRLS PASSWORD 'SCRAM-SHA-256$4096:6N8VtmMy5TeakX/HPbQqAg==$JBseKua2m3l7IcRRmmpW9Kqs/4eOXF+TLOPQrnB8bOk=:g6DgPnq5qlAXcnIywvxe1mc7akt0gAaU78RN17xZzWI=';






--
-- Databases
--

--
-- Database "template1" dump
--

--
-- PostgreSQL database dump
--

-- Dumped from database version 14.0 (Debian 14.0-1.pgdg110+1)
-- Dumped by pg_dump version 14.0 (Debian 14.0-1.pgdg110+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

UPDATE pg_catalog.pg_database SET datistemplate = false WHERE datname = 'template1';
DROP DATABASE template1;
--
-- Name: template1; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE template1 WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'en_US.utf8';


ALTER DATABASE template1 OWNER TO postgres;

\connect template1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: DATABASE template1; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE template1 IS 'default template for new databases';


--
-- Name: template1; Type: DATABASE PROPERTIES; Schema: -; Owner: postgres
--

ALTER DATABASE template1 IS_TEMPLATE = true;


\connect template1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: DATABASE template1; Type: ACL; Schema: -; Owner: postgres
--

REVOKE CONNECT,TEMPORARY ON DATABASE template1 FROM PUBLIC;
GRANT CONNECT ON DATABASE template1 TO PUBLIC;


--
-- PostgreSQL database dump complete
--

--
-- Database "concursomusica" dump
--

--
-- PostgreSQL database dump
--

-- Dumped from database version 14.0 (Debian 14.0-1.pgdg110+1)
-- Dumped by pg_dump version 14.0 (Debian 14.0-1.pgdg110+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: concursomusica; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE concursomusica WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'en_US.utf8';


ALTER DATABASE concursomusica OWNER TO postgres;

\connect concursomusica

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: canciones; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.canciones (
    numcancion bigint NOT NULL,
    titulo text,
    duracion bigint,
    grupo bigint,
    votos bigint
);


ALTER TABLE public.canciones OWNER TO postgres;

--
-- Name: canciones_numcancion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.canciones_numcancion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.canciones_numcancion_seq OWNER TO postgres;

--
-- Name: canciones_numcancion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.canciones_numcancion_seq OWNED BY public.canciones.numcancion;


--
-- Name: grupos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.grupos (
    numgrupo bigint NOT NULL,
    nombregrupo text,
    localidad text,
    esgrupo bigint DEFAULT '1'::bigint,
    annoprimerdisco bigint,
    fechaprimerconcierto text
);


ALTER TABLE public.grupos OWNER TO postgres;

--
-- Name: grupos_numgrupo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.grupos_numgrupo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.grupos_numgrupo_seq OWNER TO postgres;

--
-- Name: grupos_numgrupo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.grupos_numgrupo_seq OWNED BY public.grupos.numgrupo;


--
-- Name: canciones numcancion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.canciones ALTER COLUMN numcancion SET DEFAULT nextval('public.canciones_numcancion_seq'::regclass);


--
-- Name: grupos numgrupo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.grupos ALTER COLUMN numgrupo SET DEFAULT nextval('public.grupos_numgrupo_seq'::regclass);


--
-- Data for Name: canciones; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.canciones (numcancion, titulo, duracion, grupo, votos) FROM stdin;
2	Copacabana	237	1	21
3	Mi Realidad	214	2	12
4	Evolucion	312	2	32
5	Mejor opción	261	6	16
6	Atraco	235	6	45
7	Un espectro más	267	6	2
8	Ballet Mental	246	3	21
9	Aquitania	263	3	3
10	Jovenes	212	5	7
11	Groenlandia	222	8	18
12	Monteperdido	227	8	25
13	Accederas	180	6	11
14	Oso Panda	167	11	23
15	Primera Vez	293	11	13
16	Rincón exquisito	270	10	4
17	No gires	159	4	0
18	Autocritica	192	17	21
19	Salvese quien Pueda	202	17	13
20	Copenhague	241	17	57
21	Al Respirar	156	17	12
22	Martes	261	22	20
23	La Divina Señal	325	22	30
24	Luz Artificial	257	18	6
25	Melodrama	393	18	2
26	Que Vienen	191	18	0
27	How to Turn Rivers into Alluminium Foil	258	19	0
28	8:24	241	19	22
29	Clouds Factory	323	19	10
30	Hallo	195	20	1
31	Con mi voz	205	20	12
32	El mundo se va a acabar	222	21	7
33	Titubeas	201	21	3
34	Cigarettes	147	13	0
35	Just Like A Wall	308	13	24
36	Palos y piedras	212	14	11
37	Bien por ti	285	14	61
38	Bailando	183	15	24
39	Todo nos parece una mierda	221	15	9
1	La mujer de verde	307	1	18
\.


--
-- Data for Name: grupos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.grupos (numgrupo, nombregrupo, localidad, esgrupo, annoprimerdisco, fechaprimerconcierto) FROM stdin;
1	Izal	Madrid	1	2010	2015-03-26
2	Lori Meyers	Loja	1	2004	2004-02-15
3	Cyan	Barcelona	1	2008	2008-12-01
4	Varry Brava	Murcia	1	2009	2008-02-21
5	Correos	San Sebastián	1	2009	2009-01-30
6	Full	Sevilla	1	2009	2009-11-28
7	Ellos	Madrid	1	2002	2002-04-27
8	Carlos Sadness	Barcelona	0	2011	2011-03-15
9	The Noises	Madrid	1	2010	2010-02-14
10	Second	Murcia	1	2000	1997-01-27
11	Papa Topo	Palma de Mallorca	1	2008	2008-06-23
12	Grises	Cestona (Guipuzcoa)	1	2009	2009-10-15
13	Russian Red	Madrid	0	2008	2008-06-20
14	Viva Suecia	Murcia	1	2013	2013-01-12
15	Astrud	Barcelona	1	1999	1998-11-20
16	Delorean	Zarauz	1	2000	1999-09-27
17	Vetusta Morla	Madrid	1	2000	2000-03-02
18	Kitai	Madrid	1	2011	2011-12-02
19	Rufus T Firefly	Madrid	1	2006	2006-05-07
20	Mabü	Bilbao	1	2009	2018-06-01
21	Pauline en la Playa	Gijón	1	1997	1997-08-05
22	Repion	Camargo	1	2014	2013-11-20
23	prueba	suances	1	2021	2021-01-01
\.


--
-- Name: canciones_numcancion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.canciones_numcancion_seq', 43, true);


--
-- Name: grupos_numgrupo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.grupos_numgrupo_seq', 23, true);


--
-- Name: grupos idx_16416_grupos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.grupos
    ADD CONSTRAINT idx_16416_grupos_pkey PRIMARY KEY (numgrupo);


--
-- Name: canciones idx_16424_canciones_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.canciones
    ADD CONSTRAINT idx_16424_canciones_pkey PRIMARY KEY (numcancion);


--
-- Name: canciones canciones_grupo_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.canciones
    ADD CONSTRAINT canciones_grupo_fkey FOREIGN KEY (grupo) REFERENCES public.grupos(numgrupo);


--
-- PostgreSQL database dump complete
--

--
-- Database "concursomusicacompleto" dump
--

--
-- PostgreSQL database dump
--

-- Dumped from database version 14.0 (Debian 14.0-1.pgdg110+1)
-- Dumped by pg_dump version 14.0 (Debian 14.0-1.pgdg110+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: concursomusicacompleto; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE concursomusicacompleto WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'en_US.utf8';


ALTER DATABASE concursomusicacompleto OWNER TO postgres;

\connect concursomusicacompleto

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: concursomusicacompleto; Type: DATABASE PROPERTIES; Schema: -; Owner: postgres
--

ALTER DATABASE concursomusicacompleto SET search_path TO 'public', 'concursomusica';


\connect concursomusicacompleto

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: canciones; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.canciones (
    id bigint NOT NULL,
    grupo bigint NOT NULL,
    duracion time without time zone NOT NULL,
    titulo character varying(40) NOT NULL
);


ALTER TABLE public.canciones OWNER TO postgres;

--
-- Name: canciones_numcancion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.canciones_numcancion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.canciones_numcancion_seq OWNER TO postgres;

--
-- Name: canciones_numcancion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.canciones_numcancion_seq OWNED BY public.canciones.id;


--
-- Name: componentes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.componentes (
    id bigint NOT NULL,
    nombre character varying(20) NOT NULL,
    apellidos character varying(40) NOT NULL,
    alias character varying(20) DEFAULT NULL::character varying,
    funcion character varying(30) DEFAULT NULL::character varying,
    grupo bigint NOT NULL
);


ALTER TABLE public.componentes OWNER TO postgres;

--
-- Name: componentes_idcomp_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.componentes_idcomp_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.componentes_idcomp_seq OWNER TO postgres;

--
-- Name: componentes_idcomp_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.componentes_idcomp_seq OWNED BY public.componentes.id;


--
-- Name: grupos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.grupos (
    id bigint NOT NULL,
    nombre character varying(30) NOT NULL,
    localidad character varying(20) NOT NULL,
    estilo character varying(20) NOT NULL,
    esgrupo boolean DEFAULT true NOT NULL,
    "añograbacion" integer,
    fechaestreno date,
    "compañia" character varying(35) DEFAULT NULL::character varying
);


ALTER TABLE public.grupos OWNER TO postgres;

--
-- Name: grupos_codgrupo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.grupos_codgrupo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.grupos_codgrupo_seq OWNER TO postgres;

--
-- Name: grupos_codgrupo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.grupos_codgrupo_seq OWNED BY public.grupos.id;


--
-- Name: usuarios; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuarios (
    usuario character varying(15) NOT NULL,
    password character varying(32) NOT NULL,
    nombre character varying(15) NOT NULL,
    apellidos character varying(30) NOT NULL,
    fechanacimiento date
);


ALTER TABLE public.usuarios OWNER TO postgres;

--
-- Name: votos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.votos (
    usuario character varying(15) NOT NULL,
    fecha date NOT NULL,
    cancion bigint NOT NULL
);


ALTER TABLE public.votos OWNER TO postgres;

--
-- Name: canciones id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.canciones ALTER COLUMN id SET DEFAULT nextval('public.canciones_numcancion_seq'::regclass);


--
-- Name: componentes id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.componentes ALTER COLUMN id SET DEFAULT nextval('public.componentes_idcomp_seq'::regclass);


--
-- Name: grupos id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.grupos ALTER COLUMN id SET DEFAULT nextval('public.grupos_codgrupo_seq'::regclass);


--
-- Data for Name: canciones; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.canciones (id, grupo, duracion, titulo) FROM stdin;
1	1	00:03:56	Cancion de cuna
2	1	00:02:57	Cientos y cientos
3	1	00:02:28	Un sueño
4	1	00:03:32	Jovenes
5	2	00:02:44	No gires
6	2	00:03:42	Calor
7	2	00:03:37	Ritual
8	2	00:02:39	Radioactivo
9	5	00:05:07	La mujer de verde
10	5	00:04:01	Qué bien
11	5	00:03:53	Copacabana
12	5	00:04:47	Pequeña Gran Revolución
13	3	00:04:06	Distintos
14	3	00:04:21	Mejor opción
15	3	00:03:55	Atraco
16	3	00:04:27	Un espectro más
17	9	00:03:10	Accederas
18	7	00:03:58	Qué electricidad
19	7	00:03:29	Perseide
20	7	00:03:42	Groenlandia
21	7	00:03:47	Monteperdido
22	4	00:04:06	Ballet Mental
23	4	00:04:23	Aquitania
24	4	00:03:34	Te deslizas
25	4	00:03:53	Turistas Heridos
26	10	00:04:30	Rincón exquisito
27	10	00:04:53	Primera Vez
28	10	00:05:02	Nivel Inexperto
29	10	00:06:03	Más Suerte
30	6	00:05:40	Zona vip
31	6	00:06:20	Diferentes
32	6	00:07:30	Tu primero
34	13	00:03:29	Emborracharme
35	13	00:03:34	Mi Realidad
36	15	00:03:32	Palos y piedras
37	15	00:06:45	Bien por ti
38	14	00:02:27	Cigarettes
39	14	00:05:08	Just Like A Wall
40	18	00:03:12	Autocritica
41	18	00:03:22	Salvese quien Pueda
42	18	00:04:01	Copenhague
43	18	00:02:36	Al Respirar
44	12	00:04:23	El hombre bolígrafo
45	12	00:04:36	Polaroid
46	12	00:03:52	Aspiradora Espacial
48	17	00:04:40	Deli
49	17	00:03:50	Real Love
50	17	00:04:33	Stay Close
51	17	00:04:27	Seasun
52	13	00:05:12	Evolucion
53	13	00:04:01	El Tiempo Pasará
54	16	00:02:23	Bailando
55	16	00:03:41	Todo nos parece una mierda
56	19	00:04:17	Luz Artificial
57	19	00:06:33	Melodrama
58	19	00:03:11	Que Vienen
59	20	00:04:18	How to Turn Rivers into Alluminium Foil
60	20	00:04:01	8:24
61	20	00:05:23	Clouds Factory
62	21	00:03:15	Hallo
63	21	00:03:25	Con mi voz
64	22	00:03:42	El mundo se va a acabar
65	22	00:03:21	Titubeas
66	23	00:02:54	Las flores
67	23	00:04:21	Martes
68	23	00:05:25	La Divina Señal
\.


--
-- Data for Name: componentes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.componentes (id, nombre, apellidos, alias, funcion, grupo) FROM stdin;
1	Javi	Fernandez	\N	Voz, piano, guitarra	4
2	Jordi 	Navarro	\N	Guitarra y electrónica	4
3	Guille	Mostaza	\N	Voz y guitarra	6
4	Santi 	Capote	\N	Bajo	6
5	Gorka 	Dresbaj	\N	Guitarra y electrónica	4
6	José 	Tejedor 	\N	Bajo	4
7	Sel 	 Lee	\N	Bateria	4
8	Javier	Valencia	\N	Vocalista	3
9	Jesús	Gutiérrez	\N	Bajo	3
11	Manu	Jurado	\N	Teclado	3
12	Enrique	Sanchís	Bubby	Guitarra	3
14	Fran	Gomez	\N	Vocalista	9
33	Alejandro 	Méndez	\N	Guitarra	13
39	Sean	Frutos	\N	Vocalista	10
40	Jorge	Guirao	\N	Guitarra	10
41	Javier	Vox	Javi	Guitarra y teclado	10
42	Fernando	Robles	Nando	Bajo	10
43	Francisco	Guirao	Fran	Batería	10
44	Óscar	Ferrer	\N	Vocalista	2
45	Aarön	Sáez	\N	Guitarra y teclados	2
46	Vicente	Llescas	\N	Guitarra	2
52	Antonio	Lomas	\N	Percusión	13
53	Miguel 	López	\N	Bajo Electrico	13
54	Alfredo	Nuñez	\N	Batería	13
55	Mikel	Izal	\N	Vocalista	5
56	Alejandro	Jordá	\N	Bateria	5
57	Emanuel	Perez	\N	Bajo eléctrico	5
58	Alberto	Perez	\N	Guitarra	5
59	Ivan	Mella	\N	Teclado	5
60	Amancay	Gaztañaga	\N	Vocalista	12
61	Eñaut	Gaztañaga	\N	Voz y guitarra	12
62	Raúl	Olaizola	\N	Bajo	12
64	Antonio	Diniz	\N	Batería	12
65	Alejandro	Orbegozo	\N	Sintetizadores	12
66	Michael	Martin	\N	Guitarra	13
67	Antonio	Lopez	\N	Guitarra	13
70	Arbona	Orero	Adria	Vocalista	11
71	Fandos	Berenguer	Julia	Vocalista	11
72	Huerta	Plaza	Oscar	Guitarra	11
73	Montoya	Barbera	Sonia	Bajo	11
80	Chuso	Ruiz	Chusi	Guitarra y coros	9
81	Rafa	Val	\N	Vocalista	15
82	Jess 	Fabric	\N	Bajo	15
83	Alberto 	Cantúa	\N	Guitarra	15
84	Fernando 	Campillo	\N	Bateria	15
88	Oliver	Ruiz	\N	Bateria	9
89	Lourdes	Hernandez	Russian Red	Voz y guitarra	14
90	Juan Pedro	Marti	pucho	Vocalista	18
91	Igor 	Escudero	\N	Guitarra	17
92	Guillermo	Astrain	\N	Bateria	17
93	Unai	Lazcano	\N	Bajo	17
94	Ekhi	Lopetegui	\N	Vocalista	17
95	David	Garcia	El Indio	Bateria Coros	18
96	Alvaro	Baglietto	\N	Bajo	18
97	Jorge	Gonzalez	\N	Percusion	18
98	Guillermo	Galvan	\N	Guitarra	18
99	Carlos 	Sadness	\N	Voz y guitarra	7
101	Manolo	Martínez	Lolo	Voz, guitarra y teclados	16
102	Genís	Segarra	Sega	Teclados, sintetizadores 	16
103	Victor	Cabezuelo	\N	Vocalista	20
104	Carlos 	Campos	\N	Guitarra	20
105	Julia	Martín	\N	Batería 	20
106	Sara	Oliveira	\N	Bajo	20
107	Alexander	Rusev	\N	Vocalista	19
108	Fab	Diaz	\N	Bajista	19
109	Edu	Argumosa	\N	Guitarrista	19
110	Deiv	Karanets	\N	Bateria	19
111	María	Blanco	\N	Voz y guitarra	21
112	Txarlie	Solano	\N	Bajo, teclados, coros	21
113	César	Uña	\N	Batería	21
114	Mar	Álvarez	\N	Vocalista	22
115	Alicia	Álvarez	\N	Bateria	22
116	Marina	Iñesta	\N	Voz y guitarra	23
117	Teresa	Iñesta	\N	Batería	23
118	Diego	García	\N	Bajo eléctrico	23
10	Jaime	Gutiérrez	\N	Batería	3
\.


--
-- Data for Name: grupos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.grupos (id, nombre, localidad, estilo, esgrupo, "añograbacion", fechaestreno, "compañia") FROM stdin;
1	Correos	San Sebastián	Indie	t	2009	2009-01-01	Neo Music Box
2	Varry Brava	Murcia	Pop	t	2005	2009-02-21	Hook Management
3	FULL	Sevilla	Indie	t	2003	2009-11-28	Warner Music Spain
4	Cyan	Barcelona	Pop Rock	t	2008	2008-12-01	BMG
5	IZAL	Madrid	Indie	t	2010	2015-03-26	Hook Ediciones Musicales
6	Ellos	Madrid	Indie	t	2002	2002-04-27	Subterfuge records
7	Carlos Sadness	Barcelona	Pop	f	2011	2011-03-05	Sony Music
9	The noises	Madrid	Pop Rock	t	2010	2010-02-14	Warner Music
10	Second	Murcia	Indie rock	t	2000	1997-01-27	DRO Atlantic
12	Grises	Cestona	Indie	t	2009	2009-10-15	Origami Records
13	Lori Meyers	Loja	Indie	t	2004	2004-02-15	Fernando Vacas
14	Russian Red	Madrid	Indie Pop	f	2008	2008-06-20	 Fernando Vacas
15	Viva Suecia	Murcia	Indie	t	2014	2013-01-01	Paco Román 
16	Astrud	Barcelona	Pop	t	1999	1999-11-20	\N
17	Delorean	Zarauz	Indie pop	t	2000	2001-09-27	Sony Music
18	Vetusta Morla	Madrid	Indie-Rock	t	2000	2000-03-02	Pequeño Salto Mortal
19	Kitai	Madrid	Indie	t	2011	2011-12-02	Remnant Light Studio
20	Rufus T. Firefly	Madrid	Rock alternativo	t	2006	2006-05-07	Lago naranja records
21	Mäbu	Bilbao	Pop-Rock-Indie-Folk	t	2009	2010-06-01	Warner Music Group
22	Pauline en la Playa	Gijón	Pop	t	1997	1997-08-05	Subterfuge Records
23	Repion	Camargo	pop-rock alternativo	t	2014	2013-11-20	\N
24	Annie B Sweet	Málaga	Indie-Pop-Folk	f	2009	2008-02-21	Subterfuge Records
25	La Casa Azul	Barcelona	Indie-Pop Electr.	f	2000	1999-08-29	Elefant Records
11	Papa topo	Torrelavega	Indie rock	t	2008	2008-06-23	Elefant records
\.


--
-- Data for Name: usuarios; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuarios (usuario, password, nombre, apellidos, fechanacimiento) FROM stdin;
02Ana	f547f0213884e47059f0532cfb7b487a	Ana	García Herrero	1999-02-06
02Elsa	843b683bf1595acbec44625fa9ddae8a	Elsa	Frutos Núñez	1989-02-23
02Eva	4a8ae230f04a9a2654c23d44ab735e5f	Eva	Alvarez Martinez	1991-08-04
02Pedro	39ff4c11837a042e9ae9643b32effffd	Pedro	Pancorvo Hidalgo	1996-03-03
03ez	cdaee254fb7b83270a4b9d685a98b721	Francisco	Freire Alonso	1993-07-25
03lemon	7352ff5b4fec51fb68a6396441dcfb56	Arturo	Abrines salas	1993-07-25
03pz	44ff4701208b0fcf888962d67f6d3b7f	Sean	Matthews	1993-07-25
03squeezy	8f18a704b30d520ea4aa5fd0c659b4c4	Sonia	Rey Ortega	1993-07-25
04CarlosLa	cc01164c660a136bcc638004d8ad2e4b	Carlos	Labra Mora	1996-02-10
05User2	841bcdd84b26f32c507e12b74b6c28fa	Carla	Anton Martinez	1996-12-09
05User3	b54ec2d5736bada5fca61b35fc5be640	Jonathan	Leon Suárez	1996-03-05
05User4	294f236f3e522a908c525372ac0d6830	Alfredo	Marco Roura	1993-08-30
10agallas	13fcf26f52485e878b24c213b2e64c90	Ágata	Cortés Valverde	1997-01-08
10asdffgh	b5467fe2156ee823cad4284d2e540178	Asumta	Serra Muntaner	1992-12-12
10messy10	b8914b921d6b3821a75457a658a49236	Laura	Gómez Cuenca	1990-01-15
10qwert	63eeaa4ca6e20fec38f80853d944148f	Esteban	Rodríguez Santiago	1990-12-12
11Epami	48db4ac24cbbd9bb614086b0a37cafbc	María	Labrador Revuelta	2016-01-12
11Eustaquio	4b72f236238c195bab0576b4c92df3c1	Eustaquio	García García	1990-01-08
11Fernando	ff54f1f60f352d05af42caa8f4bfabf3	Fernando	Fernández Huidobro	1997-01-09
11Jorge	acfe7abc161a46c7a7f4ad27863509db	Jorge	Diez Gil	1996-01-07
13Antonio	e8cb202890f5be032b34d3e3df8efeaf	Antonio	Fernandez Montes	1992-05-05
13Carlota	5947ad0cacd25041544def391c39e209	Carlota	Revuelta Herrero	1994-05-05
13Concepcion	6c8c1aa897fbc804ad30c8cd12571cb0	Concepcion	Cano Higuera	1980-05-18
13LourHerna	d9fc71a911eeabbbcc000542dbb55ab4	Lourdes 	Hernández González	1995-11-20
13Lucia	3c656b9550c332524b827172a47c333b	Lucia	Calderón García	1993-05-25
16Ana	e0d4ca35f46d3382df7a8e0a41b93a6c	Ana Patricia	Fernandez González	1999-05-12
16Carlos	0938aa921713474782108ab9c06ef214	Carlos	Labrador Amieva	1996-07-08
16Victor	57c5af8bd99f6bcac8d3cc53c5dee829	Victor	Bolado Suárez	1996-01-09
16Yeray	5c0f1d73ca1cd51c238bee7cb7b0583f	Yeray	Peña Sisniega	1996-09-11
17Campillo	8f04d51704e3f4795436b1f6976e3963	Fernando 	Campillo Jiménez	1990-07-25
17Cantua	424410672d762d92eb380cf308d34386	Alberto 	Cantúa Vitienes	1990-12-12
17Fabric	f8fe3d5c5028f1e35c7dd6f00ce191ac	Joshua	Benítez Díaz	1990-03-11
17Val	597ac7f72042dc70afb11e45bef72a83	Rafael	Val Mora	1990-05-03
18Dana	dc1abaa9273a13843858ceec7d052d51	Diana	Marín Lavín	1996-02-01
18Gama	b2a3210dded5e51a9ac57dea9d6931f0	Gema	López Villegas	1982-09-09
18Rana	1ca3f755f1213865bc97d5b55b0345de	Raquel	Martín Alba	1988-04-04
18Wala	83ca9bff4b8c0357966e0903792f9937	Guillermo	Ruíz Antolín	1992-03-03
19Carls	24aa140fea23bad3554989a87143b862	Carla	Bueno Martinez	1996-09-12
19Fresh	3403141a2675eb261272167d8beedb83	Alfredo	Ortega Fernández	1993-08-28
19Joni	5e0023b1492915f4fee5415d10a8406b	Jonathan	Moreno Lorenzo	1996-03-05
19Toñin	a56fdca29f5be52d73af7e80587af30e	Antonio	Gracia Saiz	1992-04-05
20Alberto	2a97cb9ae40c655f416f895c5222ea58	Alberto	Martínez Crespo	1997-07-16
20Ana	c9baaf75f712566d45d6378d2dc2ab15	Ana	Ruiz Abascal	1989-01-02
20Juan	f376256ba0f63b7251ca994d08306711	Juan	Rodríguez Ortiz	1995-08-28
20Luis	e74db70f1a47132075143d3c1f99c63a	Luis	López Cobo	1990-12-08
21Arm	90d60f1a743649502bc7e730f1dc0fc0	Armando	Blanco Diego	1968-02-26
21booom	cab3089229992a3109e38e514d739613	Blanca	Morales Alonso	1980-02-01
21Byron	231ad5da994fb710a82b478b875f9bb6	Byron	Ortiz Martín	1995-07-16
21meko	70a5c224e7d8f4ad20a5a66fcae73d02	Marta	Saiz Álvarez	1990-02-03
22Adolf	497c33e9484d4146ad2c8f2e10c689c0	Adolfo	Dìez Cobo	1975-07-19
22Eustaquio	490fa372b57a1391c9cf7e43b62b022d	Sara	Sainz Hernández	1995-02-18
22Hans	0a26fecd3f9fb4a61b71391441fad073	Andrea	Jiménez Blanco	1982-10-02
22Santa	9278a7371a04c2a1bd863d2a16459cd2	Santiago	Peña Diego	1990-04-02
24Boom	8c56459214e2386626bc6888bf3a9913	Elena	Crespo Abascal	1989-02-14
24Leia	18726e221adfbaa9e1cb72841461f0e5	Maria	Lavín Herrero	1999-05-12
24Mary	51d4b432d681e44a2c61df0f07a16954	Marta	Herrera Castillo	1998-01-27
24Pam	6380e4e12e39b0f0f1b70d20d177dfd2	Pamela	Muñoz Vega	1982-08-11
25Victor	ff9d6e6053f42eec4200c34eff522a86	Victor	Revuelta Puente	1989-03-01
26Fer	4f1f0423f5647ffa0bad46398dae22bf	Fernando	Sierra Torre	1992-05-08
26luc	2854228089f6cf198c23126e8693dd4b	Lucas	Cuesta Santamaría	1976-03-07
26Mart	9a5c7e2565498698986c7377a29a2793	Marta	Ibáñez Iglesias	1973-04-07
26Pe	20c6395b5330ca311cc4ba5304a05483	Pilar	San Emeterio Calderón	1996-03-15
27Daniel	60c75000480640d2ecd05a0934fe032b	Daniel	Tresgallo Ceballos	1990-04-12
27flynn	600992a3e0e881930330c88ea61132a5	Cristina	Cano Trueba	1981-06-24
27potter	3f9a1eb1df2be226faf947d2ed911c81	Harry	Bolado Arce	1980-07-31
27scott	81ee3f116510861c4da5a8148c5bb4a4	Alejandro	Moreno Merino	1994-08-17
28Adela	46dbfb8784aec7fe700ac7e97287b28b	Adela	Campo Pelayo	1994-04-30
28Esther	5a853ed536498442403e6a219b6b44a9	Esther	Diaz Perez	1990-02-23
28Raul	b8fb0ed7246dee55d647fea72c762bd8	Raul	Perez Prieto	1997-02-19
28Roberto	cf119943044c527460841de675315014	Roberto	Diaz Quintana	1993-02-12
29David	6bb890795c309c459d7fa4bdcf1b1092	David	Barquín Becerra	1994-03-12
30Rodrigo	b31306124ab266da76795168ac71eb8b	Rodrigo	Ramos Cuevas	1992-01-25
31juasRodrigo	9df9bab5749a406888413ee76f7483a4	Ramón	Calvo Maza	1994-09-17
AlRuiz01	b71c2091e8ce6251b96cee93006a7341	Alicia	Ruiz Villalba	1994-04-25
AnaArias01	4c537b49977267ac9e470212681e3bed	Ana	Arias Rodríguez	1998-07-24
DaLope01	08beda14c3a9431e6fa2e98503234cd7	David	Lopez Torcida	1998-10-04
ElBuzn01	c5a42972a85b3fcfa5baf5d1e5f19139	Elisa María	Buznego Martinez	1999-01-03
ElHier01	c8accbf49cf36b69b0160e0e2e1b0f9b	Elena	Hierro Arenas	1999-03-03
10yoli	7af0b590a0c557963f68b3afa813ae1b	Yolanda	Martínez Fernández	1992-12-12
\.


--
-- Data for Name: votos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.votos (usuario, fecha, cancion) FROM stdin;
02Ana	2018-10-21	1
10messy10	2018-10-22	1
11Eustaquio	2018-06-07	1
17Cantua	2018-05-28	1
26Fer	2018-05-27	1
27Daniel	2018-08-14	1
28Roberto	2018-10-13	1
02Ana	2018-06-05	2
03squeezy	2018-10-21	2
17Cantua	2018-10-21	2
20Alberto	2018-06-07	2
26Fer	2018-05-28	2
27Daniel	2018-06-03	2
05User2	2018-05-28	3
11Epami	2018-06-06	3
19Carls	2018-05-27	3
20Luis	2018-10-16	3
21booom	2018-10-16	3
26Fer	2018-05-29	3
27flynn	2018-10-13	3
11Eustaquio	2018-10-22	4
16Victor	2018-06-06	4
21Byron	2018-06-07	4
25Victor	2018-06-07	4
02Eva	2018-06-07	5
05User3	2018-10-23	5
16Ana	2018-06-20	5
16Victor	2018-06-05	5
20Ana	2018-06-08	5
28Esther	2018-10-13	5
22Eustaquio	2018-06-04	6
02Elsa	2018-10-21	7
20Luis	2018-05-27	7
22Adolf	2018-06-07	7
11Eustaquio	2018-06-05	8
13LourHerna	2018-10-20	8
ElHier01	2018-10-11	8
16Carlos	2018-06-06	9
11Jorge	2018-10-22	10
13LourHerna	2018-05-28	10
16Carlos	2018-06-07	10
21Arm	2018-10-16	10
24Mary	2018-10-14	10
26luc	2018-05-06	10
DaLope01	2018-10-12	11
02Eva	2018-05-29	12
16Carlos	2018-05-27	12
16Victor	2018-10-19	12
18Dana	2018-05-27	12
19Fresh	2018-05-29	13
22Adolf	2018-10-16	13
02Pedro	2018-10-24	14
20Alberto	2018-06-05	14
21meko	2018-10-16	14
24Boom	2018-10-15	14
02Elsa	2018-06-01	15
11Epami	2018-06-04	15
13Lucia	2018-06-07	15
17Fabric	2018-06-03	15
17Fabric	2018-08-14	15
20Ana	2018-06-09	15
26luc	2018-05-03	15
AnaArias01	2018-10-12	15
21Byron	2018-04-28	16
26Pe	2018-05-03	16
27scott	2018-10-13	17
17Fabric	2018-06-04	18
18Gama	2018-05-31	18
21Byron	2018-05-19	18
AlRuiz01	2018-10-12	18
02Elsa	2018-05-31	19
27flynn	2018-06-02	19
02Eva	2018-05-30	20
11Eustaquio	2018-06-04	20
13Carlota	2018-10-22	20
17Val	2018-06-06	20
17Val	2018-08-07	20
18Gama	2018-10-18	20
18Wala	2018-06-02	20
20Alberto	2018-06-06	20
26Fer	2018-08-07	20
27Daniel	2018-08-07	20
13Lucia	2018-10-20	22
18Rana	2018-05-31	22
26luc	2018-10-14	22
28Adela	2018-05-27	22
28Raul	2018-05-25	22
13Concepcion	2018-06-10	23
20Alberto	2018-10-17	23
28Adela	2018-07-08	23
18Dana	2018-10-18	24
21meko	2018-05-08	24
28Adela	2018-06-10	24
28Esther	2018-05-29	24
03lemon	2018-05-20	25
03pz	2018-05-20	25
10qwert	2018-10-22	25
13LourHerna	2018-05-29	25
17Val	2018-06-05	25
19Fresh	2018-05-28	25
22Hans	2018-05-28	25
27potter	2018-10-13	25
28Esther	2018-05-27	25
02Elsa	2018-10-24	26
22Eustaquio	2018-05-27	26
27Daniel	2018-06-02	26
10asdffgh	2018-10-23	27
13Lucia	2018-06-13	27
21Byron	2018-10-16	28
22Santa	2018-10-15	28
29David	2018-10-13	29
17Val	2018-06-07	30
24Boom	2018-06-07	30
24Mary	2018-06-07	30
21Byron	2018-05-27	31
21Byron	2018-06-03	31
21Byron	2018-08-14	31
24Leia	2018-05-28	31
24Boom	2018-05-07	32
05User4	2018-10-23	34
27flynn	2018-06-03	34
27flynn	2018-08-14	34
13Lucia	2018-06-04	35
13Concepcion	2018-06-03	36
13Concepcion	2018-08-14	36
30Rodrigo	2018-10-13	36
10agallas	2018-10-23	37
16Carlos	2018-10-19	37
19Joni	2018-10-17	37
20Ana	2018-10-17	37
05User2	2018-10-23	38
05User3	2018-05-10	38
13LourHerna	2018-06-07	38
05User2	2018-05-27	39
24Pam	2018-10-14	40
22Hans	2018-10-15	41
27Daniel	2018-06-05	42
28Adela	2018-10-13	42
28Raul	2018-10-13	42
19Toñin	2018-05-27	43
22Eustaquio	2018-10-15	43
ElBuzn01	2018-10-12	43
11Fernando	2018-10-22	44
19Carls	2018-10-17	44
03lemon	2018-10-24	45
22Adolf	2018-06-05	45
26Mart	2018-10-14	45
18Rana	2018-10-18	48
19Fresh	2018-05-27	50
03ez	2021-10-24	1
03ez	2021-10-25	9
03ez	2021-10-26	25
03ez	2021-10-27	30
24Leia	2018-10-14	50
03squeezy	2018-10-24	51
27Daniel	2018-10-13	52
02Eva	2018-10-24	53
13Antonio	2018-10-22	53
20Juan	2018-10-17	53
03pz	2018-10-24	54
04CarlosLa	2018-10-23	54
11Epami	2018-06-05	54
11Epami	2018-06-07	55
11Epami	2018-10-22	56
13Concepcion	2018-10-20	56
17Fabric	2018-10-18	56
19Toñin	2018-05-28	56
16Yeray	2018-10-19	57
19Toñin	2018-10-17	57
02Ana	2018-10-24	61
16Ana	2018-10-19	61
18Wala	2018-10-18	61
22Adolf	2018-06-02	61
13Carlota	2018-06-01	62
26Fer	2018-10-14	62
17Val	2018-10-18	63
19Fresh	2018-10-17	63
25Victor	2018-10-14	64
AnaArias01	2018-07-14	66
AnaArias01	2018-08-07	66
03lemon	2018-07-21	67
03pz	2018-07-21	67
03squeezy	2018-07-21	67
26Pe	2018-10-13	67
17Campillo	2018-10-19	68
17Cantua	2018-10-18	68
10yoli	2018-10-22	59
02Elsa	2018-10-31	9
03ez	2021-10-28	67
\.


--
-- Name: canciones_numcancion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.canciones_numcancion_seq', 68, true);


--
-- Name: componentes_idcomp_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.componentes_idcomp_seq', 118, true);


--
-- Name: grupos_codgrupo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.grupos_codgrupo_seq', 25, true);


--
-- Name: canciones idx_16447_primary; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.canciones
    ADD CONSTRAINT idx_16447_primary PRIMARY KEY (id);


--
-- Name: componentes idx_16453_primary; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.componentes
    ADD CONSTRAINT idx_16453_primary PRIMARY KEY (id);


--
-- Name: grupos idx_16460_primary; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.grupos
    ADD CONSTRAINT idx_16460_primary PRIMARY KEY (id);


--
-- Name: usuarios idx_16466_primary; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT idx_16466_primary PRIMARY KEY (usuario);


--
-- Name: votos idx_16469_primary; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.votos
    ADD CONSTRAINT idx_16469_primary PRIMARY KEY (usuario, fecha);


--
-- Name: idx_16447_fk_cancion_grupo; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idx_16447_fk_cancion_grupo ON public.canciones USING btree (grupo);


--
-- Name: idx_16453_fk_componente_grupo; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idx_16453_fk_componente_grupo ON public.componentes USING btree (grupo);


--
-- Name: idx_16460_indice_localidad_grupo; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idx_16460_indice_localidad_grupo ON public.grupos USING btree (localidad);


--
-- Name: idx_16469_fk_voto_cancion; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idx_16469_fk_voto_cancion ON public.votos USING btree (cancion);


--
-- Name: canciones fk_cancion_grupo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.canciones
    ADD CONSTRAINT fk_cancion_grupo FOREIGN KEY (grupo) REFERENCES public.grupos(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: componentes fk_componente_grupo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.componentes
    ADD CONSTRAINT fk_componente_grupo FOREIGN KEY (grupo) REFERENCES public.grupos(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: votos fk_votos_canciones; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.votos
    ADD CONSTRAINT fk_votos_canciones FOREIGN KEY (cancion) REFERENCES public.canciones(id) ON UPDATE CASCADE;


--
-- Name: votos votos_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.votos
    ADD CONSTRAINT votos_fk FOREIGN KEY (usuario) REFERENCES public.usuarios(usuario) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- PostgreSQL database dump complete
--

--
-- Database "postgres" dump
--

--
-- PostgreSQL database dump
--

-- Dumped from database version 14.0 (Debian 14.0-1.pgdg110+1)
-- Dumped by pg_dump version 14.0 (Debian 14.0-1.pgdg110+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE postgres;
--
-- Name: postgres; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'en_US.utf8';


ALTER DATABASE postgres OWNER TO postgres;

\connect postgres

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: DATABASE postgres; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- PostgreSQL database dump complete
--

--
-- PostgreSQL database cluster dump complete
--

