package com.example.email.Interfaces;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.email.model.*;
public interface EmailRepository extends MongoRepository<EmailModel, String>{

}
