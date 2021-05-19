package xyz.aiinirii.carboninfosys.service;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author AIINIRII
 */
public interface BuildingKeyService {
    String getBuildingKey(Long buildingId);

    @Transactional
    String generateKey(Long id);

    boolean validateKey(Long buildingId, String key);
}
