package com.os.biz.controller;

import java.util.WeakHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.os.biz.service.DeviceService;
import com.os.biz.util.BizServerResponse;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value="/api/light")
public class DeviceController {
	@Autowired
	private DeviceService deviceService;
	@RequestMapping(value="/findByUserId",method=RequestMethod.POST)
	public Mono<BizServerResponse<?>>getLightByUserId(@RequestBody WeakHashMap<String,String> param){
		
		return deviceService.findByUserId(param);
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public Mono<BizServerResponse<?>>saveLight(@RequestBody WeakHashMap<String,String> param){
		
		return deviceService.save(param);
	}
	
	@RequestMapping(value="/findByUserId",method=RequestMethod.POST)
	public Mono<BizServerResponse<?>>findAll(@RequestBody WeakHashMap<String,String> param){
		return deviceService.findByUserId(param);
		
	}
	
	@RequestMapping(value="/findByLightLocationAndUserI",method=RequestMethod.POST)
	public Mono<BizServerResponse<?>>findByLightLocationAndUserI(@RequestBody WeakHashMap<String,String> param){
		return deviceService.findByLightLocationAndUserIdAllIgnoreCase(param);
		
	}
	
	@RequestMapping(value="/findByTypeAndUserId",method=RequestMethod.POST)
	public Mono<BizServerResponse<?>>findByTypeAndUserId(@RequestBody WeakHashMap<String,String> param){
		return deviceService.findByTypeAndUserIdAllIgnoreCase(param);
		
	}
	@RequestMapping(value="/findByOnOffAndUserId",method=RequestMethod.POST)
	public Mono<BizServerResponse<?>>findByOnOffAndUserId(@RequestBody WeakHashMap<String,String> param){
		return deviceService.findByOnOffAndUserIdAllIgnoreCase(param);
		
	}
	@RequestMapping(value="/deleteById",method=RequestMethod.POST)
	public Mono<BizServerResponse<?>>deleteById(@RequestBody WeakHashMap<String,String> param){
		return deviceService.deleteById(param);
		
	}
}