package com.example.email.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.email.Dto.*;
import com.example.email.model.EmailModel;

@Repository
public interface EmailRepository extends MongoRepository<EmailDto, String>{

	EmailModel save(EmailModel emailModel);
	EmailModel findByFrom(String from);

}
