package com.seugoverno.seugoverno.repository;


import com.seugoverno.seugoverno.auxiliar.SQLUtil;
import com.seugoverno.seugoverno.dto.OrcamentoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OrcamentoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Busca por todos os orçamentos no banco de dados de acordo com os filtros passados. Os filtros podem
     * ser ano e mes. Os filtros ano e mes suportam receber mais de um valor, assim é possível
     * realizar uma consulta passando mais de um ano, por exemplo.
     * @param anos lista contendo os anos passados
     * @param meses lista contendo os meses passados
     * @return lista de orçamentos
     */
    public List<OrcamentoDTO> findOrcamentos(List<String> anos, List<String> meses) {
        OrcamentoDTO orcDTO = new OrcamentoDTO();
        StringBuilder sql = new StringBuilder();
        sql.append("select ano, mes, sum(valor_transferido) as orcamento_geral_mes from public.orcamento orc " +
                "where 1=1 ");

        sql.append("and orc.ano in (" + SQLUtil.stringsParametros(anos) + ") ");

        if (meses != null && !meses.isEmpty()) {
            sql.append("and orc.mes in (" + SQLUtil.stringsParametros(meses) + ")" );
        }

        sql.append("group by ano, mes " +
                        "order by ano asc");

        List<OrcamentoDTO> orcamentoDTOList = jdbcTemplate.query(sql.toString(), new RowMapper<OrcamentoDTO>() {
            @Override
            public OrcamentoDTO mapRow(ResultSet resultSet, int i) throws SQLException {
                OrcamentoDTO orcDTO = new OrcamentoDTO();
                orcDTO.setAno((resultSet.getString("ano")));
                orcDTO.setMes(resultSet.getString("mes"));
                orcDTO.setOrcamento(resultSet.getBigDecimal("orcamento_geral_mes"));

                return orcDTO;
            }
        });

        return orcamentoDTOList;
    }

    /**
     * Busca por todos os anos disponíveis no Banco de Dados
     * @return lista com todos os anos
     */
    public List<String> getAllAnos() {
        StringBuilder sql = new StringBuilder();
        sql.append("select distinct orc.ano from public.orcamento orc");

        return jdbcTemplate.query(sql.toString(), new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet resultSet, int i) throws SQLException {

                return resultSet.getString("ano");
            }
        });
    }
}
