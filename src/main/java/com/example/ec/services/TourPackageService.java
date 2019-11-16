package com.example.ec.services;

import com.example.ec.domain.TourPackage;
import com.example.ec.repo.TourPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourPackageService {
    private TourPackageRepository tourPackageRepository;
    @Autowired
    public TourPackageService(TourPackageRepository tourPackageRepository) {
        this.tourPackageRepository = tourPackageRepository;
    }
    public TourPackage createTourPackage(String code, String name) {
        if (tourPackageRepository.findOne(code) == null) {
            return tourPackageRepository.save(new TourPackage(code, name));
        } else {
            return null;
        }
    }
    public Iterable<TourPackage> lookup() {
        return tourPackageRepository.findAll();
    }
    public long total() {
        return tourPackageRepository.count();
    }
}
