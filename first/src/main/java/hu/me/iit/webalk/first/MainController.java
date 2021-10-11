package hu.me.iit.webalk.first;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path= "article")
public class MainController {
	
	private final ArticleService articleService;
	
	public MainController(ArticleService articleService) {
		this.articleService = articleService;
	}

	@GetMapping(path= "", produces = MediaType.APPLICATION_JSON_VALUE)
	List<ArticleDto> allArticles() {
		return articleService.findAll();
	}
	
	@PostMapping(path= "")
	public void newArticle(@RequestBody @Valid ArticleDto articleDto) {
		articleService.save(articleDto);
	}

	
	@PutMapping(path= "{id}")
	public void replaceArticle(@PathVariable ("id") Long id, @RequestBody @Valid ArticleDto articleDto) {
		articleService.save(articleDto);
	}
	
	@DeleteMapping(path= "{id}")
	public void deleteArticle(@PathVariable ("id") Long id) {
		articleService.deleteById(id);
	}

}
