CREATE TABLE parcelamento(
	id BIGSERIAL PRIMARY KEY,
	cliente_id BIGINT NOT NULL,
	descricao VARCHAR(20) NOT NULL,
	valor_total NUMERIC(10, 2) NOT NULL,
	quantidade_parcelas SMALLINT,
	data_criacao TIMESTAMP NOT NULL
);

ALTER TABLE parcelamento 
ADD CONSTRAINT fk_parcelamento_cliente
FOREIGN KEY (cliente_id) REFERENCES cliente (id);
