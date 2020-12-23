package eu.ducksoft.serviceregister.infrastructure

import org.springframework.data.repository.CrudRepository

interface ServiceRecordRepository : CrudRepository<ServiceRecordEntity, String> {
}