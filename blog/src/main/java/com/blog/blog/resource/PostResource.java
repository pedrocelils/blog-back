package com.blog.blog.resource;

import com.blog.blog.entities.Post;
import com.blog.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @Autowired
    public PostResource(PostService postService) {
        this.postService = postService;
    }

    // Endpoint para listar todos os posts
    @GetMapping
    public List<Post> getPosts() {
        return postService.getAllPosts();
    }

    @PostMapping
    public ResponseEntity<Post> savePost(@RequestBody Post post) {
        Post savedPost = postService.createPost(post);
        return ResponseEntity.ok().body(savedPost);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Post> getPost(@PathVariable Long id) {
        Optional<Post> getById = postService.getOne(id);
        // Verificando se o post foi encontrado
        if (getById.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Retorna 404 se não encontrar
        }
        // Se o post foi encontrado, retorna com status 200 e o conteúdo
        return ResponseEntity.ok(getById.get()); // Utiliza get() para acessar o valor dentro do Optional
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post post) {
        Optional<Post> getById = postService.getOne(id);
        if (getById.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(postService.updatePost(id, post));
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}
