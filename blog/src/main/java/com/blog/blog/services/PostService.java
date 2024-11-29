package com.blog.blog.services;

import com.blog.blog.entities.Post;
import com.blog.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    // Criar um novo post
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    // Listar todos os posts
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    //Lista pelo ID
    public Optional<Post> getOne(Long id) {
        return postRepository.findById(id);
    }

    //Editar o Post
    public Post updatePost(Long id, Post post) {
        return postRepository.save(post);
    }

    // Excluir um post pelo ID
    public void deletePost(Long id) {
        postRepository.deleteById(id);
        /*Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()) {
            postRepository.deleteById(id);
        } else {
            throw new RuntimeException("Post não encontrado para o id: " + id);
        }*/
    }

}
