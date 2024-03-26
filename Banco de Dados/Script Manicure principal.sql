CREATE DATABASE Manicure;

USE Manicure;

CREATE TABLE Cliente (
idCliente int NOT NULL AUTO_INCREMENT PRIMARY KEY,
nome varchar(200) NOT NULL,
cpf varchar(11) UNIQUE NOT NULL,
rg varchar(15) UNIQUE,
email varchar(45) UNIQUE,
celular varchar(45) UNIQUE NOT NULL,
pacote_id int,
endereco_id int not null,
FOREIGN KEY (pacote_id) REFERENCES Pacotes(idPacote),
FOREIGN KEY (endereco_id) REFERENCES endereco(id_endereco)
);

 CREATE TABLE endereco(
    id_endereco INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    rua VARCHAR(200) NOT NULL,
    cep VARCHAR(10) DEFAULT NULL,
    bairro VARCHAR(100) DEFAULT NULL,
    numero INT(11) NOT NULL,
    cidade VARCHAR(100) DEFAULT NULL,
    estado VARCHAR(2) DEFAULT NULL
    );


CREATE TABLE Procedimento (
idProcedimento int NOT NULL AUTO_INCREMENT PRIMARY KEY,
nomePr varchar(255) NOT NULL,
valor decimal(9,2) NOT NULL,
duracao time NOT NULL
); 


CREATE TABLE CorEsmalte (
idCorEsmalte int NOT NULL AUTO_INCREMENT PRIMARY KEY,
CoresDisponiveis varchar(255)
);


CREATE TABLE Pacotes (
idPacote int NOT NULL AUTO_INCREMENT PRIMARY KEY,
nomeP varchar(255) NOT NULL,
valor double(10,2) NOT NULL,
descricao text(500),
data_atendimento datetime NOT NULL
);


CREATE TABLE Usuarios (
idUsuario int NOT NULL AUTO_INCREMENT PRIMARY KEY,
nomeU varchar(255) UNIQUE NOT NULL,
login varchar(255) NOT NULL,
senha varchar(40) NOT NULL
);



CREATE TABLE Agendamento (
idAgendamento int NOT NULL AUTO_INCREMENT PRIMARY KEY,
cliente_id int NOT NULL,
procedimento_id int NOT NULL,
cor_esmalte_id int NOT NULL,
Data_Agendamento datetime NOT NULL,
horario time NOT NULL,
frete double(10,2),
observacao varchar(200),
FOREIGN KEY (cliente_id) REFERENCES Cliente (idCliente),
FOREIGN KEY (procedimento_id) REFERENCES procedimento(idProcedimento),
FOREIGN KEY (cor_esmalte_id) REFERENCES coresmalte(idCorEsmalte)
);



            
	 INSERT INTO Pacotes (nomeP,valor,descricao,data_atendimento)
	 VALUES ('Pacote Essencial',190.00,'Pacote promocional com 4 serviços de pé e mão com data limite,Pagamento em 1X','2022-08-25'),
			('Pacote Chique',330.00,'Pacote promocional com 8 serviços de pé e mão com data limite, pagamento em 2X','2022-09-25'),
			('Pacote Poderosa',210.00,'Pacote promocional com 2 serviços de pé e mão e 2 serviços de esmaltação em gel,com data limite, pagamento em 2X','2022-09-25'),
			('Pacote Rainha',350.00,'Pacote promocional com 2 serviços de Alogamento de fibra de vidro 
			 2 serviços de Spa dos pés 2 serviços de esmaltação simples,com data limite, pagamento em 2X','2022-09-25');
    
    INSERT INTO endereco (id_endereco, rua, cep, bairro, numero, cidade, estado) 
			 VALUES (1,  'Joaquim Simões','83314010', 'Jardim Tropical', 120 , ' Piraquara', 'PR' ),
					(2, 'Terezina', ' 83314060', 'Jardim Tropical', 234 , 'Piraquara', 'PR' ),
					(3, 'Iguatu', '83314080', 'Jardim Tropical',  25 , 'Piraquara', 'PR' ),
					(4, 'Carlos Chagas', ' 83314020', 'Jardim Tropical',  123 , 'Piraquara', 'PR' );
   
	 INSERT INTO Procedimento (nomePr,valor,duracao)
	 VALUES ('Pé',30.00 ,'00h30'),
			('Mão',30.00 ,'01h00'),
			('Pé e Mão',60.00 ,'00h30'),
			('Esmaltação simples',20.00 ,'00h30'),
			( 'Spa dos Pés',30.00 ,'01h00'),
			('Esmaltação em Gel',80.00 ,'01h30'),
			('Alongamento de fibra de vidro',150.00 ,'02h00');
            
	INSERT INTO Usuarios (nomeU, login, senha)
		          VALUES ('Jonathan','jonh', '1234567'),
						 ('Karolyne', 'karu', '891011');
		 
	INSERT INTO CorEsmalte (CoresDisponiveis)
	VALUES ('Vermelho'),('Rosa'),('Verde'),('Nude'),('Preto'),('Ouro Nude'),('Melissa'),('Tamara'),('Rose'),
			 ('Escarlate'),('Carmim'),('Amarelo'),('Rubi'),('Condesa'),('Cristal'),('Lavanda'),('Love');
			

	INSERT INTO agendamento (cliente_id, procedimento_id, cor_esmalte_id, Data_Agendamento, horario, frete, observacao)
					VALUES (10, 7, 12, '2024-02-10 17:01:20', '18:01:20', 20.5, 'Deus amado'),
                           (12, 3, 11, '2024-01-09 19:00:00', '12:00:10', 18.0, 'Deus Maravilhoso');
                
         













