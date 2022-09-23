package com.example.demo.entity.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.PicInfo;
import com.example.demo.entity.PicRes;
import com.example.demo.repositories.PicRepo;

@RestController
@CrossOrigin
public class PicController {

	@Autowired
	PicRepo picRepo;

	PicInfo getPicOnServer() {
		RestTemplate restTemplate = new RestTemplate();
		String dogResourceUrl = "https://dog.ceo/api/breeds/image/random";
		ResponseEntity<PicRes> response = restTemplate.getForEntity(dogResourceUrl, PicRes.class);
		return new PicInfo("pic", response.getBody().getMessage());
	}

	public PicController() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/apitest")
	PicInfo testPic() {
		return new PicInfo("test", "id");
	}

	@GetMapping("/pics/{id}")
	PicInfo getPicById(@PathVariable String id) {
		return picRepo.findById(id).get();
	}

	@GetMapping("/getpic")
	PicInfo getPic() {
		Optional<PicInfo> picInDBOptional = picRepo.findById("pic");
		if (picInDBOptional.isPresent()) {
			return picInDBOptional.get();
		}
		PicInfo newPic = getPicOnServer();
		picRepo.save(newPic);

		return newPic;

	}

	@PostMapping("/write")
	PicInfo savePic(@RequestBody PicInfo newpic) {
		picRepo.save(newpic);
		return newpic;
	}

	@DeleteMapping("/deletepic")
	void deletePic() {
		picRepo.deleteById("pic");
	}

}
