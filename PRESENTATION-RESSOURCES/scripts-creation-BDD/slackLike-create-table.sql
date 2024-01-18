CREATE TABLE IF NOT EXISTS users(
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    nickname VARCHAR(50) NOT NULL,
    status INTEGER NOT NULL
    );
	

CREATE TABLE IF NOT EXISTS channels(
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    creation_date TIMESTAMP NOT NULL,
    status INTEGER NOT NULL
    );

	
CREATE TABLE IF NOT EXISTS messages (
	id SERIAL PRIMARY KEY,
    message VARCHAR(255) NOT NULL,
	date_message TIMESTAMP,
	channel_id_fk integer REFERENCES channels(id) ON DELETE SET NULL,
	user_id_fk integer REFERENCES users(id) ON DELETE SET NULL,
    status INTEGER NOT NULL
	);