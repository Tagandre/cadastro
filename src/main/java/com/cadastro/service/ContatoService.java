package com.cadastro.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cadastro.model.ContatoModel;
import com.cadastro.repository.ContatoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class ContatoService {
    
    @PersistenceContext
    private EntityManager manager;
    
    @Autowired
    private ContatoRepository cRepository;

    @GetMapping
    @RequestMapping(value="/contato")
    public @ResponseBody List<ContatoModel> listar(){
        return this.cRepository.findAll();
    }

    @PostMapping("/salvar/contato")
    public ResponseEntity<ContatoModel> salvar(@RequestBody ContatoModel contato) {
        this.cRepository.save(contato);
        return new ResponseEntity<ContatoModel>(contato, HttpStatus.CREATED);
    }

    @PutMapping("/update/contato/")
    public @ResponseBody ContatoModel atualizar(@RequestBody ContatoModel pessoaModel){
        return this.cRepository.save(pessoaModel);
    }

    @GetMapping
    @RequestMapping(value = "/contato/{id}")
    public @ResponseBody List<ContatoModel> buscarById(@PathVariable("id") Long id){
         List<ContatoModel> contatos = this.cRepository.findAll();
         List<ContatoModel> retorno = new ArrayList<ContatoModel>();
         for(ContatoModel contato : contatos){
             if(contato.getPessoa() != null && contato.getPessoa().getId().equals(id)){
                retorno.add(contato);
             }
         }
         return retorno;
    }
    
    @DeleteMapping("/excluir/contato/{id}")
    public void excluir(@PathVariable("id") long id) {
            this.cRepository.deleteById(id);
    } 


    public boolean validaEmail(String email){
        Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,3}$");    
        Matcher m = p.matcher(email.trim());   
        return m.find() ? true : false;
        
    }
}