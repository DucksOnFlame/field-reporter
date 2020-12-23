package eu.ducksoft.serviceregister.client.rest.request

import kotlinx.serialization.Serializable

@Serializable
data class UpdateServiceRecordRequest(val url: String?)