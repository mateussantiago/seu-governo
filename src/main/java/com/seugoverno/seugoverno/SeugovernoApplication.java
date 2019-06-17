package com.seugoverno.seugoverno;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.seugoverno.seugoverno.dominio.GrupoDeGasto;
import com.seugoverno.seugoverno.dominio.Orcamento;
import com.seugoverno.seugoverno.repository.OrcamentoRepository;

@SpringBootApplication
public class SeugovernoApplication {

	@Autowired
	private OrcamentoRepository orcamentoRepository;

	public static void main(String[] args) {
		SpringApplication.run(SeugovernoApplication.class, args);
	}

	@Bean
	public void populate() throws FileNotFoundException, IOException {
		String pathFolder = "/home/sig_saude/dev/engsoft/workspace/seu-governo/scripts/csvs_tratados/";
		File folder = new File(pathFolder);
		List<File> files = new ArrayList<File>();
		listFiles(folder, files);

		for (File file : files) {
			List<List<String>> csvContent = readCsv(file.getPath());
			if(!csvContent.isEmpty()) {
				for(int i = 0 ; i < csvContent.size() ; i++) {
					List<String> line = csvContent.get(i);
					Integer mes = Integer.parseInt(line.get(0));
					Integer ano = Integer.parseInt(line.get(1));
					String acaoOrcamentaria = line.get(2);
					String programaOrcamentario = line.get(3);
					String funcao = line.get(4);
					String tipoFavorecido = line.get(5);
					String uf = line.get(6);
					String municipio = line.get(7);
					BigDecimal valorTransferido = BigDecimal.valueOf(Double.parseDouble(line.get(8)));				
					Orcamento orc = new Orcamento(mes, ano, acaoOrcamentaria, programaOrcamentario, funcao, tipoFavorecido, uf, municipio, valorTransferido);				
					orc.setGrupo(setGrupo(funcao));
					orcamentoRepository.save(orc);					
				}
			}
		}

	}

	public List<List<String>> readCsv(String csvPath) throws FileNotFoundException, IOException {
		String DELIMITER = ";";
		List<List<String>> csvContent = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(csvPath))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(DELIMITER);
				List<String> content = new ArrayList<String>();
				content = Arrays.asList(values);
				csvContent.add(content);
			}
		}
		return csvContent;
	}

	public void listFiles(File folder, List<File> files) {
		for (File file : folder.listFiles()) {
			if (file.isDirectory()) {
				listFiles(file, files);
			} else {
				files.add(file);
			}
		}
	}
	
	public GrupoDeGasto setGrupo(String str) {
		//"17 - Saneamento"
		//"08 - Assistência social"
		//"12 - Educação"
		
		if(str.equals("17 - Saneamento")) {
			return GrupoDeGasto.SANEAMENTO;
		} 
		
		if(str.equals("08 - Assistência social")) {
			return GrupoDeGasto.ASSISTENCIA_SOCIAL;
		}
		
		if(str.equals("12 - Educação")) {
			return GrupoDeGasto.EDUCACAO;
		}
		
		return null;
	}

}
