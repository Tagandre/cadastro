package com.cadastro.service;

import java.util.List;
import com.cadastro.model.PessoaModel;
import com.cadastro.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PessoaService {
    
    @Autowired
    private PessoaRepository pRepository;

    //@RequestMapping(value = "/salvar")
    @PostMapping("/salvar")
    public ResponseEntity<PessoaModel> salvar(@RequestBody @Validated PessoaModel pessoa) {
        this.pRepository.save(pessoa);
        return new ResponseEntity<PessoaModel>(pessoa, HttpStatus.CREATED);
    }

    @PutMapping
    @RequestMapping(value = "update/pessoa")
    public @ResponseBody PessoaModel atualizar(@RequestBody PessoaModel pessoaModel){
        return this.pRepository.save(pessoaModel);
    }

    @GetMapping
    @RequestMapping(value="/list")
    public @ResponseBody List<PessoaModel> listar(){
        return this.pRepository.findAll();
    }

    @GetMapping
    @RequestMapping(value = "/pessoa/{id}")
    public @ResponseBody PessoaModel buscarById(@PathVariable("id") Long id){
        return this.pRepository.findById(id).stream().findFirst().orElse(new PessoaModel());
    }
    
    @DeleteMapping("/excluir/{id}")
    public void excluir(@PathVariable("id") long id) {
            this.pRepository.deleteById(id);
    } 
}
