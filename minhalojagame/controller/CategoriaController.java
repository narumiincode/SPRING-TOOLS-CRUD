package minhalojagame.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import minhalojagame.model.Categoria;

@RestController
@RequestMapping ("/categoria")
@CrossOrigin(origins="*", allowedHeaders="*")
public class CategoriaController {
	
	@Autowired
	private minhalojagame.repository.CategoriaRepository CategoriaRepository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> getAll (){
		return ResponseEntity.ok(CategoriaRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <Categoria> getbyid(@PathVariable long id) {
		return CategoriaRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Categoria>>getbynome(@PathVariable String nome){
		return ResponseEntity.ok(CategoriaRepository.FindAllByNomeContainingignorecase(nome));	
	}
	
	@PostMapping
	public ResponseEntity<Categoria>post(@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(CategoriaRepository.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity<Categoria>put(@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(CategoriaRepository.save(categoria));	
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		CategoriaRepository.deleteById(id);
	}
}
