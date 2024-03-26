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


CREATE TABLE Procedimento (
idProcedimento int NOT NULL AUTO_INCREMENT PRIMARY KEY,
nome varchar(255) NOT NULL,
valor decimal(9,2) NOT NULL
); 


CREATE TABLE CorEsmalte (
idCorEsmalte int NOT NULL AUTO_INCREMENT PRIMARY KEY,
CoresDisponiveis varchar(255)
);


CREATE TABLE Pacotes (
idPacote int NOT NULL AUTO_INCREMENT PRIMARY KEY,
nome varchar(255) NOT NULL,
valor decimal(9,2) NOT NULL,
descricao text(500),
data_atendimento datetime NOT NULL
);


CREATE TABLE Usuarios (
idUsuario int NOT NULL AUTO_INCREMENT PRIMARY KEY,
nome varchar(255) UNIQUE NOT NULL,
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



            
	 INSERT INTO Pacotes (nome,valor,descricao,data_atendimento)
	 VALUES ('Pacote Essencial',190.00,'Pacote promocional com 4 serviços de pé e mão com data limite,Pagamento em 1X','2022-08-25'),
			('Pacote Chique',330.00,'Pacote promocional com 8 serviços de pé e mão com data limite, pagamento em 2X','2022-09-25'),
			('Pacote Poderosa',210.00,'Pacote promocional com 2 serviços de pé e mão e 2 serviços de esmaltação em gel,com data limite, pagamento em 2X','2022-09-25'),
			('Pacote Rainha',350.00,'Pacote promocional com 2 serviços de Alogamento de fibra de vidro 
			 2 serviços de Spa dos pés 2 serviços de esmaltação simples,com data limite, pagamento em 2X','2022-09-25');

   
			
	 INSERT INTO Procedimento (nome,valor)
	 VALUES ('Pé',30.00),
			('Mão',30.00),
			('Pé e Mão',60.00),
			('Esmaltação simples',20.00),
			( 'Spa dos Pés',30.00),
			('Esmaltação em Gel',80.00),
			('Alongamento de fibra de vidro',150.00);
		
 
          
	INSERT INTO CorEsmalte (CoresDisponiveis)
	VALUES ('Vermelho'),('Rosa'),('Verde'),('Nude'),('Preto'),('Ouro Nude'),('Melissa'),('Tamara'),('Rose'),
			 ('Escarlate'),('Carmim'),('Amarelo'),('Rubi'),('Condesa'),('Cristal'),('Lavanda'),('Love');
			

                
                
         













