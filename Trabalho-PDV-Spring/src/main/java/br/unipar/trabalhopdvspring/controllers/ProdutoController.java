package br.unipar.trabalhopdvspring.controllers;

import br.unipar.trabalhopdvspring.domain.Cliente;
import br.unipar.trabalhopdvspring.domain.Produto;
import br.unipar.trabalhopdvspring.exceptions.ApiException;
import br.unipar.trabalhopdvspring.services.ClienteService;
import br.unipar.trabalhopdvspring.services.ProdutoService;
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
    @RequestMapping("/produtos")
    public class ProdutoController {

        @Autowired
        private ProdutoService produtoService;


        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Ok", content =
                        { @Content(mediaType = "application/json", schema =
                        @Schema(implementation = Produto.class)) }),
                @ApiResponse(responseCode = "400", description = "ID invalido informado"),
                @ApiResponse(responseCode = "404", description = "Produto não encontrado"),
                @ApiResponse(responseCode  = "500", description = "Internal server error",
                        content =
                                { @Content(mediaType = "application/json", schema =
                                @Schema(implementation = ApiException.class)) }) })


        @Operation(summary = "GETBYID PRODUTO", description = "BUSCA O PRODUTO POR ID", tags ="PRODUTO" )
        @GetMapping("/{id}")
        public ResponseEntity<Produto> getById(@PathVariable Long id) {

            return ResponseEntity.ok(produtoService.getById(id));
        }

        @Operation(summary = "FINDALL PRODUTO", description = "BUSCA TODOS OS PRODUTO ", tags ="PRODUTO" )
        @GetMapping("/all")
        public ResponseEntity<List<Produto>> getAll() {
            return ResponseEntity.ok(
                    produtoService.getAll());
        }

        @Operation(summary = "INSERT PRODUTO", description = "INSERE O PRODUTO", tags ="PRODUTO" )
        @PostMapping
        public ResponseEntity<Produto> insert(@RequestBody @Valid Produto produto,
                                              UriComponentsBuilder builder) {

            produtoService.insert(produto);

            URI uri =
                    builder.path("/produtos/{id}").
                            buildAndExpand(produto.getId()).toUri();

            return ResponseEntity.created(uri).body(produto);

        }

        @Operation(summary = "UPDATE PRODUTO", description = "ATUALIZA OS PRODUTO", tags ="PRODUTO" )
        @PutMapping("/{id}")
        public ResponseEntity<Produto> update(@PathVariable int id,
                                              @RequestBody Produto produto) {
            produtoService.update(produto);

            return ResponseEntity.ok(produto);
        }

        @Operation(summary = "DELETE PRODUTO", description = "DELETA O PRODUTO", tags ="PRODUTO" )
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable Long id) {
            produtoService.delete(id);
            return ResponseEntity.noContent().build();
        }
    }




