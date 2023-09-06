package cl.springboot.ms.mapper;

import org.mapstruct.ReportingPolicy;


@org.mapstruct.MapperConfig(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapperConfig {
	
}