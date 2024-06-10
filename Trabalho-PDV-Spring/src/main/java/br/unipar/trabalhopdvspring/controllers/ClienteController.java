package br.unipar.trabalhopdvspring.controllers;




import br.unipar.trabalhopdvspring.domain.Cliente;
import br.unipar.trabalhopdvspring.exceptions.ApiException;
import br.unipar.trabalhopdvspring.services.ClienteService;
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
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok", content =
                    { @Content(mediaType = "application/json", schema =
                    @Schema(implementation = Cliente.class)) }),
            @ApiResponse(responseCode = "400", description = "ID invalido informado"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado"),
            @ApiResponse(responseCode  = "500", description = "Internal server error",
                    content =
                    { @Content(mediaType = "application/json", schema =
                    @Schema(implementation = ApiException.class)) }) })

    @Operation(summary = "GETBYID CLIENTE", description = "BUSCA O CLIENTE POR ID", tags ="CLIENTE" )
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable  Long id) {

        return ResponseEntity.ok(clienteService.getById(id));
    }

    @Operation(summary = "FINDALL CLIENTE" ,description = "BUSCA TODOS OS CLIENTES", tags ="CLIENTE" )
    @GetMapping("/all")
    public ResponseEntity<List<Cliente>> getAll() {
        return ResponseEntity.ok(clienteService.getAll());
    }

    @Operation(summary = "INSERT CLIENTE" ,description = "INSERE OS CLIENTE", tags ="CLIENTE" )
    @PostMapping
    public ResponseEntity<Cliente> insert(@RequestBody @Valid Cliente cliente,
                                          UriComponentsBuilder builder) {

        clienteService.insert(cliente);

        URI uri =
                builder.path("/clientes/{id}").
                        buildAndExpand(cliente.getId()).toUri();

        return ResponseEntity.created(uri).body(cliente);

    }
    @Operation(summary = "UPDATE CLIENTE" ,description = "ATUALIZA OS CLIENTES", tags ="CLIENTE" )
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable int id,
                                          @RequestBody Cliente cliente) {
        clienteService.update(cliente);

        return ResponseEntity.ok(cliente);
    }

    @Operation(summary = "DELETE CLIENTE" ,description = "DELETA O CLIENTE", tags ="CLIENTE" )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
