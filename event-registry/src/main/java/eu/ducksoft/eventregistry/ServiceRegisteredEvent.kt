package eu.ducksoft.eventregistry

data class ServiceRegisteredEvent(
        val serviceName: String,
        val serviceUrl: String
)