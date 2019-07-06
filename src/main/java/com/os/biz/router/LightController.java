package com.os.biz.router;

import java.util.WeakHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.os.biz.entity.Light;
import com.os.biz.service.LightService;
import com.os.biz.util.BizServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value="/api/light")
public class LightController {
	@Autowired
	private LightService lightService;
	@RequestMapping(value="/findByUserId",method=RequestMethod.POST)
	public Mono<BizServerResponse<?>>getLightByUserId(@RequestBody WeakHashMap<String,String> param){
		
		return lightService.findByUserId(param);
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public Mono<BizServerResponse<?>>saveLight(@RequestBody WeakHashMap<String,String> param){
		
		return lightService.save(param);
	}
	
	@RequestMapping(value="/findAll",method=RequestMethod.POST)
	public Flux<Light>findAll(@RequestBody WeakHashMap<String,String> param){
		
		return lightService.findAll();
	}
	
	

}
