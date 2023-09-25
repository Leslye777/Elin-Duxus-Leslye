-- Inserção dos integrantes
INSERT INTO integrante (franquia, nome, funcao) VALUES ('NBA', 'Michael Jordan', 'ala');
INSERT INTO integrante (franquia, nome, funcao) VALUES ('NBA', 'Denis Rodman', 'ala-pivô');
INSERT INTO integrante (franquia, nome, funcao) VALUES ('NBA', 'Scottie Pippen', 'ala');

-- Inserção dos times
INSERT INTO time (data) VALUES ('1994-01-01');
INSERT INTO time (data) VALUES ('1995-01-01');
INSERT INTO time (data) VALUES ('1993-01-01');

-- Inserção da composição do Time Chicago Bulls de 1994
INSERT INTO composicao_time (time_id, integrante_id) VALUES (1, 1); -- Michael Jordan
INSERT INTO composicao_time (time_id, integrante_id) VALUES (1, 2); -- Denis Rodman
INSERT INTO composicao_time (time_id, integrante_id) VALUES (1, 3); -- Scottie Pippen

-- Inserção da composição do Time Chicago Bulls de 1995
INSERT INTO composicao_time (time_id, integrante_id) VALUES (2, 1); -- Michael Jordan
INSERT INTO composicao_time (time_id, integrante_id) VALUES (2, 2); -- Denis Rodman
INSERT INTO composicao_time (time_id, integrante_id) VALUES (2, 3); -- Scottie Pippen

-- Inserção da composição do Time Detroit Pistons de 1993
INSERT INTO composicao_time (time_id, integrante_id) VALUES (3, 2); -- Denis Rodman

