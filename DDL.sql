CREATE TABLE public.books (
	book_id varchar NOT NULL,
	isbn varchar NULL,
	title varchar NULL,
	author varchar NULL,
	published_time date NULL,
	created_time timestamp DEFAULT now() NULL,
	modified_time timestamp NULL,
	CONSTRAINT books_pk PRIMARY KEY (book_id)
);

CREATE TABLE public.loan (
	end_date timestamp(6) NULL,
	loan_days varchar(255) NULL,
	start_date timestamp(6) NULL,
	status varchar(255) NULL,
	book_id varchar NULL,
	member_id varchar NULL
);


-- public.loan foreign keys

ALTER TABLE public.loan ADD CONSTRAINT loan_books_fk FOREIGN KEY (book_id) REFERENCES public.books(book_id);
ALTER TABLE public.loan ADD CONSTRAINT loan_member_fk FOREIGN KEY (member_id) REFERENCES public."member"(member_id);

CREATE TABLE public."member" (
	member_id varchar(255) NOT NULL,
	address varchar(255) NULL,
	dateofbirth timestamp(6) NULL,
	is_active bool NOT NULL,
	"name" varchar(255) NULL,
	valid_until timestamp(6) NULL,
	create_date timestamp DEFAULT now() NULL,
	modified_time timestamp NULL,
	CONSTRAINT member_pkey PRIMARY KEY (member_id)
);