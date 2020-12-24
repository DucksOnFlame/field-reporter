package eu.ducksoft.serviceregister.rest

import eu.ducksoft.serviceregister.rest.exception.ServiceNotFoundException
import eu.ducksoft.serviceregister.rest.exception.ServiceUpdateBadRequest
import eu.ducksoft.serviceregister.rest.request.UpdateServiceRecordRequest
import eu.ducksoft.serviceregister.service.ServiceRecord
import eu.ducksoft.serviceregister.service.ServiceRecordService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/service")
class ServiceRecordController(private val serviceRecordService: ServiceRecordService) {

    @GetMapping
    fun getAllServices(): List<ServiceRecordDTO> {
        return serviceRecordService.getAllServices()
                .map(this::toDto)
    }

    @GetMapping("/{serviceName}")
    fun getService(@PathVariable serviceName: String?): ServiceRecordDTO {
        if (serviceName == null) {
            throw ServiceNotFoundException("null")
        }

        return serviceRecordService.findService(serviceName)
                .map(this::toDto)
                .orElseThrow { ServiceNotFoundException(serviceName) }
    }

    @PutMapping("/{serviceName}")
    fun updateService(@PathVariable serviceName: String?, @RequestBody updateRequest: UpdateServiceRecordRequest?) {
        if (serviceName == null || updateRequest == null || updateRequest.url == null) {
            throw ServiceUpdateBadRequest()
        }

        serviceRecordService.updateServiceRecord(serviceName, updateRequest.url)
    }

    private fun toDto(record: ServiceRecord): ServiceRecordDTO {
        return ServiceRecordDTO(record.name, record.url)
    }
}