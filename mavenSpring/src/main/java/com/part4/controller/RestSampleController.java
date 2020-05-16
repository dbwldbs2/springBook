package com.part4.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.part4.domain.RestSampleVO;
import com.part4.domain.Ticket;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/sample")
@Slf4j
public class RestSampleController {
	
	@GetMapping(value = "/getText", produces = "text/plain; charset=UTF-8")
	public String getText() {
		log.info("MIME TYPE :: " + MediaType.TEXT_PLAIN_VALUE);
		
		return "안녕하세요";
	}
	
	@GetMapping(value = "/getSample", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	public RestSampleVO getSample() {
		return new RestSampleVO(112, "스타", "필드");
	}
	
	@GetMapping(value = "/getList")
	public List<RestSampleVO> getList() {
		return IntStream.range(1,  10).mapToObj(i -> new RestSampleVO(i, i + "First", " Last"))
				.collect(Collectors.toList());
	}
	
	@GetMapping(value = "/getMap")
	public Map<String, RestSampleVO> getMap() {
		Map<String, RestSampleVO> map = new HashMap<>();
		map.put("First", new RestSampleVO(111, "그루트", "주니어"));
		
		return map;
	}
	
	@GetMapping(value = "/check", params = { "height", "wight"})
	public ResponseEntity<RestSampleVO> check(Double height, Double wight) {
		RestSampleVO vo = new RestSampleVO(0, "" + height, "" + wight);
		
		ResponseEntity<RestSampleVO> result = null;
		
		if(height < 150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		} else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		
		return result;
	}
	
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat, @PathVariable("pid") String pid) {
		return new String[] {"category: " + cat, "productid: " + pid};
	}
	
	@PostMapping("/ticket")
	public Ticket convert(@RequestBody Ticket ticket) {
		log.info("convert......ticket" + ticket);
		
		return ticket;
	}
}
