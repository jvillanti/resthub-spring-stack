package org.resthub.web.controller;

import javax.inject.Inject;
import org.resthub.common.exception.NotFoundException;

import org.resthub.web.model.Sample;
import org.resthub.web.repository.SampleResourceRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sluggable-repository-based")
public class SluggableSampleRepositoryBasedRestController extends
        RepositoryBasedRestController<Sample, String, SampleResourceRepository> {

    @Override
    @Inject
    public void setRepository(SampleResourceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Sample findById(@PathVariable String id) {
        Sample sample = this.repository.findByName(id);
        if (sample == null) {
            throw new NotFoundException();
        }
        return sample;
    }   
    
}
