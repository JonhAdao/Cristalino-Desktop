CREATE DATABASE Manicure;

USE Manicure;

CREATE TABLE endereco(
id_endereco INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
rua VARCHAR(200) NOT NULL,
cep VARCHAR(10) DEFAULT NULL,
bairro VARCHAR(100) DEFAULT NULL,
numero INT(11) NOT NULL,
cidade VARCHAR(100) DEFAULT NULL,
estado VARCHAR(2) DEFAULT NULL
);

CREATE TABLE contato(
id_contato INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
email VARCHAR(200) NOT NULL,
celular VARCHAR(30) DEFAULT NULL,
instagram VARCHAR(100) DEFAULT NULL
); 


CREATE TABLE Procedimento (
idProcedimento int NOT NULL AUTO_INCREMENT PRIMARY KEY,
nomePr varchar(255) NOT NULL,
valor double(10,2) NOT NULL,
duracao varchar(50) NOT NULL,
descricao varchar(300)
); 


CREATE TABLE CorEsmalte (
idCorEsmalte int NOT NULL AUTO_INCREMENT PRIMARY KEY,
CoresDisponiveis varchar(255)
);


CREATE TABLE Pacotes (
idPacote int NOT NULL AUTO_INCREMENT PRIMARY KEY,
nomeP varchar(255) NOT NULL,
valor double(10,2) NOT NULL,
descricao text(500)
);

CREATE TABLE Horario (
id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
hora time NOT NULL
);


CREATE TABLE Usuarios (
idUsuario int NOT NULL AUTO_INCREMENT PRIMARY KEY,
nomeU varchar(255) UNIQUE NOT NULL,
login varchar(255) NOT NULL,
senha varchar(40) NOT NULL
);

CREATE TABLE Cliente (
idCliente int NOT NULL AUTO_INCREMENT PRIMARY KEY,
nome varchar(200) NOT NULL,
cpf varchar(11) UNIQUE NOT NULL,
rg varchar(15),
dataNasc date,
sexo varchar(45),
pacote_id int,
endereco_id int not null,
contato_id int,
observacao varchar(200),
atendimento int,
FOREIGN KEY (pacote_id) REFERENCES Pacotes(idPacote)  ON DELETE SET NULL ON UPDATE CASCADE,
FOREIGN KEY (endereco_id) REFERENCES endereco(id_endereco) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (contato_id) REFERENCES contato(id_contato) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Agendamento (
idAgendamento int NOT NULL AUTO_INCREMENT PRIMARY KEY,
cliente_id int NOT NULL,
procedimento_id int,
cor_esmalte_id int,
Data_Agendamento datetime NOT NULL,
frete double(10,2),
obs varchar(200),
FOREIGN KEY (cliente_id) REFERENCES Cliente (idCliente) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (procedimento_id) REFERENCES procedimento(idProcedimento) ON DELETE SET NULL ON UPDATE CASCADE,
FOREIGN KEY (cor_esmalte_id) REFERENCES coresmalte(idCorEsmalte) ON DELETE SET NULL ON UPDATE CASCADE
);
	    
INSERT INTO Horario (id, hora)
			VALUES  (1, '09:00:00'),
					(2, '09:30:00'),
					(3, '10:00:00'),
					(4, '10:30:00'),
					(5, '11:00:00'),
					(6, '11:30:00'),
					(7, '12:00:00'),
					(8, '13:00:00'),
					(9, '13:30:00'),
					(10, '14:00:00'),
					(11, '14:30:00'),
					(12, '15:00:00'),
					(13, '15:30:00'),
					(14, '16:00:00'),
					(15, '16:30:00'),
					(16, '17:00:00'),
					(17, '17:30:00'),
					(18, '18:00:00');

INSERT INTO usuarios (nomeU, login, senha)
			  VALUES ('Everton','everton', 'c99868052fb8a76e4f4b9f2ee67d39fb');
                     
INSERT INTO procedimento (nomePr, valor, duracao, descricao) 
				VALUES   ('Pé',35, '02h00', 'Deus eterno'),
						 ('Mão',30, '01h30', 'Deus Vivente'),
						 ('Mão e Pé',50, '03h00', 'Deus de Amor');

INSERT INTO coresmalte (CoresDisponiveis )
				VALUES ('Nude'),
					   ('Rosa'),
					   ('Vermelho');
            
INSERT INTO pacotes (nomeP, valor, descricao)
			VALUES	('Essencial',150 , 'Deus eterno'),
					('Preferido',300, 'Deus Vivente'),
					('Ideal',500, 'Deus de Amor');
                  
INSERT INTO endereco (rua, cep, bairro, numero, cidade, estado)
			VALUES	('Vale verde', '08414122', 'Jd Azul marinho', '23', 'São Paulo', 'SP'),
					('Travessa Eldorado', '08021577', 'Jd Maria Luiza', '33', 'São Paulo', 'SP'),
					('Recanto dos passaros', '08015123', 'Jd Lucinda', '43', 'São Paulo', 'SP');
                    
INSERT INTO contato (email, celular, instagram) 
			 VALUES ('jo@email.com','11998877645' , '@jo2025'),
					('carol@email.com','11995456765', '@carol'),
					('rosi@email.com',11987764534, '@rosi');
                    
                    
INSERT INTO Cliente (nome, cpf, rg, dataNasc, sexo, pacote_id, endereco_id, contato_id, observacao, atendimento)
	VALUES ('Jô','9877893453', '242343432', '1975/04/15','Feminino', 2 , 3, 1, 'Jesus Amigo', 3),
		   ('Carol','9877896783', '567643432', '1985/01/19','Feminino', 1 , 2, 3, 'Jesus Amigo', 2),
           ('Rosimeire','9845696783', '567873432', '1971/03/01','Feminino', 3 , 1, 2, 'Jesus Amigo', 5);
           
		
INSERT INTO agendamento (cliente_id, procedimento_id, cor_esmalte_id, Data_Agendamento, frete, obs)
					VALUES (3, 2, 1, '2024-07-29 9:00:00', 20.5, 'Deus amado'),
                           (2, 3, 2, '2024-07-30 10:30:00', 18.0, 'Deus Maravilhoso'),
                           (1, 1, 3, '2024-07-31 11:00:00',  19.0, 'Deus Eterno'),
                           (1, 1, 3, '2024-07-31 11:00:00',  19.0, 'Deus Eterno'),
                           (2, 1, 1, '2024-07-30 10:30:00', 18.0, 'Deus Maravilhoso'),
                           (1, 1, 3, '2024-07-31 11:00:00',  19.0, 'Deus Eterno'),
                           (3, 2, 1, '2024-07-29 9:00:00', 20.5, 'Deus amado'),
                           (3, 2, 1, '2024-07-29 9:00:00', 20.5, 'Deus amado'),
                           (3, 2, 1, '2024-07-29 9:00:00', 20.5, 'Deus amado'),
                           (3, 2, 1, '2024-07-29 9:00:00', 20.5, 'Deus amado');
             










