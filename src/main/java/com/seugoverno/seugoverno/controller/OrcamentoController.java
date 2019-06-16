package com.seugoverno.seugoverno.controller;

import com.seugoverno.seugoverno.dto.OrcamentoDTO;
import com.seugoverno.seugoverno.service.OrcamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrcamentoController {

    @Autowired
    private OrcamentoService orcamentoService;

    @RequestMapping(value = "/api/orcamentos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getOrcamentos(@RequestParam(value = "ano", required = false) List<String> anos,
                                        @RequestParam(value = "mes", required = false) List<String> meses){

        List<OrcamentoDTO> orcamentoDTOS = orcamentoService.findOrcamentos(anos, meses);

        return ResponseEntity.status(HttpStatus.OK).headers(new HttpHeaders()).body(orcamentoDTOS);
    }
}
