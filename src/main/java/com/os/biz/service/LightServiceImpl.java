package com.os.biz.service;

import java.util.WeakHashMap;

import org.springframework.stereotype.Service;

import com.os.biz.entity.Light;
import com.os.biz.repo.LightRepository;
import com.os.biz.util.BizServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LightServiceImpl implements LightService {
	private LightRepository lightRepository;

	private BizServerResponse<Object> response;

	private LightServiceImpl(LightRepository lightRepository) {
		this.lightRepository = lightRepository;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.os.biz.service.LightService#findById(java.lang.String)
	 */
	@Override
	public Mono<BizServerResponse<?>> findById(String id) {

		response = new BizServerResponse<>();
		response.setData(lightRepository.findById(id));
		response.setStatus(true);
		response.setMessage("Data have been added successfully.");
		return Mono.just(response);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.os.biz.service.LightService#findAll()
	 */
	@Override
	public Flux<Light> findAll() {
		response = new BizServerResponse<>();
		// response.setData();
		response.setStatus(true);
		response.setMessage("All Light have been get successfully.");
		return lightRepository.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.os.biz.service.LightService#save(java.util.WeakHashMap)
	 */
	@Override
	public Mono<BizServerResponse<?>> save(WeakHashMap<String, String> user) {
		Light light = new Light();
		light.setLatitude(user.get("latitude"));
		light.setLongitude(user.get("longitude"));
		light.setOnOff(Boolean.valueOf(user.get("onOff")));
		light.setLightLocation(user.get("lightLocation"));
		light.setType(user.get("type"));
		response = new BizServerResponse<>();
		response.setData(lightRepository.save(light));
		response.setStatus(true);
		response.setMessage("Data have been added successfully.");
		return Mono.just(response);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.os.biz.service.LightService#deleteById(java.lang.String)
	 */
	@Override
	public Mono<BizServerResponse<?>> deleteById(String id) {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.os.biz.service.LightService#deleteAll(java.lang.String)
	 */
	@Override
	public Mono<BizServerResponse<?>> deleteAll(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.os.biz.service.LightService#findByOnOffAndUserIdAllIgnoreCase(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public Mono<BizServerResponse<?>> findByOnOffAndUserIdAllIgnoreCase(String onnOff, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.os.biz.service.LightService#findByTypeAndUserIdAllIgnoreCase(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public Mono<BizServerResponse<?>> findByTypeAndUserIdAllIgnoreCase(String type, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.os.biz.service.LightService#findByLightLocationAndUserIdAllIgnoreCase(
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public Mono<BizServerResponse<?>> findByLightLocationAndUserIdAllIgnoreCase(String lightLocation, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * 
	 * @see com.os.biz.service.LightService#findByUserId(java.lang.String)
	 */
	@Override
	public Mono<BizServerResponse<?>> findByUserId(WeakHashMap<String, String> param) {
		response = new BizServerResponse<>();
		response.setData(lightRepository.findByUserId(param.get("userId")));
		response.setStatus(true);
		response.setMessage("Data have been getted successfully.");
		return Mono.just(response);
	}

}
