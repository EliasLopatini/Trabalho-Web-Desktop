package br.unipar.trabalhopdvspring.controllers;

import br.unipar.trabalhopdvspring.domain.Cliente;
import br.unipar.trabalhopdvspring.domain.ItemVenda;
import br.unipar.trabalhopdvspring.exceptions.ApiException;
import br.unipar.trabalhopdvspring.repositories.ItemVendaRepository;
import br.unipar.trabalhopdvspring.services.ItemVendaService;
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
@RequestMapping("/itemvenda")

public class ItemVendaController {


        @Autowired
        private ItemVendaService itemVendaService;


    @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Ok", content =
                        { @Content(mediaType = "application/json", schema =
                        @Schema(implementation = ItemVenda.class)) }),
                @ApiResponse(responseCode = "400", description = "ID invalido informado"),
                @ApiResponse(responseCode = "404", description = "Item não encontrado"),
                @ApiResponse(responseCode  = "500", description = "Internal server error",
                        content =
                                { @Content(mediaType = "application/json", schema =
                                @Schema(implementation = ApiException.class)) }) })


        @Operation(summary = "GETBYID ITEM DA VENDA", description = "BUSCA O PRODUTO NA VENDA POR ID", tags ="ITEM NA VENDA" )
        @GetMapping("/{id}")
        public ResponseEntity<ItemVenda> getById(@PathVariable Long id) {

            return ResponseEntity.ok(itemVendaService.getById(id));
        }

        @Operation(summary = "FINDALL ITEM DA VENDA", description = "BUSCA TODOS OS PRODUTO NA VENDA", tags ="ITEM NA VENDA" )
        @GetMapping("/all")
        public ResponseEntity<List<ItemVenda>> getAll() {
            return ResponseEntity.ok(itemVendaService.getAll());
        }

        @Operation(summary = "INSERT ITEM DA VENDA", description = "INSERE O  PRODUTO NA VENDA", tags ="ITEM NA VENDA" )
        @PostMapping
        public ResponseEntity<ItemVenda> insert(@RequestBody @Valid ItemVenda itemVenda,
                                              UriComponentsBuilder builder) {

            itemVendaService.insert(itemVenda);

            URI uri =
                    builder.path("/itemvenda/{id}").
                            buildAndExpand(itemVenda.getId()).toUri();

            return ResponseEntity.created(uri).body(itemVenda);

        }

        @Operation(summary = "UPDATE ITEM DA VENDA", description = "ATUALIZA O PRODUTO NA VENDA", tags ="ITEM NA VENDA" )
        @PutMapping("/{id}")
        public ResponseEntity<ItemVenda> update(@PathVariable int id,
                                              @RequestBody ItemVenda itemVenda) {
            itemVendaService.update(itemVenda);

            return ResponseEntity.ok(itemVenda);
        }

        @Operation(summary = "DELETE ITEM DA VENDA", description = "DELETA O PRODUTO NA VENDA", tags ="ITEM NA VENDA" )
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable Long id) {
       itemVendaService.delete(id);
            return ResponseEntity.noContent().build();
        }
    }


