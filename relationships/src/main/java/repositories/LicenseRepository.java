package repositories;

import org.springframework.data.repository.CrudRepository;

import models.License;

public interface LicenseRepository extends CrudRepository <License, Long> {

	License getLicenseByUserId(Long id);

}
