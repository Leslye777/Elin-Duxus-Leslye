-- Inserts para a tabela Time
INSERT INTO time (data) VALUES ('2023-09-25');
INSERT INTO time (data) VALUES ('2023-09-20');
INSERT INTO time (data) VALUES ('2023-09-30');

-- Inserts para a tabela Integrante
INSERT INTO integrante (franquia, nome, funcao) VALUES ('Franquia 1', 'Alice', 'Função 1');
INSERT INTO integrante (franquia, nome, funcao) VALUES ('Franquia 2', 'Bob', 'Função 2');
INSERT INTO integrante (franquia, nome, funcao) VALUES ('Franquia 3', 'Carol', 'Função 3');

-- Inserts para a tabela ComposicaoTime (relacionando Integrantes e Times)
INSERT INTO composicao_time (time_id, integrante_id) VALUES (1, 1); -- Alice no Time 1
INSERT INTO composicao_time (time_id, integrante_id) VALUES (2, 2); -- Bob no Time 2
INSERT INTO composicao_time (time_id, integrante_id) VALUES (3, 3); -- Carol no Time 3
INSERT INTO composicao_time (time_id, integrante_id) VALUES (1, 2); -- Bob no Time 1
