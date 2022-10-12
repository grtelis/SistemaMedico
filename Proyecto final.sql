/*
Barragán Córdova Rubén
García Cuevas María Fernanda
Guerrero Torres Elizabeth Lorena
Hernández Vázquez Carlos
López Monares Gail Keegan
Rivera Álvarez Jonathan Charly 
*/
CREATE TABLE persona(
    id serial not null,
    nombre varchar(45) not null,
    apellidos varchar(45) not null,
    telefono varchar(45) not null,

    PRIMARY KEY(id)
    
);

CREATE TABLE paciente(

    id serial not null,
    edad int not null,
    peso float not null,
    talla float not null,
    padecimiento varchar(45) not null,
    num_estudios int,
    persona_id int not null,

    PRIMARY KEY(id),
    FOREIGN KEY(persona_id) REFERENCES persona(id) ON DELETE CASCADE ON UPDATE CASCADE

);

CREATE TABLE estudios_laboratorio(

    id serial not null,
    tipo_estudio varchar(45) not null,
    fecha_estudio varchar(45) not null,
    paciente_id int not null,

    PRIMARY KEY(id),
    FOREIGN KEY(paciente_id) REFERENCES paciente(id) ON DELETE CASCADE ON UPDATE CASCADE

);

CREATE TABLE hospital(

    id serial not null,
    nombre varchar(45) not null,
    tipo varchar(45) not null,

    PRIMARY KEY(id)

);

CREATE TABLE medico(

    id serial not null,
    cedula varchar(45) not null,
    persona_id int not null,
    hospital_id int,
    created_at timestamp not null,

    PRIMARY KEY(id),
    FOREIGN KEY(persona_id) REFERENCES persona(id) ON DELETE CASCADE ON UPDATE CASCADE, 
    FOREIGN KEY(hospital_id) REFERENCES hospital(id)

);

CREATE TABLE usuario(

    id serial not null,
    nombre varchar(45) unique not null,
    contrasena varchar(45) not null,

    PRIMARY KEY(id)

);

CREATE OR REPLACE FUNCTION actualizar_estudios()
RETURNS TRIGGER AS $actualizar_estudios$
BEGIN
	IF(TG_OP = 'INSERT') THEN
		UPDATE paciente SET num_estudios = num_estudios + 1 WHERE id = NEW.paciente_id;
	ELSIF (TG_OP = 'DELETE') THEN
		UPDATE paciente SET num_estudios = num_estudios - 1 WHERE id = OLD.paciente_id;
	END IF;
	RETURN NULL;
END;
$actualizar_estudios$ LANGUAGE plpgsql;
	
CREATE OR REPLACE TRIGGER actualizar_estudios
AFTER INSERT OR DELETE ON estudios_laboratorio
FOR EACH ROW
EXECUTE PROCEDURE actualizar_estudios();