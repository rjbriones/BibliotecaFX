CREATE DATABASE BibliotecaFX
GO

USE BibliotecaFX
GO


CREATE TABLE Rango (
	idRango INT IDENTITY(1,1) NOT NULL,
	nombreRango VARCHAR(255) NOT NULL,
	PRIMARY KEY(idRango));

CREATE TABLE Usuario (
	idUsuario INT IDENTITY(1,1) NOT NULL,
	nombreUsuario VARCHAR(255) NOT NULL,
	rango VARCHAR(255) NOT NULL,
	clave VARCHAR(255) NOT NULL,
	PRIMARY KEY(idUsuario));


CREATE TABLE Autor (
	idAutor INT IDENTITY(1,1) NOT NULL,
	nombreAutor VARCHAR(255) NOT NULL,
	PRIMARY KEY(idAutor));

CREATE TABLE Editorial (
	idEditorial INT IDENTITY(1,1) NOT NULL,
	nombreEditorial VARCHAR(255) NOT NULL,
	PRIMARY KEY(idEditorial));


CREATE TABLE Libro (
	idLibro INT IDENTITY(1,1) NOT NULL,
	isbn VARCHAR(255) NOT NULL,
	nombreLibro VARCHAR(255) NOT NULL,
	idEditorial INT NOT NULL,
	paginas INT NOT NULL,
	disponible BIT NOT NULL,
	PRIMARY KEY(idLibro),
	FOREIGN KEY (idEditorial) REFERENCES Editorial(idEditorial));

CREATE TABLE Prestamo (
	idPrestamo INT IDENTITY(1,1) NOT NULL,
	idLibro INT NOT NULL,
	fechaPrestamo VARCHAR(255) NOT NULL,
	fechaDevolucion VARCHAR(255) NOT NULL,
	fechaEntrega VARCHAR(255),
	entrega BIT NOT NULL,
	PRIMARY KEY(idPrestamo),
	FOREIGN KEY (idLibro) REFERENCES Libro(idLibro));
 GO 

CREATE VIEW VistaLibro
AS
	SELECT Libro.idLibro, Libro.nombreLibro AS 'Nombre', isbn, Editorial.nombreEditorial AS 'Editorial', Libro.paginas, disponible FROM Libro
		INNER JOIN Editorial ON Libro.idEditorial = Editorial.idEditorial
GO

CREATE VIEW VistaPrestamo
AS
	SELECT Prestamo.idPrestamo, Libro.idLibro, Libro.nombreLibro AS 'Libro', fechaPrestamo, fechaDevolucion, fechaEntrega, entrega FROM Prestamo
		INNER JOIN Libro ON Prestamo.idLibro = Libro.idLibro
GO
 CREATE PROCEDURE CrearEditorial
	@nombre AS VARCHAR(255)
AS
	INSERT INTO Editorial(nombreEditorial)
		VALUES(@nombre)
GO

CREATE PROCEDURE ModificarEditorial
	@nombre AS VARCHAR(255),
	@id AS INT
AS
	UPDATE Editorial SET nombreEditorial = @nombre
		WHERE Editorial.idEditorial = @id
GO

CREATE PROCEDURE EliminarEditorial
	@id AS INT
AS
	DELETE Editorial WHERE Editorial.idEditorial = @id
GO

 CREATE PROCEDURE CrearAutor
	@nombre AS VARCHAR(255)
AS
	INSERT INTO Autor(nombreAutor)
		VALUES(@nombre)
GO

CREATE PROCEDURE ModificarAutor
	@nombre AS VARCHAR(255),
	@id AS INT
AS
	UPDATE Autor SET nombreAutor = @nombre
		WHERE Autor.idAutor = @id
GO

CREATE PROCEDURE EliminarAutor
	@id AS INT
AS
	DELETE Autor WHERE Autor.idAutor = @id
GO

 CREATE PROCEDURE CrearRango
	@nombre AS VARCHAR(255)
AS
	INSERT INTO Rango(nombreRango)
		VALUES(@nombre)
GO

CREATE PROCEDURE ModificarRango
	@nombre AS VARCHAR(255),
	@id AS INT
AS
	UPDATE Rango SET nombreRango = @nombre
		WHERE Rango.idRango = @id
GO

CREATE PROCEDURE EliminarRango
	@id AS INT
AS
	DELETE Rango WHERE Rango.idRango = @id
GO

 CREATE PROCEDURE CrearUsuario
	@nombre AS VARCHAR(255),
	@rango AS VARCHAR(255),
	@clave AS VARCHAR(255)
AS
	INSERT INTO Usuario(nombreUsuario, rango, clave)
		VALUES(@nombre, @rango, @clave)
GO

CREATE PROCEDURE ModificarUsuario
	@nombre AS VARCHAR(255),
	@rango AS VARCHAR(255),
	@clave AS VARCHAR(255),
	@id AS INT
AS
	UPDATE Usuario SET nombreUsuario = @nombre, rango = @rango, clave = @clave
		WHERE Usuario.idUsuario = @id
GO

CREATE PROCEDURE EliminarUsuario
	@id AS INT
AS
	DELETE Usuario WHERE Usuario.idUsuario = @id
GO

 CREATE PROCEDURE CrearLibro
	@nombre AS VARCHAR(255),
	@isbn AS VARCHAR(255),
	@idEditorial AS INT,
	@paginas AS INT
AS
	INSERT INTO Libro(nombreLibro, isbn, idEditorial, paginas, disponible)
		VALUES(@nombre, @isbn, @idEditorial, @paginas, '1')
GO

CREATE PROCEDURE ModificarLibro
	@id AS INT,
	@nombre AS VARCHAR(255),
	@isbn AS VARCHAR(255),
	@idEditorial AS INT,
	@paginas AS Int
AS
	UPDATE Libro SET nombreLibro = @nombre, isbn = @isbn, idEditorial = @idEditorial, paginas = @paginas
		WHERE Libro.idLibro = @id
GO

CREATE PROCEDURE EliminarLibro
	@id AS INT
AS
	DELETE Usuario WHERE Usuario.idUsuario = @id
GO

CREATE PROCEDURE CrearPrestamo
	@idLibro AS INT,
	@fechaPrestamo AS VARCHAR(255),
	@fechaDevolucion AS VARCHAR(255)
AS
	INSERT INTO Prestamo(idLibro, fechaPrestamo, fechaDevolucion, entrega)
		VALUES(@idLibro, @fechaPrestamo, @fechaDevolucion, '0')
	UPDATE Libro SET disponible = '0'
		WHERE Libro.idLibro = @idLibro
GO

CREATE PROCEDURE DevolverLibro
	@id AS INT,
	@idLibro AS INT,
	@fechaEntrega AS VARCHAR(255)
AS
	UPDATE Prestamo SET fechaEntrega = @fechaEntrega, entrega = '1'
		WHERE Prestamo.idPrestamo = @id
	UPDATE Libro SET disponible = '1'
		WHERE Libro.idLibro = @idLibro
GO
INSERT INTO Autor VALUES ('Juan'),
('Pedro'),
('Juan Pedro'),
('PedroJuan'),
('Maria'),
('Juana'),
('Maria Juana'),
('Juana Maria'),
('Pedra'),
('Maria Pedra')

INSERT INTO Libro VALUES('A1', 'Cars',  1, 100, 1),
('A2', 'Las historias del alquilado', 2, 150, 1),
('A3', 'La hija del adelantado', 3, 200, 1),
('A4', 'Alejandro Magno', 4, 275, 1),
('A5', 'UML en 24 horas', 5, 150, 1),
('A6', 'Cocina', 6, 400, 1),
('A7', '50 sombras de grey', 7, 250, 1),
('A8', 'Ciudades de papel', 8, 250, 1),
('A9', 'Las flores',9, 75, 1),
('A10', 'Computacion avanzada', 1, 540, 1)

INSERT INTO Editorial VALUES ('Santillana'),
('La Frontera'),
('Mazorca'),
('Orquideas'),
('Pampas'),
('Tlacuache Feliz'),
('Santillana'),
('La Felicidad'),
('Los Angeles'),
('La Frontera')

INSERT INTO Usuario VALUES('Saul', 'Estudiante', 'Saul'),
('Carlos', 'Estudiante', 'Carlos'),
('Bryan', 'Estudiante', 'Bryan'),
('Frank', 'Lector', 'Frank'),
('Ernesto', 'Lector', 'Ernesto'),
('Josefa', 'Estudiante', 'Josefa'),
('Milo', 'Adminstrador', 'Milo'),
('Nito', 'Ayudante', 'Nito'),
('Neto', 'Lector', 'Neto'),
('Alejandra', 'Silenciador', 'Alejandra')


INSERT INTO Rango VALUES ('Bibliotecario'),
('Cuidador')

Select * From Autor
Select * From Libro
Select * From Prestamo
Select * From Usuario
Select * From Editorial
Select * From Rango