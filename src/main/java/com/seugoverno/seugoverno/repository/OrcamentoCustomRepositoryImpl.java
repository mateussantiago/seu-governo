package com.seugoverno.seugoverno.repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.seugoverno.seugoverno.auxiliar.SQLUtil;
import com.seugoverno.seugoverno.dto.OrcamentoDTO;

@Repository
public class OrcamentoCustomRepositoryImpl implements OrcamentoCustomRepository {

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
    public List<OrcamentoDTO> findOrcamentos(List<Integer> anos, List<Integer> meses, String programaOrcamentario,
                                             String categoria) {
        StringBuilder sql = new StringBuilder();
        sql.append("select ano, mes, sum(valor_transferido) as orcamento_geral_mes from public.orcamento orc " +
                "where 1=1 ");

        sql.append("and orc.ano in (" + SQLUtil.stringsParametros(anos) + ") ");

        if (meses != null && !meses.isEmpty()) {
            sql.append("and orc.mes in (" + SQLUtil.stringsParametros(meses) + ") " );
        }

        if (programaOrcamentario != null && !programaOrcamentario.isEmpty()) {
            sql.append("and orc.programa_orcamentario like ('%" + programaOrcamentario + "%') ");
        }

        if (categoria != null && !categoria.isEmpty()) {
            sql.append("and orc.funcao like ('%" + categoria + "%') ");
        }

        sql.append("group by ano, mes " +
                        "order by ano, mes asc");

        List<OrcamentoDTO> orcamentoDTOList = jdbcTemplate.query(sql.toString(), new RowMapper<OrcamentoDTO>() {
            @Override
            public OrcamentoDTO mapRow(ResultSet resultSet, int i) throws SQLException {
                OrcamentoDTO orcDTO = new OrcamentoDTO();
                orcDTO.setAno((resultSet.getInt("ano")));
                orcDTO.setMes(resultSet.getInt("mes"));
                orcDTO.setOrcamento(resultSet.getBigDecimal("orcamento_geral_mes"));

                return orcDTO;
            }
        });

        return orcamentoDTOList;
    }
}
