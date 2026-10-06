-- DimDim CP5 - Azure SQL Database
-- Banco: DimDimDB | Servidor: sql-dimdim-cp5-561694.database.windows.net
CREATE TABLE Usuario (
    id INT IDENTITY(1,1) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE
);
CREATE TABLE Transacao (
    id INT IDENTITY(1,1) PRIMARY KEY,
    descricao VARCHAR(200) NOT NULL,
    valor DECIMAL(10,2) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    data_transacao DATETIME2 NOT NULL DEFAULT GETDATE(),
    usuario_id INT NOT NULL,
    CONSTRAINT FK_Transacao_Usuario FOREIGN KEY (usuario_id) REFERENCES Usuario(id)
);
