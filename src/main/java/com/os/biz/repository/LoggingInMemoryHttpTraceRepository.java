package com.os.biz.repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.os.biz.entity.AuditLogs;
import reactor.core.publisher.Flux;

@Repository
public interface LoggingInMemoryHttpTraceRepository extends ReactiveMongoRepository <AuditLogs, String> {
	@Query("{ id: { $exists: true }}")
	Flux<AuditLogs> retrieveAllAuditLogsPaged(final Pageable page);
}
