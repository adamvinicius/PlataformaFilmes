INSERT INTO USUARIO(nome, email, senha) VALUES('Aluno', 'aluno@email.com', '$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq');
INSERT INTO USUARIO(nome, email, senha) VALUES('Moderador', 'moderador@email.com', '$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq');

INSERT INTO PLATAFORMA(descricao, nome, url) VALUES('Netflix é uma provedora global de filmes e séries de televisão via streaming sediada em Los Gatos', 'NetFlix', 'www.netflix.com');
INSERT INTO PLATAFORMA(descricao, nome, url) VALUES('Prime Video, é um serviço de vídeo sob demanda pela Amazon disponível em mais de 200 países. Ele oferece programas de televisão e filmes para aluguel ou compra', 'Prime Videos', 'www.primevideo.com');

INSERT INTO FILME(descricao, duracao, nome) VALUES('The Platform é um filme espanhol de terror e ficção científica de 2019 dirigido por Galder Gaztelu-Urrutia. O filme se passa em um grande Centro de Autogestão Vertical em estilo torre.', 1.34, 'O Poço');
INSERT INTO FILME(descricao, duracao, nome) VALUES('Frank Sheeran, O Irlandês, é um veterano de guerra cheio de condecorações. Ele aprendeu a matar servindo na Segunda Guerra Mundial e divide seu tempo entre os trabalhos de caminhoneiro e assassino de aluguel para a máfia', 3.30, 'O Irlandês');

INSERT INTO FILME(descricao, duracao, nome) VALUES('JJ é um insensível agente da CIA que foi rebaixado de categoría e é enviado para espiar uma familia.', 1.40, 'Aprendiz de espiã');
INSERT INTO FILME(descricao, duracao, nome) VALUES('Com seu suprimento de ar diminuindo constantemente, quatro jovens mergulhadoras precisam navegar por um labirinto subaquático de cavernas claustrofóbicas e túneis misteriosos para escapar de grandes tubarões brancos.', 1.30, 'Medo Profundo: O Segundo Ataque');

INSERT INTO FILME(descricao, duracao, nome) VALUES('Um homem que adora todas as coisas diabólicas, o supervilão Gru traça um plano para roubar a lua. Rodeado de um exército de pequenos ajudantes e seu arsenal de armas e máquinas de guerra, Gru se prepara para destruir quem atravessar seu caminho.', 1.35, 'Meu Malvado Favorito');

INSERT INTO FILME_PLATAFORMA(filme_id, plataforma_id) VALUES(1,1);
INSERT INTO FILME_PLATAFORMA(filme_id, plataforma_id) VALUES(2,1);
INSERT INTO FILME_PLATAFORMA(filme_id, plataforma_id) VALUES(3,2);
INSERT INTO FILME_PLATAFORMA(filme_id, plataforma_id) VALUES(4,2);
INSERT INTO FILME_PLATAFORMA(filme_id, plataforma_id) VALUES(5,1);
INSERT INTO FILME_PLATAFORMA(filme_id, plataforma_id) VALUES(5,2);

INSERT INTO CATEGORIA(tipo) VALUES('Aventura');
INSERT INTO CATEGORIA(tipo) VALUES('Ação');
INSERT INTO CATEGORIA(tipo) VALUES('Terror');
INSERT INTO CATEGORIA(tipo) VALUES('Drama');
INSERT INTO CATEGORIA(tipo) VALUES('Comédia');
INSERT INTO CATEGORIA(tipo) VALUES('Sobrevivência');
INSERT INTO CATEGORIA(tipo) VALUES('Crime');
INSERT INTO CATEGORIA(tipo) VALUES('Thriller');

INSERT INTO FILME_CATEGORIA(categoria_id, filme_id) VALUES(3,1);
INSERT INTO FILME_CATEGORIA(categoria_id, filme_id) VALUES(4,2);
INSERT INTO FILME_CATEGORIA(categoria_id, filme_id) VALUES(2,3);
INSERT INTO FILME_CATEGORIA(categoria_id, filme_id) VALUES(1,4);
INSERT INTO FILME_CATEGORIA(categoria_id, filme_id) VALUES(6,4);
INSERT INTO FILME_CATEGORIA(categoria_id, filme_id) VALUES(7,2);
INSERT INTO FILME_CATEGORIA(categoria_id, filme_id) VALUES(8,1);
INSERT INTO FILME_CATEGORIA(categoria_id, filme_id) VALUES(5,5);
INSERT INTO FILME_CATEGORIA(categoria_id, filme_id) VALUES(1,5);

