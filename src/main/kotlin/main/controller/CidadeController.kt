package main.controller

import com.google.gson.Gson
import main.domain.Cidade
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
class CidadeController {

    @GetMapping("/obterCidade/{cep}")
    fun obterCidade(@PathVariable cep: String) : String? {
        println("Obtendo cep $cep")
        val cidade = chamarServicoViaCep(cep)
        return cidade.toString()
    }

    fun chamarServicoViaCep(cep: String) : Cidade? {

        var response: String = ""

        try {
            val restTemplate = RestTemplate()
            val urlServico = "http://www.viacep.com.br/ws/$cep/json/"
            println("Tentando acesso: $urlServico")
            response = restTemplate.getForObject(urlServico , String::class.java)
            var gson = Gson()
            var objetoRetornado = gson.fromJson(response, Cidade::class.java)
            return objetoRetornado
        }catch(e : Exception){
            println("Erro no acesso a API: $e")
        }

        return null

    }
}