package org.example.tareashexagonal;

import org.example.tareashexagonal.domain.ports.input.TareaUseCase;
import org.example.tareashexagonal.domain.ports.output.TareaRepositoryPort;
import org.example.tareashexagonal.domain.usecase.TareaUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public TareaUseCase tareaUseCase(TareaRepositoryPort repository) {
        return new TareaUseCaseImpl(repository);
    }
}