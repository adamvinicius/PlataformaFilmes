INSERT INTO USUARIO(nome, email, senha) VALUES('Aluno', 'aluno@email.com', '$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq');
INSERT INTO USUARIO(nome, email, senha) VALUES('Moderador', 'moderador@email.com', '$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq');

INSERT INTO PLATAFORMA(descricao, nome, url) VALUES('Netflix e uma provedora global de filmes e series de televisao via streaming sediada em Los Gatos', 'NetFlix', 'www.netflix.com');
INSERT INTO PLATAFORMA(descricao, nome, url) VALUES('Prime Video, e um servico de video sob demanda pela Amazon disponivel em mais de 200 paises. Ele oferece programas de televisao e filmes para aluguel ou compra', 'Prime Videos', 'www.primevideo.com');

INSERT INTO FILME(descricao, duracao, nome) VALUES('The Platform e um filme espanhol de terror e ficcao cientifica de 2019 dirigido por Galder Gaztelu-Urrutia. O filme se passa em um grande Centro de Autogestao Vertical em estilo torre.', 1.34, 'O Poco');
INSERT INTO FILME(descricao, duracao, nome) VALUES('Frank Sheeran, O Irlandes, e um veterano de guerra cheio de condecoracoes. Ele aprendeu a matar servindo na Segunda Guerra Mundial e divide seu tempo entre os trabalhos de caminhoneiro e assassino de aluguel para a mafia', 3.30, 'O Irlandes');

INSERT INTO FILME(descricao, duracao, nome) VALUES('JJ e um insensivel agente da CIA que foi rebaixado de categoria e e enviado para espiar uma familia.', 1.40, 'Aprendiz de espia');
INSERT INTO FILME(descricao, duracao, nome) VALUES('Com seu suprimento de ar diminuindo constantemente, quatro jovens mergulhadoras precisam navegar por um labirinto subaquatico de cavernas claustrofobicas e tuneis misteriosos para escapar de grandes tubaroes brancos.', 1.30, 'Medo Profundo: O Segundo Ataque');

INSERT INTO FILME(descricao, duracao, nome) VALUES('Um homem que adora todas as coisas diabolicas, o supervilao Gru traca um plano para roubar a lua. Rodeado de um exercito de pequenos ajudantes e seu arsenal de armas e maquinas de guerra, Gru se prepara para destruir quem atravessar seu caminho.', 1.35, 'Meu Malvado Favorito');

INSERT INTO FILME_PLATAFORMA(filme_id, plataforma_id) VALUES(1,1);
INSERT INTO FILME_PLATAFORMA(filme_id, plataforma_id) VALUES(2,1);
INSERT INTO FILME_PLATAFORMA(filme_id, plataforma_id) VALUES(3,2);
INSERT INTO FILME_PLATAFORMA(filme_id, plataforma_id) VALUES(4,2);
INSERT INTO FILME_PLATAFORMA(filme_id, plataforma_id) VALUES(5,1);
INSERT INTO FILME_PLATAFORMA(filme_id, plataforma_id) VALUES(5,2);

INSERT INTO CATEGORIA(tipo) VALUES('Aventura');
INSERT INTO CATEGORIA(tipo) VALUES('Acao');
INSERT INTO CATEGORIA(tipo) VALUES('Terror');
INSERT INTO CATEGORIA(tipo) VALUES('Drama');
INSERT INTO CATEGORIA(tipo) VALUES('Comedia');
INSERT INTO CATEGORIA(tipo) VALUES('Sobrevivencia');
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

