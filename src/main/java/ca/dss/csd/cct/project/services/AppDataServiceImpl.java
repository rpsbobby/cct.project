package ca.dss.csd.cct.project.services;

import ca.dss.csd.cct.project.entity.AppData;
import ca.dss.csd.cct.project.repositories.AppDataRepository;
import ca.dss.csd.cct.project.repositories.AppDataTemplateRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppDataServiceImpl implements AppDataService {

    private AppDataRepository repository;
    private AppDataTemplateRepository template;
    private int defaultPageSize = 5;

    @Autowired
    public AppDataServiceImpl(AppDataRepository repository, AppDataTemplateRepository template) {
        this.repository = repository;
        // custom template
        this.template = template;
    }

    @Override
    public List<AppData> findAll() {
        return repository.findAll();
    }

    @Override
    public List<AppData> findAll(int pageNumber) {
        PageRequest request = PageRequest.of(pageNumber, defaultPageSize);
        return repository.findAll(request).toList();
    }

    @Override
    public AppData findById(String id) {
        Optional<AppData> optional = repository.findById(new ObjectId(id));
        AppData data = null;
        if (optional.isPresent()) {
            data = optional.get();
        }
        return data;
    }

    @Override
    public void update(AppData appData) {
        template.update(appData);
    }

    @Override
    public AppData save(AppData appData) {
        return repository.save(appData);
    }

    @Override
    public void delete(ObjectId id) {
        repository.deleteById(id);
    }
}
