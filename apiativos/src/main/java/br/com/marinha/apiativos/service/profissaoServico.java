package br.com.marinha.apiativos.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.marinha.apiativos.model.profissao;
import br.com.marinha.apiativos.repository.ProfissaoRepository;

@RestController
@RequestMapping({"/api"})
public class profissaoServico {
	
	@Autowired
	private ProfissaoRepository _profissaoRepository;
	
	@RequestMapping(value = "/profissaoAll", method = RequestMethod.GET)
    public List<profissao> Get() {
        return _profissaoRepository.findAll();
    }
    
    @RequestMapping(value = "/profissao/{id}", method = RequestMethod.GET)
    public ResponseEntity<profissao> GetById(@PathVariable(value = "id") long id)
    {
        Optional<profissao> militar = _profissaoRepository.findById(id);
        if(militar.isPresent())
            return new ResponseEntity<profissao>(militar.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }
    
    @RequestMapping(value = "/profissaoCPF/{cpf}", method = RequestMethod.GET)
    public ResponseEntity<profissao> GetByCpf(@PathVariable(value = "cpf") String cpf)
    {
        Optional<profissao> profissao = _profissaoRepository.findUserByCpf(cpf);
        if(profissao.isPresent())
            return new ResponseEntity<profissao>(profissao.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }
    
    @RequestMapping(value = "/profissaoIdPessoal/{idpessoal}", method = RequestMethod.GET)
    public ResponseEntity<profissao> GetByidPessoal(@PathVariable(value = "idpessoal") String idpessoal)
    {
        Optional<profissao> profissao = _profissaoRepository.findUserByidPessoal(idpessoal);
        if(profissao.isPresent())
            return new ResponseEntity<profissao>(profissao.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }
    
    
    @RequestMapping(value = "/profissaoNomeEfetivo/{nome}/{prof}", method = RequestMethod.GET)
    public List<profissao> GetByNome(@PathVariable(value = "nome") String nome, @PathVariable(value = "prof") String prof)
    {
        return _profissaoRepository.findUserByNome(nome.toUpperCase(), prof.toUpperCase());
   }
    
   @RequestMapping(value = "/saveProfissao", method =  RequestMethod.POST)
    public profissao Post(@RequestBody profissao prof)
    {
        return _profissaoRepository.save(prof);
    }
    
  @RequestMapping(value = "/alteraProfissao/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<profissao> Put(@PathVariable(value = "id") long id, @RequestBody profissao newmProfissao)
    {
        Optional<profissao> oldProfissao = _profissaoRepository.findById(id);
        if(oldProfissao.isPresent()){
        	profissao profissional = oldProfissao.get();
        	profissional.setCodativo(newmProfissao.getCodativo());
        	profissional.setCpf(newmProfissao.getCpf());
        	profissional.setDtAdm(newmProfissao.getDtAdm());
        	profissional.setIdPessoal(newmProfissao.getIdPessoal());
        	profissional.setNome(newmProfissao.getNome().toUpperCase());
        	profissional.setProfissao(newmProfissao.getNome().toUpperCase());
        	
        	_profissaoRepository.save(newmProfissao);
            return new ResponseEntity<profissao>(profissional, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    
    @RequestMapping(value = "/deletarProfissao/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<profissao> prof = _profissaoRepository.findById(id);
        if(prof.isPresent()){
        	_profissaoRepository.delete(prof.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    

}
