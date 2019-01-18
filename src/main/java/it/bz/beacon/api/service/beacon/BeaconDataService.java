package it.bz.beacon.api.service.beacon;

import it.bz.beacon.api.db.model.BeaconData;
import it.bz.beacon.api.db.repository.BeaconDataRepository;
import it.bz.beacon.api.exception.db.BeaconDataNotFoundException;
import it.bz.beacon.api.model.Beacon;
import it.bz.beacon.api.model.BeaconUpdate;
import it.bz.beacon.api.model.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BeaconDataService implements IBeaconDataService {

    @Autowired
    private BeaconDataRepository repository;

    @Override
    public List<BeaconData> findAll() {
        return repository.findAll();
    }

    @Override
    public List<BeaconData> findAllById(List<Long> ids) {
        return repository.findAllById(ids);
    }

    @Override
    public BeaconData find(long id) throws BeaconDataNotFoundException {
        return repository.findById(id).orElseThrow(BeaconDataNotFoundException::new);
    }

    @Override
    public BeaconData create(BeaconData beaconData) {
        return repository.save(beaconData);
    }

    @Override
    public BeaconData update(long id, BeaconUpdate beaconUpdate) throws BeaconDataNotFoundException {
        return repository.findById(id).map(beaconData -> {
            beaconData.setName(beaconUpdate.getName());
            beaconData.setDescription(beaconUpdate.getDescription());
            beaconData.setLat(beaconUpdate.getLat());
            beaconData.setLng(beaconUpdate.getLng());

            //TODO set other values

            return repository.save(beaconData);
        }).orElseThrow(BeaconDataNotFoundException::new);
    }

    @Override
    public ResponseEntity<?> delete(long id) throws BeaconDataNotFoundException {
        return repository.findById(id).map(
                beaconData -> {
                    repository.delete(beaconData);

                    return ResponseEntity.ok().build();
                }
        ).orElseThrow(BeaconDataNotFoundException::new);
    }
}
