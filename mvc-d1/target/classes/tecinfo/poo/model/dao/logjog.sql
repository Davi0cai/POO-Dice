-- Table: public.logjog

DROP TABLE IF EXISTS public.logjog;

CREATE TABLE IF NOT EXISTS public.logjog
(
    id integer,
    wins integer
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.logjog
    OWNER to postgres;

	INSERT INTO logjog (id, wins) VALUES (1, 0);
	INSERT INTO logjog (id, wins) VALUES (2, 0);
	INSERT INTO logjog (id, wins) VALUES (3, 0);
	INSERT INTO logjog (id, wins) VALUES (4, 0);
	INSERT INTO logjog (id, wins) VALUES (5, 0);
	INSERT INTO logjog (id, wins) VALUES (6, 0);
	INSERT INTO logjog (id, wins) VALUES (7, 0);
	INSERT INTO logjog (id, wins) VALUES (8, 0);
	INSERT INTO logjog (id, wins) VALUES (9, 0);
	INSERT INTO logjog (id, wins) VALUES (10, 0);
	INSERT INTO logjog (id, wins) VALUES (11, 0);
	INSERT INTO logjog (id, wins) VALUES (12, 0);
