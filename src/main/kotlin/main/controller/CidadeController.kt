package main.controller

import main.domain.Cidade
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class CidadeController {

    @GetMapping("/obterCidade/{cep}")
    fun obterCidade(@PathVariable cep: String) : Cidade {
        println("Obtendo cep $cep")
        val cidade = Cidade("Vila Sonia","São Paulo")
        return cidade
    }
}