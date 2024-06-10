package br.unipar.trabalhopdvspring.controllers;

import br.unipar.trabalhopdvspring.domain.Cliente;
import br.unipar.trabalhopdvspring.domain.ItemVenda;
import br.unipar.trabalhopdvspring.domain.Venda;
import br.unipar.trabalhopdvspring.exceptions.ApiException;
import br.unipar.trabalhopdvspring.services.VendaService;
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
@RequestMapping("/venda")
public class VendaController {

    @Autowired
    private VendaService vendaService;


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok", content =
                    { @Content(mediaType = "application/json", schema =
                    @Schema(implementation = Venda.class)) }),
            @ApiResponse(responseCode = "400", description = "ID invalido informado"),
            @ApiResponse(responseCode = "404", description = "Venda não encontrado"),
            @ApiResponse(responseCode  = "500", description = "Internal server error",
                    content =
                            { @Content(mediaType = "application/json", schema =
                            @Schema(implementation = ApiException.class)) }) })


    @Operation(summary = "INSERT  VENDA", description = "INSERE A VENDA", tags ="VENDA" )
    @PostMapping
    public ResponseEntity<Venda> insert(@RequestBody @Valid Venda venda,
                                            UriComponentsBuilder builder) {

        vendaService.insert(venda);

        URI uri =
                builder.path("/itemvenda/{id}").
                        buildAndExpand(venda.getId()).toUri();

        return ResponseEntity.created(uri).body(venda);

    }

    @Operation(summary = "GETBYID VENDA", description = "BUSCA A VENDA POR ID", tags ="VENDA" )
    @GetMapping("/{id}")
    public ResponseEntity<Venda> getById(@PathVariable Long id) {

        return ResponseEntity.ok(vendaService.getById(id));
    }

    @Operation(summary = "FINDALL VENDA", description = "BUSCA TODAS AS VENDA", tags ="VENDA" )
    @GetMapping("/all")
    public ResponseEntity<List<Venda>> getAll() {
        return ResponseEntity.ok(vendaService.getAll());
    }



    @Operation(summary = "UPDATE VENDA", description = "ATUALIZA AS VENDAS", tags ="VENDA" )
    @PutMapping("/{id}")
    public ResponseEntity<Venda> update(@PathVariable int id,
                                          @RequestBody Venda venda) {
   vendaService.update(venda);

        return ResponseEntity.ok(venda);
    }

    @Operation(summary = "DELETE VENDA", description = "DELETA A VENDA", tags ="VENDA" )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
       vendaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
