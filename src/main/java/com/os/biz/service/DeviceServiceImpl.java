package com.os.biz.service;

import java.util.WeakHashMap;
import org.springframework.stereotype.Service;
import com.os.biz.entity.Device;
import com.os.biz.repository.DeviceRepository;
import com.os.biz.util.BizServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DeviceServiceImpl implements DeviceService {
	private DeviceRepository deviceRepository;

	private BizServerResponse<Object> response;

	private DeviceServiceImpl(DeviceRepository deviceRepository) {
		this.deviceRepository = deviceRepository;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.os.biz.service.LightService#findById(java.lang.String)
	 */
	@Override
	public Mono<BizServerResponse<?>> findById(String id) {

		response = new BizServerResponse<>();
		response.setData(deviceRepository.findById(id));
		response.setStatus(true);
		response.setMessage("Device have been added successfully.");
		return Mono.just(response);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.os.biz.service.LightService#findAll()
	 */
	@Override
	public Flux<Device> findAll() {
		response = new BizServerResponse<>();
		// response.setData();
		response.setStatus(true);
		response.setMessage("All Device have been get successfully.");
		return deviceRepository.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.os.biz.service.LightService#save(java.util.WeakHashMap)
	 */
	@Override
	public Mono<BizServerResponse<?>> save(WeakHashMap<String, String> user) {
		Device light = new Device();
		light.setLatitude(user.get("latitude"));
		light.setLongitude(user.get("longitude"));
		light.setOnOff(Boolean.valueOf(user.get("onOff")));
		light.setDeviceLocation(user.get("deviceLocation"));
		light.setType(user.get("type"));
		response = new BizServerResponse<>();
		response.setData(deviceRepository.save(light));
		response.setStatus(true);
		response.setMessage("Device have been added successfully.");
		return Mono.just(response);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.os.biz.service.LightService#deleteById(java.lang.String)
	 */
	@Override
	public Mono<BizServerResponse<?>> deleteById(WeakHashMap<String, String> param) {
		response = new BizServerResponse<>();
		deviceRepository.deleteById(param.get("id"));
		response.setStatus(true);
		response.setMessage("Device have been deleted successfully.");
		return Mono.just(response);
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
	public Mono<BizServerResponse<?>> findByOnOffAndUserIdAllIgnoreCase(WeakHashMap<String, String> param) {
		response = new BizServerResponse<>();
		response.setData(deviceRepository.findByOnOffAndUserIdAllIgnoreCase(param.get("onnOff"),param.get("userId")));
		response.setStatus(true);
		response.setMessage(param.get("onnOff")+" Devices have been getted successfully.");
		return Mono.just(response);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.os.biz.service.LightService#findByTypeAndUserIdAllIgnoreCase(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public Mono<BizServerResponse<?>> findByTypeAndUserIdAllIgnoreCase(WeakHashMap<String, String> param) {
		response = new BizServerResponse<>();
		response.setData(deviceRepository.findByTypeAndUserIdAllIgnoreCase(param.get("type"),param.get("userId")));
		response.setStatus(true);
		response.setMessage("Device type have been getted successfully.");
		return Mono.just(response);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.os.biz.service.LightService#findByLightLocationAndUserIdAllIgnoreCase(
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public Mono<BizServerResponse<?>> findByLightLocationAndUserIdAllIgnoreCase(WeakHashMap<String, String> param) {
		response = new BizServerResponse<>();
		response.setData(deviceRepository.findByDeviceLocationAndUserIdAllIgnoreCase(param.get("lightLocation"),param.get("userId")));
		response.setStatus(true);
		response.setMessage("Location have been getted successfully.");
		return Mono.just(response);
	}

	/*
	 * 
	 * @see com.os.biz.service.LightService#findByUserId(java.lang.String)
	 */
	@Override
	public Mono<BizServerResponse<?>> findByUserId(WeakHashMap<String, String> param) {
		response = new BizServerResponse<>();
		response.setData(deviceRepository.findByUserId(param.get("userId")));
		response.setStatus(true);
		response.setMessage("Data have been getted successfully.");
		return Mono.just(response);
	}

}
