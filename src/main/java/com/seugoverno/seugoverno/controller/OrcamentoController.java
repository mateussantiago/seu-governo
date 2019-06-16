package com.seugoverno.seugoverno.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seugoverno.seugoverno.dto.OrcamentoDTO;
import com.seugoverno.seugoverno.service.OrcamentoService;

@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
@RestController
public class OrcamentoController {

    @Autowired
    private OrcamentoService orcamentoService;

    @RequestMapping(value = "/api/orcamentos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getOrcamentos(@RequestParam(value = "ano", required = false) List<Integer> anos,
                                        @RequestParam(value = "mes", required = false) List<Integer> meses){

        List<OrcamentoDTO> orcamentoDTOS = orcamentoService.findOrcamentos(anos, meses);

        return ResponseEntity.status(HttpStatus.OK).headers(new HttpHeaders()).body(orcamentoDTOS);
    }

    @RequestMapping(value = "/api/anos", method = RequestMethod.GET)
    public ResponseEntity<List<Integer>> getAnos() {
    	return new ResponseEntity<>(orcamentoService.findOpcoesAnos(), HttpStatus.OK);
    }

    @RequestMapping(value = "/api/meses", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Integer>> getMeses() {

        return ResponseEntity.status(HttpStatus.OK).headers(new HttpHeaders()).body(orcamentoService.findOpcoesMeses());
    }

    @RequestMapping(value = "/api/programas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<String>> getProgramasOrcamentarios() {

        return ResponseEntity.status(HttpStatus.OK).headers(new HttpHeaders()).body(orcamentoService.findOpcoesProramaOrcamentario());
    }
}
