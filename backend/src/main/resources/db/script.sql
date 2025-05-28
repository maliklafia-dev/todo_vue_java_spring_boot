CREATE DATABASE todo;
-- Création de la table todos
CREATE TABLE IF NOT EXISTS todo (
                       id SERIAL PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       completed BOOLEAN DEFAULT FALSE
);

-- Insertion de quelques données de test
INSERT INTO todo (title, completed) VALUES
                                         ('Faire les courses', false),
                                         ('Appeler le médecin', false),
                                         ('Réviser pour l''examen', true),
                                         ('Faire du sport', false),
                                         ('Payer les factures', true);