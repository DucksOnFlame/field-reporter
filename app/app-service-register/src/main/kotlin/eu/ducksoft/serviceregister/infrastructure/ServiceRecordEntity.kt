package eu.ducksoft.serviceregister.infrastructure

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "service")
@Entity
class ServiceRecordEntity(
        @Id val name: String,
        var url: String
)