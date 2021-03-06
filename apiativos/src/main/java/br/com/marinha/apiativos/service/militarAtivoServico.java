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
import br.com.marinha.apiativos.model.militaresAtivo;
import br.com.marinha.apiativos.repository.MilitarAtivoRepository;

@RestController
@RequestMapping({"/api"})
public class militarAtivoServico {
	
	@Autowired
	private MilitarAtivoRepository _militarativoRepository;
	
		
	@RequestMapping(value = "/militarAtivo", method = RequestMethod.GET)
    public List<militaresAtivo> Get() {
        return _militarativoRepository.findAll();
    }
    
    @RequestMapping(value = "/militar/{id}", method = RequestMethod.GET)
    public ResponseEntity<militaresAtivo> GetById(@PathVariable(value = "id") long id)
    {
        Optional<militaresAtivo> militar = _militarativoRepository.findById(id);
        if(militar.isPresent())
            return new ResponseEntity<militaresAtivo>(militar.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }
    
    @RequestMapping(value = "/militarCPF/{cpf}", method = RequestMethod.GET)
    public ResponseEntity<militaresAtivo> GetByCpf(@PathVariable(value = "cpf") String cpf)
    {
        Optional<militaresAtivo> militar = _militarativoRepository.findUserByCpf(cpf);
        if(militar.isPresent())
            return new ResponseEntity<militaresAtivo>(militar.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }
    
    @RequestMapping(value = "/militarIdPessoal/{idpessoal}", method = RequestMethod.GET)
    public ResponseEntity<militaresAtivo> GetByidPessoal(@PathVariable(value = "idpessoal") String idpessoal)
    {
        Optional<militaresAtivo> militar = _militarativoRepository.findUserByidPessoal(idpessoal);
        if(militar.isPresent())
            return new ResponseEntity<militaresAtivo>(militar.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }
    
    @RequestMapping(value = "/militarNomeEfetivo/{nome}/{efetivo}", method = RequestMethod.GET)
    public List<militaresAtivo> GetByNome(@PathVariable(value = "nome") String nome, @PathVariable(value = "efetivo") String efetivo)
    {
        return _militarativoRepository.findUserByNome(nome, efetivo);
   }
    
   @RequestMapping(value = "/saveMilitarAtivo", method =  RequestMethod.POST)
    public militaresAtivo Post(@RequestBody militaresAtivo militar)
    {
        return _militarativoRepository.save(militar);
    }
   
    @RequestMapping(value = "/alterarMilitarAtivo/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<militaresAtivo> Put(@PathVariable(value = "id") long id, @RequestBody militaresAtivo newmilitaresAtivo)
    {
        Optional<militaresAtivo> oldmilitaresAtivo = _militarativoRepository.findById(id);
        if(oldmilitaresAtivo.isPresent()){
        	militaresAtivo militar = oldmilitaresAtivo.get();
        	newmilitaresAtivo.setCpf(newmilitaresAtivo.getCpf());
        	newmilitaresAtivo.setIdPessoal(newmilitaresAtivo.getIdPessoal());
        	newmilitaresAtivo.setNome(newmilitaresAtivo.getNome());
            _militarativoRepository.save(newmilitaresAtivo);
            return new ResponseEntity<militaresAtivo>(militar, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(value = "/deletarMilitarAtivo/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<militaresAtivo> militar = _militarativoRepository.findById(id);
        if(militar.isPresent()){
        	_militarativoRepository.delete(militar.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    

}
