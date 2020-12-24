package eu.ducksoft.eventregistry.events

data class ServiceRegisteredEvent(
        val serviceName: String,
        val serviceUrl: String
)