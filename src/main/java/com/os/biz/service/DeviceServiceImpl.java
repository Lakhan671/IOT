package com.os.biz.service;

import java.util.WeakHashMap;

import org.springframework.stereotype.Service;

import com.os.biz.entity.Device;
import com.os.biz.repository.DeviceRepository;
import com.os.biz.util.BizServerResponse;

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
	public Mono<Device> findById(String id) {

		//response = new BizServerResponse<>();
	return deviceRepository.findById(id);
		//response.setData();
		//response.setStatus(true);
		//response.setMessage("Device have been get successfully.");
		//return Mono.just(response);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.os.biz.service.LightService#findAll()
	 */
	@Override
	public Mono<BizServerResponse<?>>  findAll() {
		
		return deviceRepository.findAll().collectList().map(device->{
			response = new BizServerResponse<>();
			response.setStatus(true);
			response.setData(device);
			response.setMessage("All Device have been get successfully.");
			return response;
		});
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
		light.setUserId(user.get("userId"));
		light.setDescription(user.get("description"));
		return deviceRepository.save(light).map(device -> {
			response = new BizServerResponse<>();
			response.setStatus(true);
			response.setData(device);
			response.setMessage("Device have been added successfully.");
			return response;
		});
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
		return deviceRepository.findByOnOffAndUserIdAllIgnoreCase(Boolean.valueOf(param.get("onOff")), param.get("userId"))
				.collectList().map(device -> {
					response = new BizServerResponse<>();
					response.setData(device);
					response.setStatus(true);
					response.setMessage(param.get("onnOff") + " Devices have been getted successfully.");
					return response;
				});
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

		return deviceRepository.findByTypeAndUserIdAllIgnoreCase(param.get("type"), param.get("userId")).collectList()
				.map(device -> {
					response = new BizServerResponse<>();
					response.setStatus(true);
					response.setData(device);
					response.setMessage("Device type have been getted successfully.");
					return response;
				});
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
		return deviceRepository
				.findByDeviceLocationAndUserIdAllIgnoreCase(param.get("deviceLocation"), param.get("userId"))
				.collectList().map(device -> {
					response = new BizServerResponse<>();
					response.setData(device);
					response.setStatus(true);
					response.setMessage("Location have been getted successfully.");
					return response;
				});
	}

	/*
	 * 
	 * @see com.os.biz.service.LightService#findByUserId(java.lang.String)
	 */
	@Override
	public Mono<BizServerResponse<?>> findByUserId(WeakHashMap<String, String> param) {
		return deviceRepository.findByUserId(param.get("userId")).collectList().map(mm -> {
			response = new BizServerResponse<>();
			response.setStatus(true);
			response.setMessage("Data have been getted successfully.");
			response.setData(mm);
			return response;
		});
	}
	
	@Override
	public Mono<BizServerResponse<?>> update(WeakHashMap<String, String> param) {
		
		return deviceRepository.findById(param.get("id").trim())
                .map(p -> {
                    p.setOnOff(Boolean.valueOf(param.get("onOff")));
                    p.setLatitude(param.get("latitude"));
            		p.setLongitude(param.get("longitude"));
            		p.setDeviceLocation(param.get("deviceLocation"));
            		p.setType(param.get("type"));
            		p.setDescription(param.get("description"));
                    return p;
                })
                .flatMap(p -> deviceRepository.save(p)).map(pp->{
                	response = new BizServerResponse<>();
                	response.setStatus(true);
        			response.setMessage("device have been updated successfully.");
        			response.setData(pp);
        			return response;
                });
		  
	}

}
