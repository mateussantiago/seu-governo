package com.seugoverno.seugoverno.controller;

import java.util.List;

import com.seugoverno.seugoverno.dto.BodyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.seugoverno.seugoverno.dto.OrcamentoDTO;
import com.seugoverno.seugoverno.service.OrcamentoService;

@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
@RestController
public class OrcamentoController {

    @Autowired
    private OrcamentoService orcamentoService;

    @RequestMapping(value = "/api/orcamentos", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getOrcamentos(@RequestBody BodyDTO bodyDTO) {

        List<OrcamentoDTO> orcamentoDTOS = orcamentoService.findOrcamentos(bodyDTO.getAnos(), bodyDTO.getMeses(),
                bodyDTO.getProgramaOrcamentario(), bodyDTO.getCategoria());

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

    @RequestMapping(value = "/api/categorias", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<String>> getCategorias() {

        return ResponseEntity.status(HttpStatus.OK).headers(new HttpHeaders()).body(orcamentoService.findOpcoesCategorias());
    }
}
