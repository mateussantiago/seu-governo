package com.seugoverno.seugoverno.repository;


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

    public List<OrcamentoDTO> findOrcamentos(Integer ano) {
        OrcamentoDTO orcDTO = new OrcamentoDTO();
        StringBuilder sql = new StringBuilder();
        sql.append("select ano, mes, sum(valor_transferido) from public.orcamento orc " +
                "where 1=1 ");

        if (ano != null) {
            sql.append("and orc.ano = " + ano);
        }

        sql.append("group by ano, mes " +
                        "order by ano asc");

        List<OrcamentoDTO> orcamentoDTOList = jdbcTemplate.query(sql.toString(), new RowMapper<OrcamentoDTO>() {
            @Override
            public OrcamentoDTO mapRow(ResultSet resultSet, int i) throws SQLException {
                orcDTO.setAno(Integer.parseInt(resultSet.getString("ano")));
                orcDTO.setMes(Integer.parseInt(resultSet.getString("mes")));
                orcDTO.setOrcamento(resultSet.getBigDecimal("orcamento_geral_mes"));

                return orcDTO;
            }
        });

        return orcamentoDTOList;
    }
}
