COPY orcamento(mes, ano, acao_orcamentaria, programa_orcamentario, funcao, tipo_favorecido, uf, municipio, valor_transferido) 
FROM 'path/educacao/educacao14.csv' DELIMITER ';' CSV HEADER;
COPY orcamento(mes, ano, acao_orcamentaria, programa_orcamentario, funcao, tipo_favorecido, uf, municipio, valor_transferido) 
FROM 'path/educacao/educacao15.csv' DELIMITER ';' CSV HEADER;
COPY orcamento(mes, ano, acao_orcamentaria, programa_orcamentario, funcao, tipo_favorecido, uf, municipio, valor_transferido) 
FROM 'path/educacao/educacao16.csv' DELIMITER ';' CSV HEADER;
COPY orcamento(mes, ano, acao_orcamentaria, programa_orcamentario, funcao, tipo_favorecido, uf, municipio, valor_transferido) 
FROM 'path/educacao/educacao17.csv' DELIMITER ';' CSV HEADER;
COPY orcamento(mes, ano, acao_orcamentaria, programa_orcamentario, funcao, tipo_favorecido, uf, municipio, valor_transferido, grupo) 
FROM 'path/educacao/educacao18.csv' DELIMITER ';' CSV HEADER;
UPDATE orcamento SET grupo = 'EDUCACAO'

SELECT COUNT (*) FROM orcamento