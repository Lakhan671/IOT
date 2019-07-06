package com.os.biz.service;

import java.util.WeakHashMap;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.os.biz.entity.User;
import com.os.biz.repo.UserRepository;
import com.os.biz.util.BizServerResponse;
import com.os.biz.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {
	UserRepository userRepository;
	private BizServerResponse<Object> response;
	private UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	@Override
	public Mono<User> findById(String id) {
	//userRepository.;
	return userRepository.findById(id.trim());
	}

	@Override
	public Flux<User> findAll() {
	return	userRepository.findAll();
	}

	@Override
	public Mono<User> save(User emp) {
	 return	userRepository.save(emp);
	}

	@Override
	public Mono<Void> deleteById(String id) {
		 return userRepository.deleteById(id);
	}

	@Override
	public Mono<Void> deleteAll(String key) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Flux<User> findByName(String name,int page,int size) {
		return userRepository.findByNameLike(name, PageRequest.of(page,size));
	}


	/* (non-Javadoc)
	 * @see com.os.biz.service.UserService#findByMobileNo(java.lang.String)
	 */
	@Override
	public Flux<User> findByMobileNo(String mob) {
		
		return userRepository.findByMobileNo(mob);
	}


	/* (non-Javadoc)
	 * @see com.os.biz.service.UserService#findByemail(java.lang.String)
	 */
	@Override
	public Mono<BizServerResponse<?>> findByemail(WeakHashMap<String, String> email) {
		  response=new BizServerResponse<>();
		  Flux<User>light=null;
		  if(Util.valiMobileNo(email.get("userName")))
			  light=userRepository.findByMobileNo(email.get("userName"));
		  if(Util.isValidEmail(email.get("userName")))
			  light=userRepository.findByEmail(email.get("email"));
		  response.setStatus(true);
		  response.setMessage("Login have been successfully");
		 return Mono.just(response);
	}

}
