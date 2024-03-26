

Delete from empresa where id > 0;

alter table empresa auto_increment = 0;

 CREATE TABLE `funcionario` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `nomefunc` varchar(100) NOT NULL,
    `empresaid` int(11) NOT NULL,
  PRIMARY KEY (id)
  );
  
  ALTER TABLE `funcionario` ADD CONSTRAINT `fk_empresa` FOREIGN KEY (`empresaid`) REFERENCES `empresa`(`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
  
  select* from funcionario;
  
  ALTER TABLE funcionario ADD admissao date;
  
  select* from funcionario;
  SELECT* FROM empresa;

  delete from filmes where id >0;
  
  Alter table filmes auto_increment = 0;
  
  select* from filmes;
  
  select* from pacotes;
  
  select* from usuario;
  
  select* from horario;
  
  select* from PROCEDIMENTO;
  
  SELECT* FROM cliente;
  SELECT* FROM pacotes;
  SELECT* FROM endereco;
  
  INSERT INTO Cliente (nome, cpf, rg, email, celular, Pacote_id, endereco_id)
	VALUES ('Jô','9877893453', '242343432', 'josiane.freitas@gmail.com','(11) 984237681', null, 4),
		   ('Rosana', '5679024678', '838787483','rosanadeandrade@gmail.com','(11) 956789234', null, 1),
		   ('Renata',' 6789459213','776575676', 'renatadeandrade@outlook.com','(11) 974356782',2,3 ),
		   ('Leticia','8387163786','65675875', 'leticiamaria124@outlook.com','(11) 945789265',1, 2);
           
           INSERT INTO `endereco` (`id_endereco`, `rua`, `cep`, `bairro`, `numero`, `cidade`, `estado`) VALUES
					(1,  'Joaquim Simões','83314010', 'Jardim Tropical', 120 , ' Piraquara', 'PR' ),
					(2, 'Terezina', ' 83314060', 'Jardim Tropical', 234 , 'Piraquara', 'PR' ),
					(3, 'Iguatu', '83314080', 'Jardim Tropical',  25 , 'Piraquara', 'PR' ),
					(4, 'Carlos Chagas', ' 83314020', 'Jardim Tropical',  123 , 'Piraquara', 'PR' );
		 
				INSERT INTO Usuarios (nomeU, login, senha)
					VALUES ('Jonathan','jonh', '1234567'),
						   ('Karolyne', 'karu', '891011');
                           
                           select* from usuarios;
                           
                           select* from agendamento;
                           
                           select* from orcamento;
                           
                           select* from coresmalte;	
                           
                           drop table cliente_coresmalte;
                           
                           drop table cliente_procedimento;
                           
                           drop table empresa;
                           
					
  
  SELECT *, nomeP FROM cliente LEFT JOIN pacotes ON Pacote_id = idPacote;
  
  alter table procedimento add column duracao time NOT NULL;
  alter table procedimento modify column duracao varchar(50) NOT NULL;
  
  alter table cliente_procedimento drop foreign key cliente_procedimento_ibfk_1;
  alter table cliente_procedimento drop foreign key cliente_procedimento_ibfk_2;
  alter table cliente_coresmalte drop foreign key cliente_coresmalte_ibfk_1;
  alter table cliente_coresmalte drop foreign key cliente_coresmalte_ibfk_2;
  
  alter table cartao_credito drop foreign key cartao_credito_ibfk_1;
  
  alter table agendamento drop column Cliente_CorEsmalte_id; 
  alter table cliente add column endereco_id int NOT NULL ;
  alter table cliente add CONSTRAINT fk_endereco_id  foreign key (endereco_id) references endereco(id_endereco);
  
  select* from procedimento;
  alter table procedimento auto_increment = 1;
  delete from procedimento where idProcedimento > 1;
  
  update procedimento set duracao = '00h30' where idProcedimento = 1;
  update procedimento set duracao = '01h00' where idProcedimento = 2;
  update procedimento set duracao = '00h30' where idProcedimento = 3;
  update procedimento set duracao = '00h30' where idProcedimento = 4;
  update procedimento set duracao = '01h30' where idProcedimento = 5;
  update procedimento set duracao = '02h00' where idProcedimento = 6;
  
 CREATE TABLE endereco(
    id_endereco INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    rua VARCHAR(200) NOT NULL,
    cep VARCHAR(10) DEFAULT NULL,
    bairro VARCHAR(100) DEFAULT NULL,
    numero INT(11) NOT NULL,
    cidade VARCHAR(100) DEFAULT NULL,
    estado VARCHAR(2) DEFAULT NULL
    );  
    
desc endereco;
desc cliente;
  
  SELECT idCliente, nome, cpf, rg, celular, email,
         endereco_id, id_endereco, rua, cep, bairro, numero, cidade, estado, idPacote, nomeP, valor, descricao
         FROM cliente LEFT JOIN endereco ON endereco_id = id_endereco LEFT JOIN pacotes ON pacote_id = idPacote;
         
         select* from pacotes;
         select* from agendamento;
         select* from cliente;
         select* from procedimento;
         select* from coresmalte;
         select* from endereco;
         
         select* from horario;
         select* from usuarios;
         
         
         
         alter table pacotes drop column data_atendimento; 
         
         INSERT INTO agendamento (cliente_id, procedimento_id, cor_esmalte_id, Data_Agendamento, horario, frete, observacao)
					VALUES (10, 7, 12, '2024-02-18 17:00:00', '18:00:00', 20.5, 'Deus amado'),
                           (12, 3, 11, '2024-01-19 19:00:00', '12:00:00', 18.0, 'Deus Maravilhoso'),
                           (11, 8, 10, '2024-03-20 9:00:00', '14:00:00', 19.0, 'Deus Eterno'),
						   (9, 5, 3, '2024-03-20 10:00:00', '16:00:00', 19.0, 'Deus Misericordioso'),
                           (12, 14, 1, '2024-03-20 9:30:00', '16:00:00', 180.0, 'Deus Amado'),
                           (9, 11, 2, '2024-03-20 18:00:00', '16:00:00', 190.0, 'Deus Rei'),
                           (9, 8, 11, '2024-03-20 17:00:00', '16:00:00', 200.0, 'Deus Senhor dos Céus'),
						   (10, 9, 6, '2024-02-18 17:00:00', '18:00:00', 200.5, 'Deus amado'),
                           (12, 11, 10, '2024-04-19 19:00:00', '12:00:00', 180.0, 'Deus Maravilhoso'),
                           (11, 13, 14, '2024-05-20 9:00:00', '14:00:00', 25.0, 'Deus Eterno'),
						   (9, 12, 5, '2024-06-20 10:00:00', '16:00:00', 160.0, 'Deus Misericordioso');
                           
         SELECT a.idAgendamento, c.idCliente, c.nome, p.nomePr, co.coresdisponiveis, e.rua, e.numero,
            a.Data_Agendamento, a.horario,a.frete, a.observacao 
            FROM agendamento a JOIN cliente c ON c.idCliente = a.cliente_id 
            JOIN procedimento p ON p.idProcedimento = a.procedimento_id 
            JOIN coresmalte co ON co.idCorEsmalte = a.cor_esmalte_id 
            JOIN endereco e ON c.endereco_id = id_endereco 
            WHERE a.data_agendamento > 0;
            
            
            
						   
          alter table procedimento modify valor double(10,2) not null;
          
          update agendamento set data_agendamento = "2024-03-18 11:00:00" where idAgendamento = 6;
          
          ALTER TABLE usuarios RENAME COLUMN nome TO nomeU;
                                 
         
         
  