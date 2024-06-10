package br.unipar.trabalhopdvspring.controllers;

import br.unipar.trabalhopdvspring.domain.Produto;
import br.unipar.trabalhopdvspring.domain.Tabela;
import br.unipar.trabalhopdvspring.exceptions.ApiException;
import br.unipar.trabalhopdvspring.services.ProdutoService;
import br.unipar.trabalhopdvspring.services.TabelaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tabela")
public class TabelaController {

         @Autowired
         private TabelaService tabelaService;


         @ApiResponses(value = {
                 @ApiResponse(responseCode = "200", description = "Ok", content =
                         {@Content(mediaType = "application/json", schema =
                         @Schema(implementation = Tabela.class))}),
                 @ApiResponse(responseCode = "400", description = "ID invalido informado"),
                 @ApiResponse(responseCode = "404", description = "tabela não encontrado"),
                 @ApiResponse(responseCode = "500", description = "Internal server error",
                         content =
                                 {@Content(mediaType = "application/json", schema =
                                 @Schema(implementation = ApiException.class))})})


         @Operation(summary = "GETBYID TABELA", description = "BUSCA O ITEM NA TABELA POR ID", tags = "TABELA")
         @GetMapping("/{id}")
         public ResponseEntity<Tabela> getById (@PathVariable Long id){

         return ResponseEntity.ok(tabelaService.getById(id));
     }

         @Operation(summary = "FINDALL TABELA", description = "BUSCA  OS ITEM NA TABELA ", tags = "TABELA")
         @GetMapping("/all")
         public ResponseEntity<List<Tabela>> getAll () {
         return ResponseEntity.ok(
                 tabelaService.getAll());
     }

         @Operation(summary = "UPDATE TABELA", description = "ATUALIZA A TABELA", tags = "TABELA")
         @PutMapping("/{id}")
         public ResponseEntity<Tabela> update ( @PathVariable int id,
         @RequestBody Tabela tabela){
         tabelaService.update(tabela);

         return ResponseEntity.ok(tabela);
     }


     }

